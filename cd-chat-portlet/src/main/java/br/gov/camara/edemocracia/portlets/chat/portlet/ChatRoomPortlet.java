package br.gov.camara.edemocracia.portlets.chat.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.apache.commons.lang.StringUtils;

import br.gov.camara.edemocracia.portlets.chat.AccessDeniedException;
import br.gov.camara.edemocracia.portlets.chat.ChatRoomClosedException;
import br.gov.camara.edemocracia.portlets.chat.ChatRoomFullException;
import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException;
import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException;
import br.gov.camara.edemocracia.portlets.chat.UserBannedException;
import br.gov.camara.edemocracia.portlets.chat.UserNameAlreadyInUseException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;
import br.gov.camara.edemocracia.portlets.chat.portlet.exporter.ChatRoomExporter;
import br.gov.camara.edemocracia.portlets.chat.portlet.exporter.ChatRoomExporterFactory;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.AbstractView;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;
import br.gov.camara.edemocracia.util.FlashScopeUtil;

import com.liferay.portal.NoSuchRegionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

public class ChatRoomPortlet extends LiferayPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(ChatRoomPortlet.class);
	private static final String CD_CHAT_ROOM_COMPLETE_LIST_PORTLET_ID = "cdchatroomcompletelist_WAR_cdchatportlet";

	@Override
	protected final void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		ChatRoomView requestedView;
		//
		// Se informou a sala via parâmetro da página, entra diretamente na sala
		// ou mostra a tela de cadastro
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = td.getUser();
		UserActivityId userActivityId = null;
		try {
			// Procedimento padrão
			// Verifica os pré-requisitos
			String requestedViewParam = ParamUtil.getString(request, ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
			requestedView = ChatRoomView.fromUrlParamValue(requestedViewParam);
			if (requestedView == null) {
				LOG.warn("view inexistente: " + requestedViewParam);
				requestedView = ChatRoomView.ERROR;
			}

			ChatRoom chatRoom = ChatPortletRequestUtil.getChatRoomFromRequest(request);
			if (chatRoom != null) {
				userActivityId = ChatPortletSessionUtil.getValidatedUserActivityIdInRoom(request, chatRoom.getRoomId());
			}
			requestedView = processRequest(request, response, requestedView, user, chatRoom, userActivityId);

		} catch (PortalException e) {
			LOG.info(ChatPortletConstants.ERRO_PREPARANDO_A_VIEW, e);
			requestedView = ChatRoomView.ERROR;
		} catch (SystemException e) {
			LOG.info(ChatPortletConstants.ERRO_PREPARANDO_A_VIEW, e);
			requestedView = ChatRoomView.ERROR;
		}

		getPortletContext().getRequestDispatcher(requestedView.getJspName()).include(request, response);
	}

	/**
	 * Processa a requisição
	 * 
	 * @param request
	 * @param response
	 * @param requestedView
	 * @param user
	 * @param chatRoom
	 * @param chatRoomUser
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private ChatRoomView processRequest(RenderRequest request, RenderResponse response, ChatRoomView requestedView, User user, ChatRoom chatRoom,
			UserActivityId userActivityId) throws PortalException, SystemException {
		request.setAttribute(ChatPortletConstants.ROOM_ATTRIBUTE, chatRoom);

		if (userActivityId != null) {
			request.setAttribute(ChatPortletConstants.USER_ACTIVITY_ID_ATTRIBUTE, userActivityId);
		}

		// Usuário autenticado não pode entrar como anônimo
		if (requestedView == ChatRoomView.ANON && !user.isDefaultUser()) {
			requestedView = ChatRoomView.LIST;
		}
		if (requestedView == null) {
			return ChatRoomView.ERROR;
		}

		HashSet<Class<? extends AbstractView>> classes = new HashSet<Class<? extends AbstractView>>();
		AbstractView view = requestedView.createHandler();
		do {
			if (view == null) {
				return ChatRoomView.ERROR;
			}

			if (classes.contains(view.getClass())) {
				LOG.error("Processing loop");
				return ChatRoomView.ERROR;
			}

			// Processa as classes
			requestedView = view.process(request, response);
			AbstractView newView = requestedView.createHandler();

			// Teve redirecionamento?
			if (newView.getClass().equals(view.getClass()))
				break;

			classes.add(view.getClass());
			view = newView;
		} while (true);

		return requestedView;
	}

	@Override
	protected final void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		String editPage = getInitParameter("edit-jsp");
		getPortletContext().getRequestDispatcher(editPage).include(request, response);
	}
	
	@ProcessAction(name = "savePortletPreferences")
	public final void savePortletPreferences(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException {
		Boolean addThisUtilizarLinkParaSala = ParamUtil.getBoolean(req, "addthis_utilizar_link_para_sala");
		String addThisTextoDescricao = ParamUtil.getString(req, "addthis_texto_descricao");
		
		PortletPreferences prefs = req.getPreferences();
		try {
			prefs.setValue("addthis_texto_descricao", addThisTextoDescricao);
			prefs.setValue("addthis_utilizar_link_para_sala", addThisUtilizarLinkParaSala.toString());
			prefs.store();
			SessionMessages.add(req, "success");
			
		} catch (ReadOnlyException e) {
			SessionErrors.add(req, "failure");
			LOG.error("Ocorreu um erro ao salvar as preferências para o bate-papo.", e);
		} catch (ValidatorException e) {
			SessionErrors.add(req, "failure");
			LOG.error("Ocorreu um erro ao salvar as preferências para o bate-papo.", e);
		} catch (IOException e) {
			SessionErrors.add(req, "failure");
			LOG.error("Ocorreu um erro ao salvar as preferências para o bate-papo.", e);
		}
	}

	/**
	 * A partir da lista de salas:
	 * 
	 * Sala que permite anônimo: Se o usuário estiver logado, entra direto,
	 * autenticando Se o usuário não estiver logado, pede email, usuário e UF
	 * 
	 * Sala que não permite anônimo Se o usuário estiver logado, entra direto Se
	 * o usuário não estiver logado, redireciono para login
	 * 
	 * Espiar: Depende das permissões (SPY)
	 * 
	 * @param req
	 * @param rsp
	 * @throws PortalException
	 * @throws SystemException
	 */
	@ProcessAction(name = "enterChatRoom")
	public final void enterChatRoom(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException {
		User user = ChatPortletRequestUtil.getUserFromRequest(req);
		long roomId = ParamUtil.get(req, ChatPortletConstants.ROOM_ID_PARAM, -1);

		addPreviousPageLinkParameter(req, rsp);

		if (user.isDefaultUser()) {
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.VIEW.getUrlParamValue());
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
			return;
		}
		ChatPortletSessionUtil.removeUserFromRoomAndSession(req, roomId);
		try {
			ChatRoomUser chatRoomUser = ChatRoomServiceUtil.addChatUser(roomId, new Date());
			ChatPortletSessionUtil.addUserToSession(req, roomId, UserActivityId.forPersistentUser(chatRoomUser.getChatUserId()));
		} catch (NoSuchChatRoomException e) {
			SessionErrors.add(req, "room-cant-find");
		} catch (ChatRoomFullException e) {
			SessionErrors.add(req, "user-must-join-audience");
		} catch (ChatRoomClosedException e) {
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.DETAILS.getUrlParamValue());
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
			return;
			// SessionErrors.add(req, "room-closed");
		} catch (UserBannedException e) {
			SessionErrors.add(req, "user-banned");
		} catch (AccessDeniedException e) {
			SessionErrors.add(req, "no-access");
		}

		if (!SessionErrors.isEmpty(req)) {
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
			return;
		}
		// Ok, adicionado na sala
		rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
		rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.VIEW.getUrlParamValue());
	}
	
	/**
	 * Entra na sala em modo "espião"
	 * 
	 * @param req
	 * @param rsp
	 * @throws PortalException
	 * @throws SystemException
	 */
	@ProcessAction(name = "enterChatSpy")
	public final void enterChatSpy(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException {
		User user = ChatPortletRequestUtil.getUserFromRequest(req);
		long roomId = ParamUtil.get(req, ChatPortletConstants.ROOM_ID_PARAM, -1);

		addPreviousPageLinkParameter(req, rsp);

		// Remove a sessão antiga, caso o objeto esteja em sessão
		ChatPortletSessionUtil.removeUserFromRoomAndSession(req, roomId);
		try {

			UserActivityId userActivityId = ChatRoomServiceUtil.addSpyUser(roomId, new Date());
			ChatPortletSessionUtil.addUserToSession(req, roomId, userActivityId);

			// Ok, adicionado na sala
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.VIEW.getUrlParamValue());
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));

		} catch (NoSuchChatRoomException e) {
			SessionErrors.add(req, "room-cant-find");
			if (user.isDefaultUser()) {
				rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ERROR.getUrlParamValue());
			} else {
				rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
			}
			return;
		} catch (ChatRoomClosedException e) {
			SessionErrors.add(req, "room-closed");
		} catch (AccessDeniedException e) {
			SessionErrors.add(req, "no-access");
		} catch (ChatRoomFullException e) {
			SessionErrors.add(req, "user-must-join-audience");
		} catch (UserBannedException e) {
			SessionErrors.add(req, "user-banned");
		}

		if (!SessionErrors.isEmpty(req)) {
			if (user.isDefaultUser()) {
				rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
				rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ANON.getUrlParamValue());
			} else {
				rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
			}
			return;
		}
	}

	/**
	 * Na validação das informações passadas pelo usuário anônimo, deve-se
	 * verificar não só se existe algum usuário na mesma sala com com mesmo
	 * apelido e email, mas também se já existe algum usuário no portal com
	 * mesmo full name e email, a fim de evitar duplicidade dentro da sala.
	 * 
	 * @param req
	 * @param rsp
	 * @throws PortalException
	 * @throws SystemException
	 */
	@ProcessAction(name = "enterChatAnon")
	public final void enterChatAnon(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException {

		User user = ChatPortletRequestUtil.getUserFromRequest(req);
		if (!user.isDefaultUser()) {
			enterChatRoom(req, rsp);
			return;
		}

		addPreviousPageLinkParameter(req, rsp);

		long roomId = ParamUtil.get(req, ChatPortletConstants.ROOM_ID_PARAM, -1);

		// Acrescenta
		String nome = ParamUtil.getString(req, "nome", "").trim();

		if (nome.length() == 0) {
			SessionErrors.add(req, "missing-name");
		} else if (nome.length() > 75) {
			SessionErrors.add(req, "name-too-long");
		}

		String email = ParamUtil.getString(req, ChatPortletConstants.EMAIL_PARAM, "").trim();
		if (email.length() == 0) {
			SessionErrors.add(req, "missing-email");
		} else if (email.length() > 75) {
			SessionErrors.add(req, "email-too-long");
		} else if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(req, "invalid-email");
		}

		long uf = ParamUtil.getLong(req, ChatPortletConstants.REGION_ID_PARAM, 0l);
		Country brasil = CountryServiceUtil.getCountryByA2("BR");
		try {
			Region region = RegionServiceUtil.getRegion(uf);
			if (region.getCountryId() != brasil.getCountryId()) {
				SessionErrors.add(req, "invalid-region");
			}
		} catch (NoSuchRegionException e) {
			SessionErrors.add(req, "invalid-region");
		}

		if (!SessionErrors.isEmpty(req)) {
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ANON.getUrlParamValue());
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
			FlashScopeUtil.set(req, ChatPortletConstants.NICKNAME_PARAM, nome);
			FlashScopeUtil.set(req, ChatPortletConstants.EMAIL_PARAM, email);
			FlashScopeUtil.set(req, ChatPortletConstants.REGION_ID_PARAM, uf);
			return;
		}

		try {
			ChatPortletSessionUtil.removeUserFromRoomAndSession(req, roomId);
			ChatRoomUser chatRoomUser = ChatRoomServiceUtil.addAnonUser(roomId, new Date(), nome, email, uf);
			ChatPortletSessionUtil.addUserToSession(req, roomId, UserActivityId.forPersistentUser(chatRoomUser.getChatUserId()));
		} catch (UserNameAlreadyInUseException e) {
			SessionErrors.add(req, "name-already-exists-scope-room");
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ANON.getUrlParamValue());
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
			FlashScopeUtil.set(req, ChatPortletConstants.NICKNAME_PARAM, nome);
			FlashScopeUtil.set(req, ChatPortletConstants.EMAIL_PARAM, email);
			FlashScopeUtil.set(req, ChatPortletConstants.REGION_ID_PARAM, uf);
			FlashScopeUtil.set(req, ChatPortletConstants.NAME_SUGGESTIONS, e.getSuggestions());
			return;
		} catch (NoSuchChatRoomException e) {
			SessionErrors.add(req, "room-cant-find");
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ERROR.getUrlParamValue());
			return;
		} catch (ChatRoomFullException e) {
			SessionErrors.add(req, "user-must-join-audience");
		} catch (ChatRoomClosedException e) {
			SessionErrors.add(req, "room-closed");
		} catch (UserBannedException e) {
			SessionErrors.add(req, "user-banned");
		} catch (AccessDeniedException e) {
			SessionErrors.add(req, "no-access");
		}
		if (!SessionErrors.isEmpty(req)) {
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ANON.getUrlParamValue());
			return;
		}

		DateFormat df = new SimpleDateFormat(ChatPortletConstants.ISO_DATE_PATTERN);
		df.setTimeZone(TimeZone.getTimeZone(ChatPortletConstants.GMT));
		rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(roomId));
		rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.VIEW.getUrlParamValue());
	}

	@ProcessAction(name = "leaveChatRoom")
	public final void leaveChatRoom(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException, IOException {

		Long chatRoomId = ParamUtil.getLong(req, ChatPortletConstants.ROOM_ID_PARAM);

		UserActivityId userActivityIdFromRequest = UserActivityId.fromString(req.getParameter("userActivityId"));
		UserActivityId userActivityIdFromSession = ChatPortletSessionUtil.getUserActivityIdInRoom(req, chatRoomId);

		if (userActivityIdFromRequest != null && userActivityIdFromRequest.equals(userActivityIdFromSession)) {
			if (userActivityIdFromSession.isPersistentUser()) {
				ChatRoomUser chatRoomUser = ChatPortletRequestUtil.getChatRoomUser(req, chatRoomId);
				if (chatRoomUser != null && chatRoomUser.isBanned()) {
					SessionErrors.add(req, "user-banned");
				}
			}
			ChatPortletSessionUtil.removeUserFromRoomAndSession(req, chatRoomId);
		}

		// Decide se redirecionará para a página de listagem de salas ou
		// para a entrada de usuário anônimo
		ThemeDisplay td = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		String previousPageLink = req.getParameter(ChatPortletConstants.PREVIOUS_PAGE_LINK);
		boolean validPreviousPageLink = StringUtils.isNotBlank(previousPageLink) && ChatPortletRequestUtil.isUrlToSameHost(req, previousPageLink);
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(chatRoomId);

		if (room.getAnonymousAllowed() && td.getUser().isDefaultUser()) {
			if (validPreviousPageLink) {
				rsp.setRenderParameter(ChatPortletConstants.PREVIOUS_PAGE_LINK, previousPageLink);
			}
			rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, chatRoomId.toString());
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.ANON.getUrlParamValue());
		} else {
			if (validPreviousPageLink) {
				rsp.sendRedirect(previousPageLink);
			} else {
				resolveListViewRedirectPage(req, rsp);
			}
		}
	}

	@ProcessAction(name = "viewHistory")
	public final void viewHistory(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException {
		ChatRoom room = ChatPortletRequestUtil.getChatRoomFromRequest(req);
		if (room == null) {
			SessionErrors.add(req, "room-cant-find");
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
			return;
		}
		if (room.getStatus() != RoomStatus.Exported.getValue()) {
			SessionErrors.add(req, "room-not-exported");
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
			return;
		}

		addPreviousPageLinkParameter(req, rsp);

		rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.HISTORY.getUrlParamValue());
		rsp.setRenderParameter(ChatPortletConstants.ROOM_ID_PARAM, Long.toString(room.getRoomId()));
	}

	@ProcessAction(name = "listChatRooms")
	public final void listChatRooms(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException, IOException {
		resolveListViewRedirectPage(req, rsp);
	}

	/**
	 * Verifica se a comunidade atual possui alguma página com o portlet de
	 * todas as comunidades. Se encontrar alguma, faz o redirect para a página.
	 * Se não encontrar envia para a página de listagem padrão onde são exibidas
	 * somente as salas da comunidade atual.
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 * 
	 */
	private void resolveListViewRedirectPage(ActionRequest req, ActionResponse rsp) throws PortalException, SystemException, IOException {
		ThemeDisplay td = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(td.getScopeGroupId(), CD_CHAT_ROOM_COMPLETE_LIST_PORTLET_ID);

		if (plid != LayoutConstants.DEFAULT_PLID) {
			PortletURL portletURL = PortletURLFactoryUtil.create(req, CD_CHAT_ROOM_COMPLETE_LIST_PORTLET_ID, plid, PortletRequest.ACTION_PHASE);
			portletURL.setParameter("javax.portlet.action", "listChatRooms");
			portletURL.setParameter("p_p_lifecycle", "1");

			String url = portletURL.toString();

			rsp.sendRedirect(url);
		} else {
			rsp.setRenderParameter(ChatPortletConstants.VIEW_PARAM, ChatRoomView.LIST.getUrlParamValue());
		}
	}

	@Override
	public final void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		String id = request.getResourceID();
		PrintWriter out = response.getWriter();
		if (id.equalsIgnoreCase("cdchatupdate")) {
			getAjaxChatUpdate(request, out);
		} else if (id.equalsIgnoreCase("cdchatpostmsg")) {
			postAjaxMessage(request, out);
		} else if (id.equalsIgnoreCase("cdchatbanuser")) {
			ajaxBanUser(request, out, true);
		} else if (id.equalsIgnoreCase("cdchatunbanuser")) {
			ajaxBanUser(request, out, false);
		} else if (id.equalsIgnoreCase("cdchatapprovemsg")) {
			ajaxApproveMsg(request, out, true);
		} else if (id.equalsIgnoreCase("cdchatrejectmsg")) {
			ajaxApproveMsg(request, out, false);
		} else if (id.equalsIgnoreCase("cdchatopenroom")) {
			ajaxOpenRoom(request, out);
		} else if (id.equalsIgnoreCase("cdchatcloseroom")) {
			ajaxCloseRoom(request, out);
		} else if (id.equalsIgnoreCase("cdchatexport")) {
			exportMessages(request, response);
		}
	}

	private void addPreviousPageLinkParameter(PortletRequest req, ActionResponse rsp) {
		String previousPageLink = ParamUtil.get(req, ChatPortletConstants.PREVIOUS_PAGE_LINK, "");
		if (StringUtils.isNotBlank(previousPageLink)) {
			rsp.setRenderParameter(ChatPortletConstants.PREVIOUS_PAGE_LINK, previousPageLink);
		}
	}

	/**
	 * Aprova uma mensagem
	 * 
	 * @param request
	 * @param out
	 * @param approved
	 */
	private void ajaxApproveMsg(ResourceRequest request, PrintWriter out, boolean approved) {
		long roomId = ParamUtil.get(request, ChatPortletConstants.ROOM_ID_PARAM, -1);
		long msgId = ParamUtil.getLong(request, "msgId", -1);
		if (roomId != -1 && msgId != -1) {
			try {
				ChatRoomServiceUtil.approveMessage(roomId, msgId, approved, new Date());
				out.print("{\"ok\" : true, \"id\" : " + msgId + "}");
			} catch (PortalException e) {
				out.print("{\"ok\" : false, \"id\" : " + msgId + "}");
			} catch (SystemException e) {
				LOG.error("Erro ao aprovar mensagem", e);
				out.print("{\"ok\" : false, \"id\" : " + msgId + "}");
			}
		}
	}

	/**
	 * Bane um usuário
	 * 
	 * @param request
	 * @param out
	 * @param banned
	 */
	private void ajaxBanUser(ResourceRequest request, PrintWriter out, boolean banned) {
		long roomId = ParamUtil.get(request, ChatPortletConstants.ROOM_ID_PARAM, -1);
		long userId = ParamUtil.getLong(request, "user", -1);
		if (roomId != -1 && roomId != -1) {
			try {
				ChatRoomServiceUtil.banUser(roomId, userId, new Date(), banned);
				out.print(ChatPortletConstants.OK);
			} catch (PortalException e) {
				out.print(ChatPortletConstants.ERROR);
			} catch (SystemException e) {
				LOG.error("Erro ao banir usuário", e);
				out.print(ChatPortletConstants.ERROR);
			}
		}

	}

	/**
	 * Abre a sala de bate-papo
	 * 
	 * @param request
	 * @param out
	 */
	private void ajaxOpenRoom(ResourceRequest request, PrintWriter out) {
		long roomId = ParamUtil.get(request, ChatPortletConstants.ROOM_ID_PARAM, -1);
		try {
			ChatRoomServiceUtil.openChatRoom(roomId, new Date());
			out.print(ChatPortletConstants.OK_TRUE);
		} catch (PortalException e) {
			out.print(ChatPortletConstants.OK_FALSE);
		} catch (SystemException e) {
			LOG.error("Erro ao banir usuário", e);
			out.print(ChatPortletConstants.OK_FALSE);
		}
	}

	/**
	 * Fecha a sala de bate-papo
	 * 
	 * @param request
	 * @param out
	 */
	private void ajaxCloseRoom(ResourceRequest request, PrintWriter out) {
		long roomId = ParamUtil.get(request, ChatPortletConstants.ROOM_ID_PARAM, -1);
		try {
			ChatRoomServiceUtil.closeChatRoom(roomId, new Date());
			out.print(ChatPortletConstants.OK_TRUE);
		} catch (PortalException e) {
			out.print(ChatPortletConstants.OK_FALSE);
		} catch (SystemException e) {
			LOG.error("Erro ao banir usuário", e);
			out.print(ChatPortletConstants.OK_FALSE);
		}
	}

	private void getAjaxChatUpdate(ResourceRequest request, PrintWriter out) {
		Date since;
		DateFormat df = new SimpleDateFormat(ChatPortletConstants.ISO_DATE_PATTERN);
		df.setTimeZone(TimeZone.getTimeZone(ChatPortletConstants.GMT));

		String strSince = ParamUtil.getString(request, "chat_since");
		try {
			since = df.parse(strSince);
		} catch (ParseException e) {
			since = new Date();
			LOG.error("Erro ao interpretar data");
		}

		long roomId = ParamUtil.getLong(request, ChatPortletConstants.ROOM_ID_PARAM);
		boolean firstUpdate = ParamUtil.getBoolean(request, "first");

		try {
			UserActivityId userActivityId = UserActivityId.fromString(request.getParameter("chatUserId"));
			String output = ChatRoomServiceUtil.getJSONUpdate(roomId, userActivityId, since, firstUpdate);
			out.print(output);
		} catch (NoSuchChatRoomUserException e) {
			out.print("\"error: NoSuchChatRoomUserException\"");
		} catch (NoSuchChatRoomException e) {
			out.print("\"error: NoSuchChatRoomException\"");
			LOG.error("Erro ao obter atualização das mensagens. Não existe sala de bate papo com a chave primária " + roomId);
			LOG.debug("Erro ao obter atualização das mensagens. Não existe sala de bate papo com a chave primária " + roomId, e);
		} catch (PortalException e) {
			out.print("\"error: ");
			out.print(e.getMessage());
			out.print("\"");
			LOG.error("Erro ao obter atualizacao das mensagens", e);
		} catch (SystemException e) {
			out.print("\"error: ");
			out.print(e.getMessage());
			out.print("\"");
			LOG.error("Erro ao obter atualizacao das mensagens", e);
		}
	}

	private void postAjaxMessage(ResourceRequest request, PrintWriter out) {

		String msgText = ParamUtil.getString(request, "msgText");
		boolean msgPublic = !ParamUtil.getBoolean(request, "priv", true);
		long msgRecipient = ParamUtil.getLong(request, "user");
		int textType = ParamUtil.getInteger(request, "textType", 0);

		ChatRoomUser chatRoomUser = null;
		ChatRoom chatRoom;
		try {
			chatRoom = ChatPortletRequestUtil.getChatRoomFromRequest(request);
			if (chatRoom != null) {
				chatRoomUser = ChatPortletRequestUtil.getChatRoomUser(request, chatRoom.getRoomId());
			}

			if (chatRoomUser == null) {
				out.print("\"error: NoSuchChatRoomUserException\"");
				return;
			}
		} catch (PortalException e) {
			out.print("\"error: ");
			out.print(e.getMessage());
			out.print("\"");
			LOG.error("Erro ao obter postar mensagens", e);
			return;
		} catch (SystemException e) {
			out.print("\"error: ");
			out.print(e.getMessage());
			out.print("\"");
			LOG.error("Erro ao obter postar mensagens", e);
			return;
		}

		long userId = chatRoomUser.getChatUserId();
		boolean msgAdmin = false;
		try {
			ChatPermissionChecker checker = new ChatPermissionChecker(chatRoom);
			if (checker.isCanModerate()) {
				msgAdmin = ParamUtil.getBoolean(request, "admin", false);
				long sendAsId = ParamUtil.getLong(request, "sendAs", -1);
				if (sendAsId != -1) {
					userId = sendAsId;
				}
			}

			// Se a mensagem for para todos, obrigatoriamente é pública
			if (msgRecipient == -1)
				msgPublic = true;

			boolean canPost = (checker.isCanModerate() || checker.isOpen()) && !chatRoomUser.isBanned();
			if (canPost && (msgText != null && msgText.trim().length() > 0)) {

				Calendar cal = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat(ChatPortletConstants.ISO_DATE_PATTERN);
				df.setTimeZone(TimeZone.getTimeZone(ChatPortletConstants.GMT));
				cal.setTimeZone(TimeZone.getTimeZone(ChatPortletConstants.GMT));
				LOG.debug(df.format(cal.getTime()));

				ChatRoomServiceUtil.postMessage(MessageType.Standard, userId, chatRoom.getRoomId(), cal.getTime(), msgText, msgPublic, msgAdmin, msgRecipient,
						textType);
				out.print(ChatPortletConstants.OK);
			} else {
				out.print(ChatPortletConstants.OK);
			}
		} catch (PortalException e) {
			out.print("fail");
			LOG.error("Erro ao postar mensagem", e);
		} catch (SystemException e) {
			out.print("fail");
			LOG.error("Erro ao postar mensagem", e);
		}
	}

	private void exportMessages(ResourceRequest request, ResourceResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try {
			long roomId = ParamUtil.getLong(request, ChatPortletConstants.ROOM_ID_PARAM, -1);

			User user = ChatPortletRequestUtil.getUserFromRequest(request);

			TimeZone tz = TimeZone.getDefault();
			if (user != null) {
				tz = user.getTimeZone();
			}

			String format = ParamUtil.getString(request, "format", "html");

			ChatRoomExporter exporter = ChatRoomExporterFactory.create(format);
			String exportedRoom = exporter.exportChatRoom(roomId, tz);
			out.println(exportedRoom);
			response.setProperty("Content-Disposition", "attachment;filename=\"" + exporter.getFilename(roomId) + "\"");

		} catch (NumberFormatException nfe) {
			LOG.error("Erro ao interpretar numero", nfe);
		} catch (PortalException e) {
			LOG.error("Erro ao exportar mensagens", e);
		} catch (SystemException e) {
			LOG.error("Erro ao exportar mensagens", e);
		}
	}
}

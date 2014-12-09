package br.gov.camara.edemocracia.portlets.chat.portlet.beans.completelist;

import java.io.Serializable;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;
import br.gov.camara.edemocracia.util.LinkSalasCacheUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

/**
 * Listagem das salas de bate-papo de uma instancia do portal
 * 
 * 
 */
@ManagedBean(name = "redirecionaSalasPortal")
@RequestScoped
public class RedirecionaSalasPortalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String CD_CHAT_ROOM_PORTLET_ID = "cdchatroom_WAR_cdchatportlet";
	private static final String CD_CHAT_ROOM_COMPLETE_LIST_PORTLET_ID = "cdchatroomcompletelist_WAR_cdchatportlet";
	private String previousPageLink = "";
	
	@PostConstruct
	private void init(){
		previousPageLink = montarlinkParaBotaoVoltar();
	}

	public String entrarSala(Long roomId) {
		String url = entrarSalaSemPreviousPageLink(roomId);

		String urlCompleta = adicionarPreviousPageLinkParam(url, previousPageLink);
		return urlCompleta;
	}
	
	public String entrarSalaSemPreviousPageLink(Long roomId) {
		String url = LinkSalasCacheUtil.getLinkEntrar(roomId);
		
		if (StringUtils.isBlank(url)) {
			url = montarlinkParaSala(roomId, PortletRequest.ACTION_PHASE, "javax.portlet.action", "enterChatRoom", "1");
			LinkSalasCacheUtil.setLinkEntrar(roomId, url);
		}

		return url;
	}

	public String espiarSala(Long roomId) {
		String url = LinkSalasCacheUtil.getLinkEspiar(roomId);

		if (StringUtils.isBlank(url)) {
			url = montarlinkParaSala(roomId, PortletRequest.ACTION_PHASE, "javax.portlet.action", "enterChatSpy", "1");
			LinkSalasCacheUtil.setLinkEspiar(roomId, url);
		}
		
		String urlCompleta = adicionarPreviousPageLinkParam(url, previousPageLink);
		return urlCompleta;
	}

	public String historicoSala(Long roomId) {
		String url = LinkSalasCacheUtil.getLinkVerHistorico(roomId);
		
		if (StringUtils.isBlank(url)) {
			url = montarlinkParaSala(roomId, PortletRequest.RENDER_PHASE, "view", "history", "0");
			LinkSalasCacheUtil.setLinkVerHistorico(roomId, url);
		}

		String urlCompleta = adicionarPreviousPageLinkParam(url, previousPageLink);
		return urlCompleta;
	}

	private String adicionarPreviousPageLinkParam(String url, String previousPageLink) {
		URIBuilder uriBuilder = null;
		try {
			uriBuilder = new URIBuilder(url);
		} catch (URISyntaxException e) {
			throw new RuntimeException("Erro ao adicionar parâmetro previousPageLink", e);
		}
		uriBuilder.setParameter(ChatPortletConstants.PREVIOUS_PAGE_LINK, previousPageLink);
		return uriBuilder.toString();
	}

	private String montarlinkParaBotaoVoltar() {
		String url = StringPool.BLANK;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) LiferayFacesContext.getInstance().getPortletRequest().getAttribute(WebKeys.THEME_DISPLAY);
			long plid = themeDisplay.getPlid();
			if (plid != LayoutConstants.DEFAULT_PLID) {
				PortletRequest request = (PortletRequest) LiferayFacesContext.getInstance().getExternalContext().getRequest();
				PortletURL portletURL = PortletURLFactoryUtil.create(request, CD_CHAT_ROOM_COMPLETE_LIST_PORTLET_ID, plid, PortletRequest.RENDER_PHASE);
				url = portletURL.toString();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return url;
	}

	private String montarlinkParaSala(Long roomId, String lifecycle, String parameterKey, String parameterValue, String parameter_p_p_LifeCycle) {
		String url = StringPool.BLANK;
		try {
			ChatRoom chatRoom = ChatRoomLocalServiceUtil.getChatRoom(roomId);
			long groupId = chatRoom.getGroupId();
			long plid = PortalUtil.getPlidFromPortletId(groupId, CD_CHAT_ROOM_PORTLET_ID);
			if (plid != LayoutConstants.DEFAULT_PLID) {
				PortletRequest request = (PortletRequest) LiferayFacesContext.getInstance().getExternalContext().getRequest();
				PortletURL portletURL = PortletURLFactoryUtil.create(request, CD_CHAT_ROOM_PORTLET_ID, plid, lifecycle);
				portletURL.setParameter(parameterKey, parameterValue);
				portletURL.setParameter("roomId", roomId.toString());
				portletURL.setParameter("p_p_lifecycle", parameter_p_p_LifeCycle);

				url = portletURL.toString();
				// LiferayFacesContext.getInstance().getExternalContext().redirect(url);
				// // colocar quando sair nova versão do bridge jsf do liferay
				// (stateless)
				LinkSalasCacheUtil.setLinkEntrar(roomId, url);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return url;
	}

}

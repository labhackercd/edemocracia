package br.gov.camara.edemocracia.portlets.comunidades.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TopoComunidade extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(TopoComunidade.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay td = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = td.getScopeGroup().getGroupId();
		String urlImgCom = null;
		Group grp = td.getScopeGroup();
		String tituloCom = grp.getName();
		String descCom = grp.getDescription();
		try {
			urlImgCom = CommunityIconFinder.findUrl(td, groupId);
	
			boolean podeAssinar;

			User user = td.getUser();
			if (grp.isRegularSite()) {
				if (user.isDefaultUser()) {
					if (grp.getType() == GroupConstants.TYPE_SITE_OPEN)
						podeAssinar = true;
					else
						podeAssinar = false;
				} else {
					// Se não estiver no grupo, mostra a mensagem
					if (!GroupLocalServiceUtil.hasUserGroup(user.getUserId(), groupId)) {
						if (grp.getType() == GroupConstants.TYPE_SITE_OPEN)
							podeAssinar = true;
						else
							podeAssinar = false;
					} else {
						podeAssinar = false;
					}
				}
			} else {
				podeAssinar = false;
			}
			
			// URL de inscricao
			if (podeAssinar) {
				if (user.isDefaultUser())
					renderRequest.setAttribute("urlInscricao", td.getURLSignIn());
				else {
					PortletURL url = renderResponse.createActionURL();
					url.setParameter(ActionRequest.ACTION_NAME, "entraComunidade");
					renderRequest.setAttribute("urlInscricao", url.toString());
				}
			} else {
				renderRequest.setAttribute("urlInscricao", "");
			}
			
			String urlInicial = null;
			// URL de página inicial da comunidade
			List<Layout> layouts = td.getLayouts();
			if (layouts.size() > 0) 
				urlInicial = PortalUtil.getLayoutFullURL(layouts.get(0), td);

			
			renderRequest.setAttribute("titulo", tituloCom);
			renderRequest.setAttribute("descricao", descCom);
			renderRequest.setAttribute("imagem", urlImgCom);
			renderRequest.setAttribute("podeAssinar", podeAssinar);
			renderRequest.setAttribute("urlInicial", urlInicial);
		} catch (PortalException e) {
			_log.error("Erro. Avalie o Log", e);
			renderRequest.setAttribute("titulo", "--Erro--");
			renderRequest.setAttribute("descricao", "--Erro--");
			renderRequest.setAttribute("imagem", "");
			renderRequest.setAttribute("podeAssinar", false);
			renderRequest.setAttribute("urlInscricao", "");
			renderRequest.setAttribute("urlInicial", null);
		} catch (SystemException e) {
			_log.error("Erro. Avalie o Log", e);
			renderRequest.setAttribute("titulo", "--Erro--");
			renderRequest.setAttribute("descricao", "--Erro--");
			renderRequest.setAttribute("imagem", "");
			renderRequest.setAttribute("podeAssinar", false);
			renderRequest.setAttribute("urlInscricao", "");
			renderRequest.setAttribute("urlInicial", null);
		}

		super.doView(renderRequest, renderResponse);

	}

	@ProcessAction(name = "entraComunidade")
	public void entraComunidade(ActionRequest req, ActionResponse rsp) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			User userLog = themeDisplay.getUser();
			if (userLog.isDefaultUser()) {
				rsp.sendRedirect(themeDisplay.getURLSignIn());
				return;
			}
			// Verifica se o usuário tem permissão para entrar no grupo
			Group group = themeDisplay.getScopeGroup();
			if (!GroupLocalServiceUtil.hasUserGroup(userLog.getUserId(), group.getGroupId())) {
				if (group.getType() == GroupConstants.TYPE_SITE_OPEN) {
					long[] groupIds = { themeDisplay.getScopeGroupId() };
					GroupLocalServiceUtil.addUserGroups(userLog.getUserId(), groupIds);
					SessionMessages.add(req, "membro-usuario");
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
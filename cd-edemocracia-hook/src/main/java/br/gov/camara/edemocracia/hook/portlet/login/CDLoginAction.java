package br.gov.camara.edemocracia.hook.portlet.login;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

/**
 * Mantém o login do usuário na sessão
 * 
 * @author p_7339
 * 
 */
public class CDLoginAction extends BaseStrutsPortletAction {

	@Override
	public void processAction(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		originalStrutsPortletAction.processAction(portletConfig, actionRequest,
				actionResponse);

		armazenaLoginNaSessaoSeAuthFalhar(actionRequest, actionResponse);
	}

	private void armazenaLoginNaSessaoSeAuthFalhar(ActionRequest actionRequest, ActionResponse actionResponse) {
		if (!SessionErrors.isEmpty(actionRequest)) {
			actionRequest.getPortletSession().setAttribute("login",
					actionRequest.getParameter("login"));
			actionResponse.setRenderParameter("saveLastPath", "0");
		}
	}

	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {

		recuperaLoginDaSessao(renderRequest);
		return originalStrutsPortletAction.render(portletConfig, renderRequest,
				renderResponse);
	}

	private void recuperaLoginDaSessao(RenderRequest renderRequest) {
		String login = null;
		PortletSession session = renderRequest.getPortletSession(false);
		if (session != null) {
			login = (String) session.getAttribute("login");
			session.removeAttribute("login");
		}

		renderRequest.setAttribute("login", login);
	}

}
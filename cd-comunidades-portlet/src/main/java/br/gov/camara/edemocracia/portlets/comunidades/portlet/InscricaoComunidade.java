/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.portlets.comunidades.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class InscricaoComunidade extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(InscricaoComunidade.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Group comunidade = td.getScopeGroup();
		User usuario = td.getUser();

		try {
			boolean podeAssinarComunidade = usuarioPodeAssinarAComunidade(comunidade, usuario);
			boolean podeSairDaComunidade = usuarioPodeSairDaComunidade(comunidade, usuario);

			String urlAcao = StringPool.BLANK;

			if (usuario.isDefaultUser()) {
				urlAcao = td.getURLSignIn();
				if (comunidade.isGuest()) {
					podeAssinarComunidade = false;
					podeSairDaComunidade = false;
				}
			} else {
				if (podeAssinarComunidade) {
					urlAcao = createActionURL(renderResponse, "assinarComunidade");
				} else if (podeSairDaComunidade) {
					urlAcao = createActionURL(renderResponse, "sairDaComunidade");
				}
			}

			setDefaultAttributes(renderRequest, podeAssinarComunidade, podeSairDaComunidade, urlAcao);

		} catch (SystemException e) {
			_log.error("Erro. Avalie o Log", e);
			setDefaultAttributes(renderRequest, false, false, "");
		}

		super.doView(renderRequest, renderResponse);
	}

	private boolean usuarioPodeSairDaComunidade(Group comunidade, User usuario) throws SystemException {
		boolean comunidadeDiferenteDaGuest = !comunidade.isGuest();
		boolean usuarioEMembroDaComunidade = GroupLocalServiceUtil.hasUserGroup(usuario.getUserId(), comunidade.getGroupId());

		if (usuarioEMembroDaComunidade && comunidadeDiferenteDaGuest && comunidade.isRegularSite()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean usuarioPodeAssinarAComunidade(Group comunidade, User usuario) throws SystemException {
		boolean usuarioNaoEstaNaComunidade = !GroupLocalServiceUtil.hasUserGroup(usuario.getUserId(), comunidade.getGroupId());
		boolean comunidadeAberta = comunidade.getType() == GroupConstants.TYPE_SITE_OPEN;

		if (usuarioNaoEstaNaComunidade && comunidadeAberta && comunidade.isRegularSite()) {
			return true;
		} else {
			return false;
		}
	}

	private String createActionURL(RenderResponse renderResponse, String actionName) {
		PortletURL url = renderResponse.createActionURL();
		url.setParameter(ActionRequest.ACTION_NAME, actionName);
		return url.toString();
	}

	private void setDefaultAttributes(RenderRequest renderRequest, boolean podeAssinarComunidade, boolean podeSairDaComunidade, String urlAcao) {
		renderRequest.setAttribute("urlAcao", urlAcao);
		renderRequest.setAttribute("podeAssinarAComunidade", podeAssinarComunidade);
		renderRequest.setAttribute("podeSairDaComunidade", podeSairDaComunidade);
	}

	@ProcessAction(name = "assinarComunidade")
	public void entraComunidade(ActionRequest req, ActionResponse rsp) {
		ThemeDisplay td = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			verificarSeUsuarioEGuestERedirecionarParaLogin(rsp, td);

			boolean usuarioPodeAssinarAComunidade = usuarioPodeAssinarAComunidade(td.getScopeGroup(), td.getUser());
			if (usuarioPodeAssinarAComunidade) {
				long[] groupIds = { td.getScopeGroupId() };
				GroupLocalServiceUtil.addUserGroups(td.getUserId(), groupIds);
				SessionMessages.add(req, "membro-usuario");
			}

		} catch (SystemException e) {
			_log.error("Erro ao inscrever usuário na comunidade. Usuário: " + td.getUserId() + " .Comunidade:" + td.getScopeGroupId(), e);
			SessionErrors.add(req, "erro-cadastrar-usuario");

		} catch (IOException e) {
			_log.error("Erro ao inscrever usuário na comunidade. Usuário: " + td.getUserId() + " .Comunidade:" + td.getScopeGroupId(), e);
			SessionErrors.add(req, "erro-cadastrar-usuario");
		}
	}

	@ProcessAction(name = "sairDaComunidade")
	public void deixarComunidade(ActionRequest req, ActionResponse rsp) {
		ThemeDisplay td = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			verificarSeUsuarioEGuestERedirecionarParaLogin(rsp, td);

			boolean usuarioPodeSairDaComunidade = usuarioPodeSairDaComunidade(td.getScopeGroup(), td.getUser());
			if (usuarioPodeSairDaComunidade) {
				long[] groupIds = { td.getScopeGroupId() };
				GroupLocalServiceUtil.unsetUserGroups(td.getUserId(), groupIds);
				SessionMessages.add(req, "descadastrado-usuario");
			}

		} catch (SystemException e) {
			_log.error("Erro ao descadastrar usuário na comunidade. Usuário: " + td.getUserId() + " .Comunidade:" + td.getScopeGroupId(), e);
			SessionErrors.add(req, "erro-descadastrar-usuario");
		} catch (IOException e) {
			_log.error("Erro ao descadastrar usuário na comunidade. Usuário: " + td.getUserId() + " .Comunidade:" + td.getScopeGroupId(), e);
			SessionErrors.add(req, "erro-descadastrar-usuario");
		}
	}

	private void verificarSeUsuarioEGuestERedirecionarParaLogin(ActionResponse rsp, ThemeDisplay themeDisplay) throws IOException {
		User userLog = themeDisplay.getUser();
		if (userLog.isDefaultUser()) {
			rsp.sendRedirect(themeDisplay.getURLSignIn());
			return;
		}
	}
}

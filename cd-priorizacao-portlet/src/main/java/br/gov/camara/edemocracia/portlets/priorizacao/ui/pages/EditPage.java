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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.pages;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.target.basic.RedirectRequestTarget;

import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author p_7339
 * 
 */
public class EditPage extends WebPage {

	private static final Log LOG = LogFactoryUtil.getLog(EditPage.class);

	private FeedbackPanel feedback;
	private Form<?> form;
	private TextField<String> mensagem;
	private TextField<String> url;
	private Button voltar;

	private String viewUrl;

	public EditPage() {

		// Obtém a página de visualização
		RenderResponse rRes = UIUtils.getRenderResponse();
		PortletURL pURL = rRes.createRenderURL();
		try {
			pURL.setPortletMode(PortletMode.VIEW);
		} catch (PortletModeException e) {
		}
		viewUrl = pURL.toString();

		PortletPreferences pp = UIUtils.getPortletPreferences();

		initFeedbackPanel();
		initForm();
		initMensagem(pp);
		initUrl(pp);
		initVoltar();
	}

	private void initFeedbackPanel() {
		feedback = new FeedbackPanel("feedback");
		add(feedback);
	}

	private void initForm() {
		form = new Form<Void>("form") {
			@Override
			protected void onSubmit() {
				String txtMensagem = mensagem.getModelObject();
				if (txtMensagem == null)
					txtMensagem = "";
				else
					txtMensagem = txtMensagem.trim();
				String txtUrl = url.getModelObject();
				if (txtUrl == null)
					txtUrl = "";
				else
					txtUrl = txtUrl.trim();
				if (!txtUrl.isEmpty() && txtMensagem.isEmpty()) {
					error("Se informar a URL, é obrigatório informar a mensagem");
				} else {
					PortletPreferences pp = UIUtils.getPortletPreferences();
					try {
						pp.setValue("mensagem", mensagem.getModelObject());
						pp.setValue("url", url.getModelObject());
						pp.store();
						getRequestCycle().setRequestTarget(
								new RedirectRequestTarget(viewUrl));
					} catch (Exception e) {
						LOG.error("Erro gravando preferências", e);
						error("Erro ao gravar configurações. Por favor, tente mais tarde");
					}
				}
			}
		};
		add(form);
	}

	private void initMensagem(PortletPreferences pp) {
		mensagem = new TextField<String>("mensagem", Model.of(pp.getValue(
				"mensagem", "")));
		form.add(mensagem);
	}

	private void initUrl(PortletPreferences pp) {
		url = new TextField<String>("url", Model.of(pp.getValue("url", "")));
		form.add(url);
	}

	private void initVoltar() {
		voltar = new Button("voltar") {
			@Override
			public void onSubmit() {
				getRequestCycle().setRequestTarget(
						new RedirectRequestTarget(viewUrl));
			}
		};
		voltar.setDefaultFormProcessing(false);
		form.add(voltar);
	}

}

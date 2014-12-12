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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.votacao;

import java.text.MessageFormat;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.MinimumValidator;

import br.gov.camara.edemocracia.portlets.priorizacao.UsuariosComMaisVotosPorPropostaException;
import br.gov.camara.edemocracia.portlets.priorizacao.UsuariosComMaisVotosTotaisException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.panels.PriorizacaoAdminMenuPanel;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ConfigurarVotacaoPage extends WebPage {

	private Form<Void> formConfiguracao;
	private RequiredTextField<Integer> maximoVotos;
	private RequiredTextField<Integer> maximoVotosProposta;
	private CheckBox votacaoAberta;
	private static final Log LOG = LogFactoryUtil
			.getLog(ConfigurarVotacaoPage.class);
	private Configuracao configuracao;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		initConfiguracao();
		initMenuPriorizacao();
		initMensagensFeedBack();
		initFormConfiguracao();
		initMaximoVotos();
		initMaximoVotosProposta();
		initVotacaoAberta();
	}

	@Override
	protected void onConfigure() {
		super.onConfigure();
		initConfiguracao();
	}

	private void initConfiguracao() {
		configuracao = getConfiguracao();
	}

	private void initMenuPriorizacao() {
		add(new PriorizacaoAdminMenuPanel("menuPriorizacao"));
	}

	private void initMensagensFeedBack() {
		add(new FeedbackPanel("mensagensFeedback"));
	}

	private void initFormConfiguracao() {
		formConfiguracao = new Form<Void>("formConfiguracao") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onValidate() {
				super.onValidate();
				try {

					int maxVotos = maximoVotos.getConvertedInput();
					int maxVotosProposta = maximoVotosProposta
							.getConvertedInput();
					if (maxVotosProposta > maxVotos)
						error("O número de votos por proposta não pode ser maior que o máximo de votos.");

				} catch (NullPointerException ex) {
					// Ignore
				}
			}

			@Override
			protected void onSubmit() {
				super.onSubmit();
				gravarAlteracoes();
			}
		};
		add(formConfiguracao);
	}

	private void initMaximoVotos() {
		maximoVotos = new RequiredTextField<Integer>("maximoVotos",
				new Model<Integer>(configuracao.getMaximoVotos()));
		maximoVotos.setType(Integer.class);
		maximoVotos.add(new MinimumValidator<Integer>(1));
		formConfiguracao.add(maximoVotos);
	}

	private void initMaximoVotosProposta() {
		maximoVotosProposta = new RequiredTextField<Integer>(
				"maximoVotosProposta", new Model<Integer>(
						configuracao.getMaxVotosProposta()));
		maximoVotosProposta.setType(Integer.class);
		maximoVotosProposta.add(new MinimumValidator<Integer>(1));
		formConfiguracao.add(maximoVotosProposta);
	}
	
	private void initVotacaoAberta() {
		votacaoAberta = new CheckBox("votacaoAberta", Model.of(configuracao.isVotacaoAberta()));
		formConfiguracao.add(votacaoAberta);
	}

	private void gravarAlteracoes() {
		int maximoVotos = this.maximoVotos.getModelObject();
		int maxVotosProposta = this.maximoVotosProposta.getModelObject();
		boolean votacaoAberta = this.votacaoAberta.getModelObject();
		
		try {
			PriorizacaoServiceUtil.updateConfiguracao(
					UIUtils.getScopeGroupId(), maximoVotos, maxVotosProposta, votacaoAberta);
			info("Configuração atualizada com sucesso!");
		} catch (UsuariosComMaisVotosPorPropostaException e) {
			error(MessageFormat.format("Já há pelo menos um usuário que votou mais de {0} vezes em um proposta", maxVotosProposta));
		} catch (UsuariosComMaisVotosTotaisException e) {
			error(MessageFormat.format("Já há pelo menos um usuário que votou mais de {0} vezes", maximoVotos));
		} catch (PortalException e) {
			LOG.error("Erro ao atualizar configuração.");
			error("Erro ao atualizar configuração");
		} catch (SystemException e) {
			error("Erro ao atualizar configuração");
			LOG.error("Erro ao atualizar configuração.");
		}

	}

	private Configuracao getConfiguracao() {
		Configuracao configuracao = null;
		try {
			configuracao = PriorizacaoServiceUtil.getConfiguracaoPorGrupo(UIUtils
					.getScopeGroupId());
		} catch (PortalException e) {
			LOG.error("Erro ao obter configuracao");
		} catch (SystemException e) {
			LOG.error("Erro ao obter configuracao");
		}

		return configuracao;
	}

}

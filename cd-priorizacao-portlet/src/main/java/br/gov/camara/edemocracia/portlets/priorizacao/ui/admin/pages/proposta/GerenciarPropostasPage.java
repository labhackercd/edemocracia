package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.proposta;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.panels.PriorizacaoAdminMenuPanel;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.EixosDropDown;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.PropostasRefreshingView;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class GerenciarPropostasPage extends WebPage {

	private static final Log LOG = LogFactoryUtil
			.getLog(GerenciarPropostasPage.class);
	private Link<Void> adicionarProposta;
	private EixosDropDown eixos;
	private PropostasRefreshingView propostas;
	private WebMarkupContainer propostasContainer;
	private WebMarkupContainer propostaVazia;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		initMenuPriorizacao();
		initAdicionarProposta();
		initMensagensFeedBack();
		initEixos();
		initPropostasContainer();
		initPropostas();
		initPropostaVazia();
	}

	private void initMenuPriorizacao() {
		add(new PriorizacaoAdminMenuPanel("menuPriorizacao"));
	}

	private void initMensagensFeedBack() {
		add(new FeedbackPanel("mensagensFeedback"));
	}

	private void initAdicionarProposta() {
		adicionarProposta = new Link<Void>("adicionarProposta") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(PropostaPage.class);
			}
		};
		add(adicionarProposta);
	}

	private void initEixos() {
		eixos = new EixosDropDown("eixos", UIUtils.getScopeGroupId(),null);
		eixos.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				long eixoId = (eixos.getModelObject() != null) ? eixos
						.getModelObject().getEixoId() : 0l;
				propostas.recarregarPropostas(eixoId);
				propostas.setVisible(getPropostasCount(eixoId) != 0);
				propostaVazia.setVisible(!propostas.isVisible());
				if (target != null) {
					target.addComponent(propostaVazia);
					target.addComponent(propostasContainer);
				}

			}
		});
		add(eixos);
	}

	private void initPropostasContainer() {
		propostasContainer = new WebMarkupContainer("propostasContainer");
		propostasContainer.setOutputMarkupId(true);
		add(propostasContainer);
	}

	private void initPropostas() {
		propostas = new PropostasRefreshingView("propostas", 0l);
		propostas.setVisible(propostas.getDefaultModelObject() != null);
		propostas.setOutputMarkupId(true);
		propostasContainer.add(propostas);
	}

	private void initPropostaVazia() {
		propostaVazia = new WebMarkupContainer("propostaVazia");
		propostaVazia.setOutputMarkupPlaceholderTag(true);
		propostaVazia.setOutputMarkupId(true);
		add(propostaVazia);
	}

	private int getPropostasCount(long eixoId) {
		try {
			return PriorizacaoServiceUtil.getPropostasCountByEixoId(eixoId);
		} catch (SystemException e) {
			LOG.error("Erro ao obter quantidade de propostas ");
		}

		return 0;
	}

}

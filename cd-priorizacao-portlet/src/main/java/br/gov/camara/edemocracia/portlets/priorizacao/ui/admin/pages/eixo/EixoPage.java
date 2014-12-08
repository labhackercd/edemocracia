package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.eixo;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.CategoriaDropDown;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.EixosDropDown;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class EixoPage extends WebPage {

	private long eixoId;
	private Label cabecalho;
	private FeedbackPanel mensagensFeedback;
	private Form<Void> form;
	private RequiredTextField<String> titulo;
	private RequiredTextField<String> sumario;
	private CategoriaDropDown categorias;
	private EixosDropDown eixos;
	private Link<GerenciarEixosPage> cancelar;
	private static final Log LOG = LogFactoryUtil.getLog(EixoPage.class);

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		initCabecalho();
		initMensagensFeedback();
		initForm();
		initTitulo();
		initSumario();
		initCategorias();
		initEixos();
		initCancelar();
	}
	
	private Eixo getModelObject() {
		return (Eixo) getDefaultModelObject();
	}

	public EixoPage(PageParameters parameters) {
		super(parameters);
		if (parameters.containsKey("eixoId")) {
			eixoId = Long.parseLong(parameters.getString("eixoId"));
			getEixo();
		}
	}

	private void getEixo() {

		IModel<Eixo> modelo = new LoadableDetachableModel<Eixo>() {
			@Override
			protected Eixo load() {
				try {
					return PriorizacaoServiceUtil.getEixo(eixoId);
				} catch (Exception e) {
					throw new RuntimeException("Unable to get eixo");
				}
			}
		};
		setDefaultModel(modelo);
	}
	
	private void initCabecalho() {
		String textoCabecalho = getModelObject() != null ? "Editar Eixo" : "Novo Eixo";
		cabecalho = new Label("cabecalho",Model.of(textoCabecalho));
		add(cabecalho);
	}

	private void initMensagensFeedback() {
		mensagensFeedback = new FeedbackPanel("mensagensFeedback");
		add(mensagensFeedback);
	}
	
	private void initForm() {
		form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				gravar();
			}
		};
		add(form);
	}

	private void initTitulo() {
		String texto = getModelObject() != null ? getModelObject().getTitulo()
				: "";
		titulo = new RequiredTextField<String>("titulo", Model.of(texto));
		titulo.setOutputMarkupId(true);
		form.add(titulo);
	}

	private void initSumario() {
		String texto = getModelObject() != null ? getModelObject().getSumario()
				: "";
		sumario = new RequiredTextField<String>("sumario", Model.of(texto));
		sumario.setOutputMarkupId(true);
		form.add(sumario);
	}

	private void initCategorias() {
		categorias = new CategoriaDropDown("categorias",
				UIUtils.getScopeGroupId());
		categorias.setRequired(true);
		if (getModelObject() != null)
			categorias.setDefaultModelObject(PriorizacaoServiceUtil
					.getMBCategory(getModelObject().getCategoryId()));
		form.add(categorias);
	}

	private void initEixos() {
		IChoiceRenderer<Eixo> renderer = new IChoiceRenderer<Eixo>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public String getIdValue(Eixo object, int index) {
				return Long.toString(object.getEixoId());
			}
			
			@Override
			public Object getDisplayValue(Eixo object) {
				return "após " + object.getTitulo();
			}
		};
		eixos = new EixosDropDown("eixos", UIUtils.getScopeGroupId(),renderer);
		eixos.setNullValid(true);
		if (getModelObject() != null) {
			List<? extends Eixo> eixos = this.eixos.getChoices();
			int index = eixos.indexOf(getModelObject());
			if(index != 0)
				this.eixos.setDefaultModelObject(eixos.get(index - 1));
		}
		form.add(eixos);
	}

	private void initCancelar() {
		cancelar = new Link<GerenciarEixosPage>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(GerenciarEixosPage.class);
			}
		};
		form.add(cancelar);
	}

	private void gravar() {
		String titulo = this.titulo.getModelObject();
		String sumario = this.sumario.getModelObject();
		long categoryId = this.categorias.getModelObject().getCategoryId();
		long eixoAnteriorId = this.eixos.getModelObject() == null ? 0l
				: this.eixos.getModelObject().getEixoId();

		try {
			if(getModelObject() != null){
				PriorizacaoServiceUtil.updateEixo(
						eixoId, sumario, titulo, eixoAnteriorId, categoryId);
			} else {
				PriorizacaoServiceUtil.addEixo(UIUtils.getScopeGroupId(),
						categoryId, sumario, titulo, eixoAnteriorId);
			}
			info("Alterações gravadas com sucesso!");
		} catch (SystemException e) {
			LOG.error("Erro ao gravar alterações no eixo.", e);
			error("Erro ao gravar alterações.");
		} catch (PortalException e) {
			LOG.error("Erro gravar alterações no eixo", e);
			error("Erro ao gravar alterações");
		}
		setResponsePage(GerenciarEixosPage.class);
		setRedirect(true);
	}

}

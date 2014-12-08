package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.proposta;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import br.gov.camara.edemocracia.portlets.priorizacao.InvalidIdentificadorException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.EixosDropDown;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.TopicosDropDown;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.HtmlStripper;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;

public class PropostaPage extends WebPage{
	
	private long propostaId;
	private Form<Void> form;
	private RequiredTextField<String> identificador;
	private TextArea<String> ementa;
	private TextArea<String> texto;
	private EixosDropDown eixos;
	private Label categoria;
	private TopicosDropDown topicos;
	private Link<GerenciarPropostasPage> cancelar;
	private static final Log LOG = LogFactoryUtil.getLog(PropostaPage.class);

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(JavascriptPackageResource.getHeaderContribution("ckeditor/ckeditor.js"));
		
		initCabecalho();
		initMensagensFeedback();
		initForm();
		initIdentificador();
		initEmenta();
		initTexto();
		initEixos();
		initCategoria();
		initTopicos();
		initCancelar();
	}
	
	private Proposta getModelObject(){
		return (Proposta) getDefaultModelObject();
	}
	
	public PropostaPage(PageParameters parameters) {
		super(parameters);
		if (parameters.containsKey("propostaId")) {
			propostaId = Long.parseLong(parameters.getString("propostaId"));
			getProposta();
		}

	}
	
	@Override
	public void renderHead(HtmlHeaderContainer container) {
		super.renderHead(container);
		String configCkEditor="CKEDITOR.config.toolbar_Basic =[['Bold', 'Italic','Link','Unlink' ]]; CKEDITOR.config.toolbar = 'Basic';";
		container.getHeaderResponse().renderOnDomReadyJavascript(configCkEditor);
		container.getHeaderResponse().renderOnDomReadyJavascript(String.format("CKEDITOR.replace('%s');", texto.getMarkupId()));
	}
	
	private void getProposta() {
		IModel<Proposta> modelo = new LoadableDetachableModel<Proposta>() {
			@Override
			protected Proposta load() {
				try {
					return PriorizacaoServiceUtil.getProposta(propostaId);
				} catch (Exception e) {
					throw new RuntimeException("Unable to get proposta");
				}
			}
		};
		setDefaultModel(modelo);
		
	}

	private void initCabecalho() {
		String cabecalho = getModelObject() != null ? "Editar Proposta" : "Nova Proposta";
		add(new Label("cabecalho",Model.of(cabecalho)));
	}

	private void initMensagensFeedback() {
		add(new FeedbackPanel("mensagensFeedback"));
	}
	
	private void initForm() {
		form = new Form<Void>("form"){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				gravar();
					
			}
		};
		add(form);
	}
	
	private void initIdentificador() {
		String texto = getModelObject() != null ? getModelObject().getIdentificador() : "";
		identificador = new RequiredTextField<String>("identificador",Model.of(texto));
		identificador.setOutputMarkupId(true);
		form.add(identificador);
	}

	private void initEmenta() {
		String texto = getModelObject() != null ? getModelObject().getEmenta() : "";
		ementa = new TextArea<String>("ementa",Model.of(texto));
		ementa.setRequired(true);
		ementa.setOutputMarkupId(true);
		ementa.add(StringValidator.maximumLength(3000));
		form.add(ementa);
	}
	
	private void initTexto() {
		String textoModel = getModelObject() != null ? getModelObject().getTexto() : "";
		texto = new TextArea<String>("texto",Model.of(textoModel));
		texto.setOutputMarkupId(true);
		form.add(texto);
	}	
	
	private void initEixos(){
		eixos = new EixosDropDown("eixos", UIUtils.getScopeGroupId(),null);
		eixos.setRequired(true);
		eixos.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				recarregarCategoria();
				recarregarTopicos();
				if (target != null){
					target.addComponent(categoria);
					target.addComponent(topicos);
				}	
			}
		});
		if(getModelObject() != null){
			try {
				  eixos.setModelObject(PriorizacaoServiceUtil.getEixo(getModelObject().getEixoId()));
			} catch (Exception e) {
				//Ignore
			} 
		}
		form.add(eixos);
	}
	
	private void initCategoria() {
		categoria = new Label("categoria", Model.of(""));
		categoria.setOutputMarkupId(true);
		recarregarCategoria();
		form.add(categoria);
	}
	
	private void initTopicos(){
		if(getModelObject() != null){
			topicos = new TopicosDropDown("topicos", UIUtils.getScopeGroupId(), eixos.getModelObject().getCategoryId());
			try {
				  topicos.setModelObject(MBThreadLocalServiceUtil.getMBThread(getModelObject().getThreadId()));
			} catch (Exception e) {
				//Ignore
			} 
		}else{
			topicos = new TopicosDropDown("topicos", UIUtils.getScopeGroupId(),0l);
		}
		topicos.setRequired(true);
		form.add(topicos);
	}
	
	private void initCancelar() {
		cancelar = new Link<GerenciarPropostasPage>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(GerenciarPropostasPage.class);
			}
		};
		form.add(cancelar);
	}
	
	private void recarregarTopicos() {
		long categoryId =  eixos.getModelObject() != null ? eixos.getModelObject().getCategoryId() : 0l;
		topicos.recarregar(UIUtils.getScopeGroupId(), categoryId);
	}
	
	private void recarregarCategoria() {
		long categoryId =  eixos.getModelObject() != null ? eixos.getModelObject().getCategoryId() : 0l;
		String categoria;
		try {
			categoria = PriorizacaoServiceUtil.getMBCategory(categoryId).getName();
		} catch (Exception e) {
			categoria = "";
		}
		this.categoria.setDefaultModelObject(categoria);
	}
	
	private void gravar(){
		HtmlStripper htmlStripper = new HtmlStripper();
		String identificador = this.identificador.getModelObject();
		String ementa = this.ementa.getModelObject();
		String texto = htmlStripper.strip(this.texto.getModelObject());
		long eixoId = eixos.getModelObject() != null ? eixos.getModelObject().getEixoId() : 0l;
		long threadId = topicos.getModelObject().getThreadId();
		
		try {
			if(getModelObject() != null){
				PriorizacaoServiceUtil.updateProposta(propostaId, eixoId, ementa, texto, threadId, identificador);
			} else {
				PriorizacaoServiceUtil.addProposta(UIUtils.getScopeGroupId(), eixoId, ementa, texto, threadId, identificador);
			}	

			info("Alterações gravadas com sucesso!");
		} catch(InvalidIdentificadorException e){
			error("Esse identificador já está cadastrado. Escolha outro.");
		} catch (PortalException e) {
			LOG.error("Erro ao gravar alterações na proposta.",e);
			error("Erro ao gravar alterações.");
		} catch (SystemException e) {
			LOG.error("Erro ao gravar alterações na proposta.",e);
			error("Erro ao gravar alterações.");
		}
		setResponsePage(GerenciarPropostasPage.class);
		setRedirect(true);
	}

}
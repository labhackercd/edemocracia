/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import java.io.IOException;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.target.basic.RedirectRequestTarget;

import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;
import br.gov.camara.edemocracia.util.HtmlStripper;

/**
 * Página de configuração do portlet - define o título do PL em discussão
 * 
 * @author robson
 * 
 */
public class ConfiguracaoPage extends WebPage {

	private String viewUrl;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(JavascriptPackageResource.getHeaderContribution("ckeditor/ckeditor.js"));
		
		buildViewUrl();
		
		initMensagensFeedBack();
		initForm();
		initTituloProjetoLei();
		initTituloDescricaoProjeto();
		initDescricaoProjeto();
		initHabilitaPlugins();
		initHabilitaSugestoes();
		initPaginaInicial();
	}

	/**
	 * URL para redirecionar para visualização
	 */
	private void buildViewUrl() {
		RenderResponse rRes = UIUtils.getRenderResponse();
		PortletURL pURL = rRes.createRenderURL();
		try {
			pURL.setPortletMode(PortletMode.VIEW);
		} catch (PortletModeException e) {
		}
		viewUrl = pURL.toString();
	}	
	

	

	@Override
	public void renderHead(HtmlHeaderContainer container) {
		super.renderHead(container);
		String configCkEditor="CKEDITOR.config.toolbar_Basic =[['Bold', 'Italic','Link','Unlink' ]]; CKEDITOR.config.toolbar = 'Basic';";
		container.getHeaderResponse().renderOnDomReadyJavascript(configCkEditor);
		container.getHeaderResponse().renderOnDomReadyJavascript(String.format("CKEDITOR.replace('%s');", descricaoProjeto.getMarkupId()));
	}

	
	private Form<Void> form;
	private TextField<String> tituloProjetoLei;
	private TextField<String> tituloDescricaoProjeto;
	private TextArea<String> descricaoProjeto;
	private CheckBox habilitaPlugins;
	private CheckBox habilitaSugestoes;
	private FeedbackPanel mensagensFeedback;
	private ExternalLink paginaInicial;
	
	private void initForm() {

		
		
		form = new Form<Void>("form") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				PortletPreferences prefs = UIUtils.getPortletPreferences();
				HtmlStripper htmlStripper = new HtmlStripper();

				try {
					prefs.setValue("titulo", tituloProjetoLei.getModelObject());
					prefs.setValue("tituloDescricao", tituloDescricaoProjeto.getModelObject());
					prefs.setValue("descricaoProjeto", htmlStripper.strip(descricaoProjeto.getModelObject()));
					prefs.setValue("habilitaPlugins", habilitaPlugins.getModelObject().toString());
					prefs.setValue("habilitaSugestoes", habilitaSugestoes.getModelObject().toString());
					
					info("Alterações realizadas com sucesso!");
					getRequestCycle().setRequestTarget(new RedirectRequestTarget(viewUrl));
				} catch (ReadOnlyException e) {
					error("Erro ao gravar alterações");
					return;
				}
				try {
					prefs.store();
				} catch (ValidatorException e) {
					error("Erro ao gravar alterações");
				} catch (IOException e) {
					error("Erro ao gravar alterações");
				}
			}
		};
		add(form);
	}
	
	private void initPaginaInicial() {
		paginaInicial = new ExternalLink("paginaInicial", viewUrl);
		form.add(paginaInicial);
		
	}

	private void initMensagensFeedBack() {
		mensagensFeedback = new FeedbackPanel("mensagensFeedback");
		add(mensagensFeedback);
		
	}

	private void initTituloProjetoLei() {
		String pref = UIUtils.getPortletPreferences().getValue("titulo", "Título do projeto de lei em discussão");
	
		tituloProjetoLei = new TextField<String>("tituloProjetoLei", Model.of(pref));
		
		form.add(tituloProjetoLei);
	}
	
	private void initTituloDescricaoProjeto() {
		String pref = UIUtils.getPortletPreferences().getValue("tituloDescricao", "Breve Descricao");
	
		tituloDescricaoProjeto = new TextField<String>("tituloDescricaoProjeto", Model.of(pref));
		
		form.add(tituloDescricaoProjeto);
	}
	
	private void initDescricaoProjeto() {
		
		String pref = UIUtils.getPortletPreferences().getValue("descricaoProjeto", "Descricao...");
	
		descricaoProjeto = new TextArea<String>("descricaoProjeto", Model.of(pref));
		descricaoProjeto.setOutputMarkupId(true);
		form.add(descricaoProjeto);
		
	}
	
	private void initHabilitaPlugins(){
		String pref = UIUtils.getPortletPreferences().getValue("habilitaPlugins", "true");
		habilitaPlugins = new CheckBox("habilitaPlugins", Model.of(Boolean.parseBoolean(pref)));
		habilitaPlugins.setOutputMarkupId(true);
		form.add(habilitaPlugins);
	}
	
	private void initHabilitaSugestoes(){
		String pref = UIUtils.getPortletPreferences().getValue("habilitaSugestoes", "true");
		habilitaSugestoes = new CheckBox("habilitaSugestoes", Model.of(Boolean.parseBoolean(pref)));
		habilitaSugestoes.setOutputMarkupId(true);
		form.add(habilitaSugestoes);
	}
	
	
}

/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebRequest;

import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.PosicaoArtigo;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.PosicaoArtigoPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author rpdmiranda
 * 
 */
public class NovoArtigoPage extends WebPage {

	private Form<Void> form;
	private TextArea<String> textoArtigo;
	private TextArea<String> legislacaoVigente;
	private PosicaoArtigoPanel posicaoArtigo;
	private static final Log LOG = LogFactoryUtil.getLog(NovoArtigoPage.class);

	public NovoArtigoPage() {
		// Verifica se pode editar
		if (!UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION))
			throw new RestartResponseException(HomePage.class);
		
		init();
	}

	private void init() {
		
		initMenuWikilegis();
		initForm();
		initTextoTextArea();
		initLegislacaoVigente();
		initPosicaoArtigo();
		initEnviarButton();
		initCancelarButton();
	}

	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));
	}

	private void initForm() {
		form = new Form<Void>("form") {
			/**
			 * Realizar validações
			 */
			@Override
			protected void onSubmit() {
				gravaAlteracoes();
			}
		};
		add(form);
	}

	private void initTextoTextArea() {
		textoArtigo = new TextArea<String>("textoArtigo", Model.of(""));
		textoArtigo.setOutputMarkupId(true);
		form.add(textoArtigo);
	}

	private void initLegislacaoVigente() {
		legislacaoVigente = new TextArea<String>("legislacaoVigente",
				Model.of(""));
		legislacaoVigente.setOutputMarkupId(true);
		form.add(legislacaoVigente);
	}

	private void initPosicaoArtigo() {
		posicaoArtigo = new PosicaoArtigoPanel("posicao",
				new Model<PosicaoArtigo>());
		form.add(posicaoArtigo);
	}

	private void initEnviarButton() {
		form.add(new Button("enviar"));
	}

	private void initCancelarButton() {
		form.add(new BookmarkablePageLink<HomePage>("cancelar", HomePage.class));
		
	}

	// //////////////////////////////
	//
	// //////////////////////////////
	private void gravaAlteracoes() {
		HttpServletRequest req = ((WebRequest) RequestCycle.get().getRequest())
				.getHttpServletRequest();
		ThemeDisplay td = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		String texto = textoArtigo.getModelObject();
		String emVigor = legislacaoVigente.getModelObject();
		PosicaoArtigo posicao = posicaoArtigo.getModelObject();
		try {
			WikiLegisServiceUtil.criaArtigo(td.getScopeGroupId(),
					posicao.getEstruturaPaiId(), posicao.getArtigoAnteriorId(),
					texto, emVigor);
		} catch (SystemException e) {
			LOG.error("Erro ao criar novo artigo.",e);
		} catch (PortalException e) {
			LOG.error("Erro ao criar novo artigo.",e);
		}
		setResponsePage(HomePage.class);
		setRedirect(true);
	}
}

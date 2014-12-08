package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import org.apache.wicket.markup.html.panel.Panel;

import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.MenuLink;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.EstruturaPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.ExportacaoPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.HomePage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.NovoArtigoPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.UploadPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.security.permission.ActionKeys;

/**
 * 
 * @author bruno
 * 
 */

public class WikiLegisMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public WikiLegisMenuPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {

		super.onInitialize();

		// Monta o botão início
		initInicio();

		// Monta o botão novo
		initNovo();

		// Monta o botão gerenciar agrupamento
		initEstrutura();

		// Monta o botão importar
		initImportar();
		
		// Monta o botão exportar
		initExportar();
				

	}


	private void initInicio() {						
		add(new MenuLink<HomePage>("inicio", HomePage.class));

	}

	private void initNovo() {
		add(new MenuLink<HomePage>("novo", NovoArtigoPage.class) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION));
			}
		});	
	}

	private void initEstrutura() {
		add(new MenuLink<HomePage>("estrutura", EstruturaPage.class) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION));
			}
		});		
	}

	private void initImportar() {
		add(new MenuLink<HomePage>("importar", UploadPage.class) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION));
			}
		});		
	}

	private void initExportar() {
		add(new MenuLink<ExportacaoPage>("exportar",ExportacaoPage.class){
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(UIUtils.possuiPermissoes("EXPORT_DATA"));
			}
		});
	}

}

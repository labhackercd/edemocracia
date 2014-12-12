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

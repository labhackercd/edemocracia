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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.panels;

import org.apache.wicket.markup.html.panel.Panel;

import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.eixo.GerenciarEixosPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.proposta.GerenciarPropostasPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.votacao.ConfigurarVotacaoPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.GroupPermissionLink;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.MenuLink;
/**
 * 
 * @author bruno
 * 
 */

public class PriorizacaoAdminMenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public PriorizacaoAdminMenuPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {

		super.onInitialize();
		
		// Monta o botão Gerenciar Eixos
		initGerenciarEixos();

		// Monta o botão Gerenciar Propostas
		initGerenciarPropostas();

		//Monta o botão Configurar Votação
		initConfigurarVotacao();
		
		// Monta o botão Permissões
		initPermissioes();
		
	}

	private void initGerenciarEixos() {						
		add(new MenuLink<GerenciarEixosPage>("gerenciarEixos", GerenciarEixosPage.class));

	}

	private void initGerenciarPropostas() {
		add(new MenuLink<GerenciarPropostasPage>("gerenciarPropostas", GerenciarPropostasPage.class) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
//				setVisible(UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION));
			}
		});	
	}

	private void initConfigurarVotacao() {
		add(new MenuLink<ConfigurarVotacaoPage>("configurarVotacao", ConfigurarVotacaoPage.class) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
//				setVisible(UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION));
			}
		});	
	}
	
	private void initPermissioes() {
		add(new GroupPermissionLink("permissioes", "br.gov.camara.edemocracia.portlets.priorizacao", "priorizacao-model"));
	}

}

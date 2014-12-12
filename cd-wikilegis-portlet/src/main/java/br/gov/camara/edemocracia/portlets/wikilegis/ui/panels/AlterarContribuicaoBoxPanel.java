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

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ContribuicaoDisplay;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AlterarContribuicaoBoxPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(AlterarContribuicaoBoxPanel.class);

	
	private Form<Void> formEdicao;
	private TextArea<String> editTextoArtigo;
	private TextArea<String> editDescricao;
	private long contribuicaoId;
	
	public AlterarContribuicaoBoxPanel(String id) {
		super(id);
		init();
	}
	private void init(){
		initFormEdicao();
		initEditTextoArtigo();
		initEditDescricao();
	}
	
	private void initFormEdicao() {
		formEdicao = new Form<Void>("formEdicao"){

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				gravarAlteracoes();
			}
		};
		add(formEdicao);
	}
	
	private void initEditTextoArtigo() {
		editTextoArtigo = new TextArea<String>("editTextoArtigo",Model.of(""));
		editTextoArtigo.setOutputMarkupId(true);
		formEdicao.add(editTextoArtigo);
	}
	
	private void initEditDescricao() {
		editDescricao = new TextArea<String>("editDescricao",Model.of(""));
		editDescricao.setOutputMarkupId(true);
		formEdicao.add(editDescricao);
	}
	
	public void editarArtigo(ContribuicaoDisplay contribuicao){
		editTextoArtigo.setModelObject(contribuicao.getTexto());
		editDescricao.setModelObject(contribuicao.getDescricao());
		contribuicaoId = contribuicao.getContribuicaoId();
	}
	
	private void gravarAlteracoes(){
		String textoArtigo = editTextoArtigo.getModelObject();
		String descricao = editDescricao.getDefaultModelObjectAsString();
		
		try {
			WikiLegisServiceUtil.atualizaContribuicao(contribuicaoId, textoArtigo, descricao);
		} catch (PortalException e) {
			LOG.error("Erro ao atualizar contribuicao.", e);
		} catch (SystemException e) {
			LOG.error("Erro ao atualizar contribuicao.", e);
		}
	}
}

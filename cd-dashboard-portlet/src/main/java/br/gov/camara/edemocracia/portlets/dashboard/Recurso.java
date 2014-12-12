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
package br.gov.camara.edemocracia.portlets.dashboard;

import br.gov.camara.edemocracia.portlets.dashboard.customquery.QueryExecutor;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.ArtigosComMaiorParticipacao;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.ArtigosComMaisSugestoes;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.BatePapoComMaisMensagens;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.BatePapoComMaisUsuarios;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.BlogsComMaiorParticipacao;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.ComunidadesComMaisConteudosWeb;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.ComunidadesComMaisDocumentos;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.ComunidadesComMaisPaginas;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.TopicosComMaiorParticipacao;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.impl.WikisComMaiorParticipacao;

import com.liferay.portal.model.Layout;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.wiki.model.WikiPage;

public enum Recurso {
	
	TOPICO(1,"Tópico","(Postagens) Tópico", "Postagens" , TopicosComMaiorParticipacao.class, MBThread.class.getName(), false), 
	WIKI(2, "Wiki", "(Comentários) Wiki" , "Comentários" ,  WikisComMaiorParticipacao.class, WikiPage.class.getName(), false), 
	BLOG(3,"Blog", "(Comentários) Blog" , "Comentários" ,  BlogsComMaiorParticipacao.class, BlogsEntry.class.getName(), false),
	ARTIGOS_WIKILEGIS(4,"Artigo", " (Comentários) Wikilégis" , "Comentários" , ArtigosComMaiorParticipacao.class, "br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo", false),
	ARTIGOS_WIKILEGIS_SUGESTOES(5,"Artigo", "(Sugestões) Wikilégis" , "Sugestões" , ArtigosComMaisSugestoes.class, "br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao", false ),
	BATEPAPO_MENSAGENS (6,"Sala", "(Mensagens) Bate-papo" , "Mensagens" , BatePapoComMaisMensagens.class, "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" , false),
	BATEPAPO_USUARIOS (7,"Sala", "(Usuários) Bate-papo" , "Usuários" , BatePapoComMaisUsuarios.class, "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" , false),
	PAGINAS_COMUNIDADE (8,"Comunidade", "(Páginas) Comunidade" , "Páginas" , ComunidadesComMaisPaginas.class, Layout.class.getName() , true),
	DOCUMENTOS_COMUNIDADE (9,"Comunidade", "(Documentos) Comunidade" , "Documentos" , ComunidadesComMaisDocumentos.class, DLFileEntry.class.getName() , true),
	CONTEUDO_WEB_COMUNIDADE (10,"Comunidade", "(Conteúdos Web) Comunidade" , "Conteúdos Web" , ComunidadesComMaisConteudosWeb.class, JournalArticle.class.getName() , true);
	
	private int id;
	private String label;
	private String labelConfiguracao;
	private String medida;
	private Class<? extends QueryExecutor> queryExecutor;
	private String className;
	private boolean quantitativoGeral;
	
	private Recurso (int id, String label , String labelConfiguracao ,String medida, Class<? extends QueryExecutor> queryExecutor , String className , boolean quantitativoGeral) {
		this.id = id;
		this.label = label;
		this.labelConfiguracao = labelConfiguracao;
		this.medida = medida;
		this.queryExecutor = queryExecutor;
		this.className = className;
		this.quantitativoGeral = quantitativoGeral;
	}
	
	/**
	 * Retorna um objeto Recursos correspondente
	 * 
	 * Se não encontrar retorna null
	 * 
	 * @param id
	 * @return
	 */
	public static Recurso withValue(int id){
		Recurso[] recursos = values();
		
		for (Recurso recurso : recursos) {
			if (recurso.getId() == id ) {
				return recurso;
			}
		}
		
		return null;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getMedida() {
		return medida;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabelConfiguracao() {
		return labelConfiguracao;
	}
	
	public Class<? extends QueryExecutor> getQueryExecutor() {
		return queryExecutor;
	}
	
	public String getClassName() {
		return className;
	}
	
	public boolean isQuantitativoGeral() {
		return quantitativoGeral;
	}
	
	
	
}

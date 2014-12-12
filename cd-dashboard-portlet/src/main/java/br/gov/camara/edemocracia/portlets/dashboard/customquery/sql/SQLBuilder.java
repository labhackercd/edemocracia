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
package br.gov.camara.edemocracia.portlets.dashboard.customquery.sql;

import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.LayoutPrototype;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

public class SQLBuilder {
	
	public static String buildSQLWikisComMaiorParticipacao(Configuracao config) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" W.resourcePrimKey as id, G.groupId as groupId, W.title as titulo, ");
		sb.append(" G.name as tituloComunidade, COUNT(*) as quantidade ");
		sb.append(" FROM MBMessage M ");
		sb.append(" INNER JOIN WikiPage W ON M.classPK = W.resourcePrimKey AND W.version = 1 ");
		sb.append(" INNER JOIN Group_ G	ON W.groupId = G.groupId ");
		sb.append(" WHERE M.companyId = ? AND M.classNameId = ? AND M.parentMessageId <> 0 ");
		sb.append(" AND M.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "M", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY M.rootMessageId ,  W.title , G.name , G.groupId, W.resourcePrimKey ");
		sb.append(" ORDER BY quantidade DESC ");
		
		return  sb.toString();
		
	}
	
	public static String buildSQLBlogsComMaiorParticipacao(Configuracao config) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" B.entryId as id, G.groupId as groupId, B.title as titulo, ");
		sb.append(" G.name as tituloComunidade, COUNT(*) as quantidade ");
		sb.append(" FROM MBMessage M ");
		sb.append(" INNER JOIN BlogsEntry B ON M.classPK = B.entryId ");
		sb.append(" INNER JOIN Group_ G	ON B.groupId = G.groupId ");
		sb.append(" WHERE M.companyId = ? AND M.classNameId = ? AND M.parentMessageId <> 0 ");
		sb.append(" AND M.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "M", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY M.rootMessageId ,  B.title , G.name , G.groupId, B.entryId ");
		sb.append(" ORDER BY quantidade DESC ");
		
		return  sb.toString();
		
	}
	
	public static String buildSQLTopicosComMaiorParticipacao(Configuracao config){
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append("g.groupId, g.name AS tituloComunidade, ");
		sb.append("mb.threadId as id, count(threadId) AS quantidade, ");
		sb.append(" (SELECT subject FROM MBMessage mb2 ");
		sb.append(" WHERE mb2.threadId = mb.threadId ");
		sb.append(" AND mb2.parentMessageId = 0 ");
		sb.append(" ) AS titulo ");
		sb.append(" FROM MBMessage mb ");
		sb.append(" INNER JOIN Group_ g ON g.groupId = mb.groupId ");
		sb.append(" WHERE mb.classNameId = 0 ");
		sb.append(" AND g.companyId = ? ");
		sb.append(" AND mb.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "mb", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY threadId, Name, g.groupId ");
		sb.append(" ORDER BY quantidade DESC; ");
		return sb.toString();
		
	}
	
	public static String buildSQLArtigosWikilegisComMaiorParticipacao(Configuracao config){
	
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" A.artigoId as id , G.groupId , G.name as tituloComunidade, ");
		sb.append(" COUNT(*) as quantidade, ");
		sb.append(" (SELECT A2.texto FROM CDWL_Artigo A2  ");
		sb.append(" WHERE A2.artigoId = a.artigoId) AS titulo ");
		sb.append(" FROM MBMessage m  ");
		sb.append(" INNER JOIN CDWL_Artigo A ON A.artigoId = M.classPK ");
		sb.append(" INNER JOIN Group_ G ");
		sb.append(" ON A.groupId = G.groupId ");
		sb.append(" WHERE M.companyId = ? AND M.classNameId = ? AND M.parentMessageId <> 0  ");
		sb.append(" AND m.createDate BETWEEN ? AND ? ");

		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "m", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY M.rootMessageId,G.name , A.artigoId, G.groupId ");
		sb.append(" ORDER BY quantidade DESC; ");
		return sb.toString();
		
	}
	
	public static String buildSQLArtigosWikilegisComMaisSugestoes(Configuracao config){
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" C.artigoId as id , G.groupId ,G.name as tituloComunidade, ");
		sb.append(" COUNT(*) as quantidade, ");
		sb.append(" (SELECT A2.texto FROM CDWL_Artigo A2  ");
		sb.append("  WHERE A2.artigoId = C.artigoId) AS titulo ");
		sb.append(" FROM CDWL_Contribuicao C  ");
		sb.append(" INNER JOIN CDWL_Artigo A ON A.artigoId = C.artigoId  ");
		sb.append(" INNER JOIN Group_ G ");
		sb.append(" ON A.groupId = G.groupId ");
		sb.append(" WHERE A.companyId = ? ");
		sb.append(" AND C.data_ BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "A", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY C.artigoId , G.name, G.groupId ");
		sb.append(" ORDER BY quantidade DESC; ");
		return sb.toString();
		
	}
	
	public static String buildSQLBatePaposComMaisMensagens(Configuracao config){
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" M.chatRoomId as id ,R.roomName as titulo , ");
		sb.append(" COUNT(*) as quantidade, ");
		sb.append(" G.groupId , G.name as tituloComunidade ");
		sb.append(" FROM CDChat_ChatRoomMessage M ");
		sb.append(" INNER JOIN CDChat_ChatRoom R ON M.chatRoomId = R.roomId  ");
		sb.append(" INNER JOIN Group_ G ON R.groupId = G.groupId ");
		sb.append(" WHERE R.companyId = ? ");
		sb.append(" AND M.messageType = 0 and M.messageStatus = 1 ");
		sb.append(" AND M.messageTS BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "R", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY M.chatRoomId, R.roomName, G.groupId, G.name ");
		sb.append(" ORDER BY quantidade DESC; ");
		
		return sb.toString();
	}
	
	public static String buildSQLBatePaposComMaisUsuarios(Configuracao config) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" R.roomId as id, R.roomName AS titulo, ");
		sb.append(" (SELECT COUNT(DISTINCT M.senderName) FROM CDChat_ChatRoomMessage M WHERE M.chatRoomId = R.roomId AND M.messageType = 1) as quantidade, ");
		sb.append(" R.groupId , G.name as tituloComunidade ");
		sb.append(" FROM CDChat_ChatRoom R ");
		sb.append(" INNER JOIN Group_ G ON R.groupId = G.groupId ");
		sb.append(" WHERE R.companyId = ? ");
		sb.append(" AND R.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "R", config.getComunidadeSelecionada()));
		
		sb.append(" ORDER BY quantidade DESC; ");
		
		return sb.toString();
	}
	
	public static String buildSQLComunidadesComMaisPaginasCriadas(Configuracao config) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" L.groupId, G.name AS tituloComunidade ,count(*) AS quantidade  ");
		sb.append(" FROM Layout L ");
		sb.append(" INNER JOIN Group_ G ON L.groupId = G.groupId ");
		sb.append(" WHERE L.companyId = ? ");
		sb.append(" AND L.groupId NOT IN (select groupId from Group_ where classNameId in " );
		sb.append(" (select classNameId from ClassName_ where value = '"+ LayoutPrototype.class.getName() +"' OR value = '"+ User.class.getName() +"' OR value = '"+ UserGroup.class.getName() +"' OR value = '"+ LayoutSetPrototype.class.getName() +"' ))");
		sb.append(" AND G.name <> '"+ GroupConstants.CONTROL_PANEL +"'");
		sb.append(" AND L.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "L", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY L.groupId , G.name ");
		sb.append("  ORDER BY quantidade DESC , tituloComunidade ASC; ");
		
		return sb.toString();
	}

	public static String buildSQLComunidadesComMaisDocumentosCriados(Configuracao config) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" DL.groupId , G.name as tituloComunidade , COUNT(*) AS quantidade ");
		sb.append(" FROM DLFileEntry DL  ");
		sb.append(" INNER JOIN Group_ G ON DL.groupId = G.groupId ");
		sb.append(" WHERE DL.companyId = ? ");
		sb.append(" AND DL.groupId NOT IN (select groupId from Group_ where classNameId in " );
		sb.append(" (select classNameId from ClassName_ where value = '" + User.class.getName() +"'))");
		sb.append(" AND DL.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "DL", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY DL.groupId , G.name ");
		sb.append("  ORDER BY quantidade DESC , tituloComunidade ASC; ");
		
		return sb.toString();
	}
	
	public static String buildSQLComunidadesComMaisConteudosWebCriados(Configuracao config) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" J.groupId, G.name AS tituloComunidade ,count (DISTINCT J.articleId) as quantidade ");
		sb.append(" FROM JournalArticle J  ");
		sb.append(" INNER JOIN Group_ G ON J.groupId = G.groupId ");
		sb.append(" WHERE J.companyId = ? ");
		sb.append(" AND J.groupId IN (SELECT groupId FROM Group_ WHERE classNameId NOT IN  " );
		sb.append(" (SELECT classNameId FROM ClassName_  where value = '"+ User.class.getName() +"' OR value = '"+ UserGroup.class.getName() +"' OR value = '"+ LayoutSetPrototype.class.getName() +"'))");
		sb.append(" AND J.createDate BETWEEN ? AND ? ");
		
		sb.append(montarSQLRestricaoDeComunidadeSeNecessario("AND", "J", config.getComunidadeSelecionada()));
		
		sb.append(" GROUP BY J.groupId , G.name ");
		sb.append("  ORDER BY quantidade DESC , J.groupId DESC; ");
		
		return sb.toString();
	}
	
	private static String montarSQLRestricaoDeComunidadeSeNecessario(final String operadorSQL , final String apelidoDaTabela, final long comunidadeSelecionada) {

		if (comunidadeSelecionada != Configuracao.TODAS_COMUNIDADES) {
			String sqlRestricaoComunidade = criarSQLParaRestricaoDeComunidade(apelidoDaTabela, comunidadeSelecionada);
			
			if(sqlRestricaoComunidade != null){
				return " " + operadorSQL + " " + sqlRestricaoComunidade;
			}
		} 

		return "";
	}
	
	private static String criarSQLParaRestricaoDeComunidade(final String apelidoDaTabela, final long comunidadeSelecionada) {
		
		if (comunidadeSelecionada > 0) {
			
			return apelidoDaTabela + "." + "groupId = ? ";
		
		} else if (comunidadeSelecionada == Configuracao.SOMENTE_COMUNIDADES_PUBLICAS) {
			
			return apelidoDaTabela + "." + "groupId in ( " + getSqlParaRestricaoDeComunidadePorTipo(GroupConstants.TYPE_SITE_OPEN) + " ) "; 
			
		} else if (comunidadeSelecionada == Configuracao.SOMENTE_COMUNIDADES_PRIVADAS) {
			
			return apelidoDaTabela + "." + "groupId in ( " + getSqlParaRestricaoDeComunidadePorTipo(GroupConstants.TYPE_SITE_PRIVATE) + " ) ";
			
		} else if (comunidadeSelecionada == Configuracao.SOMENTE_COMUNIDADES_RESTRITAS) {
			
			return apelidoDaTabela + "." + "groupId in ( " + getSqlParaRestricaoDeComunidadePorTipo(GroupConstants.TYPE_SITE_RESTRICTED) + " ) ";
			
		} else {
			return null;
		}
	}
	
	/**
	 * @param tipoComunidadeId Disponivel em {@link GroupConstants} iniciados por TYPE_SITE
	 * @return retorna uma instrucao SELECT para buscar todas as comunidades que são do tipo especificado
	 */
	private static String getSqlParaRestricaoDeComunidadePorTipo(int tipoComunidadeId) {
		StringBuilder sql = new StringBuilder();
	
		sql.append(" SELECT GR.groupId FROM Group_ GR ");
		sql.append(" WHERE GR.classNameId = " + getGroupClassNameId());
		sql.append(" AND GR.parentGroupId = " + GroupConstants.DEFAULT_PARENT_GROUP_ID + " ");
		sql.append(" AND GR.active_  = 1 ");
		sql.append(" AND GR.name <> '" + GroupConstants.CONTROL_PANEL + "'");
		sql.append("AND GR.type_ = " + tipoComunidadeId);
		
		return sql.toString();
	}
	
	
	
	private static long getGroupClassNameId() {
		return ClassNameLocalServiceUtil.getClassNameId(Group.class);
	}
}

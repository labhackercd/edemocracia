package br.gov.camara.edemocracia.portlets.graficos.service.impl;

import br.gov.camara.edemocracia.portlets.graficos.DadosUsuarioDTO;

import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.wiki.model.WikiPage;

public enum ParticipacaoSQLQueries {

	// TODO adicionar o classnameId do layout na sql de dentro da clausula IN

	SQLPOSTAGENSFORUM {

		String sql = " SELECT m.userid,m.username, u.emailaddress, count(*) "
				+ " FROM mbmessage m "
				+ " LEFT JOIN user_ u "
				+ " ON m.userid = u.userid "
				+ " WHERE m.classnameid = 0 and m.groupid "
				+ " IN (select groupid from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#  ) #PERIODO# "
				+ " GROUP BY m.userid, m.username , u.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and m.createDate between ? and ? ");

		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "postagensForum";
		}

	},

	SQLCOMENTARIOSWIKILEGIS {

		String sql = " SELECT m.userid,m.username, u.emailaddress , count(*) "
				+ " FROM mbmessage m "
				+ " LEFT JOIN user_ u "
				+ " ON m.userid = u.userid "
				+ " INNER JOIN CDWL_Artigo a "
				+ " ON m.classPK = a.artigoId "
				+ " WHERE m.classnameid = (SELECT cl.classnameid FROM classname_ cl WHERE cl.value = 'br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo') "
				+ " and m.parentmessageid != 0 and m.groupid "
				+ " IN (select groupid from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#) #PERIODO# "
				+ " GROUP BY m.userid, m.username , u.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and m.createDate between ? and ? ");

		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "comentariosWikilegis";
		}
	},

	SQLCOMENTARIOSCONTEUDOWEB {

		String sql = " SELECT m.userid,m.username, u.emailaddress, count(*) "
				+ " FROM mbmessage m "
				+ " LEFT JOIN user_ u "
				+ " ON m.userid = u.userid "
				+ " WHERE m.classnameid = (SELECT cl.classnameid FROM classname_ cl WHERE cl.value = '"+ JournalArticle.class.getName() +"')"
				+ " and m.parentmessageid != 0 and m.groupid "
				+ " IN (select groupid from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#) #PERIODO# "
				+ " GROUP BY m.userid, m.username , u.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and m.createDate between ? and ? ");

		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "comentariosConteudoWeb";
		}

	},

	SQLCOMENTARIOSWIKI {

		String sql = " SELECT m.userid,m.username, u.emailaddress , count(*) "
				+ " FROM mbmessage m "
				+ " LEFT JOIN user_ u "
				+ " ON m.userid = u.userid "
				+ " WHERE m.classnameid = (SELECT cl.classnameid FROM classname_ cl WHERE cl.value = '"+ WikiPage.class.getName() +"')"
				+ " and m.parentmessageid != 0 and m.groupid "
				+ " IN (select groupid from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#  ) #PERIODO# "
				+ " GROUP BY m.userid, m.username , u.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and m.createDate between ? and ? ");

		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "comentariosWiki";
		}

	},

	SQLCOMENTARIOSDOCUMENTOS {

		String sql = " SELECT m.userid,m.username, u.emailaddress , count(*) "
				+ " FROM mbmessage m "
				+ " LEFT JOIN user_ u "
				+ " ON m.userid = u.userid "
				+ " WHERE m.classnameid = (SELECT cl.classnameid FROM classname_ cl WHERE cl.value = '"+ DLFileEntry.class.getName() +"')"
				+ " and m.parentmessageid != 0 and m.groupid "
				+ " IN (select groupid from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#) #PERIODO# "
				+ " GROUP BY m.userid, m.username , u.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and m.createDate between ? and ? ");

		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "comentariosDocumentos";
		}

	},

	SQLCOMENTARIOSBLOG {

		String sql = " SELECT m.userid,m.username, u.emailaddress, count(*) "
				+ " FROM mbmessage m LEFT JOIN user_ u "
				+ " ON m.userid = u.userid "
				+ " WHERE m.classnameid = (SELECT cl.classnameid FROM classname_ cl WHERE cl.value = '"+ BlogsEntry.class.getName() +"')"
				+ " and m.parentmessageid != 0 and m.groupid "
				+ " IN (select groupid from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#) #PERIODO# "
				+ " GROUP BY m.userid, m.username , u.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and m.createDate between ? and ? ");

		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "comentariosBlog";
		}
	},

	SQLCONTRIBUICOESWIKILEGIS {
		
		
		
		String sql = " SELECT C.userId, U.firstname "+ Constantes.CONCATENADOR_SQL +" ' ' "+ Constantes.CONCATENADOR_SQL +" U.middlename "+ Constantes.CONCATENADOR_SQL +" ' ' "+ Constantes.CONCATENADOR_SQL +" U.lastname as username, U.emailaddress , count(*) "
				+ " FROM cdwl_artigo A "
				+ " INNER JOIN cdwl_contribuicao C "
				+ " ON A.artigoid = C.artigoid "
				+ " LEFT JOIN user_ U "
				+ " ON C.userid = U.userid "
				+ " WHERE A.groupid IN (select groupId from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#) #PERIODO#"
				+ " GROUP BY  C.userId ,U.emailaddress, U.firstname , U.middlename , U.lastname ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and C.data_ between ? and ? ");
		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "contribuicoesWikilegis";
		}

	},

	SQLALTERACOESWIKI {
		String sql = " SELECT W.userid, W.username, U.emailaddress , count(*) "
				+ " FROM wikipage W "
				+ " LEFT JOIN user_ U "
				+ " ON W.userid = U.userid"
				+ " WHERE W.groupid in (select groupId from group_ where groupid = #GROUPID# or parentgroupid = #GROUPID#) and W.status = 0 #PERIODO#"
				+ " GROUP BY W.userid, W.username ,  U.emailaddress ";

		@Override
		String getQueryParaPeriodo(Long groupId) {
			return mountSQL(sql, groupId, " and W.createDate between ? and ? ");
		};

		@Override
		public String getSql() {
			return sql;
		}

		@Override
		String getPropriedadeBean() {
			return "alteracoesWiki";
		}

	};

	protected abstract String getSql();

	/**
	 * Retorna a query com restrições de período de data para serem setados
	 * Padrão de retorno : userId, username, email, nº de participações
	 * 
	 * @param groupId
	 * @param classnameId
	 * @param clausulaPeriodo
	 *            sql de restrição de período
	 * @return
	 */
	abstract String getQueryParaPeriodo(Long groupId);

	/**
	 * Retorna o nome da propriedade correspondente no bean DadosUsuarioDTO
	 * 
	 * @see DadosUsuarioDTO
	 * @return
	 */
	abstract String getPropriedadeBean();

	String mountSQL(String sql, Long groupId, String clausulaPeriodo) {
		sql = sql.replace("#PERIODO#", clausulaPeriodo);
		sql = sql.replace("#GROUPID#", Long.toString(groupId));

		return sql;
	}
	
	String getQuery(Long groupId) {
		return mountSQL(getSql(), groupId, "");
	};

}

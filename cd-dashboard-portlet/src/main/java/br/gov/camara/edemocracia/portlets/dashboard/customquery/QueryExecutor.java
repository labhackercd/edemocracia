package br.gov.camara.edemocracia.portlets.dashboard.customquery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.gov.camara.edemocracia.portlets.dashboard.cache.util.CacheKey;
import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

public abstract class QueryExecutor {

	protected abstract List<RecursoDTO> listar(Connection connection, Configuracao config, long companyId) throws SQLException;

	public abstract CacheKey getChaveCache();

	public final List<RecursoDTO> listarRecursosComMaiorParticipacao(Connection connection, Configuracao config, long companyId) throws SQLException {
		List<RecursoDTO> retorno = listar(connection, config, companyId);
		adicionarClassificacaoETruncarTitulo(retorno);
		buscarEscopoSeNecessario(retorno, connection);
		return retorno;
	}

	public static int getQuantidadeMaximaDeResultados(Configuracao config) {
		if (config.getQtdDeRecursos() == 0) {
			return Configuracao.QUANTIDADE_DE_RECURSOS_PADRAO;
		} else {
			return config.getQtdDeRecursos();
		}
	}

	/**
	 * Verifica se o recurso está em um escopo especifico. Se estiver, busca a
	 * página de escopo correspondente
	 * 
	 * @throws SQLException
	 */
	private static void buscarEscopoSeNecessario(List<RecursoDTO> recursos, Connection conn) throws SQLException {

		for (RecursoDTO recurso : recursos) {

			// ACERTAR DOCUMENTACAO que possuem escopo o liferay cria um
			// registro intermediario na tabela Group
			// e o nome da comunidade fica sendo o plid da página de escopo.

			String tituloComunidade = recurso.getTituloComunidade();
			boolean possuiEscopo = StringUtils.isNumeric(tituloComunidade);

			if (possuiEscopo) {
				String escopo = buscarEscopo(conn, tituloComunidade);
				if (StringUtils.isBlank(escopo)) {
					recurso.setTituloComunidade("Comunidade Global");
				} else {
					recurso.setTituloComunidade(escopo);
				}
			}
		}
	}

	/**
	 * Retorna a comunidade e a página correspondente ao escopo
	 * 
	 * Ex: Politica Espaçial ("/pagina")
	 * 
	 * @param conn
	 * @param plid
	 * @return
	 * @throws SQLException
	 */
	private static String buscarEscopo(Connection conn, String plid) throws SQLException {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT g.name as comunidade , l.friendlyURL as paginaEscopo ");
		sb.append(" FROM Layout l  ");
		sb.append(" INNER JOIN Group_ g ON l.groupId = g.groupId ");
		sb.append(" WHERE l.plid = ? ");
		String sql = sb.toString();

		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, Long.parseLong(plid));
			result = ps.executeQuery();

			String tituloComunidadeComEscopo = "";
			while (result.next()) {
				String comunidade = result.getString("comunidade");
				String paginaEscopo = result.getString("paginaEscopo");
				tituloComunidadeComEscopo = comunidade + " (escopo: " + paginaEscopo + ")";
			}

			return tituloComunidadeComEscopo;

		} finally {
			DataAccess.cleanUp(result);
			DataAccess.cleanUp(ps);
		}

	}
	
	/**
	 * Trunca o titulo, deixando apenas 88 caracteres
	 * 
	 * @param recurso
	 */
	private static void truncarTitulo(RecursoDTO recurso) {

		String titulo = recurso.getTitulo();
		if (StringUtils.isNotBlank(titulo) &&  titulo.length() > 85) {
			recurso.setTitulo(titulo.substring(0, 85) + " ...");
		}

	}

	private static void adicionarClassificacaoETruncarTitulo(List<RecursoDTO> recursos) {
		int i = 1;
		for (RecursoDTO recursoDTO : recursos) {
			truncarTitulo(recursoDTO);
			recursoDTO.setClassificacao(i);
			i++;
		}
	}
}

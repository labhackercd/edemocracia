package br.gov.camara.edemocracia.portlets.dashboard.customquery.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import br.gov.camara.edemocracia.portlets.dashboard.cache.util.CacheKey;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.QueryExecutor;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.sql.SQLBuilder;
import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

public class ArtigosComMaiorParticipacao extends QueryExecutor {

	@Override
	protected List<RecursoDTO> listar(Connection connection, Configuracao config, long companyId) throws SQLException {
		boolean possuiComunidade = config.getComunidadeSelecionada() > 0;

		long artigoWikilegis = ClassNameLocalServiceUtil.getClassNameId("br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecursoDTO> retorno = new ArrayList<RecursoDTO>();
		String sql = SQLBuilder.buildSQLArtigosWikilegisComMaiorParticipacao(config);

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, companyId);
			pstmt.setLong(2, artigoWikilegis);

			pstmt.setTimestamp(3, new Timestamp(config.getDataInicioPeriodoEmMillis()));
			pstmt.setTimestamp(4, new Timestamp(config.getDataFimPeriodoEmMillis()));

			if (possuiComunidade) {
				pstmt.setLong(5, config.getComunidadeSelecionada());
			}
			
			pstmt.setMaxRows(getQuantidadeMaximaDeResultados(config));
			
			rs = pstmt.executeQuery();

			BeanListHandler<RecursoDTO> handler = new BeanListHandler<RecursoDTO>(RecursoDTO.class);
			retorno = handler.handle(rs);
			
		} finally {
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(pstmt);
		}

		return retorno;
	}

	@Override
	public CacheKey getChaveCache() {
		return CacheKey.COMENTARIOS_WIKILEGIS;
	}
	
}

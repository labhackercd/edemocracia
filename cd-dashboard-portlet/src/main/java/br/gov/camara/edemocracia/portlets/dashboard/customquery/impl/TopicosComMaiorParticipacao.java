package br.gov.camara.edemocracia.portlets.dashboard.customquery.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

import br.gov.camara.edemocracia.portlets.dashboard.cache.util.CacheKey;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.QueryExecutor;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.sql.SQLBuilder;
import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

public class TopicosComMaiorParticipacao extends QueryExecutor {

	@Override
	protected List<RecursoDTO> listar (Connection conn, Configuracao config, long companyId) throws SQLException {

	boolean possuiComunidade = config.getComunidadeSelecionada() > 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecursoDTO> retorno = new ArrayList<RecursoDTO>();
		String sql = SQLBuilder.buildSQLTopicosComMaiorParticipacao(config);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, companyId);
			
			pstmt.setTimestamp(2, new Timestamp(config.getDataInicioPeriodoEmMillis()));
			pstmt.setTimestamp(3, new Timestamp(config.getDataFimPeriodoEmMillis()));
		
			if (possuiComunidade) {
				pstmt.setLong(4, config.getComunidadeSelecionada());
			}
			
			pstmt.setMaxRows(getQuantidadeMaximaDeResultados(config));
			
			rs = pstmt.executeQuery();
			
			BeanListHandler<RecursoDTO> handler = new BeanListHandler<RecursoDTO>(RecursoDTO.class);
			retorno = handler.handle(rs);
			
						
			return retorno;
		} finally {
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(pstmt);
		}
	}

	@Override
	public CacheKey getChaveCache() {
		return CacheKey.TOPICO;
	}

}

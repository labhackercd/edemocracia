package br.gov.camara.edemocracia.portlets.chat.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import br.gov.camara.edemocracia.portlets.chat.wrapper.CanalWrapper;

public class DAOWebcamara {

	private static final Log LOG = LogFactoryUtil.getLog(ConexaoWebcamara.class);

	public static List<CanalWrapper> getMapeamentoCanais() {
		Connection conn = null;
		Statement statement = null;
		List<CanalWrapper> retorno = null;
		ResultSet resultSet = null;

		try {
			conn = ConexaoWebcamara.getConnection();
			
			String sql = "select nomCanal, nomPontoAlta from Canais where datInicio < getDate() and datFim is null";
			
			statement = conn.createStatement();
			
			resultSet = statement.executeQuery(sql);

			BeanListHandler<CanalWrapper> handle = new BeanListHandler<CanalWrapper>(CanalWrapper.class);

			retorno = handle.handle(resultSet);
			
		} catch (SQLException e) {
			LOG.error("Ocorreu um erro de banco ao recuperar os canais",e);
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao recuperar os canais",e);
		} finally {
			DbUtils.closeQuietly(conn, statement, resultSet);
		}
		
		return retorno;
	}
	
	
	
}

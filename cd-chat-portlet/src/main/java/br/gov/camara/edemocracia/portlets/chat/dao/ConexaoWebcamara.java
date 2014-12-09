package br.gov.camara.edemocracia.portlets.chat.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ConexaoWebcamara {

	private static final Log LOG = LogFactoryUtil.getLog(ConexaoWebcamara.class);

	public static Connection getConnection() {
		DataSource ds;
		Connection conn = null;
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Sinais");
			conn = ds.getConnection();
		} catch (Exception e) {
			LOG.error("Erro ao obter conexão do webCamara.", e);
		}
		return conn;
	}

}

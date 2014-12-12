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

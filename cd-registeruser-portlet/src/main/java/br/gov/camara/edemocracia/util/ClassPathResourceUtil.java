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
package br.gov.camara.edemocracia.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * @author P_7339
 *
 */
public final class ClassPathResourceUtil {
	
	private static Log _log = LogFactoryUtil.getLog(ClassPathResourceUtil.class);
	
	/**
	 * Carrega um template, utilizando inicialmente o classloader local e, 
	 * depois, o classloader do portal.
	 * 
	 * Caso não encontre nenhum arquivo, retorna uma string vazia
	 * 
	 * @param fileName
	 * @return
	 */
	public static final String loadResource(String fileName) {
		ClassLoader clPortal = PortalClassLoaderUtil.getClassLoader();
		ClassLoader clThread = Thread.currentThread().getContextClassLoader();
		
		InputStream is = clThread.getResourceAsStream(fileName);
		if (is == null) {
			is = clPortal.getResourceAsStream(fileName);
			if (is == null)
				return "";
		}
		InputStreamReader reader = new InputStreamReader(is);
		try {
			char[] chr = new char[1024];
			StringBuilder sb = new StringBuilder();
			int readed;
			while ( (readed = reader.read(chr)) != -1) {
				sb.append(chr, 0, readed);
			}
			return sb.toString();
		} catch (IOException e) {
			_log.error(String.format("Erro recuperando template %s", fileName), e);
			return "";
		} finally {
			try {
				is.close();
			} catch (IOException ignore) {
			}
		}
	}
}

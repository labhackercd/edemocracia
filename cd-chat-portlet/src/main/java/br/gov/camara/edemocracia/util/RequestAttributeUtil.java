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

import java.lang.reflect.Constructor;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

public class RequestAttributeUtil {
	private RequestAttributeUtil() {
	}

	private static final Log LOG = LogFactoryUtil.getLog(RequestAttributeUtil.class);

	@SuppressWarnings("unchecked")
	private static <T> T get(HttpServletRequest req, String att, Class<T> clazz) {
		Object val = req.getAttribute(att);
		// Se já for do tipo definido, retorna
		if (val != null && clazz.isInstance(val))
			return (T) val;

		String value;
		if (val == null)
			value = "";
		else
			value = val.toString();

		// Caso especial
		if (clazz == Character.class) {
			if (value.length() != 0)
				throw new IllegalArgumentException("Invalid cast to Character");
			Character chr = value.charAt(0);
			return (T) chr;
		} else if (clazz == Boolean.class) {
			return (T) Boolean.valueOf(GetterUtil.get(value, false));
		}

		//
		try {
			Constructor<T> ctor = clazz.getConstructor(String.class);
			return ctor.newInstance(value);
		} catch (Exception e) {
			LOG.error("Nao foi possivel instanciar " + clazz.getName(), e);
			throw new IllegalArgumentException("Invalid class " + clazz.getName());
		}
	}

	public static Long getLong(HttpServletRequest req, String att) {
		return get(req, att, Long.class);
	}

	public static Integer getInteger(HttpServletRequest req, String att) {
		return get(req, att, Integer.class);
	}

	public static String getString(HttpServletRequest req, String att) {
		return get(req, att, String.class);
	}

	public static Boolean getBoolean(HttpServletRequest req, String att) {
		return get(req, att, Boolean.class);
	}
}

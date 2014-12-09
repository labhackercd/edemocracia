package br.gov.camara.edemocracia.util;

import java.util.Enumeration;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Utilitários para gerenciamento do escopo "flash"
 * 
 * @author P_7339
 * 
 */
public class FlashScopeUtil {
	private FlashScopeUtil() {
	}

	private static final Log LOG = LogFactoryUtil.getLog(FlashScopeUtil.class);

	/**
	 * Copia os parâmetros para o escopo da requisição
	 * 
	 * @param req
	 * @param att
	 * @param defaultValue
	 */
	public static void copyToRequest(PortletRequest req, String att, Object defaultValue) {
		PortletSession session = req.getPortletSession(false);
		if (session == null)
			req.setAttribute(att, defaultValue);
		else {
			Object obj = session.getAttribute("FLASH_" + att);
			if (obj == null)
				req.setAttribute(att, defaultValue);
			else
				req.setAttribute(att, obj);
			session.removeAttribute("FLASH_" + att);
		}
	}

	/**
	 * Copia os valores para a requisição.
	 * 
	 * Se o valor existir na sessão, copia para a requisição Se não existir, e o
	 * objeto tiver sido informado, utiliza-o Se não o objeto não for informado,
	 * tenta obter da sessão. Se não conseguir, utiliza o default
	 * 
	 * @param req
	 * @param att
	 * @param propName
	 * @param obj
	 * @param defaultValue
	 */
	public static void copyToRequest(PortletRequest req, String att, String propName, Object obj, Object defaultValue) {
		PortletSession session = req.getPortletSession(false);
		if (session != null) {
			Object val = session.getAttribute("FLASH_" + att);
			if (val != null) {
				req.setAttribute(att, val);
				session.removeAttribute("FLASH_" + att);
				return;
			}
		}

		// Não existe na sessão
		if (obj == null) {
			req.setAttribute(att, defaultValue);
		} else {
			// Obtem o valor do objeto e copia - aqui apenas strings
			try {
				Object value = PropertyUtils.getProperty(obj, propName);
				req.setAttribute(att, value);
			} catch (Exception e) {
				LOG.error("Erro ao copiar propriedade " + propName + " da classe " + obj.getClass().getName(), e);
			}
		}
	}

	/**
	 * Limpa o escopo flash
	 * 
	 * @param req
	 */
	public static void clearFlashScope(PortletRequest req) {
		PortletSession session = req.getPortletSession(false);
		if (session == null)
			return;
		Enumeration<String> attNames = session.getAttributeNames();
		while (attNames.hasMoreElements()) {
			String att = attNames.nextElement();
			if (att.startsWith("FLASH_"))
				session.removeAttribute(att);
		}
	}

	/**
	 * Altera um valor no escopo flash
	 * 
	 * @param req
	 * @param name
	 * @param value
	 */
	public static void set(PortletRequest req, String name, Object value) {
		req.getPortletSession().setAttribute("FLASH_" + name, value);
	}

	/**
	 * Limpa o escopo flash
	 * 
	 * @param req
	 */
	public static void clearFlashScope(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null)
			return;
		@SuppressWarnings("unchecked")
		Enumeration<String> attNames = session.getAttributeNames();
		while (attNames.hasMoreElements()) {
			String att = attNames.nextElement();
			if (att.startsWith("FLASH_"))
				session.removeAttribute(att);
		}
	}

}

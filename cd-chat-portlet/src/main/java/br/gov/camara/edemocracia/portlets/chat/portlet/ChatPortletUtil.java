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
package br.gov.camara.edemocracia.portlets.chat.portlet;

import java.util.Calendar;
import java.util.Date;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author P_7339
 * 
 */
public class ChatPortletUtil {

	public static Date addToDate(Date date, int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		return cal.getTime();
	}

	public static boolean checkPermission(PortletRequest request, String action) {
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker checker = td.getPermissionChecker();
		long groupId = td.getScopeGroupId();
		return checker.hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, action);
	}

	public static boolean checkPermission(HttpServletRequest request, String action) {
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker checker = td.getPermissionChecker();
		long groupId = td.getScopeGroupId();
		return checker.hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, action);
	}

	/**
	 * Verifica se a sala está aberta
	 * 
	 * @param chatRoom
	 * @return
	 */
	public static boolean checkOpen(ChatRoom chatRoom) {
		Date now = new Date();
		// Verifica se a sala está aberta
		if (chatRoom == null)
			return true;
		boolean open = chatRoom.getStatus() == RoomStatus.Opened.getValue() || chatRoom.getOpenPolicy() == RoomOpenPolicy.Always.getValue();
		if (!open && chatRoom.getOpenPolicy() == RoomOpenPolicy.Scheduled.getValue()) {
			Date from = chatRoom.getOpenFrom();
			if (from == null)
				from = now;
			Date until = chatRoom.getOpenUntil();
			if (until == null)
				until = now;
			open = (from.before(now) || from.equals(now)) && (now.before(until) || now.equals(until));
		}
		return open;
	}
}

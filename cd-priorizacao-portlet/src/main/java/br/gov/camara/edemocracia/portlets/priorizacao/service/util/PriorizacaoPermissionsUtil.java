package br.gov.camara.edemocracia.portlets.priorizacao.service.util;

import com.liferay.portal.security.permission.PermissionChecker;

/**
 * Utilitário para verificação de permissões
 * 
 * @author robson
 * 
 */
public class PriorizacaoPermissionsUtil {

	public static boolean hasPermission(PermissionChecker checker, long groupId, String actionId) {
		return checker.hasPermission(groupId, "br.gov.camara.edemocracia.portlets.priorizacao", groupId, actionId);
	}
}

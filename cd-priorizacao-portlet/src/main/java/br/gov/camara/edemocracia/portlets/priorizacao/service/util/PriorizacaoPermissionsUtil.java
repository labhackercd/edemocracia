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

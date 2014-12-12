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
package hooks;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletCategoryKeys;

public class EDemocraciaControlPanelEntry extends com.liferay.portlet.DefaultControlPanelEntry {

	public boolean isVisible(
			Portlet portlet, String category, ThemeDisplay themeDisplay)
		throws Exception {

		Group group = themeDisplay.getScopeGroup();

		if (category.equals(PortletCategoryKeys.CONTENT) && group.isUser()) {
			return false;
		}
		// mas ainda restaram: páginas, enquetes, configuração de workflow, equidade social
		// Extender (classe e liferay-portlet.xml ext):
		//  com.liferay.portlet.polls.PollsControlPanelEntry 
		//  com.liferay.portal.workflow.WorkflowControlPanelEntry
		//  com.liferay.portlet.socialequityadmin.SocialEquityAdminControlPanelEntry
		//  com.liferay.portlet.grouppages.GroupPagesControlPanelEntry
		return super.isVisible(portlet, category, themeDisplay);
	} 

}
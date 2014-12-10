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
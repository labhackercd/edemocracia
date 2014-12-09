package br.gov.camara.edemocracia.movetopico.view;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.wizard.Wizard;
import org.apache.wicket.markup.html.WebPage;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author Richard Wilkinson - richard.wilkinson@jweekend.com
 * 
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// private Accordion accordion;

	/**
	 * Constructor that is invoked when page is invoked without a em.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public HomePage(final PageParameters parameters) {

		ThemeDisplay td = getThemeDisplay();
		Group comunidade = td.getScopeGroup();
		long idUsuario = td.getUserId();
		
		Wizard move = new MoveTopicosWizard("wizard", comunidade, idUsuario);
		add(move);

	}

	private ThemeDisplay getThemeDisplay() {
		HttpServletRequest request = getWebRequestCycle().getWebRequest()
				.getHttpServletRequest();
		ThemeDisplay td = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		return td;
	}

}

/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.components;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author rpdmiranda
 * 
 */
public class UserImage extends WebComponent {

	private static final long serialVersionUID = 1L;

	public UserImage(String id, IModel<?> model) {
		super(id, model);
	}

	public UserImage(String id) {
		super(id);
	}

	/**
	 * Obtem o identificador do usuário
	 */
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		checkComponentTag(tag, "img");
		Object obj = getDefaultModelObject();
		long imageId = 0l;
		if (obj != null) {
			long userId;
			if (obj instanceof Number)
				userId = ((Number) obj).longValue();
			else {
				try {
					userId = Long.parseLong(getDefaultModelObjectAsString(obj));
				} catch (NumberFormatException e) {
					userId = 0l;
				}
			}
			if (userId > 0l) {
				try {
					imageId = UserLocalServiceUtil.getUser(userId).getPortraitId();
				} catch (PortalException e) {
				} catch (SystemException e) {
				}
			}
		}

		String url = PortalUtil.getPathImage() + "/user_portrait?img_id=" + imageId; 
		tag.put("src", url);
	}
}

/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * Bean para autocomplete de nomes de usuário na comunidade atual
 * 
 * @author p_7339
 * 
 */
@ManagedBean(name = "autocompleteUserBean")
@ViewScoped
public class AutocompleteUserBean implements Serializable {

    private static final long serialVersionUID = -715701134357137292L;
	private List<String> selectedUsers;
	private long currentGroupId;

	private String convidado;
	private String filter;

	/**
	 * Recupera os usuários do grupo atual
	 */
	private synchronized void fetchUsers() {
		currentGroupId = LiferayFacesContext.getInstance().getScopeGroupId();
		if (this.filter != null && this.filter.length() >= 1) {
			List<User> users;
			try {
				users = UserLocalServiceUtil.getGroupUsers(currentGroupId);

				int total = 0;
				ArrayList<String> result = new ArrayList<String>();
				for (User user : users) {
					if (user.getFullName().startsWith(filter)) {
						result.add(user.getFullName());
						total++;
						if (total >= 10)
							break;
					}
				}

				selectedUsers = Collections.unmodifiableList(result);
				// Se o usuário selecionado for o que tem o nome digitado, então
				// esconde a lista
				if (selectedUsers.size() == 1 && selectedUsers.get(0).equals(this.filter))
					selectedUsers = Collections.emptyList();

			} catch (SystemException e) {
				selectedUsers = Collections.emptyList();
			}
		} else {
			selectedUsers = Collections.emptyList();
		}
	}

	/**
	 * Recupera a nova lista de usuários
	 * 
	 * @param event
	 */
	public List<String> complete(String query) {
		this.filter = query;
		fetchUsers();
		if (selectedUsers == null)
			return Collections.emptyList();

		return selectedUsers;

	}

	/**
	 * Usuário submeteu o formulário. Limpa os valores
	 * 
	 * @param event
	 */
	public void submitName(ActionEvent event) {
		filter = null;
		selectedUsers = null;
	}

	public void setConvidado(String convidado) {
		this.convidado = convidado;
	}

	public String getConvidado() {
		return convidado;
	}

}

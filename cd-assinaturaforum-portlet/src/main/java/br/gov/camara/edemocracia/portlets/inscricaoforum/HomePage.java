/**
 * 
 */
package br.gov.camara.edemocracia.portlets.inscricaoforum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.protocol.http.WebRequestCycle;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.comparator.UserLoginDateComparator;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;

/**
 * @author P_7339
 * 
 */
public class HomePage extends WebPage {

	private ThemeDisplay getThemeDislay() {
		HttpServletRequest req = ((ServletWebRequest) WebRequestCycle.get()
				.getRequest()).getHttpServletRequest();
		return (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public HomePage() {

		initUsuariosList();

		initInscreverLink();
	}

	/**
	 * Inscreve os usuarios na lista do forum
	 */
	private void initInscreverLink() {
		add(new Link<Void>("inscreverTodosLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				// Lista os usuários desta comunidade
				ThemeDisplay td = getThemeDislay();
				LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();
				userParams.put("usersGroups", new Long(td.getScopeGroupId()));

				try {
					int total = UserLocalServiceUtil.searchCount(
							td.getCompanyId(), null, WorkflowConstants.STATUS_APPROVED, userParams);

					List<User> results = UserLocalServiceUtil.search(
							td.getCompanyId(), null, WorkflowConstants.STATUS_APPROVED, userParams,
							0, total, new UserLoginDateComparator());

					// Acrescenta no forum
					for (User user : results) {
						if (!SubscriptionLocalServiceUtil.isSubscribed(
								user.getCompanyId(), user.getUserId(),
								MBCategory.class.getName(),
								td.getScopeGroupId())) {
							SubscriptionLocalServiceUtil.addSubscription(
									user.getUserId(),
									td.getScopeGroupId(),
									MBCategory.class.getName(),
									td.getScopeGroupId());
						}
					}
				} catch (SystemException e) {
					throw new RuntimeException(e);
				} catch (PortalException e) {
					throw new RuntimeException(e);
				}
			}

		});

	}

	/**
	 * Obtém a lista de membros do forum
	 */
	private void initUsuariosList() {
		IDataProvider<User> idp = new IDataProvider<User>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void detach() {
			}

			private DynamicQuery buildQuery() {
				long classNameId = ClassNameLocalServiceUtil
						.getClassNameId(MBCategory.class);

				DynamicQuery query = DynamicQueryFactoryUtil.forClass(
						Subscription.class,
						PortalClassLoaderUtil.getClassLoader());
				query.add(PropertyFactoryUtil.forName("classNameId").eq(
						classNameId));
				query.add(PropertyFactoryUtil.forName("classPK").eq(
						getThemeDislay().getScopeGroupId()));

				return query;
			}

			public Iterator<User> iterator(int first, int count) {
				DynamicQuery query = buildQuery();
				query.addOrder(OrderFactoryUtil.asc("userName"));
				List<User> usuarios;
				try {
					@SuppressWarnings("unchecked")
					List<Subscription> assinaturas = SubscriptionLocalServiceUtil
							.dynamicQuery(buildQuery(), first, count + first);
					usuarios = new ArrayList<User>();
					for (Subscription assinatura : assinaturas) {
						User usuario = UserLocalServiceUtil.getUser(assinatura
								.getUserId());
						if (usuario != null && !usuario.isDefaultUser())
							usuarios.add(usuario);
					}
				} catch (SystemException e) {
					throw new RuntimeException(e);
				} catch (PortalException e) {
					throw new RuntimeException(e);
				}
				return usuarios.iterator();
			}

			public int size() {
				try {
					return (int) SubscriptionLocalServiceUtil
							.dynamicQueryCount(buildQuery());
				} catch (SystemException e) {
					throw new RuntimeException(e);
				}
			}

			public IModel<User> model(User object) {
				final long userId = object.getUserId();
				return new LoadableDetachableModel<User>(object) {
					private static final long serialVersionUID = 1L;

					@Override
					protected User load() {
						try {
							return UserLocalServiceUtil.getUser(userId);
						} catch (PortalException e) {
							throw new RuntimeException(e);
						} catch (SystemException e) {
							throw new RuntimeException(e);
						}
					}
				};
			}
		};
		add(new DataView<User>("usuariosList", idp) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<User> item) {
				Label lbl;
				String userName = item.getModelObject().getFirstName().trim();
				if (userName.length() > 0)
					userName += " ";
				userName += item.getModelObject().getMiddleName().trim();
				if (userName.length() > 0)
					userName += " ";
				userName += item.getModelObject().getLastName();
				lbl = new Label("contact.userName", userName);
				item.add(lbl);
			}
		});
	}
}

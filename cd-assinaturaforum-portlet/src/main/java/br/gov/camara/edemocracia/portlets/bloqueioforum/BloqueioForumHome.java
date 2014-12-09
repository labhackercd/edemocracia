/**
 * 
 */
package br.gov.camara.edemocracia.portlets.bloqueioforum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebRequest;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;

/**
 * @author p_7339
 * 
 */
public class BloqueioForumHome extends WebPage {

	/**
	 * @return
	 */
	private static long getScopeGroupId() {
		HttpServletRequest request = ((WebRequest) RequestCycle.get()
				.getRequest()).getHttpServletRequest();
		ThemeDisplay td = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = td.getScopeGroupId();
		return scopeGroupId;
	}

	private Form<?> form;

	private DropDownChoice<DadosCategoria> categorias;

	private Button bloquear;
	private Button desbloquear;

	public BloqueioForumHome() {
		initForm();
		initFeedback();
		initCategorias();
		initBotao();
		initDesbloquear();
	}
	
	private void initForm() {
		form = new Form<Void>("form");
		add(form);
	}
	
	private void initFeedback() {
		form.add(new FeedbackPanel("feedback"));
	}

	private void initCategorias() {
		ChoiceRenderer<DadosCategoria> renderer = new ChoiceRenderer<DadosCategoria>(
				"categoryName", "categoryId");
		categorias = new DropDownChoice<DadosCategoria>("categorias",
				new Model<DadosCategoria>(), new ListaDadosCategoriaModel(),
				renderer);
		categorias.setNullValid(true);
		
		form.add(categorias);
	}

	private void initBotao() {
		bloquear = new Button("bloquear") {
			@Override
			public void onSubmit() {
				bloqueiaThreads();
				info("Todas as threads abaixo da comunidade informada foram marcadas como bloqueadas");
			}
		};
		form.add(bloquear);
	}
	
	private void initDesbloquear() {
		desbloquear = new Button("desbloquear") {
			@Override
			public void onSubmit() {
				desbloqueiaThreads();
				info("Todas as threads abaixo da comunidade informada foram desbloqueadas");
			}
		};
		form.add(desbloquear);
	}

	/**
	 * Bloqueia as threads filhas
	 */
	private void bloqueiaThreads() {
		DadosCategoria categoria = categorias.getModelObject();
		long parentCategoryId;
		if (categoria == null)
			parentCategoryId = MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID;
		else
			parentCategoryId = categoria.getCategoryId();

		long scopeGroupId = getScopeGroupId();

		// Visita todas as categorias filhas
		try {
			Stack<Long> categories = new Stack<Long>();
			categories.add(parentCategoryId);

			while (!categories.isEmpty()) {
				Long categoryId = categories.pop();
				List<MBThread> threads = MBThreadLocalServiceUtil.getThreads(
						scopeGroupId, categoryId,
						WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);

				for (MBThread thread : threads) {
					if (!thread.isLocked()) {
						try {
							MBThreadServiceUtil
									.lockThread(thread.getThreadId());
						} catch (PortalException e) {
							// TODO LOG
							// Thread apagada
						}
					}
				}

				// Adiciona os filhos
				List<MBCategory> children = MBCategoryLocalServiceUtil.getCategories(
						scopeGroupId, categoryId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);
				for (MBCategory child: children) 
					categories.add(child.getCategoryId());
			}
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Desbloqueia as threads filhas
	 */
	private void desbloqueiaThreads() {
		DadosCategoria categoria = categorias.getModelObject();
		long parentCategoryId;
		if (categoria == null)
			parentCategoryId = MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID;
		else
			parentCategoryId = categoria.getCategoryId();

		long scopeGroupId = getScopeGroupId();

		// Visita todas as categorias filhas
		try {
			Stack<Long> categories = new Stack<Long>();
			categories.add(parentCategoryId);

			while (!categories.isEmpty()) {
				Long categoryId = categories.pop();
				List<MBThread> threads = MBThreadLocalServiceUtil.getThreads(
						scopeGroupId, categoryId,
						WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);

				for (MBThread thread : threads) {
					if (thread.isLocked()) {
						try {
							MBThreadServiceUtil
									.unlockThread(thread.getThreadId());
						} catch (PortalException e) {
							// TODO LOG
							// Thread apagada
						}
					}
				}

				// Adiciona os filhos
				List<MBCategory> children = MBCategoryLocalServiceUtil.getCategories(
						scopeGroupId, categoryId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);
				for (MBCategory child: children) 
					categories.add(child.getCategoryId());
			}
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

	}
	/**
	 * Modelo com os dados das categorias do forum atual
	 * 
	 * @author p_7339
	 * 
	 */
	private static class ListaDadosCategoriaModel extends
			LoadableDetachableModel<List<DadosCategoria>> {
		@Override
		protected List<DadosCategoria> load() {
			long scopeGroupId = getScopeGroupId();

			ArrayList<DadosCategoria> categorias = new ArrayList<DadosCategoria>();

			try {
				adicionaCategorias(categorias, 0, scopeGroupId,
						MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID);
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}

			return categorias;

		}

		private void adicionaCategorias(ArrayList<DadosCategoria> categorias,
				int level, long scopeGroupId, long parentCategoryId)
				throws SystemException {
			List<MBCategory> children = MBCategoryLocalServiceUtil
					.getCategories(scopeGroupId, parentCategoryId,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (MBCategory child : children) {
				StringBuilder sb = new StringBuilder(level
						+ child.getName().trim().length());
				for (int i = 0; i < level; i++)
					sb.append("-");
				sb.append(child.getName().trim());
				categorias.add(new DadosCategoria(child.getCategoryId(), sb
						.toString()));
				adicionaCategorias(categorias, level + 1, scopeGroupId,
						child.getCategoryId());
			}
		}
	}
}

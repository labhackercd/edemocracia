/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxFallbackButton;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.parser.XmlTag;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.http.WebRequest;

import br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.LinkToAnchor;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.UserImage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ComentarioDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ComentarioDisplayItemReuseStrategy;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ComentarioDisplayModel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.google.common.collect.Iterators;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.util.comparator.MessageCreateDateComparator;

/**
 * @author rpdmiranda
 * 
 */
public class ComentariosPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil
			.getLog(ComentariosPanel.class);

	public ComentariosPanel(String id, IModel<ArtigoDisplay> artigo) {
		super(id, artigo);
		init();
		initOcultarComentarios();
	}

	private WebMarkupContainer comentariosContainer;
	private AjaxLink<Void> adicionarComentario;
	private AjaxLink<Void> cancelar;
	private RefreshingView<ComentarioDisplay> comentarios;
	private AjaxLink<Void> ocultarComentarios;
	private WebMarkupContainer comentarioVazio;

	/**
	 * Fragmento para edição de comentários
	 * 
	 * @author robson
	 * 
	 */
	private class ComentarioFragment extends Fragment {

		private static final long serialVersionUID = 1L;
		private Form<Void> form;
		private TextArea<String> comentario;

		/**
		 * @param id
		 * @param model
		 */
		public ComentarioFragment(String id, IModel<Long> model) {
			super(id, "comentarioForm", ComentariosPanel.this, model);
			form = new Form<Void>("form");
			form.setOutputMarkupId(true);
			form.setOutputMarkupPlaceholderTag(true);
			add(form);

			initComentario();
			initComentar();
			initCancelar();
		}

		public ComentarioFragment(String id, ComentarioDisplay comentario) {
			super(id, "comentarioForm", ComentariosPanel.this, Model
					.of(comentario));
			form = new Form<Void>("form");
			form.setOutputMarkupId(true);
			form.setOutputMarkupPlaceholderTag(true);
			add(form);

			initComentario();
			initComentar();
			initCancelar();
		}

		private void removeFragmento() {
			// Remove o fragmento da classe pai
			MarkupContainer parent = getParent();
			String id = getId();
			remove();

			// Acrescenta um painel vazio no pai
			parent.add(new EmptyPanel(id).setVisible(false));
		}

		/**
		 * Textarea
		 */
		private void initComentario() {
			Object obj = ComentarioFragment.this.getDefaultModelObject();
			String texto = "";
			if (obj instanceof ComentarioDisplay)
				texto = ((ComentarioDisplay) obj).getBody();

			comentario = new TextArea<String>("comentario", Model.of(texto));
			form.add(comentario);
		}

		/**
		 * Botão "Gravar"
		 */
		private void initComentar() {
			AjaxFallbackButton comentar = new AjaxFallbackButton("comentar",
					form) {

				private static final long serialVersionUID = 1L;

				@Override
				protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
					Object obj = ComentarioFragment.this
							.getDefaultModelObject();
					if (obj instanceof Long) {
						gravaComentario(comentario.getModelObject(), (Long) obj);
					} else {
						atualizarComentario(comentario.getModelObject(),
								((ComentarioDisplay) obj).getMessageId(),
								((ComentarioDisplay) obj).getSenderId());
					}
					comentario.setDefaultModelObject("");

					removeFragmento();
					if (target != null)
						target.addComponent(comentariosContainer);

					onComentariosChanged(target);
				}
			};
			form.add(comentar);
		}

		/**
		 * Botão para cancelar a edição do comentário
		 */
		private void initCancelar() {
			cancelar = new AjaxLink<Void>("cancelar") {

				private static final long serialVersionUID = 1L;

				@Override
				public void onClick(AjaxRequestTarget target) {
					removeFragmento();
					if (target != null)
						target.addComponent(comentariosContainer);
				}
			};
			form.add(cancelar);
		}
	}

	// //////////////////////////////////////
	// Componentes
	// //////////////////////////////////////
	private void init() {
		comentariosContainer = new WebMarkupContainer("comentariosContainer");
		comentariosContainer.setOutputMarkupId(true);
		add(comentariosContainer);

		initAdicionarComentario();

		comentariosContainer.add(new EmptyPanel("comentarioRaiz"));

		initComentarios();
	}

	/**
	 * ,final Item<ComentarioDisplay> item Lista de comentários
	 */
	private void initComentarios() {
		comentarioVazio = new WebMarkupContainer("comentarioVazio") {

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(!listaMensagens().hasNext());
			}
		};
		comentariosContainer.add(comentarioVazio);

		comentarios = new RefreshingView<ComentarioDisplay>("comentarios") {
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<IModel<ComentarioDisplay>> getItemModels() {
				return listaMensagens();
			}

			@Override
			protected void populateItem(final Item<ComentarioDisplay> item) {
				WebComponent postagem = new WebComponent("postagem") {
					/**
					 * @see org.apache.wicket.Component#onComponentTag(org.apache.wicket.markup.ComponentTag)
					 */
					@Override
					protected void onComponentTag(ComponentTag tag) {
						super.onComponentTag(tag);
						tag.setType(XmlTag.OPEN);
					}
				};
				postagem.add(new AttributeModifier("name",
						new ComponentPropertyModel<String>("anchor")));
				String urlToUserProfile = getUserProfileURL(item
						.getModelObject().getSenderId());
				item.add(postagem);
				item.add(new ExternalLink("senderProfile", urlToUserProfile)
						.add(new UserImage("senderId")));
				item.add(new ExternalLink("senderName", urlToUserProfile, item
						.getModelObject().getSenderName()));
				item.add(new Label("body").setEscapeModelStrings(false));
				item.add(new Label("when"));
				item.add(new AjaxLink<Long>("responder",
						new ComponentPropertyModel<Long>("messageId")) {

					private static final long serialVersionUID = 1L;

					@Override
					protected void onConfigure() {
						super.onConfigure();
						setVisible(UIUtils
								.possuiPermissoes(ActionKeys.ADD_DISCUSSION));
					}

					@Override
					public void onClick(AjaxRequestTarget target) {
						adicionarComentario("resposta", item, getModelObject());
						if (target != null)
							target.addComponent(comentariosContainer);
					}
				});
				item.add(new LinkToAnchor("linkArtigo",
						new PropertyModel<String>(ComentariosPanel.this
								.getDefaultModel(), "nodeName")));
				item.add(new AjaxLink<Long>("alterar",
						new ComponentPropertyModel<Long>("messageId")) {

					private static final long serialVersionUID = 1L;

					@Override
					protected void onConfigure() {
						super.onConfigure();
						if (!(UIUtils
								.possuiPermissoes(ActionKeys.UPDATE_DISCUSSION) || UIUtils
								.isOwner(item.getModelObject().getSenderId(),
										ActionKeys.UPDATE_DISCUSSION)))
							setVisible(false);
					}

					@Override
					public void onClick(AjaxRequestTarget target) {
						editarComentario("resposta", item,
								item.getModelObject());
						if (target != null)
							target.addComponent(comentariosContainer);
					}
				});
				item.add(new AjaxLink<Void>("exclui") {

					private static final long serialVersionUID = 1L;

					@Override
					protected void onConfigure() {
						super.onConfigure();
						if (!(UIUtils
								.possuiPermissoes(ActionKeys.DELETE_DISCUSSION) || UIUtils
								.isOwner(item.getModelObject().getSenderId(),
										ActionKeys.DELETE_DISCUSSION)))
							setVisible(false);
					}

					@Override
					public void onClick(AjaxRequestTarget target) {
						excluiComentario(item.getModelObject());
						if (target != null)
							target.addComponent(comentariosContainer);
						onComentariosChanged(target);
					}
				});
				LinkToAnchor parentMessageName = new LinkToAnchor(
						"parentMessageName");
				item.add(parentMessageName);
				Label inReplyTo = new Label("inReplyToName") {
					@Override
					public boolean isVisible() {
						return getDefaultModelObject() != null
								&& getDefaultModelObjectAsString().length() > 0;
					}
				};
				parentMessageName.add(inReplyTo);
				item.add(new EmptyPanel("resposta"));
				item.setVisible(item.getModelObject() != null);
			}

			private String getUserProfileURL(long userId) {
				try {
					return UserLocalServiceUtil.getUser(userId).getDisplayURL(
							UIUtils.getThemeDisplay());

				} catch (PortalException e) {
					// ignore
				} catch (SystemException e) {
					// ignore
				}
				return "#";
			}

		};

		comentarios.setItemReuseStrategy(ComentarioDisplayItemReuseStrategy
				.getInstance());
		comentariosContainer.add(comentarios);
	}

	/**
	 * Link para adicionar comentário
	 */
	private void initAdicionarComentario() {
		adicionarComentario = new AjaxLink<Void>("adicionarComentario") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				adicionarComentario("comentarioRaiz", comentariosContainer,
						MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);
				if (target != null)
					target.addComponent(comentariosContainer);
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(UIUtils.possuiPermissoes(ActionKeys.ADD_DISCUSSION));
			}
		};
		comentariosContainer.add(adicionarComentario);
	}

	/**
	 * Acrescenta o campo
	 * 
	 * @param id
	 * @param container
	 * @param parentMessageId
	 */
	private void adicionarComentario(String id, WebMarkupContainer container,
			long parentMessageId) {
		container.remove(id);
		ComentarioFragment frag = new ComentarioFragment(id,
				Model.of(parentMessageId));
		container.add(frag);
	}

	/**
	 * Acrescenta o comentário para edição
	 * 
	 * @param id
	 * @param container
	 * @param comentario
	 */
	private void editarComentario(String id, WebMarkupContainer container,
			ComentarioDisplay comentario) {
		container.remove(id);
		ComentarioFragment frag = new ComentarioFragment(id, comentario);
		container.add(frag);
	}

	private void gravaComentario(String body, long parentMessageId) {
		try {

			long artigoId = ((ArtigoDisplay) getDefaultModelObject()).getId();

			WikiLegisServiceUtil.postaComentario(artigoId, parentMessageId,
					body);
		} catch (PortalException ex) {
			LOG.error("Erro ao gravar comentário", ex);
		} catch (SystemException ex) {
			LOG.error("Erro ao gravar comentário", ex);
		}
	}

	private void atualizarComentario(String body, long messageId, long userId) {
		try {
			long artigoId = ((ArtigoDisplay) getDefaultModelObject()).getId();

			WikiLegisServiceUtil.atualizaComentario(body, artigoId, messageId,
					userId);
		} catch (PortalException e) {
			LOG.error("Erro ao atualizar comentário");
		} catch (SystemException e) {
			LOG.error("Erro ao atualizar comentário");
		}
	}

	/**
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Iterator<IModel<ComentarioDisplay>> listaMensagens() {

		try {
			MBMessageDisplay md = getDisplayMessage();

			List<MBMessage> messages = md.getTreeWalker().getMessages();
			messages.remove(md.getTreeWalker().getRoot());
			messages = ListUtil.sort(messages, new MessageCreateDateComparator(
					true));

			HttpServletRequest req = ((WebRequest) RequestCycle.get()
					.getRequest()).getHttpServletRequest();
			ThemeDisplay td = (ThemeDisplay) req
					.getAttribute(WebKeys.THEME_DISPLAY);

			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
					td.getLocale());
			df.setTimeZone(td.getTimeZone());

			ArrayList<IModel<ComentarioDisplay>> retorno = new ArrayList<IModel<ComentarioDisplay>>();
			for (MBMessage message : messages)
				retorno.add(new CompoundPropertyModel<ComentarioDisplay>(
						new ComentarioDisplayModel(message, df)));
			return retorno.iterator();
		} catch (SystemException e) {
			LOG.error("Erro ao obter mensagens de comentário. ", e);
			return Iterators.emptyIterator();
		} catch (PortalException e) {
			LOG.error("Erro ao obter mensagens de comentário. ", e);
			return Iterators.emptyIterator();
		}

	}

	/**
	 * Exclui o comentário especificado
	 * 
	 * @param comentario
	 */
	private void excluiComentario(ComentarioDisplay comentario) {
		try {
			long messageId = comentario.getMessageId();
			long artigoId = ((ArtigoDisplay) getDefaultModelObject()).getId();
			WikiLegisServiceUtil.excluiComentario(artigoId, messageId);
		} catch (Exception e) {
			LOG.error("Erro ao excluir mensagem", e);
		}

	}

	/**
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private MBMessageDisplay getDisplayMessage() throws PortalException,
			SystemException {
		String className = Artigo.class.getName();
		long idArtigo = ((ArtigoDisplay) getDefaultModelObject()).getId();
		HttpServletRequest req = ((WebRequest) RequestCycle.get().getRequest())
				.getHttpServletRequest();
		ThemeDisplay td = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		long groupId = td.getScopeGroupId();

		MBMessageDisplay md = MBMessageLocalServiceUtil
				.getDiscussionMessageDisplay(userId, groupId, className,
						idArtigo, WorkflowConstants.STATUS_ANY);
		return md;
	}

	private void initOcultarComentarios() {

		ocultarComentarios = new AjaxLink<Void>("ocultarComentarios") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {

				MarkupContainer parent = getParent();
				while (parent != null
						&& !(parent instanceof WikiLegisArtigoPanel))
					parent = parent.getParent();
				if (parent != null)
					((WikiLegisArtigoPanel) parent).ocultaComentarios(target);

			}
		};
		add(ocultarComentarios);
	}

	/**
	 * Chamado quando há mudança nos comentários (exclusão/inclusão)
	 * 
	 * @param target
	 */
	protected void onComentariosChanged(AjaxRequestTarget target) {

	}

}

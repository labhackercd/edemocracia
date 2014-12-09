package br.gov.camara.edemocracia.movetopico.view;

import java.util.Collection;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.extensions.wizard.Wizard;
import org.apache.wicket.extensions.wizard.dynamic.DynamicWizardModel;
import org.apache.wicket.extensions.wizard.dynamic.DynamicWizardStep;
import org.apache.wicket.extensions.wizard.dynamic.IDynamicWizardStep;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.tree.BaseTree;
import org.apache.wicket.markup.html.tree.LinkTree;

import br.gov.camara.edemocracia.movetopico.model.BuliderModeloArvoreForuns;
import br.gov.camara.edemocracia.movetopico.model.Forum;
import br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico;
import br.gov.camara.edemocracia.movetopico.model.ModeloListaComunidadesDestino;
import br.gov.camara.edemocracia.movetopico.model.ModeloListaTopicosDeForum;
import br.gov.camara.edemocracia.movetopico.model.Topico;
import br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;

public class MoveTopicosWizard extends Wizard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3271119522088888547L;

	private DynamicWizardModel modelo;
	private InfoMoverTopico info;
	
	public MoveTopicosWizard(String id, Group comunidadeOrigem, long idUsuario) {
		super(id);
		info = new InfoMoverTopico(idUsuario, comunidadeOrigem.getGroupId(), comunidadeOrigem.getName(),comunidadeOrigem.getFriendlyURL());
		modelo = new DynamicWizardModel(new ForumOrigemStep()) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 472362717938017089L;

			@Override
			public void finish() {
				try {
					MoveTopicoLocalServiceUtil.moveTopico(info);
					setResponsePage(new SucessoAoMoverPage());
				} catch (PortalException e) {
					e.printStackTrace();
					setResponsePage(new FalhaAoMoverPage());
				} catch (SystemException e) {
					e.printStackTrace();
					setResponsePage(new FalhaAoMoverPage());
				}
				super.finish();
			}
		};
		modelo.setLastVisible(false);

		init(modelo);

	}

	private class ForumOrigemStep extends DynamicWizardStep {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4185799867162685606L;
		

		public ForumOrigemStep() {
			
			super(null,"Escolha o fórum","Clique no fórum cujo tópico será movido");

		
			setComplete(false);

			LinkTree arvoreForums = new LinkTree("forums",
					new BuliderModeloArvoreForuns(info.getIdComunidadeOrigem()).construir()) {

				private static final long serialVersionUID = 6698027674151343855L;

				@Override
				protected void onNodeLinkClicked(Object node, BaseTree tree,
						AjaxRequestTarget target) {

					Collection<Object> selectedNodes = tree.getTreeState()
							.getSelectedNodes();
					setComplete(selectedNodes.contains(node));
					if (isComplete()) {
						DefaultMutableTreeNode noArvore = (DefaultMutableTreeNode) node; 
						if (noArvore.getUserObject() instanceof Forum) {
							Forum forum = (Forum) noArvore.getUserObject();
							
							info.setIdForumOrigem(forum.getId());
							info.setNomeForumOrigem(forum.getNome());
						} else {
							info.setIdForumOrigem(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID);
							info.setNomeForumOrigem("Forum da comunidade " + info.getNomeComunidadeOrigem());
						}
						
					}

				}

			};
			add(arvoreForums);

		}

		@Override
		public boolean isLastStep() {
			return false;
		}

		@Override
		public IDynamicWizardStep next() {
			return new TopicoStep(this);
		}

	}

	private class TopicoStep extends DynamicWizardStep {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2870739302876867478L;
		
		public TopicoStep(IDynamicWizardStep previous) {
			super(previous,"Escolha o Tópico","CLique no tópico a mover");
			setComplete(false);
			

			ListView<Topico> topicos = new ListView<Topico>("topicos",
					new ModeloListaTopicosDeForum(info.getIdComunidadeOrigem(), info.getIdForumOrigem())) {

				private static final long serialVersionUID = -5113198906301138306L;

				@Override
				protected void populateItem(final ListItem<Topico> item) {
					Link<Void> linkTopico = new AjaxFallbackLink<Void>(
							"link_topico") {

						private static final long serialVersionUID = 2729459814700718807L;

						@Override
						public void onClick(AjaxRequestTarget target) {
							info.setIdTopico(item.getModelObject().getId());
							info.setNomeTopico(item.getModelObject().getAssunto());
							setComplete(true);

						}
					};
					
					Label nomeTopico = new Label("nome_topico", item.getModelObject().toString());
					linkTopico.setOutputMarkupId(true);
					linkTopico.add(nomeTopico);
					item.add(linkTopico);

				}
			};
			topicos.setOutputMarkupId(true);
			add(topicos);

		}

		@Override
		public boolean isLastStep() {
			return false;
		}

		@Override
		public IDynamicWizardStep next() {
			return new ComunidadeDestinoStep(this);
		}

	}
	
	private class ComunidadeDestinoStep extends DynamicWizardStep {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 3775185109321135772L;
		
		

		public ComunidadeDestinoStep(IDynamicWizardStep previousStep) {
			super(previousStep,"Escolha a Comunidade de Destino","Clique na comunidade para onde o tópico será movido");
			
			ListView<Group> comunidades = new ListView<Group>("comunidades",
					new ModeloListaComunidadesDestino(info.getIdUsuario(),info.getIdComunidadeOrigem())) {

				private static final long serialVersionUID = -5113198906301138306L;

				@Override
				protected void populateItem(final ListItem<Group> item) {
					Link<Void> linkComunidade = new AjaxFallbackLink<Void>(
							"link_comunidade") {

						private static final long serialVersionUID = 2729459814700718807L;

						@Override
						public void onClick(AjaxRequestTarget target) {
							Group comunidade = item.getModelObject();
							info.setIdComunidadeDestino(comunidade.getGroupId());
							info.setUrlComunidadeDestino(comunidade.getFriendlyURL());
							info.setNomeComunidadeDestino(comunidade.getName());
							setComplete(true);
						}
					};
					
					Label nomeComunidade = new Label("nome_comunidade", item.getModelObject().getName());
					linkComunidade.setOutputMarkupId(true);
					linkComunidade.add(nomeComunidade);
					item.add(linkComunidade);

				}
			};
			comunidades.setOutputMarkupId(true);
			add(comunidades);

			
		}

		@Override
		public boolean isLastStep() {
			return false;
		}

		@Override
		public IDynamicWizardStep next() {
			return new ForumDestinoStep(this);
		}
		
	}
	
	private class ForumDestinoStep extends DynamicWizardStep {
		
		private static final long serialVersionUID = -88860392537324502L;

		public ForumDestinoStep(IDynamicWizardStep previousStep) {
			super(previousStep,"Escolha o Fórum de destino","Clique no fórum para onde o tópico será movido");
			setComplete(false);

			LinkTree arvoreForums = new LinkTree("forums",
					new BuliderModeloArvoreForuns(info.getIdComunidadeDestino()).construir()) {

				private static final long serialVersionUID = 6698027674151343855L;

				@Override
				protected void onNodeLinkClicked(Object node, BaseTree tree,
						AjaxRequestTarget target) {

					Collection<Object> selectedNodes = tree.getTreeState()
							.getSelectedNodes();
					setComplete(selectedNodes.contains(node));
					if (isComplete()) {
						DefaultMutableTreeNode noArvore = (DefaultMutableTreeNode) node; 
						if (noArvore.getUserObject() instanceof Forum) {
							Forum forum = (Forum) noArvore.getUserObject();
							
							info.setIdForumDestino(forum.getId());
							info.setNomeForumDestino(forum.getNome());
						} else {
							info.setIdForumDestino(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID);
							info.setNomeForumDestino("Forum da comunidade " + info.getNomeComunidadeDestino());
						}
						
					}

				}

			};
			add(arvoreForums);

		}

		@Override
		public boolean isLastStep() {
			return false;
		}

		@Override
		public IDynamicWizardStep next() {
			return new ConfirmaMovimentacaoStep(this);
		}
		
	}
	
	private class ConfirmaMovimentacaoStep extends DynamicWizardStep {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6822513350959878576L;
		
		

		public ConfirmaMovimentacaoStep(IDynamicWizardStep previousStep) {
			super(previousStep,"Conclusão","Confirme a movimentação");
			
			add(new Label("topico",info.getNomeTopico()));
			add(new Label("forum_origem",info.getNomeForumOrigem()));
			add(new ExternalLink("link_comunidade_origem", info.getUrlComunidadeOrigem(), info.getNomeComunidadeOrigem()));
			add(new Label("forum_destino",info.getNomeForumDestino()));
			add(new ExternalLink("link_comunidade_destino",info.getUrlComunidadeDestino(),info.getNomeComunidadeDestino()));
			setComplete(true);
			
		}

		@Override
		public boolean isLastStep() {
			return true;
		}

		@Override
		public IDynamicWizardStep next() {
			return null;
		}
		
		
		
	}
	
	

}

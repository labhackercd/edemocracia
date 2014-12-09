package br.gov.camara.edemocracia.movetopico.model;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalServiceUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.liferay.portlet.messageboards.model.MBCategory;


public class BuliderModeloArvoreForuns {

	private final class FiltroForumPossuiSubForuns implements Predicate<MBCategory> {

		private MBCategory parent;
		
		public FiltroForumPossuiSubForuns(MBCategory parent) {
			
			this.parent = parent;
			
		}
		
		@Override
		public boolean apply(MBCategory input) {
			return input.getParentCategoryId() == parent.getCategoryId();
		}
	}

	private final class FiltroForumRaiz implements Predicate<MBCategory> {
		
		
		
		@Override
		public boolean apply(MBCategory input) {
			return input.isRoot();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8743212025751706394L;
	private long idComunidade; 
	
	
	
	public BuliderModeloArvoreForuns(long idComunidade) {
		
		this.idComunidade = idComunidade;
		
	}
	

	public TreeModel construir() {
			
			List<MBCategory> result = MoveTopicoLocalServiceUtil.getForunsComunidade(idComunidade);
			Iterable<MBCategory> roots = Iterables.filter(result, new FiltroForumRaiz());
			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Fórums");
			
			for(MBCategory category : roots) {
				
				Iterable<MBCategory> children = Iterables.filter(result, new FiltroForumPossuiSubForuns(category));
				DefaultMutableTreeNode node = addChildren(category, children,result);
				rootNode.add(node);
			}
			
			return new DefaultTreeModel(rootNode);
		
	}
	
	private DefaultMutableTreeNode addChildren(MBCategory parent, Iterable<MBCategory> children, List<MBCategory> universe) {
		
		DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(new Forum(parent.getCategoryId(), parent.getName()));
		
		if(!Iterables.isEmpty(children)) {
			for(MBCategory category : children) {
				Iterable<MBCategory> kids = Iterables.filter(universe, new FiltroForumPossuiSubForuns(category));
				DefaultMutableTreeNode node = addChildren(category, kids, universe);
				parentNode.add(node); 
			}
		}
		return parentNode;
	}
	
}

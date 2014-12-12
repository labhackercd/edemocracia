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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.messageboards.model.MBCategory;

public class CategoriaDropDown extends DropDownChoice<MBCategory> {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(CategoriaDropDown.class);


	public CategoriaDropDown(String id, long groupId) {
			super(id,  new Model<MBCategory>(), new MBCategoryListModel(groupId));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		init();
	}
	
	private void init(){
		this.setOutputMarkupId(true);
		this.setChoiceRenderer(new IChoiceRenderer<MBCategory>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(MBCategory object) {
				return object.getName();
			}

			@Override
			public String getIdValue(MBCategory object, int index) {
				return Long.toString(object.getCategoryId());
			}
		});		
	}
	
	private static class MBCategoryListModel extends LoadableDetachableModel<List<MBCategory>> {
		
		private static final long serialVersionUID = 1L;
		private final long groupId;

		private MBCategoryListModel(long groupId) {
			this.groupId = groupId;
		}
		
		@Override
		protected List<MBCategory> load() {
			ArrayList<MBCategory> retorno = new ArrayList<MBCategory>();
			try {
				
				List<MBCategory> categoriasRaiz = PriorizacaoServiceUtil.listarCategorias(groupId,0l);
				
				for(MBCategory categoria : categoriasRaiz ){
					adiciona(retorno, 0, categoria);
				}
				return retorno;
				
			} catch (Exception e) {
				LOG.error("Erro ao obter lista de categorias.Param groupId=\""+groupId+"\"",e);
				return Collections.emptyList();
			}
		}
		
		private void adiciona(ArrayList<MBCategory> retorno, int nivel,
				MBCategory categoria) throws PortalException, SystemException {
			StringBuilder sb = new StringBuilder(nivel
					+ categoria.getName().length());
			for (int i = 0; i < nivel; i++)
				sb.append("-");
			sb.append(categoria.getName());
			categoria.setName(sb.toString());
			retorno.add(categoria);

			List<MBCategory> filhos = PriorizacaoServiceUtil.listarCategorias(
					groupId, categoria.getCategoryId());
			for (MBCategory filho : filhos)
				adiciona(retorno, nivel + 1, filho);
		}

	}

}

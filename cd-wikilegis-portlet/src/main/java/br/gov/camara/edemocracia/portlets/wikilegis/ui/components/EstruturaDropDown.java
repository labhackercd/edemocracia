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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ElementoEstrutura;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * componente DropDownChoice com todos os agrupamentos cadastrados
 */
public class EstruturaDropDown extends DropDownChoice<ElementoEstrutura> {
		
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(EstruturaDropDown.class);
	
	public EstruturaDropDown(String id,long scopeGroupId) {
		super(id,  new Model<ElementoEstrutura>(), new ElementoEstruturaListModel(scopeGroupId));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		init();
	}

	private void init() {
		this.setOutputMarkupId(true);
		this.setChoiceRenderer(new IChoiceRenderer<ElementoEstrutura>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(ElementoEstrutura object) {
				return object.getTexto();
			}

			@Override
			public String getIdValue(ElementoEstrutura object, int index) {
				return Long.toString(object.getEstruturaId());
			}
		});
	}
	
	/**
	 * Lista de elementos, organizados de forma hierárquica (espaços indicam o
	 * nível)
	 * 
	 * @author robson
	 * 
	 */
	private static class ElementoEstruturaListModel extends LoadableDetachableModel<List<ElementoEstrutura>> {
		
		private static final long serialVersionUID = 1L;
		private final long groupId;

		private ElementoEstruturaListModel(long groupId) {
			this.groupId = groupId;
		}

		@Override
		protected List<ElementoEstrutura> load() {
			ArrayList<ElementoEstrutura> retorno = new ArrayList<ElementoEstrutura>();

			try {
				List<Estrutura> raizes = WikiLegisServiceUtil.listaEstruturaFilhos(groupId, 0l);

				for (Estrutura estrutura : raizes) {
					adiciona(retorno, 0, estrutura);
				}
				return retorno;
			} catch (Exception e) {
				// XXX Log
				LOG.error("Erro ao obter lista de elementos.Param groupId=\""+groupId+"\",paiEstruturaId = \"0l\" ",e);
				return Collections.emptyList();
			}
		}

		private void adiciona(ArrayList<ElementoEstrutura> retorno, int nivel, Estrutura estrutura) throws PortalException,
				SystemException {
			StringBuilder sb = new StringBuilder(nivel + estrutura.getTexto().length());
			for (int i = 0; i < nivel; i++)
				sb.append("-");
			sb.append(estrutura.getTexto());
			retorno.add(new ElementoEstrutura(estrutura.getEstruturaId(), sb.toString()));

			List<Estrutura> filhos = WikiLegisServiceUtil.listaEstruturaFilhos(groupId, estrutura.getEstruturaId());
			for (Estrutura filho : filhos)
				adiciona(retorno, nivel + 1, filho);
		}
	}

}

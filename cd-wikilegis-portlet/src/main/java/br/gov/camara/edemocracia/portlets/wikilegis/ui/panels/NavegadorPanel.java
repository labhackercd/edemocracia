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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.LinkToAnchor;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;
import br.gov.camara.liferay.comum.StaticImage;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author rpdmiranda
 * 
 */
public class NavegadorPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String imgAbrirArvore;
	
	/**
	 * @param id
	 */
	public NavegadorPanel(String id) {
		super(id);
		init();	
	}

	private RefreshingView<EstruturaDisplay> raizes;

	private void init() {
		add(JavascriptPackageResource.getHeaderContribution("html/js/liferay/arvore.js"));
		imgAbrirArvore = UIUtils.getThemeDisplay().getPathThemeImages() + "/custom/iconeExpandir.gif";
		initRaizes();
	}

	private void initRaizes() {
		raizes = new RefreshingView<EstruturaDisplay>("raizes") {

			@Override
			protected Iterator<IModel<EstruturaDisplay>> getItemModels() {
				return listaEstrutura().iterator();
			}

			@Override
			protected void populateItem(Item<EstruturaDisplay> item) {
				populateChild(item);
			}
		};
		add(raizes);
	}

	/**
	 * Popula um elemento com o nó atual e os nós filhos
	 * 
	 * Como os elementos são reconstruidos a cada requisição, é possível testar
	 * algumas funcionalidades (por exemplo, se tem elementos filhos) dentro do
	 * próprio método
	 * 
	 * @param item
	 */
	private void populateChild(Item<EstruturaDisplay> item) {
		Fragment frag = new Fragment("filho", "no", this);
		item.add(frag);
		
		StaticImage img = new StaticImage("imgExpandir", imgAbrirArvore);
		item.add(img);
		
		LinkToAnchor link = new LinkToAnchor("link", new PropertyModel<String>(item.getModel(), "nodeName"));
		frag.add(link);
		
		Label titulo = new Label("titulo", new PropertyModel<String>(item.getModel(), "texto"));
		link.add(titulo);
		
		final List<EstruturaDisplay> filhos = item.getModelObject().getFilhos();
		if (filhos.isEmpty()) {
			img.setVisible(false);
			frag.add(new EmptyPanel("filhos").setVisible(false));
		} else {
			img.setVisible(true);
			frag.add(new RefreshingView<EstruturaDisplay>("filhos") {

				@Override
				protected Iterator<IModel<EstruturaDisplay>> getItemModels() {
					return convertToListOfModels(filhos).iterator();
				}

				@Override
				protected void populateItem(Item<EstruturaDisplay> item) {
					populateChild(item);
				}
			});
		}
	}

	/**
	 * Obtém a estrutura a ser visualizada
	 * 
	 * @return
	 */
	private List<IModel<EstruturaDisplay>> listaEstrutura() {
		long groupId = UIUtils.getThemeDisplay().getScopeGroupId();
		List<EstruturaDisplay> estruturas;
		try {
			estruturas = WikiLegisServiceUtil.listaEstrutura(groupId);
		} catch (PortalException e) {
			return Collections.emptyList();
		} catch (SystemException e) {
			// TODO Log
			throw new RuntimeException("Unable to get structure children");
		}
		
		return convertToListOfModels(estruturas);
	}

	/**
	 * @param estruturas
	 * @return
	 */
	private ArrayList<IModel<EstruturaDisplay>> convertToListOfModels(
			List<EstruturaDisplay> estruturas) {
		ArrayList<IModel<EstruturaDisplay>> retorno = new ArrayList<IModel<EstruturaDisplay>>();
		for (EstruturaDisplay raiz : estruturas) {
			retorno.add(new CompoundPropertyModel<EstruturaDisplay>(Model.of(raiz)));
		}
		return retorno;
	}

}

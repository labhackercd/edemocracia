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
package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.components;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.model.SelectItem;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutServiceUtil;


@FacesComponent(value="linkPainel")
public class LinkPainel extends UINamingContainer implements Serializable {

	private static final long serialVersionUID = 8643619054400898594L;
	private List<Layout> paginasComunidade;
	
	private static final Log LOG = LogFactoryUtil.getLog(LinkPainel.class);
	
	public LinkPainel() {
		// recuperando as páginas da comunidade
		Long groupId = LiferayFacesContext.getInstance().getScopeGroupId();

		try {
			this.paginasComunidade = LayoutServiceUtil.getLayouts(
					groupId.intValue(), false);
		} catch (SystemException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Erro ao recuperar páginas da comunidade");
			throw new RuntimeException(e);
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"pagina-comunidade-nao-encontrada");
			LOG.error("Erro ao recuperar páginas da comunidade", e);
		}

	}
	
	public SelectItem[] getLinkExternoValues() {  
		return new SelectItem[] {   
		new SelectItem(Boolean.FALSE, "Comunidade"),
		new SelectItem(Boolean.TRUE, "Externo")};  
	}
	
	public List<Layout> getPaginasComunidade() {
		return paginasComunidade;
	}

}

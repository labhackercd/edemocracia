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
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.completelist;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.liferay.faces.portal.context.LiferayFacesContext;

import br.gov.camara.edemocracia.util.LinkSalasCacheUtil;

@RequestScoped
@ManagedBean(name="preferenciasSalasPortal")
public class PreferenciasSalasPortalBean {
	
	public void limparCaches(){
		
		LinkSalasCacheUtil.limparCaches();
		LiferayFacesContext.getInstance().addGlobalInfoMessage("Cache limpo com sucesso!");

	}
	
}

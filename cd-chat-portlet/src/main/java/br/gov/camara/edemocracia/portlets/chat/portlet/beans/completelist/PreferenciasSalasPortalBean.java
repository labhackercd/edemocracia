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

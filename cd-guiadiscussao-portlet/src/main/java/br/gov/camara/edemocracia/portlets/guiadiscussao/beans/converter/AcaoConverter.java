package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


@FacesConverter(value="acaoConverter")
public class AcaoConverter implements Converter {
	
	private static final Log LOG = LogFactoryUtil.getLog(AcaoConverter.class);
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String str) {
		Acao acao = null;
		try {
			acao = AcaoLocalServiceUtil.getAcao(Long.parseLong(str));
		} catch (NumberFormatException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Erro ao converter ações");
			LOG.error("Erro no conversor de ações. Erro ao converter String para long", e);

		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"acao-nao-encontrada");
			LOG.error("Erro no conversor de ações. Ação não encontrada", e);
			
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		return acao;
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
		return obj.toString();
	}
}

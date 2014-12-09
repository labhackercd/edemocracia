package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.BibliotecaImagensUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.URLUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "bannerBean")
@RequestScoped
public class BannerBean {
	private String urlImagem;

	private String titulo;

	private String texto;
	
	private String linkBanner;

	@PostConstruct
	public void carregaConfiguracao() {
		long groupId = LiferayFacesContext.getInstance().getScopeGroupId();
		try {
			Configuracao config = ConfiguracaoLocalServiceUtil
					.getByGroupId(groupId);
			if (config.getImagemIdBanner() == 0)
				urlImagem = BibliotecaImagensUtil.getImagemPadraoBanner()
						.getUrlImagem();
			else
				urlImagem = BibliotecaImagensUtil.getUrlImagem(config
						.getImagemIdBanner());

			titulo = config.getTituloBanner();
			texto = config.getTextoBanner();
			
			final String urlBanner = config.getUrlBanner();
			if(StringUtils.isNotBlank(urlBanner)) {
				boolean urlExterna = config.getUrlExterna();
				linkBanner = URLUtil.construirURL(urlBanner, urlExterna);
			}
			
		} catch (SystemException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public String getLinkBanner(){
		return linkBanner;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

}

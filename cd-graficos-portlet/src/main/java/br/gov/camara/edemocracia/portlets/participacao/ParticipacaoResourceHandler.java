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
package br.gov.camara.edemocracia.portlets.participacao;

import java.util.Date;
import java.util.List;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;

import br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO;
import br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.participacao.resource.ParticipacaoResource;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ParticipacaoResourceHandler extends ResourceHandlerWrapper{
	
	private final ResourceHandler wrapped;
	
	public static final String LIBRARY_NAME = "participacao";
	
	public static final String PARTICIPACAO_RESOURCE_PREFIX = "comunidades_";
	
	public ParticipacaoResourceHandler(ResourceHandler wrapped) {
		this.wrapped = wrapped;
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#getWrapped()
	 */
	@Override
	public ResourceHandler getWrapped() {
		return wrapped;
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#createResource(java.lang.String)
	 */
	@Override
	public Resource createResource(String resourceName) {
		return createResource(resourceName, null);
	}

	/* (non-Javadoc)
	 * @see javax.faces.application.ResourceHandlerWrapper#createResource(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Resource createResource(String resourceName, String libraryName,
			String contentType) {
		return createResource(resourceName, libraryName);
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#createResource(java.lang.String, java.lang.String)
	 */
	@Override
	public Resource createResource(String resourceName, String libraryName) {
		if (!LIBRARY_NAME.equals(libraryName))
			return super.createResource(resourceName, libraryName);
		
		if (resourceName == null || !resourceName.startsWith(PARTICIPACAO_RESOURCE_PREFIX))
			return super.createResource(resourceName, libraryName);

		// Cria o recurso para retornar os dados das comunidades especificadas
		try {
			
			String keyComunidades = resourceName.substring(PARTICIPACAO_RESOURCE_PREFIX.length());
			
			if (true/* TODO: canExport? */) {
				try {
					List<Long> comunidadesSelecionadas = (List<Long>) LiferayFacesContext.getInstance().getSessionAttribute(keyComunidades);
					
					Date dataInicio = (Date) LiferayFacesContext.getInstance().getSessionAttribute("dataInicio");
					List<DadosComunidadeDTO> dadosComunidade;
					if(dataInicio != null){
						Date dataFim = (Date) LiferayFacesContext.getInstance().getSessionAttribute("dataFim");
						dadosComunidade = ParticipacaoLocalServiceUtil.getDadosComunidade(comunidadesSelecionadas, dataInicio, dataFim);
						return new ParticipacaoResource(dadosComunidade, keyComunidades, dataInicio, dataFim);
					}else {
						dadosComunidade = ParticipacaoLocalServiceUtil.getDadosComunidade(comunidadesSelecionadas);
						return new ParticipacaoResource(dadosComunidade, keyComunidades);
					}
					
					
				} catch (PortalException e) {
					return super.createResource(resourceName, libraryName);
				} catch (SystemException e) {
					throw new RuntimeException(e);
				}
			} else {
				return super.createResource(resourceName, libraryName);
			}
		} catch (NumberFormatException e) {
			return super.createResource(resourceName, libraryName);
		}
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#libraryExists(java.lang.String)
	 */
	@Override
	public boolean libraryExists(String libraryName) {
		if (LIBRARY_NAME.equals(libraryName))
			return true;
		else
			return super.libraryExists(libraryName);
	}
	
}

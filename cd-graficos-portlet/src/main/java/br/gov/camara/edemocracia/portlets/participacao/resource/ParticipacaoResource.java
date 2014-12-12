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
package br.gov.camara.edemocracia.portlets.participacao.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;

import org.apache.commons.io.input.CharSequenceInputStream;

import br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO;
import br.gov.camara.edemocracia.portlets.participacao.ParticipacaoResourceHandler;
import br.gov.camara.edemocracia.portlets.participacao.exporter.CSVParticipacaoExporter;

public class ParticipacaoResource extends Resource {
	
	/**
	 * Lista de Dados das Comunidades
	 */
	private final List<DadosComunidadeDTO> listaDadosComunidade;
	
	private final Date dataInicial;
	
	private final Date dataFinal;
	
	
	
	/**
	 * URL para o recurso
	 */
	private String requestPath;

	public ParticipacaoResource( List<DadosComunidadeDTO> listaDadosComunidade, String key) {
		this.listaDadosComunidade = listaDadosComunidade;
		this.dataInicial = null;
		this.dataFinal = null;
		setLibraryName(ParticipacaoResourceHandler.LIBRARY_NAME);
		setResourceName(ParticipacaoResourceHandler.PARTICIPACAO_RESOURCE_PREFIX + key);
		setContentType("text/csv");
	}
	
	public ParticipacaoResource( List<DadosComunidadeDTO> listaDadosComunidade, String key, Date dataInicial, Date dataFinal) {
		this.listaDadosComunidade = listaDadosComunidade;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		setLibraryName(ParticipacaoResourceHandler.LIBRARY_NAME);
		setResourceName(ParticipacaoResourceHandler.PARTICIPACAO_RESOURCE_PREFIX + key);
		setContentType("text/csv");
	}

	/**
	 * @see javax.faces.application.Resource#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws IOException {

		String csv = CSVParticipacaoExporter.export(listaDadosComunidade);
		return new CharSequenceInputStream(csv, "ISO-8859-1");
	}

	/**
	 * @see javax.faces.application.Resource#getResponseHeaders()
	 */
	@Override
	public Map<String, String> getResponseHeaders() {
		HashMap<String, String> retorno = new HashMap<String, String>();
		String nomeDoArquivo = "";
		if(dataInicial == null) {
			nomeDoArquivo = "participacoes.csv";
		}else {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			nomeDoArquivo = "participacoes - "+ formatador.format(dataInicial).toString() + " - " + formatador.format(dataFinal).toString() + ".csv";
		}
		
		retorno.put("Content-Disposition", "attachment;filename=\""+ nomeDoArquivo +"\"");
		return retorno;
	}

	/**
	 * @see javax.faces.application.Resource#getRequestPath()
	 */
	@Override
	public String getRequestPath() {
		if (requestPath == null) {
			StringBuilder buf = new StringBuilder();
			buf.append(ResourceHandler.RESOURCE_IDENTIFIER);
			buf.append("/");
			buf.append(getResourceName());
			buf.append("?ln=");
			buf.append(getLibraryName());
			requestPath = buf.toString();
			requestPath = FacesContext.getCurrentInstance()
					.getExternalContext().encodeResourceURL(requestPath);
		}

		return requestPath;
	}

	/**
	 * @see javax.faces.application.Resource#getURL()
	 */
	@Override
	public URL getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see javax.faces.application.Resource#userAgentNeedsUpdate(javax.faces.context.FacesContext)
	 */
	@Override
	public boolean userAgentNeedsUpdate(FacesContext context) {
		return true;
	}

}

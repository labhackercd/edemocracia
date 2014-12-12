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
package br.gov.camara.edemocracia.portlets.dashboard.cache.util;

import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;

import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

public class CacheRecursosDTO implements Serializable {

    private static final long serialVersionUID = -6849867484367854642L;
    
	private DateTime dataCache;
	private List<RecursoDTO> recursos;
	
	public CacheRecursosDTO(DateTime dataCache, List<RecursoDTO> recursos) {
		this.dataCache = dataCache;
		this.recursos = recursos;
	}
	
	public List<RecursoDTO> getRecursos() {
		return recursos;
	}
	
	public void setRecursos(List<RecursoDTO> recursos) {
		this.recursos = recursos;
	}
	
	public DateTime getDataCache() {
		return dataCache;
	}
	
	public void setDataCache(DateTime dataCache) {
		this.dataCache = dataCache;
	}
	
	
}

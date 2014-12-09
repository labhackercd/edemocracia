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

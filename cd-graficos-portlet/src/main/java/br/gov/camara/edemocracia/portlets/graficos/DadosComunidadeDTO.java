package br.gov.camara.edemocracia.portlets.graficos;

import java.util.Map;

public class DadosComunidadeDTO {

	private long groupId;
	private String nomeComunidade;
	private Map<Long , DadosUsuarioDTO> listaDadosUsuario; 
	
	public DadosComunidadeDTO(long groupId, String nomeComunidade, Map<Long , DadosUsuarioDTO> listaDadosUsuario ) {
		this.groupId = groupId;
		this.nomeComunidade = nomeComunidade;
		this.listaDadosUsuario = listaDadosUsuario;
		
	}

	public DadosComunidadeDTO() {
	
	}
	
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getNomeComunidade() {
		return nomeComunidade;
	}

	public void setNomeComunidade(String nomeComunidade) {
		this.nomeComunidade = nomeComunidade;
	}

	public Map<Long, DadosUsuarioDTO> getListaDadosUsuario() {
		return listaDadosUsuario;
	}

	public void setListaDadosUsuario(Map<Long, DadosUsuarioDTO> listaDadosUsuario) {
		this.listaDadosUsuario = listaDadosUsuario;
	}
	
	

	
}
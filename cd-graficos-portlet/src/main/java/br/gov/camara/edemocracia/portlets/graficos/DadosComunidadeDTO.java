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
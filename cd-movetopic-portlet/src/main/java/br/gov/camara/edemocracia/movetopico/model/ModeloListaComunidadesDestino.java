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
package br.gov.camara.edemocracia.movetopico.model;

import java.util.List;

import org.apache.wicket.model.LoadableDetachableModel;

import br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalServiceUtil;

import com.liferay.portal.model.Group;

public class ModeloListaComunidadesDestino extends LoadableDetachableModel<List<Group>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4138507743422761980L;
	private final long idUsuario;
	private final long idComunidadeOrigem;

	public ModeloListaComunidadesDestino(long idUsuario, long idComunidadeOrigem) {
		super();
		this.idUsuario = idUsuario;
		this.idComunidadeOrigem = idComunidadeOrigem;
	}



	@Override
	protected List<Group> load() {
		return MoveTopicoLocalServiceUtil.getComunidadesComPermissaoParaMover(idUsuario,idComunidadeOrigem);
	}

}

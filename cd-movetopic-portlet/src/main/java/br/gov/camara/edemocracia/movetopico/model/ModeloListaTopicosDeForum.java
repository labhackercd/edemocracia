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

import java.util.Collections;
import java.util.List;

import org.apache.wicket.model.LoadableDetachableModel;

import br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalServiceUtil;

public class ModeloListaTopicosDeForum extends
		LoadableDetachableModel<List<Topico>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3611002075778745729L;
	private final long idComunidade;
	private long idForum;

	public ModeloListaTopicosDeForum(long idComunidade, long idForum) {
		super();
		this.idComunidade = idComunidade;
		this.idForum = idForum;
	}

	public long getIdComunidade() {
		return idComunidade;
	}

	public long getIdForum() {
		return idForum;
	}

	public void setIdForum(long categoryId) {
		this.idForum = categoryId;
	}

	@Override
	protected List<Topico> load() {

		List<Topico> result = Collections.emptyList();

		result = MoveTopicoLocalServiceUtil.getTopicosPorComunidadeEForum(idComunidade, idForum);

		return result;

	}

}

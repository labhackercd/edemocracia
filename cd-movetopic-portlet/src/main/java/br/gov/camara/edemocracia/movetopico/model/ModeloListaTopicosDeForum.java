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

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

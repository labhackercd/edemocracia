package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class EixosDropDown extends DropDownChoice<Eixo> {
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(EixosDropDown.class);

	public EixosDropDown(String id, long groupId, IChoiceRenderer<Eixo> renderer) {
		super(id, new Model<Eixo>(), new EixosListModel(groupId));
		this.setOutputMarkupId(true);
		if (renderer == null) {
			this.setChoiceRenderer(new IChoiceRenderer<Eixo>() {

				private static final long serialVersionUID = 1L;

				@Override
				public Object getDisplayValue(Eixo object) {
					return object.getTitulo();
				}

				@Override
				public String getIdValue(Eixo object, int index) {
					return Long.toString(object.getEixoId());
				}
			});
		} else {
			setChoiceRenderer(renderer);
		}
	}

	private static class EixosListModel extends
			LoadableDetachableModel<List<Eixo>> {

		private static final long serialVersionUID = 1L;
		private final long groupId;

		private EixosListModel(long groupId) {
			this.groupId = groupId;
		}

		@Override
		protected List<Eixo> load() {
			try {
				return PriorizacaoServiceUtil.listarEixos(groupId);
			} catch (Exception e) {
				LOG.error("Erro ao obter lista de eixos.Param groupId=\""
						+ groupId + "\"", e);
				return Collections.emptyList();
			}
		}

	}

}

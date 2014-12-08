package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.messageboards.model.MBThread;

public class TopicosDropDown extends DropDownChoice<MBThread> {
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(TopicosDropDown.class);
	
	public TopicosDropDown(String id,long groupId, long categoryId) {
		
		super(id,  new Model<MBThread>(), new MBThreadListModel(groupId,categoryId));

	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		init();
	}
	
	private void init(){
		this.setOutputMarkupId(true);
		this.setChoiceRenderer(new IChoiceRenderer<MBThread>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(MBThread object) {
				return UIUtils.getTituloMBThread(object);
			}

			@Override
			public String getIdValue(MBThread object, int index) {
				return Long.toString(object.getThreadId());
			}
		});		
	}
	
	public void recarregar(long groupId,long categoryId){
		
		List<MBThread> threads;
		
		try {
			threads = PriorizacaoServiceUtil.listarTopicosPorCategoryId(groupId, categoryId);
		} catch (Exception e) {
			LOG.error("Erro ao obter lista de topicos.Param groupId=\""+groupId+"\"",e);
			threads = Collections.emptyList();
		}
		
		this.setChoices(threads);
		
	}
	
	private static class MBThreadListModel extends LoadableDetachableModel<List<MBThread>> {
		
		private static final long serialVersionUID = 1L;
		private final long groupId;
		private final long categoryId;
		
		private MBThreadListModel(long groupId,long categoryId) {
			this.groupId = groupId;
			this.categoryId = categoryId;
		}
		
		@Override
		protected List<MBThread> load() {
			if(categoryId == 0l)
				return Collections.emptyList();
			try {
				return PriorizacaoServiceUtil.listarTopicosPorCategoryId(groupId, categoryId);
			} catch (Exception e) {
				LOG.error("Erro ao obter lista de topicos.Param groupId=\""+groupId+"\"",e);
				return Collections.emptyList();
			}
		}

	}
	
	
	

}

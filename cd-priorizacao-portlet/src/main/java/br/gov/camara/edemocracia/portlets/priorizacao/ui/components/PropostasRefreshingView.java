package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.eixo.EixoPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.proposta.PropostaPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.google.common.collect.Iterators;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PropostasRefreshingView extends RefreshingView<Proposta>{

	private static final long serialVersionUID = 1L;
	private long eixoId;
	private static final Log LOG = LogFactoryUtil.getLog(PropostasRefreshingView.class);

	public PropostasRefreshingView(String id,long eixoId) {
		super(id);
		this.eixoId = eixoId;
		
	}

	@Override
	protected Iterator<IModel<Proposta>> getItemModels() {
		return listarPropostas();
	}

	@Override
	protected void populateItem(Item<Proposta> item) {
		item.add(new Label("identificador",Model.of(item.getModelObject().getIdentificador())));
		item.add(new Label("topico",Model.of(UIUtils.getTituloMBThread(item.getModelObject().getThreadId()))));
		item.add(new Label("ementa",Model.of(item.getModelObject().getEmenta())));
		item.add(new UpdatePropostaLink("updateProposta", item.getModelObject().getPropostaId()));
		item.add(new ExcluirPropostaLink("excluirProposta", item.getModelObject().getPropostaId()));
	}

	private Iterator<IModel<Proposta>> listarPropostas() {
		if(eixoId == 0l )
			return Iterators.emptyIterator();
		try{
			List<Proposta> propostas = PriorizacaoServiceUtil.listarPropostasPorEixoId(eixoId);
			ArrayList<IModel<Proposta>> retorno = new ArrayList<IModel<Proposta>>();
			for(Proposta proposta : propostas){
				retorno.add(new Model<Proposta>(proposta));
			}
			return retorno.iterator();					
		}catch(SystemException e){					
			return Iterators.emptyIterator();
		}
	}
	
	public void recarregarPropostas(long eixoId){
		this.eixoId = eixoId;
	}
	
	class UpdatePropostaLink extends Link<PropostaPage>{
		private static final long serialVersionUID = 1L;
		long propostaId;
		
		public UpdatePropostaLink (String id,long propostaId){
			super(id);
			this.propostaId = propostaId;
		}

		@Override
		public void onClick() {
			PageParameters parameters = new PageParameters();
			parameters.put("propostaId",String.valueOf(propostaId));
			setResponsePage(PropostaPage.class,parameters);
		}
		
	}
	
	class ExcluirPropostaLink extends Link<Void>{
		private static final long serialVersionUID = 1L;
		private long propostaId;
		
		public ExcluirPropostaLink(String id,long propostaId) {
			super(id);
			this.propostaId = propostaId;
			this.add(new SimpleAttributeModifier("onclick", "if(!confirm('Você realmente deseja fazer isso?')) return false;"));
		}
		
		@Override
		public void onClick() {
			excluirProposta(propostaId);
		}
		
	}
	
	private void excluirProposta(long propostaId) {
		try {
			PriorizacaoServiceUtil.deleteProposta(propostaId);
			info("Proposta excluida com sucesso!");
		} catch (PortalException e) {
			error("Erro ao excluir proposta");
			LOG.error("Erro ao excluir proposta");
		} catch (SystemException e) {
			error("Erro ao excluir proposta");
			LOG.error("Erro ao excluir proposta");
		}
	}
	
}

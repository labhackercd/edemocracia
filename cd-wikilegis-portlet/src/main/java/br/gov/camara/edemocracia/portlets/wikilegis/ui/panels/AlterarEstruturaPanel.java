package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.EstruturaDropDown;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ElementoEstrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.HomePage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AlterarEstruturaPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(AlterarEstruturaPanel.class);	

	
	private EstruturaDropDown agrupamentos;
	private Form<Void> form;
	private TextField<String> nomeAgrupamento; 
	private DropDownChoice<ElementoEstrutura> paiAlt;
	private DropDownChoice<Estrutura> posicaoAlt;
	private BookmarkablePageLink<HomePage> cancelar;	
	private Button gravar;
	
	public AlterarEstruturaPanel(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		init();
	
	}

	private void init() {
		
		initForm();
		initAgrupamentos();
		initNomeAgrupamento();
		initPai();
		initPosicao();
		initGravar();
		initCancelar();
		desativarComponentes();
	}

	private void initForm() {
		form = new Form<Void>("formAlteracao") {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				gravarAlteracao();
			}
		};
		add(form);

	}
	
	private void initAgrupamentos() {
		agrupamentos = new EstruturaDropDown("agrupamentos",UIUtils.getScopeGroupId());
		agrupamentos.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
					
				
				if(agrupamentos.getModelObject() == null){
					desativarComponentes();
				}else{
					ativarComponentes();
					recarregaPai(getElementoPaiAtual());
					recarregaPosicao();
					recarregaNomeAgrupamento();						
				}
				if (target != null)
				{
					target.addComponent(paiAlt);
					target.addComponent(posicaoAlt);
					target.addComponent(nomeAgrupamento);
					target.addComponent(gravar);
				}
			}
		});
		agrupamentos.setNullValid(false);
		form.add(agrupamentos);
	}	
	
	private void initNomeAgrupamento() {
		nomeAgrupamento = new TextField<String>("nomeAgrupamento",Model.of(""));
		nomeAgrupamento.add(StringValidator.maximumLength(300));
		nomeAgrupamento.setOutputMarkupId(true);
		form.add(nomeAgrupamento);
	}
		
	private void initGravar() {
		gravar = new Button("gravarAlteracao");
		gravar.setOutputMarkupId(true);
		form.add(gravar);		
	}
	
	private void initCancelar() {
		cancelar = new BookmarkablePageLink<HomePage>("cancelarAlteracao", HomePage.class);
		form.add(cancelar);
	}
	
	private void initPai() {
		
		paiAlt = new DropDownChoice<ElementoEstrutura>("paiAlt");
		paiAlt.setNullValid(true);
		paiAlt.setOutputMarkupId(true);
		paiAlt.setChoiceRenderer(new IChoiceRenderer<ElementoEstrutura>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(ElementoEstrutura object) {
				return object.getTexto();
			}

			@Override
			public String getIdValue(ElementoEstrutura object, int index) {
				return Long.toString(object.getEstruturaId());
			}
		});
		paiAlt.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				recarregaPosicao();
				if (target != null)
					target.addComponent(posicaoAlt);
			}
		});
						
		form.add(paiAlt);
	}
	
	private void initPosicao() {
		posicaoAlt = new DropDownChoice<Estrutura>("posicaoAlt");
		posicaoAlt.setNullValid(true);
		posicaoAlt.setOutputMarkupId(true);
		posicaoAlt.setChoiceRenderer(new IChoiceRenderer<Estrutura>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(Estrutura object) {
				return object.getTexto();
			}

			@Override
			public String getIdValue(Estrutura object, int index) {
				return Long.toString(object.getEstruturaId());
			}
		});
		
		form.add(posicaoAlt);
	}
	
	/**
	 * Recarrega a lista de elementos para a posição
	 */
	private void recarregaPosicao() {
		
		ElementoEstrutura noPai = paiAlt.getModelObject();
		long estruturaPaiId = (noPai == null) ? 0l : noPai.getEstruturaId();
		ElementoEstrutura estruturaSelecionada = agrupamentos.getModelObject();
		long estruturaSelecionadaId = (estruturaSelecionada == null) ? 0l :  estruturaSelecionada.getEstruturaId();
		long groupId = UIUtils.getScopeGroupId();
		
		Estrutura anterior =  null;
		Estrutura selecionado = null;
		
		ArrayList<Estrutura> filhosValidos = new ArrayList<Estrutura>();

		try {
			List<Estrutura> estruturas = WikiLegisServiceUtil.listaEstruturaFilhos(groupId, estruturaPaiId);
			for(Estrutura estrutura : estruturas){
				
				if (estrutura.getEstruturaId() != estruturaSelecionadaId)
					filhosValidos.add(estrutura);	
				else
					selecionado = anterior;

				anterior = estrutura;
			}
			
		} catch (Exception e) {
			LOG.error("Erro ao obter lista de elementos da estrutura.Param estruturaPaiId=\""+estruturaPaiId+"\", groupId=\""+groupId+"\" ",e);
		}

		posicaoAlt.setChoices(filhosValidos);
		
		@SuppressWarnings("unchecked")
		List<Estrutura> choices = (List<Estrutura>) posicaoAlt.getChoices();
		
		if (choices.isEmpty())
			posicaoAlt.setModel(new Model<Estrutura>());
		else if(selecionado == null)
			posicaoAlt.setModel(new Model<Estrutura>());
		else
			posicaoAlt.setModel(Model.of(selecionado));
				
	}
		
	/**
	 * Recarrega a lista de elementos pai setando o combo para a estrutura Pai passada por parametro
	 */	
	private void recarregaPai(long estruturaPaiAtualId) {
		ElementoEstrutura noPai = agrupamentos.getModelObject();
		long estruturaPaiId = (noPai == null) ? 0l : noPai.getEstruturaId();
				
			paiAlt.setChoices(new EstruturaListModelExclude(UIUtils.getScopeGroupId(), estruturaPaiId));
						
			@SuppressWarnings("unchecked")
			List<ElementoEstrutura> choices = (List<ElementoEstrutura>) paiAlt.getChoices();
			if (choices.isEmpty()){
				paiAlt.setModel(new Model<ElementoEstrutura>());
			}
			else{
				paiAlt.setModel(new Model<ElementoEstrutura>());
				for(ElementoEstrutura estrutura : choices){
					
					if(estrutura.getEstruturaId() == estruturaPaiAtualId ){
						paiAlt.setModel(Model.of(estrutura));
						break;
					}
				}
			}		
	}
	
	/*
	 * Insere no textfield o nome do agrupamento selecionado em tela
	 */
	private void recarregaNomeAgrupamento() {
		ElementoEstrutura noPai = agrupamentos.getModelObject();
		String textoArtigo = "";
		Estrutura estrutura;

		try {
			estrutura = WikiLegisServiceUtil.getEstrutura(noPai.getEstruturaId());
		} catch (PortalException e) {
			estrutura = null;
			LOG.error("Erro ao recuperar estrutura. Param estruturaId = "+noPai.getEstruturaId() ,e);
			estrutura = null;
		} catch (SystemException e) {
			estrutura = null;
			LOG.error("Erro ao recuperar estrutura. Param estruturaId = "+noPai.getEstruturaId() ,e);
		}
		
		if(noPai != null && estrutura != null)
			textoArtigo = estrutura.getTexto();
			
		nomeAgrupamento.setModel(Model.of(textoArtigo));
	
	}
	
	/*
	 * ativa os componentes em tela
	 */
	private void ativarComponentes(){
		paiAlt.setEnabled(true);
		posicaoAlt.setEnabled(true);
		nomeAgrupamento.setEnabled(true);
		gravar.setEnabled(true);
	}
	
	/*
	 * desativa os componentes em tela
	 */	
	private void desativarComponentes(){		
		paiAlt.setEnabled(false);
		paiAlt.setModel(null);
		posicaoAlt.setEnabled(false);
		posicaoAlt.setModel(null);
		nomeAgrupamento.setModel(null);
		nomeAgrupamento.setEnabled(false);
		gravar.setEnabled(false);
		
	}
	
	/**
	 * 
	 * @return id do pai do elemento selecionado em tela
	 */
	private long getElementoPaiAtual() {
		
		ElementoEstrutura estruturaSelecionada = agrupamentos.getModelObject();				
		
		if(estruturaSelecionada != null){
			try {
				Estrutura estrutura = WikiLegisServiceUtil.getEstrutura(estruturaSelecionada.getEstruturaId());
				return estrutura.getPaiEstruturaId();
			} catch (PortalException e) {
				LOG.error("Erro ao obter paiEstruturaId da estrutura.Param estruturaId=\""+estruturaSelecionada.getEstruturaId(),e);
			} catch (SystemException e) {
				LOG.error("Erro ao obter paiEstruturaId da estrutura.Param estruturaId=\""+estruturaSelecionada.getEstruturaId(),e);
			}			
		}		
		
		return 0l;		
	}
	
	private void gravarAlteracao(){
		
		ElementoEstrutura estruturaSelecionada = agrupamentos.getModelObject();
		String novoNomeEstrutura = nomeAgrupamento.getModelObject();
		long paiId = (paiAlt.getModelObject() == null  ) ? 0l : paiAlt.getModelObject().getEstruturaId() ;
		long estruturaDepoisDe =  (posicaoAlt.getModelObject() == null ) ? 0l : posicaoAlt.getModelObject().getEstruturaId() ;
		
		try {
			
			WikiLegisServiceUtil.atualizaEstrutura(estruturaSelecionada.getEstruturaId(), UIUtils.getScopeGroupId(), paiId, estruturaDepoisDe, novoNomeEstrutura);
			info("Suas alterações foram gravadas com sucesso!");			
			
		} catch (SystemException e) {
			// XXX
			LOG.error("Erro ao gravar alterações da estrutura.", e);
			error("Erro ao tentar gravar alterações");
		} catch (PortalException e) {
			// XXX
			LOG.error("Erro ao gravar alterações da estrutura.", e);
			error("Erro ao tentar gravar alterações");
		}
	
	}
	
	
	/**
	 * Lista de elementos, organizados de forma hierárquica excluindo a estrutura do parametro
	 * 
	 * @author robson
	 * 
	 */
	private static class EstruturaListModelExclude extends LoadableDetachableModel<List<ElementoEstrutura>> {
		
		private static final long serialVersionUID = 1L;
		private final long groupId;
		private final long estruturaAtualId;

		private EstruturaListModelExclude(long groupId, long estruturaAtualId) {
			this.groupId = groupId;
			this.estruturaAtualId = estruturaAtualId;
		}

		@Override
		protected List<ElementoEstrutura> load() {
			ArrayList<ElementoEstrutura> retorno = new ArrayList<ElementoEstrutura>();

			try {
				List<Estrutura> raizes = WikiLegisServiceUtil.listaEstruturaFilhos(groupId, 0l);

				for (Estrutura estrutura : raizes) {
					adiciona(retorno, 0, estrutura);
				}
				return retorno;
			} catch (Exception e) {
				// XXX Log
				LOG.error("Erro ao obter lista de elementos.Param groupId=\""+groupId+"\",paiEstruturaId = \"0l\" ",e);
				return Collections.emptyList();
			}
		}
		
		private void adiciona(ArrayList<ElementoEstrutura> retorno, int nivel, Estrutura estrutura) throws PortalException,
				SystemException {
						
			if (estrutura.getEstruturaId() != estruturaAtualId) {
				
				StringBuilder sb = new StringBuilder(nivel
						+ estrutura.getTexto().length());
				for (int i = 0; i < nivel; i++)
					sb.append("-");
				sb.append(estrutura.getTexto());
				retorno.add(new ElementoEstrutura(estrutura.getEstruturaId(),
						sb.toString()));

				List<Estrutura> filhos = WikiLegisServiceUtil.listaEstruturaFilhos(groupId, estrutura.getEstruturaId());
				for (Estrutura filho : filhos)
					adiciona(retorno, nivel + 1, filho);
			}
			
		
		}
	}

}
package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class NovaEstruturaPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(NovaEstruturaPanel.class);	
	
	////////////////////////////////
	//Componentes
	////////////////////////////////
	
	private Form<Void> form;

	/**
	 * Nome do novo agrupamento
	 */
	private TextField<String> novoAgrupamento;
	/**
	 * Nó pai
	 */
	private EstruturaDropDown pai;
	/**
	 * Em qual posição?
	 */
	private DropDownChoice<Estrutura> posicao;

	/**
	 * Botão para criar
	 */
	private Button criar;

	/**
	 * Botão para cancelar
	 */
	private BookmarkablePageLink<HomePage> cancelar;
	
		
	public NovaEstruturaPanel(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		init();
	}

	private void init() {
		initForm();
		initNovoAgrupamento();
		initPai();
		initPosicao();
		initCriar();
		initCancelar();
	}

	private void initForm() {
		form = new Form<Void>("form") {
			@Override
			protected void onSubmit() {
				criaEstrutura();
			}
		};
		add(form);

	}

	private void initNovoAgrupamento() {
		novoAgrupamento = new TextField<String>("novoAgrupamento", Model.of(""));
		novoAgrupamento.add(StringValidator.maximumLength(300));
		novoAgrupamento.setOutputMarkupId(true);
		form.add(novoAgrupamento);
	}
	
	private void initPai() {
				
		pai = new EstruturaDropDown("pai",UIUtils.getScopeGroupId()) ;
		
		pai.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				recarregaPosicao();
				if (target != null)
					target.addComponent(posicao);
			}
		});
		form.add(pai);
	}
	
	private void initPosicao() {
		posicao = new DropDownChoice<Estrutura>("posicao");
		posicao.setNullValid(true);
		posicao.setOutputMarkupId(true);
		posicao.setChoiceRenderer(new IChoiceRenderer<Estrutura>() {

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
		posicao.setOutputMarkupId(true);
		recarregaPosicao();
		form.add(posicao);
	}

	private void initCriar() {
		criar = new Button("criar");
		form.add(criar);
	}

	private void initCancelar() {
		cancelar = new BookmarkablePageLink<HomePage>("cancelar", HomePage.class);
		form.add(cancelar);
	}
	
	/**
	 * Cria uma nova estrutura na posição informada
	 */
	private void criaEstrutura() {

		ElementoEstrutura noPai = pai.getModelObject();
		Estrutura noPosicao = posicao.getModelObject();
		long paiId = (noPai == null) ? 0l : noPai.getEstruturaId();
		long antesDeId = (noPosicao == null) ? 0l : noPosicao.getEstruturaId();

		try {
			posicao.setModelObject(WikiLegisServiceUtil.criaEstrutura(UIUtils.getScopeGroupId(), paiId, antesDeId, novoAgrupamento.getModelObject()));
			novoAgrupamento.setModelObject("");
		} catch (Exception e) {
			// TODO Log
			LOG.error("Erro ao criar nova estrutura na posição informada",e);
			error("Erro ao gravar nova estrutura");
		}
	}

	/**
	 * Recarrega a lista de elementos para a posição
	 */
	private void recarregaPosicao() {
		ElementoEstrutura noPai = pai.getModelObject();
		long estruturaPaiId = (noPai == null) ? 0l : noPai.getEstruturaId();
		posicao.setChoices(new EstruturaListModel(UIUtils.getScopeGroupId(), estruturaPaiId));
		@SuppressWarnings("unchecked")
		List<Estrutura> choices = (List<Estrutura>) posicao.getChoices();
		if (choices.isEmpty())
			posicao.setModel(new Model<Estrutura>());
		else
			posicao.setModel(Model.of(choices.get(choices.size()-1)));

	}

	/**
	 * Lista de elementos de um nível da estrutura
	 * 
	 * @author robson
	 * 
	 */
	private static class EstruturaListModel extends LoadableDetachableModel<List<Estrutura>> {
		private static final long serialVersionUID = 1L;
		private final long groupId;
		private final long estruturaPaiId;

		private EstruturaListModel(long groupId, long estruturaPaiId) {
			this.groupId = groupId;
			this.estruturaPaiId = estruturaPaiId;
		}

		@Override
		protected List<Estrutura> load() {

			try {
				return WikiLegisServiceUtil.listaEstruturaFilhos(groupId, estruturaPaiId);
			} catch (Exception e) {
				// XXX Log
				LOG.error("Erro ao obter lista de elementos da estrutura.Param estruturaPaiId=\""+estruturaPaiId+"\", groupId=\""+groupId+"\" ",e);
				return Collections.emptyList();
			}

		}
	}
	
}

/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ElementoEstrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.PosicaoArtigo;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;
import br.gov.camara.edemocracia.portlets.wikilegis.util.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author rpdmiranda O *
 */
public class PosicaoArtigoPanel extends FormComponentPanel<PosicaoArtigo> {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil
			.getLog(PosicaoArtigoPanel.class);

	private long artigoAtualId;

	/**
	 * Lista de elementos, organizados de forma hierárquica (espaços indicam o
	 * nível)
	 * 
	 * @author robson
	 * 
	 */
	private static class ElementoEstruturaListModel extends
			LoadableDetachableModel<List<ElementoEstrutura>> {
		private static final long serialVersionUID = 1L;

		private final long groupId;

		private ElementoEstruturaListModel(long groupId) {
			this.groupId = groupId;
		}

		@Override
		protected List<ElementoEstrutura> load() {
			ArrayList<ElementoEstrutura> retorno = new ArrayList<ElementoEstrutura>();

			try {
				List<Estrutura> raizes = WikiLegisServiceUtil
						.listaEstruturaFilhos(groupId, 0l);

				for (Estrutura estrutura : raizes) {
					adiciona(retorno, 0, estrutura);
				}
				return retorno;
			} catch (Exception e) {
				// XXX Log
				LOG.error("Erro ao obter elementos da estrutura", e);
				return Collections.emptyList();
			}
		}

		private void adiciona(ArrayList<ElementoEstrutura> retorno, int nivel,
				Estrutura estrutura) throws PortalException, SystemException {
			StringBuilder sb = new StringBuilder(nivel
					+ estrutura.getTexto().length());
			for (int i = 0; i < nivel; i++)
				sb.append("-");
			sb.append(estrutura.getTexto());
			retorno.add(new ElementoEstrutura(estrutura.getEstruturaId(), sb
					.toString()));

			List<Estrutura> filhos = WikiLegisServiceUtil.listaEstruturaFilhos(
					groupId, estrutura.getEstruturaId());
			for (Estrutura filho : filhos)
				adiciona(retorno, nivel + 1, filho);
		}
	}

	/**
	 * Construtor
	 * 
	 * @param id
	 * @param model
	 */
	public PosicaoArtigoPanel(String id, IModel<PosicaoArtigo> model) {
		super(id, model);
		init();
	}

	/**
	 * Construtor sem modelo
	 * 
	 * @param id
	 */
	public PosicaoArtigoPanel(String id) {
		this(id, null);
	}

	/**
	 * Coloca na posição inicial
	 * 
	 * @param id
	 * @param model
	 * @param ordem
	 */
	public PosicaoArtigoPanel(String id, IModel<PosicaoArtigo> model,
			long artigoAtualId) {
		super(id, model);
		this.artigoAtualId = artigoAtualId;
		init();
	}

	/**
	 * Nó pai
	 */
	private DropDownChoice<ElementoEstrutura> pai;

	/**
	 * Em qual posição?
	 */
	private DropDownChoice<Artigo> posicao;

	private void init() {
		initPai();
		initPosicao();
	}

	private void initPai() {
		pai = new DropDownChoice<ElementoEstrutura>("pai",
				new Model<ElementoEstrutura>(), new ElementoEstruturaListModel(
						UIUtils.getScopeGroupId()));
		pai.setNullValid(true);
		pai.setOutputMarkupId(true);
		pai.setChoiceRenderer(new IChoiceRenderer<ElementoEstrutura>() {

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
		pai.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				recarregaPosicao();
				if (target != null)
					target.addComponent(posicao);
			}
		});
		add(pai);
		if (getModelObject() != null
				&& getModelObject().getEstruturaPaiId() != 0) {
			try {
				Estrutura estrutura = WikiLegisServiceUtil
						.getEstrutura(getModelObject().getEstruturaPaiId());
				pai.setModelObject(new ElementoEstrutura(estrutura
						.getEstruturaId(), estrutura.getTexto()));
			} catch (Exception e) {
				// TODO LOG
			}
		}

	}

	private void initPosicao() {
		posicao = new DropDownChoice<Artigo>("posicao");
		posicao.setModel(new Model<Artigo>());
		posicao.setNullValid(true);
		posicao.setOutputMarkupId(true);
		posicao.setChoiceRenderer(new IChoiceRenderer<Artigo>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(Artigo object) {
				return StringUtils.truncate(object.getTexto(), 60);
			}

			@Override
			public String getIdValue(Artigo object, int index) {
				return Long.toString(object.getArtigoId());
			}
		});
		posicao.setOutputMarkupId(true);
		recarregaPosicao();
		add(posicao);
	}

	/**
	 * Recarrega a lista de elementos para a posição
	 */
	private void recarregaPosicao() {
		ElementoEstrutura noPai = pai.getModelObject();
		long estruturaPaiId = (noPai == null) ? 0l : noPai.getEstruturaId();
		List<Artigo> filhos;
		try {
			filhos = WikiLegisServiceUtil.listaArtigos(
					UIUtils.getScopeGroupId(), estruturaPaiId);
		} catch (PortalException e) {
			filhos = Collections.emptyList();
		} catch (SystemException e) {
			// TODO Log
			throw new RuntimeException("Error fetching artigos");
		}
		ArrayList<Artigo> filhosValidos = new ArrayList<Artigo>();
		Artigo anterior = null;
		Artigo selecionado = null;
		for (Artigo artigo : filhos) {
			if (artigo.getArtigoId() == artigoAtualId) {
				selecionado = anterior;
			} else {
				filhosValidos.add(artigo);
			}
			anterior = artigo;
		}

		posicao.setChoices(filhosValidos);
		posicao.setModelObject(selecionado);
	}

	protected void onModelChanged() {
		super.onModelChanged();
		PosicaoArtigo pos = getModelObject();
		if (pos == null) {
			pai.setModelObject(null);
			posicao.setModelObject(null);
		} else {
			try {
				if (pos.getEstruturaPaiId() == 0) {
					pai.setModelObject(null);
				} else {
					Estrutura estrutura = WikiLegisServiceUtil.getEstrutura(pos
							.getEstruturaPaiId());
					pai.setModelObject(new ElementoEstrutura(estrutura
							.getEstruturaId(), estrutura.getTexto()));
				}
			} catch (Exception e) {
				// TODO Log
				LOG.error("Erro ao mudar model da estruturaPai.", e);
				pai.setModelObject(null);
			}

			recarregaPosicao();
		}
	}

	protected void convertInput() {
		long paiId = 0;
		long artigoAnteriorId = 0;
		if (pai.getConvertedInput() != null)
			paiId = pai.getConvertedInput().getEstruturaId();
		if (posicao.getConvertedInput() != null)
			artigoAnteriorId = posicao.getConvertedInput().getArtigoId();

		PosicaoArtigo pos = new PosicaoArtigo(paiId, artigoAnteriorId);
		setConvertedInput(pos);
	}
}

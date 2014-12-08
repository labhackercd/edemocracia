package br.gov.camara.edemocracia.portlets.wikilegis.service.impl;

import java.util.List;
import java.util.Map;

import br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;
import br.gov.camara.edemocracia.portlets.wikilegis.service.base.ArtigoLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBDiscussionLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;

/**
 * The implementation of the artigo local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil}
 * to access the artigo local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.ArtigoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil
 */
public class ArtigoLocalServiceImpl extends ArtigoLocalServiceBaseImpl {
	/**
	 * Lista os filhos do pai especificado
	 */
	@Override
	public List<Artigo> listaArtigos(long groupId, long estruturaId)
			throws SystemException {
		return artigoPersistence.findByG_E(groupId, estruturaId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, new ArtigoComparator());
	}

	/**
	 * Lista os filhos do pai especificado, já formatados para visualização
	 * 
	 * @param groupId
	 * @param estruturaId
	 * @return
	 */
	@Override
	public List<ArtigoDisplay> listaArtigoDisplay(long groupId, long estruturaId) {
		return artigoFinder.findDisplayByG_E(groupId, estruturaId);
	}

	/**
	 * Lista todos os artigos do grupo especificadoz
	 * 
	 * @param groupId
	 * @return
	 */
	@Override
	public Map<Long, List<ArtigoDisplay>> listaArtigoDisplay(long groupId) {
		return artigoFinder.findAllArtigoDisplay(groupId);
	}

	/**
	 * Cria um artigo no nó especificado
	 * 
	 * @param groupId
	 * @param estruturaId
	 * @param texto
	 * @param legislacaoVigente
	 * @param ordem
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 * @return Artigo artigo recém-criado
	 */
	@Override
	public Artigo criaArtigo(long groupId, long estruturaId,
			long anteriorArtigoId, String texto, String legislacaoVigente)
			throws SystemException, PortalException {

		// Formata
		Group group = GroupServiceUtil.getGroup(groupId);
		long companyId = group.getCompanyId();

		// Insere o artigo na posição correta
		int ordem = atualizaPosicaoArtigos(groupId, estruturaId,
				anteriorArtigoId);

		Artigo artigo = artigoPersistence.create(counterLocalService
				.increment());
		artigo.setCompanyId(companyId);
		artigo.setGroupId(groupId);
		artigo.setEstruturaId(estruturaId);
		artigo.setOrdem(ordem);
		artigo.setTexto(texto);
		artigo.setLegislacaoVigente(legislacaoVigente);
		return artigoPersistence.update(artigo, true);
	}

	/**
	 * @param groupId
	 * @param estruturaId
	 * @param anteriorArtigoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private int atualizaPosicaoArtigos(long groupId, long estruturaId,
			long anteriorArtigoId) throws PortalException, SystemException {
		int ordem = 0;
		if (anteriorArtigoId > 0l) {
			Artigo anterior = getArtigo(anteriorArtigoId);
			// Deve estar na mesma estrutura
			if (anterior.getEstruturaId() == estruturaId)
				ordem = anterior.getOrdem() + 1;
		}

		List<Artigo> antigos = artigoPersistence
				.findByG_E(groupId, estruturaId);
		for (Artigo antigo : antigos) {
			if (antigo.getOrdem() >= ordem) {
				antigo.setOrdem(antigo.getOrdem() + 1);
				artigoPersistence.update(antigo, false);
			}
		}
		return ordem;
	}

	/**
	 * Exclui um artigo e seus comentários
	 * 
	 * @param artigoId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void excluiArtigo(long artigoId) throws PortalException,
			SystemException {
		Artigo artigo = getArtigo(artigoId);
		long groupId = artigo.getGroupId();
		long estruturaId = artigo.getEstruturaId();

		// Atualiza a ordem dos artigos
		List<Artigo> artigosNoNivel = artigoPersistence.findByG_E(groupId,
				estruturaId);
		for (Artigo outroArtigo : artigosNoNivel) {
			if (outroArtigo.getOrdem() > artigo.getOrdem()) {
				outroArtigo.setOrdem(outroArtigo.getOrdem() - 1);
				artigoPersistence.update(outroArtigo, false);
			}
		}
		
		// Exclui as contribuições
		List<Contribuicao> contribuicoes = contribuicaoPersistence.findByA(artigoId);
		for (Contribuicao contrib : contribuicoes) {
			contribuicaoPersistence.remove(contrib);
		}
		
		// Exclui o artigo
		deleteArtigo(artigo);
	}

	/**
	 * Atualiza um artigo
	 * 
	 * @param userId
	 * @param artigoId
	 * @param textoArtigo
	 * @param legislacaoVigente
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Transactional(rollbackFor = NoSuchArtigoException.class)
	public Artigo atualizaArtigo(long userId, long artigoId, long estruturaId,
			long anteriorArtigoId, String textoArtigo, String legislacaoVigente)
			throws SystemException, PortalException {

		// Atualiza o texto
		if (textoArtigo == null)
			textoArtigo = "";
		textoArtigo = textoArtigo.trim();

		if (legislacaoVigente == null)
			legislacaoVigente = "";
		legislacaoVigente = legislacaoVigente.trim();

		Artigo artigo = artigoPersistence.findByPrimaryKey(artigoId);
		artigo.setTexto(textoArtigo);
		artigo.setLegislacaoVigente(legislacaoVigente);

		// Verifica se alterou a estrurura
		// if (artigo.getEstruturaId() != estruturaId) {
		List<Artigo> artigos = artigoPersistence.findByG_E(artigo.getGroupId(),
				artigo.getEstruturaId());
		int ordemAnterior = artigo.getOrdem();

		// Altera a numeração, retirando o nó da hierarquia existente
		artigo.setEstruturaId(estruturaId);
		artigo.setOrdem(-1);
		artigoPersistence.update(artigo, false);

		for (Artigo anterior : artigos) {
			if (anterior.getArtigoId() != artigo.getArtigoId()
					&& anterior.getOrdem() > ordemAnterior) {
				anterior.setOrdem(anterior.getOrdem() - 1);
				artigoPersistence.update(anterior, false);
			}
		}
		// }

		// Altera a posição do artigo
		int ordem = atualizaPosicaoArtigos(artigo.getGroupId(), estruturaId,
				anteriorArtigoId);
		artigo.setOrdem(ordem);

		return artigoPersistence.update(artigo, false);
	}

}

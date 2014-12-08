package br.gov.camara.edemocracia.portlets.wikilegis.service.impl;

import java.util.Date;
import java.util.List;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.base.ContribuicaoLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the contribuicao local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalServiceUtil}
 * to access the contribuicao local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.ContribuicaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalServiceUtil
 */
public class ContribuicaoLocalServiceImpl extends
		ContribuicaoLocalServiceBaseImpl {

	private static class ContribuicaoComparator extends OrderByComparator {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(Object obj1, Object obj2) {
			Contribuicao lhs = (Contribuicao) obj1;
			Contribuicao rhs = (Contribuicao) obj2;
			if (lhs.equals(rhs))
				return 0;
			if (lhs.getData().before(rhs.getData()))
				return -1;
			else
				return 1;
		}

		public String getOrderBy() {
			return "data ASC";
		}

		public String[] getOrderByFields() {
			return new String[] { "data" };
		}

		@Override
		public boolean isAscending() {
			return true;
		}

	}

	/**
	 * Lista todas as contribuições do artigo
	 * 
	 * @param artigoId
	 *            Lista as contribuições do artigo especificado
	 */
	@Override
	public List<Contribuicao> listaContribuicoes(long artigoId)
			throws SystemException {
		return contribuicaoPersistence.findByA(artigoId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, new ContribuicaoComparator());
	}

	/**
	 * Cria uma nova contribuição para o artigo especificado
	 * 
	 * @param userId
	 * @param artigoId
	 * @param textoArtigo
	 * @param descricao
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@Override
	public void criaContribuicao(long userId, long artigoId,
			String textoArtigo, String descricao) throws SystemException, PortalException {
		
		User user = UserLocalServiceUtil.getUser(userId);
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);
		Contribuicao contrib = createContribuicao(counterLocalService.increment());
		contrib.setUserId(userId);
		contrib.setUserName(user.getFullName());
		contrib.setArtigoId(artigo.getArtigoId());
		contrib.setData(new Date());
		
		contrib.setTexto(textoArtigo);
		contrib.setDescricao(descricao);
		
		updateContribuicao(contrib, true);
	}
	
	/**
	 * Conta o número de contribuições para um artigo
	 * 
	 * @param artigoId
	 * @return
	 * @throws SystemException
	 */
	public int contaContribuicoes(long artigoId) throws SystemException {
		return getContribuicaoPersistence().countByA(artigoId);
	}
	
	
	/**
	 * Atualiza a contribuicao especificada
	 * 
	 *  @param contribuicaoId
	 *  @param textoArtigo
	 *  @param descricao
	 *  @return
	 *  @throws PortalException
	 *  @throws SystemException
	 */
	@Transactional(rollbackFor = NoSuchContribuicaoException.class)
	public Contribuicao atualizaContribuicao(long contribuicaoId,String textoArtigo,String descricao) throws PortalException, SystemException{
		Contribuicao contribuicao = getContribuicao(contribuicaoId);
		contribuicao.setTexto(textoArtigo);
		contribuicao.setDescricao(descricao);
		
		return updateContribuicao(contribuicao, false);
	}
}

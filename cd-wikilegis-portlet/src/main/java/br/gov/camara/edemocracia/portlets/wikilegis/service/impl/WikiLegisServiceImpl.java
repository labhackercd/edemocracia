/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.ElementoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper;
import br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisService;
import br.gov.camara.edemocracia.portlets.wikilegis.service.base.WikiLegisServiceBaseImpl;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;

/**
 * The implementation of the wiki legis remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil}
 * to access the wiki legis remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.WikiLegisServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil
 */
public class WikiLegisServiceImpl extends WikiLegisServiceBaseImpl {

	private static final String CACHE_NAME = WikiLegisService.class.getName();

	/**
	 * Invalida o cache para o grupo especificado
	 * 
	 * @param groupId
	 */
	private void invalidateCache(long groupId) {
		PortalCache _portalCache = MultiVMPoolUtil.getCache(CACHE_NAME);
		_portalCache.remove("wikilegiscacheall_" + groupId);
		_portalCache.remove("wikilegisstruct_" + groupId);
	}

	private int contaMensagens(long artigoId) throws SystemException {
		return MBMessageLocalServiceUtil.getDiscussionMessagesCount(
				Artigo.class.getName(), artigoId, WorkflowConstants.STATUS_ANY);
	}

	private int contaContribuicoes(long artigoId) throws SystemException {
		return ContribuicaoLocalServiceUtil.contaContribuicoes(artigoId);
	}

	/**
	 * @param input
	 * @return
	 */
	private ArtigoDisplay constroiArtigoDisplay(Artigo input) {
		int numeroMensagens;
		try {
			numeroMensagens = contaMensagens(input.getArtigoId());
		} catch (SystemException e) {
			numeroMensagens = 0;
		}
		int numeroContribuicoes;
		try {
			numeroContribuicoes = contaContribuicoes(input.getArtigoId());
		} catch (SystemException e) {
			numeroContribuicoes = 0;
		}
		return new ArtigoDisplay(input, numeroMensagens, numeroContribuicoes);
	}

	/**
	 * Obtém informações para exibição de um artigo
	 * 
	 * @param artigoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public ArtigoDisplay getArtigoDisplay(long artigoId)
			throws PortalException, SystemException {
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);
		return constroiArtigoDisplay(artigo);
	}

	private Map<String, ElementoDisplay> obtemDadosCache(long groupId) {
		PortalCache _portalCache = MultiVMPoolUtil.getCache(CACHE_NAME);
		String key = "wikilegiscacheall_" + groupId;
		@SuppressWarnings("unchecked")
		Map<String, ElementoDisplay> cachedData = (Map<String, ElementoDisplay>) _portalCache
				.get(key);
		if (cachedData != null) {
			if (cachedData.isEmpty())
				return cachedData;
			if (cachedData.values().iterator().next() instanceof ElementoDisplay)
				return cachedData;
		}
		return null;
	}

	private void atualizaCache(long groupId, Map<String, ElementoDisplay> map) {
		PortalCache _portalCache = MultiVMPoolUtil.getCache(CACHE_NAME);
		String key = "wikilegiscacheall_" + groupId;
		_portalCache.put(key, map);
	}

	/**
	 * Lista todos os elementos da wikilegis especificada
	 * 
	 * @param companyId
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public Collection<ElementoDisplay> listaElementos(long groupId)
			throws SystemException, PortalException {
		// TODO: Verificar permissões

		// Group group = GroupLocalServiceUtil.getGroup(groupId);

		// Verifica se está em cache
		Map<String, ElementoDisplay> cachedData = obtemDadosCache(groupId);
		if (cachedData != null) {
			if (cachedData.isEmpty())
				return Collections.unmodifiableCollection(cachedData.values());
			if (cachedData.values().iterator().next() instanceof ElementoDisplay)
				return Collections.unmodifiableCollection(cachedData.values());
		}

		cachedData = new LinkedHashMap<String, ElementoDisplay>();

		Map<Long, List<ArtigoDisplay>> artigos = ArtigoLocalServiceUtil
				.listaArtigoDisplay(groupId);

		for (ArtigoDisplay artigo : getArtigos(artigos, 0l)) {
			cachedData.put("a" + artigo.getId(), artigo);
		}

		List<Estrutura> nos = EstruturaLocalServiceUtil.listaTodos(groupId);
		for (Estrutura no : nos) {
			cachedData.put("e" + no.getEstruturaId(), new EstruturaDisplay(no));
			for (ArtigoDisplay artigo : getArtigos(artigos, no.getEstruturaId())) {
				cachedData.put("a" + artigo.getId(), artigo);
			}
		}

		// Adiciona em cache
		atualizaCache(groupId, Collections.synchronizedMap(cachedData));

		return Collections.unmodifiableCollection(cachedData.values());
	}

	/**
	 * Obtém os artigos a partir do mapa
	 * 
	 * @param artigos
	 * @param estruturaId
	 * @return
	 */
	private List<ArtigoDisplay> getArtigos(
			Map<Long, List<ArtigoDisplay>> artigos, long estruturaId) {
		List<ArtigoDisplay> ret = artigos.get(estruturaId);
		if (ret == null)
			return Collections.emptyList();
		else
			return ret;
	}

	/**
	 * Monta a lista de estruturas para visualização no menu
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public List<EstruturaDisplay> listaEstrutura(long groupId)
			throws SystemException, PortalException {

		// TODO Verificar acesso

		String key = "wikilegisstruct_" + groupId;
		PortalCache _portalCache = MultiVMPoolUtil.getCache(CACHE_NAME);
		@SuppressWarnings("unchecked")
		List<EstruturaDisplay> retorno = (List<EstruturaDisplay>) _portalCache
				.get(key);
		if (retorno != null) {
			if (retorno.isEmpty())
				return retorno;
			if (retorno.get(0) instanceof EstruturaDisplay)
				return retorno;
		}

		List<Estrutura> raizes = EstruturaLocalServiceUtil.listaFilhos(groupId,
				0L);
		retorno = new ArrayList<EstruturaDisplay>();
		for (Estrutura raiz : raizes) {
			EstruturaDisplay raizDisplay = new EstruturaDisplay(raiz);
			retorno.add(raizDisplay);
			adicionaFilhos(raizDisplay, raiz);
		}
		_portalCache.put(key, retorno);
		return retorno;
	}

	/**
	 * Adiciona os elementos filho, recursivamente
	 * 
	 * @param paiDisplay
	 * @param pai
	 * @throws SystemException
	 */
	private void adicionaFilhos(EstruturaDisplay paiDisplay, Estrutura pai)
			throws SystemException {
		List<Estrutura> filhos = EstruturaLocalServiceUtil.listaFilhos(
				pai.getGroupId(), pai.getEstruturaId());
		for (Estrutura filho : filhos) {
			EstruturaDisplay filhoDisplay = paiDisplay.adicionaFilho(filho);
			adicionaFilhos(filhoDisplay, filho);
		}
	}

	/**
	 * Edita o artigo especificado, criando uma nova versão
	 * 
	 * @param artigoId
	 * @param estruturaId
	 * @param textoArtigo
	 * @param legislacaoVigente
	 * @param anteriorArtigoId
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public void editaArtigo(long artigoId, long estruturaId,
			long anteriorArtigoId, String textoArtigo, String legislacaoVigente)
			throws SystemException, PortalException {

		// TODO: Verificar permissões
		User user = getGuestOrUser();

		Artigo artigo = ArtigoLocalServiceUtil.atualizaArtigo(user.getUserId(),
				artigoId, estruturaId, anteriorArtigoId, textoArtigo,
				legislacaoVigente);

		invalidateCache(artigo.getGroupId());
	}
	
	/**
	 * Exclui um artigo
	 * 
	 * TODO Verificar permissões no modelo
	 * 
	 * @param artigoId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void excluiArtigo(long artigoId) throws SystemException, PortalException {
		User user = getGuestOrUser();
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);
		long groupId = artigo.getGroupId();
		
		// TODO Verifica se tem permissões
		ArtigoLocalServiceUtil.excluiArtigo(artigo.getArtigoId());
		
		invalidateCache(groupId);
	}

	/**
	 * Cria um novo artigo
	 * 
	 * @param groupId
	 * @param noId
	 * @param anteriorArtigoId
	 * @param textoArtigo
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 * @return Artigo o artigo recém-criado
	 */
	@Override
	public Artigo criaArtigo(long groupId, long noId, long anteriorArtigoId,
			String textoArtigo, String legislacaoVigente)
			throws SystemException, PortalException {

		// TODO: Verificar permissões
		User user = getGuestOrUser();

		Artigo artigo = ArtigoLocalServiceUtil.criaArtigo(groupId, noId,
				anteriorArtigoId, textoArtigo, legislacaoVigente);

		invalidateCache(artigo.getGroupId());
		return artigo;
	}

	/**
	 * Lista as contribuições para o artigo especificado
	 * 
	 * @param artigoId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public List<Contribuicao> listaContribuicoes(long artigoId)
			throws SystemException {
		// TODO: Verificar permissoes
		return ContribuicaoLocalServiceUtil.listaContribuicoes(artigoId);
	}

	/**
	 * Adiciona uma contribuição no artigo especificado
	 * 
	 * @param artigoId
	 * @param textoArtigo
	 * @param descricao
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public void adicionaContribuicao(long artigoId, String textoArtigo,
			String descricao) throws SystemException, PortalException {

		// TODO: Verificar permissões
		User user = getGuestOrUser();
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);

		long groupId = artigo.getGroupId();
		ContribuicaoLocalServiceUtil.criaContribuicao(user.getUserId(),
				artigoId, textoArtigo, descricao);

		Map<String, ElementoDisplay> dados = obtemDadosCache(groupId);
		if (dados != null) {
			dados.put("a" + artigoId, constroiArtigoDisplay(artigo));
			atualizaCache(groupId, dados);
		}
	}

	/**
	 * Exclui uma contribuição
	 * 
	 * @param contribuicaoId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeContribuicao(long contribuicaoId) throws SystemException,
			PortalException {
		// TODO: Verificar permissões
		User user = getGuestOrUser();
		Contribuicao contribuicao = ContribuicaoLocalServiceUtil
				.getContribuicao(contribuicaoId);
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(contribuicao
				.getArtigoId());
		long groupId = artigo.getGroupId();
		long artigoId = artigo.getArtigoId();

		ContribuicaoLocalServiceUtil.deleteContribuicao(contribuicao);
		Map<String, ElementoDisplay> dados = obtemDadosCache(groupId);
		if (dados != null) {
			dados.put("a" + artigoId, constroiArtigoDisplay(artigo));
			atualizaCache(groupId, dados);
		}
	}

	/**
	 * Lista os nós filhos da estrutura
	 * 
	 * @param groupId
	 * @param paiEstruturaId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public List<Estrutura> listaEstruturaFilhos(long groupId,
			long paiEstruturaId) throws PortalException, SystemException {
		// TODO: Verificar permissões
		User user = getGuestOrUser();
		Group group = GroupLocalServiceUtil.getGroup(groupId);

		return EstruturaLocalServiceUtil.listaFilhos(groupId, paiEstruturaId);
	}

	/**
	 * Lista os artigos filhos do nó de estrutura especificado
	 * 
	 * @param groupId
	 * @param paiEstruturaId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public List<Artigo> listaArtigos(long groupId, long paiEstruturaId)
			throws PortalException, SystemException {
		// TODO: Verificar permissões
		User user = getGuestOrUser();
		Group group = GroupLocalServiceUtil.getGroup(groupId);

		return ArtigoLocalServiceUtil.listaArtigos(groupId, paiEstruturaId);
	}

	/**
	 * Cria uma novo nó na estrutura
	 * 
	 * @param groupId
	 * @param paiId
	 * @param antesDeId
	 * @param nome
	 * @throws SystemException
	 * @throws PortalException
	 * @return Estrutura recém-criada
	 */
	@Override
	public Estrutura criaEstrutura(long groupId, long paiId, long antesDeId,
			String nome) throws PortalException, SystemException {
		// TODO verificar permissões
		User user = getGuestOrUser();
		Group group = GroupLocalServiceUtil.getGroup(groupId);

		Estrutura estrutura = EstruturaLocalServiceUtil.criaEstrutura(groupId,
				paiId, antesDeId, nome);
		invalidateCache(groupId);
		return estrutura;
	}

	/**
	 * Obtém a estrutura com o identificador informado
	 * 
	 * @param estruturaId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public Estrutura getEstrutura(long estruturaId) throws PortalException,
			SystemException {
		Estrutura estrutura = EstruturaLocalServiceUtil
				.getEstrutura(estruturaId);

		// TODO Verificar permissões
		return estrutura;
	}

	/**
	 * Obtém o artigo com o identificador informado
	 * 
	 * @param artigoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Artigo getArtigo(long artigoId) throws PortalException,
			SystemException {
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);

		// TODO Verificar permissões
		return artigo;
	}

	/**
	 * Compara as versões de contribuições e com o artigo original
	 * 
	 * @param artigoId
	 * @param contribuicaoId1
	 * @param contribuicaoId2
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	/*
	@Override
	public List<List<DiffResult>> comparaVersoes(long artigoId,
			long contribuicaoId1, long contribuicaoId2) throws PortalException,
			SystemException {

		String left, right;
		if (contribuicaoId1 == 0l) {
			left = ArtigoLocalServiceUtil.getArtigo(artigoId).getTexto();
		} else {
			left = ContribuicaoLocalServiceUtil
					.getContribuicao(contribuicaoId1).getTexto();
		}
		if (contribuicaoId2 == 0l) {
			right = ArtigoLocalServiceUtil.getArtigo(artigoId).getTexto();
		} else {
			right = ContribuicaoLocalServiceUtil.getContribuicao(
					contribuicaoId2).getTexto();
		}
		List<DiffResult>[] results = DiffUtil.diff(new StringReader(left),
				new StringReader(right));
		return Arrays.asList(results);
	}
	*/

	/**
	 * Atualiza um elemento da estrutura
	 */
	public Estrutura atualizaEstrutura(long estruturaId, long groupId,
			long estruturaPaiId, long depoisDeEstruturaId, String texto)
			throws PortalException, SystemException {

		Estrutura estrutura = EstruturaLocalServiceUtil.atualizaEstrutura(
				estruturaId, groupId, estruturaPaiId, depoisDeEstruturaId,
				texto);

		invalidateCache(groupId);

		return estrutura;
	}

	/**
	 * Acrescenta um comentário
	 * 
	 * @param artigoId
	 * @param comentarioPaiId
	 * @param texto
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void postaComentario(long artigoId, long comentarioPaiId,
			String texto) throws PortalException, SystemException {
		User user = getGuestOrUser();
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);
		long userId = user.getUserId();
		String userName = user.getFullName();
		long groupId = artigo.getGroupId();
		String className = Artigo.class.getName();
		long classPK = artigoId;
		long threadId;

		if (comentarioPaiId <= 0l) {
			MBMessageDisplay md = MBMessageLocalServiceUtil
					.getDiscussionMessageDisplay(userId, groupId, className,
							artigoId, WorkflowConstants.STATUS_ANY);
			MBThread thread = md.getThread();
			threadId = thread.getThreadId();
			comentarioPaiId = md.getTreeWalker().getRoot().getMessageId();
		} else {
			MBMessage parent = MBMessageLocalServiceUtil
					.getMessage(comentarioPaiId);
			threadId = parent.getThreadId();
		}
		String subject = Long.toString(classPK);

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		MBMessageLocalServiceUtil.addDiscussionMessage(userId, userName,
				groupId, className, classPK, threadId, comentarioPaiId,
				subject, texto, serviceContext);

		Map<String, ElementoDisplay> dados = obtemDadosCache(groupId);
		if (dados != null) {
			dados.put("a" + artigoId, constroiArtigoDisplay(artigo));
			atualizaCache(groupId, dados);
		}
	}

	/**
	 * Exclui um comentário de uma mensagem
	 * 
	 * @param artigoId
	 * @param messageId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void excluiComentario(long artigoId, long messageId)
			throws PortalException, SystemException {
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);
		String className = Artigo.class.getName();
		String permissionClassName = className;
		long permissionClassPK = artigoId;
		long groupId = artigo.getGroupId();
		MBMessageServiceUtil.deleteDiscussionMessage(groupId, className,
				groupId, permissionClassName, permissionClassPK,
				0l, messageId);
		// deleteDiscussionMessage(groupId, className,
		// artigoId, permissionClassName, permissionClassPK, messageId);

		Map<String, ElementoDisplay> dados = obtemDadosCache(groupId);
		if (dados != null) {
			dados.put("a" + artigoId, constroiArtigoDisplay(artigo));
			atualizaCache(groupId, dados);
		}
	}

	/**
	 * Atualiza um comentário
	 * 
	 * @param body
	 * @param artigoId
	 * @param messageId
	 * @param userId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public MBMessage atualizaComentario(String body, long artigoId,
			long messageId, long userId) throws PortalException,
			SystemException {
		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(artigoId);
		long groupId = artigo.getGroupId();
		String className = Artigo.class.getName();
		long classPK = artigoId;
		String subject = Long.toString(classPK);

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGuestPermissions(true);

		MBMessage mbMessage = MBMessageLocalServiceUtil
				.updateDiscussionMessage(userId, messageId, className, classPK,
						subject, body, serviceContext);
		// updateDiscussionMessage(userId, messageId, subject, body,
		// WorkflowConstants.STATUS_ANY);

		Map<String, ElementoDisplay> dados = obtemDadosCache(groupId);
		if (dados != null) {
			dados.put("a" + artigoId, constroiArtigoDisplay(artigo));
			atualizaCache(groupId, dados);
		}

		return mbMessage;
	}

	public Contribuicao atualizaContribuicao(long contribuicaoId,
			String textoArtigo, String descricao) throws PortalException,
			SystemException {

		Contribuicao contribuicao = ContribuicaoLocalServiceUtil
				.atualizaContribuicao(contribuicaoId, textoArtigo, descricao);

		Artigo artigo = ArtigoLocalServiceUtil.getArtigo(contribuicao
				.getArtigoId());

		Map<String, ElementoDisplay> dados = obtemDadosCache(artigo
				.getGroupId());
		if (dados != null) {
			dados.put("a" + contribuicao.getArtigoId(),
					constroiArtigoDisplay(artigo));
			atualizaCache(artigo.getGroupId(), dados);
		}

		return contribuicao;
	}

	/**
	 * Retorna uma lista de contribuições (wrapper) para exportação 
	 * 
	 */
	public List<ContribuicaoWrapper> exportaContribuicoes(long groupId) throws SystemException{
		
		//TODO Verificar Permissões
				
		String sql = " select SUBSTRING(a.texto , 1, 20) as artigo, c.userName as usuario ,c.texto as sugestao,c.descricao as justificativa ,c.data_ as data from CDWL_Contribuicao c "
				   + " inner join CDWL_artigo a on a.artigoId = c.artigoId "
				   + " where c.artigoId in ( select artigoId from CDWL_artigo where groupId = "+ Long.toString(groupId) +" )";
		Connection conn = null;
		PreparedStatement pstmt = null ;
		
		try {
			
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			BeanListHandler<ContribuicaoWrapper> contribuicaoHandler = new BeanListHandler<ContribuicaoWrapper>(ContribuicaoWrapper.class);
			
			List<ContribuicaoWrapper> retorno = contribuicaoHandler.handle(rs);
			
			return retorno;
			
		} catch (SQLException e) {
			throw new SystemException(e);
		} finally {
			DataAccess.cleanUp(pstmt);
			DataAccess.cleanUp(conn);
		}
		
	}
	
	/**
	 * Retorna uma lista de comentários (wrapper) para exportação 
	 */
	public List<ComentarioWrapper> exportaComentarios(long groupId) throws SystemException{
		
		//TODO Verificar Permissões
	
		String sql = " select SUBSTRING(a.texto, 1, 20) as artigo, m.userName as usuario, m.body as comentario ,m.createDate as dataCriacao"
				   + " from CDWL_Artigo a left join MbMessage m on m.classPK = a.artigoId " 
				   + " where m.classNameId = "+ ClassNameLocalServiceUtil.getClassNameId(Artigo.class) + " "
				   + " and a.groupId = "+ Long.toString(groupId) +" "
				   + " and m.groupId = "+ Long.toString(groupId) +" "
				   + " and m.parentMessageId <> 0 "
				   + " order by createDate ";
		Connection conn = null;
		PreparedStatement pstmt = null ;
		
		try {
			
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			BeanListHandler<ComentarioWrapper> contribuicaoHandler = new BeanListHandler<ComentarioWrapper>(ComentarioWrapper.class);
			
			List<ComentarioWrapper> retorno = contribuicaoHandler.handle(rs);
			
			return retorno;
			
		} catch (SQLException e) {
			throw new SystemException(e);
		} finally {
			DataAccess.cleanUp(pstmt);
			DataAccess.cleanUp(conn);
		}
		
	}
	
}

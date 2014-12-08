package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.gov.camara.edemocracia.portlets.priorizacao.EixoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta;
import br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay;
import br.gov.camara.edemocracia.portlets.priorizacao.PropostaSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.VotoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.VotosUsuario;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;
import br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.VotoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.base.PriorizacaoServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.priorizacao.service.util.PriorizacaoPermissionsUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.NoSuchCategoryException;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryUtil;
import com.liferay.portlet.messageboards.service.persistence.MBThreadUtil;

/**
 * The implementation of the categorizacao remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil}
 * to access the categorizacao remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.PriorizacaoServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil
 */
public class PriorizacaoServiceImpl extends PriorizacaoServiceBaseImpl {

	/**
	 * Obtém um eixo com o identificador informado
	 * 
	 * @param eixoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Eixo getEixo(long eixoId) throws PortalException, SystemException {
		return EixoLocalServiceUtil.getEixo(eixoId);
	}

	/**
	 * Lista todos os eixos da comunidade
	 * 
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public List<Eixo> listarEixos(long groupId) throws SystemException {

		// if (!getPermissionChecker().hasPermission(groupId,
		// "br.gov.camara.edemocracia.portlets.priorizacao.model", primKey,
		// ActionKeys.VIEW))
		// return Collections.emptyList();

		return EixoLocalServiceUtil.listarEixosPorGroupId(groupId);
	}
	
	/**
	 * Lista as propostas e seu estado, de um eixo específico
	 * 
	 * @param eixoId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<PropostaDisplay> listarPropostaDisplay(long eixoId) throws PortalException, SystemException {
		PermissionChecker checker = getPermissionChecker();
		Eixo eixo = EixoLocalServiceUtil.getEixo(eixoId);
		long groupId = eixo.getGroupId();

		// Verifica se pode visualizar votos
		boolean podeVerVotos = PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VIEW_VOTE");
		boolean podeVotar = PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VOTE");

		List<PropostaDisplay> propostas = PropostaLocalServiceUtil.findPropostaDisplayPorUsuarioEixoId(getGuestOrUserId(), eixoId, podeVerVotos, podeVotar);
//		Collections.shuffle(propostas);
/*		Collections.sort(propostas, new Comparator<PropostaDisplay>() {
			@Override
			public int compare(PropostaDisplay o1, PropostaDisplay o2) {
				if (o1.getVotosUsuario() == o2.getVotosUsuario()) {
					return o1.getProposta().getIdentificador().compareToIgnoreCase(o2.getProposta().getIdentificador());
				} else if (o1.getVotosUsuario() > o2.getVotosUsuario())
					return -1;
				else 
					return 1;
			}
		});
		return propostas;
*/
		Collections.sort(propostas, new Comparator<PropostaDisplay>() {
			@Override
			public int compare(PropostaDisplay o1, PropostaDisplay o2) {
				return o1.getProposta().getIdentificador().compareToIgnoreCase(o2.getProposta().getIdentificador());
			}
		});
		return propostas;
	}

	/**
	 * Cria um eixo na posição informada
	 * 
	 * @param groupId
	 * @param categoryId
	 * @param sumario
	 * @param titulo
	 * @param eixoAnteriorId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Eixo addEixo(long groupId, long categoryId, String sumario, String titulo, long eixoAnteriorId) throws PortalException,
			SystemException {
		return EixoLocalServiceUtil.addEixo(groupId, categoryId, sumario, titulo, eixoAnteriorId);
	}

	/**
	 * Atualiza o eixo com o identificador informado
	 * 
	 * @param eixoId
	 * @param sumario
	 * @param titulo
	 * @param eixoAnteriorId
	 * @param categoryId
	 * 
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Eixo updateEixo(long eixoId, String sumario, String titulo, long eixoAnteriorId, long categoryId)
			throws PortalException, SystemException {

		return EixoLocalServiceUtil.updateEixo(eixoId, sumario, titulo, eixoAnteriorId, categoryId);
	}

	/**
	 * Remove o eixo com identificador informado e suas respectivas propostas
	 * 
	 * @param eixoId
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public void deleteEixo(long eixoId) throws PortalException, SystemException {

		EixoLocalServiceUtil.deleteEixo(eixoId);
	}

	/**
	 * Obtém a proposta com identificador informado
	 * 
	 * @param propostaId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Proposta getProposta(long propostaId) throws PortalException, SystemException {
		return PropostaLocalServiceUtil.getProposta(propostaId);

	}

	/**
	 * Lista todas as propostas do eixo especificado
	 * 
	 * @param eixoId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public List<Proposta> listarPropostasPorEixoId(long eixoId) throws SystemException {
		return PropostaLocalServiceUtil.listarPropostasPorEixoId(eixoId);
	}

	/**
	 * Remove a proposta e os votos vinculados a proposta especificada
	 * 
	 * @param propostaId
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public void deleteProposta(long propostaId) throws PortalException, SystemException {
		PropostaLocalServiceUtil.deleteProposta(propostaId);
	}

	/**
	 * Atualiza a proposta especificada
	 * 
	 * @param propostaId
	 * @param eixoId
	 * @param ementa
	 * @param texto
	 * @param threadId
	 * @param identificador
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Proposta updateProposta(long propostaId, long eixoId, String ementa, String texto, long threadId, String identificador)
			throws PortalException, SystemException {
		return PropostaLocalServiceUtil.updateProposta(propostaId, eixoId, ementa, texto, threadId, identificador);
	}

	/**
	 * Cria uma proposta no eixo especificado
	 * 
	 * @param groupId
	 * @param eixoId
	 * @param ementa
	 * @param texto
	 * @param threadId
	 * @param identificador
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public Proposta addProposta(long groupId, long eixoId, String ementa, String texto, long threadId, String identificador)
			throws PortalException, SystemException {
		return PropostaLocalServiceUtil.addProposta(groupId, eixoId, ementa, texto, threadId, identificador);
	}

	/**
	 * Adiciona um voto na proposta especificada
	 * 
	 * @param propostaId
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public void addVoto(long propostaId) throws PortalException, SystemException {
		Proposta proposta = PropostaLocalServiceUtil.getProposta(propostaId);
		long groupId = proposta.getGroupId();
		User user = getGuestOrUser();
		if (user.isDefaultUser())
			return;

		PermissionChecker checker = getPermissionChecker();

		if (!PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VOTE"))
			throw new PrincipalException("Sem permissão para votar");

		VotoLocalServiceUtil.addVoto(propostaId, user.getUserId());
	}
	
	/**
	 * Remove um voto na proposta especificada
	 * 
	 * @param propostaId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteVoto(long propostaId) throws PortalException, SystemException {
		Proposta proposta = PropostaLocalServiceUtil.getProposta(propostaId);
		long groupId = proposta.getGroupId();
		User user = getGuestOrUser();
		if (user.isDefaultUser())
			return;
		PermissionChecker checker = getPermissionChecker();

		if (!PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VOTE"))
			throw new PrincipalException("Sem permissão para votar");
		
		VotoLocalServiceUtil.deleteVoto(propostaId, user.getUserId());
	}

	/**
	 * Obtém a categoria especificada
	 * 
	 * @param categoryId
	 * @return
	 */
	@Override
	public MBCategory getMBCategory(long categoryId) {
		try {
			return MBCategoryUtil.findByPrimaryKey(categoryId);
		} catch (NoSuchCategoryException e) {
			return null;
		} catch (SystemException e) {
			return null;
		}
	}

	/**
	 * Lista as categorias da comunidade
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public List<MBCategory> listarCategorias(long groupId , long parentCategoryId) throws SystemException {
		return MBCategoryUtil.findByG_P(groupId, parentCategoryId);
	}

	/**
	 * Lista os tópicos da categoria especificada
	 * 
	 * @param groupId
	 * @param categoryId
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 */
	@Override
	public List<MBThread> listarTopicosPorCategoryId(long groupId, long categoryId) throws SystemException {
		return MBThreadUtil.findByG_C(groupId, categoryId);
	}

	/**
	 * Lista o sumário da priorização (para gráficos)
	 * 
	 * @param groupId
	 * @param campos
	 *            Ordem dos campos que devem ser ordenados. Se vazio, deixa a
	 *            lista em ordem aleatória
	 * @return
	 * @throws SystemException
	 * @throws PortalException 
	 */
	@Override
	public PriorizacaoSumario getSumarioPriorizacao(long groupId, OrdemProposta[] campos) throws SystemException {

		int totalGlobalVotos = 0;
		List<EixoSumario> eixos = new ArrayList<EixoSumario>();
		List<PropostaSumario> todasPropostas = new ArrayList<PropostaSumario>();
		for (Eixo eixo : EixoLocalServiceUtil.listarEixosPorGroupId(groupId)) {
			EixoSumario eixoSumario = new EixoSumario(eixo.getEixoId(), eixo.getTitulo());
			for (Proposta proposta : PropostaLocalServiceUtil.listarPropostasPorEixoId(eixo.getEixoId())) {
				List<VotoSumario> votos = new ArrayList<VotoSumario>();
				for(Voto voto: VotoLocalServiceUtil.getVotosPorPropostaId(proposta.getPropostaId())){
					
					String userUF = "";
					try {
						List<Address> addresses =  AddressLocalServiceUtil.getAddresses(
						        GroupLocalServiceUtil.getGroup(groupId).getCompanyId(), "com.liferay.portal.model.Contact", UserLocalServiceUtil.getUser(voto.getUserId()).getContactId()) ;
						if(addresses.size() != 0 && addresses != null)
							userUF = addresses.get(0).getRegion().getRegionCode();
					} catch (PortalException e) {
						//Ignore
					}					
					votos.add(new VotoSumario(voto.getData(), voto.getUserName(), userUF, voto.getNumeroVotos()));
					
				}
				int votosProposta = VotoLocalServiceUtil.getVotosByPropostaId(proposta.getPropostaId());
				totalGlobalVotos += votosProposta;
				PropostaSumario propostaSumario = eixoSumario.adicionaProposta(proposta.getPropostaId(),
						proposta.getIdentificador(), proposta.getEmenta(), votosProposta,votos);
				todasPropostas.add(propostaSumario);
			}
			eixos.add(eixoSumario);
		}

		// Ordena a lista de todas as propostas
		ordena(todasPropostas, campos);
		return new PriorizacaoSumario(eixos, todasPropostas, totalGlobalVotos);
	}

	/**
	 * Coloca a lista de propostas de acordo com a lista de campos para ordenar
	 * 
	 * @param propostas
	 * @param campos
	 */
	private void ordena(List<PropostaSumario> propostas, OrdemProposta... campos) {
		if (campos == null || campos.length == 0) {
			Collections.shuffle(propostas);
		} else {
			final List<Comparator<PropostaSumario>> comparadores = new ArrayList<Comparator<PropostaSumario>>();
			for (OrdemProposta ordem : campos) {
				switch (ordem) {
				case EIXO:
					comparadores.add(new Comparator<PropostaSumario>() {
						@Override
						public int compare(PropostaSumario o1, PropostaSumario o2) {
							return o1.getEixo().getNome().compareToIgnoreCase(o2.getEixo().getNome());
						}
					});
					break;
				case IDENTIFICADOR:
					comparadores.add(new Comparator<PropostaSumario>() {
						@Override
						public int compare(PropostaSumario o1, PropostaSumario o2) {
							return o1.getIdentificador().compareToIgnoreCase(o2.getIdentificador());
						}
					});
					break;
				case NOME:
					comparadores.add(new Comparator<PropostaSumario>() {
						@Override
						public int compare(PropostaSumario o1, PropostaSumario o2) {
							return o1.getNome().compareToIgnoreCase(o2.getNome());
						}
					});
					break;
				case VOTOS:
					comparadores.add(new Comparator<PropostaSumario>() {
						@Override
						public int compare(PropostaSumario o1, PropostaSumario o2) {
							if (o1.getNumeroVotos() > o2.getNumeroVotos())
								return -1;
							else if (o1.getNumeroVotos() == o2.getNumeroVotos())
								return 0;
							else
								return 1;
						}
					});
					break;
				}
			}
			if (comparadores.size() > 0) {
				Collections.sort(propostas, new Comparator<PropostaSumario>() {

					@Override
					public int compare(PropostaSumario o1, PropostaSumario o2) {
						for (Comparator<PropostaSumario> comp : comparadores) {
							int result = comp.compare(o1, o2);
							if (result != 0)
								return result;
						}
						return 0;
					}
				});
			}
		}
	}

	/**
	 * Obtém as informações para a votação em uma proposta
	 * 
	 * @param propostaId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public PropostaDisplay getPropostaDisplay(long propostaId) throws SystemException, PortalException {
		Proposta proposta = PropostaLocalServiceUtil.getProposta(propostaId);
		Eixo eixo = EixoLocalServiceUtil.getEixo(proposta.getEixoId());
		long groupId = proposta.getGroupId();
		User user = getGuestOrUser();

		PermissionChecker checker = getPermissionChecker();

		// Verifica se pode visualizar votos
		boolean podeVerVotos = PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VIEW_VOTE");

		int totalVotos;
		if (podeVerVotos)
			totalVotos = VotoLocalServiceUtil.getVotosByPropostaId(propostaId);
		else
			totalVotos = 0;

		boolean podeVotar = PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VOTE");
		boolean podeCancelarVoto = podeVotar;

		int votosUsuarioNaProposta;
		int totalVotosDisponiveis;
		if (user.isDefaultUser()) {
			votosUsuarioNaProposta = 0;
			totalVotosDisponiveis = 0;
		} else {
			Voto voto = VotoLocalServiceUtil.getVotoPorPropostaIdUserId(propostaId, user.getUserId());
			if (voto != null) 
				votosUsuarioNaProposta = voto.getNumeroVotos();
			else
				votosUsuarioNaProposta = 0;
			if (podeVotar) {
				totalVotosDisponiveis = VotoLocalServiceUtil
						.getVotosDisponiveisByUsuarioId(proposta.getGroupId(), user.getUserId());
				if (totalVotosDisponiveis <= 0 || (voto != null && voto.getVotosDisponiveis() <= 0))
					podeVotar = false;
			} else {
				totalVotosDisponiveis = 0;
			}
		}
		if (podeCancelarVoto && votosUsuarioNaProposta == 0)
			podeCancelarVoto = false;

		return new PropostaDisplay(proposta, eixo, totalVotos, votosUsuarioNaProposta, totalVotosDisponiveis, podeVotar, podeCancelarVoto);
	}
	
	/**
	 * Retorna o número de votos que o usuário já deu e a quantidade de votos disponíveis
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public VotosUsuario getVotosUsuario(long groupId) throws SystemException, PortalException {

		long userId = getGuestOrUserId();
		PermissionChecker checker = getPermissionChecker();

		
		if (userId > 0) {
			// Verifica se pode votar
			boolean podeVotar = PriorizacaoPermissionsUtil.hasPermission(checker, groupId, "VOTE");
			if (podeVotar) {
				Configuracao configuracao = ConfiguracaoLocalServiceUtil.getConfiguracaoPorGrupo(groupId);
				int totalVotos = VotoLocalServiceUtil.getVotosByUsuarioId(groupId, userId);
				int votosDisponiveis = 0;
				if (configuracao.isVotacaoAberta()) {
					if (configuracao.isVotacaoAberta())
						votosDisponiveis = VotoLocalServiceUtil.getVotosDisponiveisByUsuarioId(groupId, userId);
				}
				return new VotosUsuario(totalVotos, votosDisponiveis);
			} else {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Retorna a configuração definida para a comunidade especificada
	 * 
	 * @param scopeGroupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Configuracao getConfiguracaoPorGrupo(long scopeGroupId) throws PortalException, SystemException{
		return ConfiguracaoLocalServiceUtil.getConfiguracaoPorGrupo(scopeGroupId);
	}
	
	/**
	 * Atualiza a configuração para a comunidade especificada
	 * 
	 * @param groupId
	 * @param maximoVotos
	 * @param maxVotosProposta
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Configuracao updateConfiguracao(long groupId,int maximoVotos,int maxVotosProposta, boolean votacaoAberta) throws PortalException, SystemException{
		return ConfiguracaoLocalServiceUtil.updateConfiguracao(groupId, maximoVotos, maxVotosProposta, votacaoAberta);
	}
	
	
	/**
	 * Retorna a quantidade de eixos cadastrados para a comunidade especificada
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 */
	public int getEixosCountByGroupId(long groupId) throws SystemException{
		return EixoLocalServiceUtil.getEixosCountByGroupId(groupId);
	}
	
	/**
	 * Retorna a quantidade de propostas cadastrada para o eixo especificado
	 * 
	 * @param eixoId
	 * @return
	 * @throws SystemException
	 */
	public int getPropostasCountByEixoId(long eixoId) throws SystemException{
		return PropostaLocalServiceUtil.getPropostasCountByEixoId(eixoId);
	}
	
	/**
	 * Retorna todos os votos realizados na proposta especificada
	 * propostaId
	 * @param propostaId
	 * @return
	 * @throws SystemException
	 */
	public List<Voto> getVotosPorPropostaId(long propostaId) throws SystemException{
		return VotoLocalServiceUtil.getVotosPorPropostaId(propostaId);
	}
}
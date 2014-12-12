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
package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import java.util.List;

import br.gov.camara.edemocracia.portlets.priorizacao.InvalidIdentificadorException;
import br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException;
import br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.service.base.PropostaLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;

/**
 * The implementation of the proposta local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalServiceUtil}
 * to access the proposta local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.PropostaLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalServiceUtil
 */
public class PropostaLocalServiceImpl extends PropostaLocalServiceBaseImpl {

	/**
	 * Obtém a proposta especificada
	 * 
	 * @param propostaId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Proposta getProposta(long propostaId) throws PortalException,
			SystemException {
		return propostaPersistence.findByPrimaryKey(propostaId);
	}

	/**
	 * Lista todas as propostas vinculadas ao eixo especificado
	 * 
	 * @param eixoId
	 * @return
	 * @throws SystemException
	 */
	public List<Proposta> listarPropostasPorEixoId(long eixoId)
			throws SystemException {
		return propostaPersistence.findByE(eixoId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, new PropostaComparator());
	}

	/**
	 * Cria uma proposta
	 * 
	 * @param groupId
	 * @param eixoId
	 * @param ementa
	 * @param texto
	 * @param threadId
	 * @param identificador
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Transactional(rollbackFor = InvalidIdentificadorException.class)
	public Proposta addProposta(long groupId, long eixoId, String ementa,
			String texto, long threadId, String identificador)
			throws SystemException, PortalException {

		// Valida identificador
		identificador = tratarString(identificador);
		if (identificador.length() == 0)
			throw new InvalidIdentificadorException();
		if (validarIdentificador(identificador, 0, groupId))
			throw new InvalidIdentificadorException("Identificador Inválido");

		ementa = tratarString(ementa);
		texto = tratarString(texto);

		Group group = GroupLocalServiceUtil.getGroup(groupId);
		long companyId = group.getCompanyId();

		Proposta proposta = createProposta(counterLocalService.increment());
		proposta.setGroupId(groupId);
		proposta.setCompanyId(companyId);
		proposta.setEixoId(eixoId);
		proposta.setEmenta(ementa);
		proposta.setTexto(texto);
		proposta.setThreadId(threadId);
		proposta.setIdentificador(identificador);

		return propostaPersistence.update(proposta, true);
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
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Proposta updateProposta(long propostaId, long eixoId, String ementa,
			String texto, long threadId, String identificador)
			throws SystemException, PortalException {

		Proposta proposta = propostaPersistence.findByPrimaryKey(propostaId);

		// Valida identificador
		identificador = tratarString(identificador);
		if (identificador.length() == 0)
			throw new InvalidIdentificadorException();
		if (validarIdentificador(identificador, propostaId,
				proposta.getGroupId()))
			throw new InvalidIdentificadorException();

		ementa = tratarString(ementa);
		texto = tratarString(texto);

		proposta.setTexto(texto);
		proposta.setEmenta(ementa);
		proposta.setEixoId(eixoId);
		proposta.setThreadId(threadId);
		proposta.setIdentificador(identificador);

		return super.updateProposta(proposta, false);
	}

	/**
	 * Deleta a proposta especificada
	 * 
	 * @param propostaId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void excluirProposta(long propostaId) throws PortalException,
			SystemException {

		votoPersistence.removeByP(propostaId);
		super.deleteProposta(propostaId);
	}

	/**
	 * Deleta a proposta especificada
	 */
	public void excluirProposta(Proposta proposta) throws SystemException {
		votoPersistence.removeByP(proposta.getPropostaId());
		super.deleteProposta(proposta);
	}
	
	private String tratarString(String texto) {
		if (texto == null)
			return "";
		else
			return texto.trim();
	}

	/**
	 * Verifica se o identificador já está cadastrado na comunidade
	 * 
	 * @param identificador
	 * @param propostaId
	 * @param groupId
	 * @return
	 * @throws SystemException
	 */
	private boolean validarIdentificador(String identificador, long propostaId,
			long groupId) throws SystemException {

		try {
			Proposta p = propostaPersistence.findByI_G_First(identificador,
					groupId, null);
			if (p == null)
				return false;
			if (propostaId <= 0)
				return true;
			if (p.getPropostaId() == propostaId)
				return false;
			else
				return true;
		} catch (NoSuchPropostaException e) {
			return false;
		}
	}

	/**
	 * Retorna a quantidade de propostas cadastradas para o eixo especificado
	 * 
	 * @param eixoId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int getPropostasCountByEixoId(long eixoId) throws SystemException {
		return propostaPersistence.countByE(eixoId);
	}

	/**
	 * Lista o estado da votação para cada proposta, de acordo com as permissões
	 * do usuário
	 * 
	 * @param userId
	 * @param eixoId
	 * @param podeVerVotos
	 * @param podeVotar
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public List<PropostaDisplay> findPropostaDisplayPorUsuarioEixoId(
			long userId, long eixoId, boolean podeVerVotos, boolean podeVotar)
			throws SystemException, PortalException {

		Eixo eixo = eixoLocalService.getEixo(eixoId);
		int votosDisponiveis;
		
		// Verifica se o usuário pode votar
		if (userId < 0)
			podeVotar = false;
		if (podeVotar) {
			votosDisponiveis = votoLocalService.getVotosDisponiveisByUsuarioId(
					eixo.getGroupId(), userId);
			if (votosDisponiveis <= 0) {
				votosDisponiveis = 0;
			}
		} else {
			votosDisponiveis = 0;
		}
		
		return propostaFinder.findPropostaDisplayByUserEixo(userId, eixoId, votosDisponiveis, podeVerVotos, podeVotar);

	}
}

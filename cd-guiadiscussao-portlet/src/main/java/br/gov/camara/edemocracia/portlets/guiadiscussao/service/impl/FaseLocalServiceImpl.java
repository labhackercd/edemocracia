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
package br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl;

import java.util.List;

import br.gov.camara.edemocracia.portlets.guiadiscussao.CantFaseMoveDownException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.CantFaseMoveUpException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.FaseLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence.FasePersistence;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the fase local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Robson
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.FaseLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil
 */
public class FaseLocalServiceImpl extends FaseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.gov.camara.edemocracia
	 * .portlets.guiadiscussao.service.FaseLocalServiceUtil} to access the fase
	 * local service.
	 */
	public Fase criaFase(Fase fase) throws PortalException, SystemException {

		FasePersistence fasePersistence = getFasePersistence();
		Fase novaFase = fasePersistence.create(getCounterLocalService()
				.increment(Fase.class.getName()));
		novaFase.setTitulo(fase.getTitulo());
		novaFase.setConfiguracaoId(fase.getConfiguracaoId());
		int totalDeFases = fasePersistence.countByConfiguracaoId(fase
				.getConfiguracaoId());
		novaFase.setOrdem(totalDeFases + 1);

		if (totalDeFases == 0) {
			Configuracao config;
			config = configuracaoLocalService.getConfiguracao(fase
					.getConfiguracaoId());
			config.setFaseAtualId(novaFase.getFaseId());
			configuracaoLocalService.updateConfiguracao(config, false);
		}

		return fasePersistence.update(novaFase, false);
	}

	public List<Fase> getFasesByConfiguracaoId(long configuracaoId)
			throws SystemException {
		return getFasePersistence().findByConfiguracaoId(configuracaoId);
	}

	public void excluirFase(long faseId) throws PortalException,
			SystemException {
		//fase que será excluída
		Fase fase = getFase(faseId);
		
		List<Fase> fasesDaComunidade = getFasePersistence()
				.findByConfiguracaoId(fase.getConfiguracaoId());


		// Removendo ações cadastradas para esta fase
		List<Acao> acoesCadastradas = AcaoLocalServiceUtil
				.getAcoesByFaseId(fase.getFaseId());
		for (Acao acao : acoesCadastradas) {
			AcaoLocalServiceUtil.excluirAcao(acao.getAcaoId());
		}

		if (fasesDaComunidade.size() != 1) {

			// Atualização de próxima fase atual
			long faseAtualId = configuracaoLocalService.getConfiguracao(
					fase.getConfiguracaoId()).getFaseAtualId();
			if(fase.getFaseId() == faseAtualId) {
				
				Fase fasePosterior = null;
				Fase faseAnterior = null;
				for (Fase outraFase : fasesDaComunidade) {
					// Guardando a fase anterior a fase que será excluida
					if (outraFase.getOrdem() == fase.getOrdem() - 1) {
						faseAnterior = outraFase;
					}
	
					// Guardando a fase posterior a fase que será excluida
					if (outraFase.getOrdem() == fase.getOrdem() + 1) {
						fasePosterior = outraFase;
					}
				}
				
				// Marcando próxima fase atual
				if (fasePosterior != null || faseAnterior != null) {
					Fase faseAtual = null;
					if (fasePosterior != null) {
						faseAtual = fasePosterior;
					} else {
						faseAtual = faseAnterior;
					}
					Configuracao configuracao = configuracaoLocalService
							.getConfiguracao(fase.getConfiguracaoId());
					configuracao.setFaseAtualId(faseAtual.getFaseId());
					configuracaoLocalService
							.updateConfiguracao(configuracao, false);
				}
			}
			
			// Atualiza a ordem das demais fases
			for (Fase outraFase : fasesDaComunidade) {
				if (outraFase.getOrdem() > fase.getOrdem()) {
					outraFase.setOrdem(outraFase.getOrdem() - 1);
					fasePersistence.update(outraFase, false);
				}
			}
		}

		deleteFase(fase);
	}

	public void moverFaseParaCima(long faseId) throws PortalException,
			SystemException, CantFaseMoveUpException {

		Fase fase = getFase(faseId);

		if (fase != null) {
			if (fase.getOrdem() == 1) {
				throw new CantFaseMoveUpException();
			}
		}

		// Atualiza a ordem das demais fases
		List<Fase> fasesDaComunidade = getFasePersistence()
				.findByConfiguracaoId(fase.getConfiguracaoId());

		for (Fase outraFase : fasesDaComunidade) {
			if (outraFase.getOrdem() == fase.getOrdem() - 1) {
				outraFase.setOrdem(outraFase.getOrdem() + 1);
				fasePersistence.update(outraFase, false);
			}
		}
		fase.setOrdem(fase.getOrdem() - 1);
		fasePersistence.update(fase, false);
	}

	public void moverFaseParaBaixo(long faseId) throws PortalException,
			SystemException, CantFaseMoveDownException {

		Fase fase = getFase(faseId);

		if (fase != null) {
			int totalDeFases = fasePersistence.countByConfiguracaoId(fase
					.getConfiguracaoId());
			if (fase.getOrdem() == totalDeFases) {
				throw new CantFaseMoveDownException();
			}
		}

		// Atualiza a ordem das demais fases
		List<Fase> fasesDaComunidade = getFasePersistence()
				.findByConfiguracaoId(fase.getConfiguracaoId());

		for (Fase outraFase : fasesDaComunidade) {
			if (outraFase.getOrdem() == fase.getOrdem() + 1) {
				outraFase.setOrdem(outraFase.getOrdem() - 1);
				fasePersistence.update(outraFase, false);
			}
		}
		fase.setOrdem(fase.getOrdem() + 1);
		fasePersistence.update(fase, false);
	}

}

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
package br.gov.camara.edemocracia.portlets.participacao.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO;
import br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;

@ManagedBean(name = "dadosParticipacao")
@RequestScoped
public class DadosParticipacaoBean {

	private List<Group> comunidadesDisponiveis;
	private List<Long> comunidadesSelecionadas;
	private List<DadosComunidadeDTO> dadosComunidade;

	@ManagedProperty(value = "#{relatorio}")
	private RelatorioParticipacaoBean relatorioBean;
	private static final Log LOG = LogFactoryUtil
			.getLog(DadosParticipacaoBean.class);

	@PostConstruct
	private void init() {
		this.comunidadesSelecionadas = new ArrayList<Long>();

		try {
			this.comunidadesDisponiveis = ParticipacaoLocalServiceUtil
					.getComunidadesDisponiveis(LiferayFacesContext
							.getInstance().getCompanyId());

		} catch (SystemException e) {
			LOG.error("Erro ao recuperar comunidades disponíveis.", e);
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Erro ao recuperar comunidades disponíveis.");
		}
	}

	/**
	 * Obtém os dados de participação da(s) comunidade(s) selecionadas(s)
	 */
	public void obterDados() {
		try {

			if (relatorioBean.isPeriodoEnabled()) {
				dadosComunidade = ParticipacaoLocalServiceUtil
						.getDadosComunidade(comunidadesSelecionadas,
								relatorioBean.getDataInicio(),
								relatorioBean.getDataFim());
				insereDadosNaSessao(
						relatorioBean.getKeyComunidadesSelecionadas(),
						comunidadesSelecionadas, relatorioBean.getDataInicio(),
						relatorioBean.getDataFim());

			} else {
				dadosComunidade = ParticipacaoLocalServiceUtil
						.getDadosComunidade(comunidadesSelecionadas);
				insereDadosNaSessao(
						relatorioBean.getKeyComunidadesSelecionadas(),
						comunidadesSelecionadas, null, null);
			}

		} catch (PortalException e) {
			LOG.error("Erro ao obter dados.", e);
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Erro ao obter dados.");
		} catch (SystemException e) {
			LOG.error("Erro ao obter dados.", e);
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Erro ao obter dados.");
		}
	}

	/**
	 * Insere os groupIds das comunidades selecionadas na sessão do usuário *
	 * 
	 * @param keyComunidadesSelecionadas
	 *            chave que identifica as comunidades selecionadas pelo usuário
	 * @param groupIds
	 *            groupIds das comunidades selecionadas
	 * @param dataInicio
	 * @param dataFim
	 */
	private void insereDadosNaSessao(String keyComunidadesSelecionadas,
			List<Long> groupIds, Date dataInicio, Date dataFim) {
		LiferayFacesContext.getInstance().setSessionAttribute(
				relatorioBean.getKeyComunidadesSelecionadas(), groupIds);
		LiferayFacesContext.getInstance().setSessionAttribute("dataInicio",
				dataInicio);
		LiferayFacesContext.getInstance().setSessionAttribute("dataFim",
				dataFim);
	}

	public RelatorioParticipacaoBean getRelatorioBean() {
		return relatorioBean;
	}

	public void setRelatorioBean(RelatorioParticipacaoBean relatorioBean) {
		this.relatorioBean = relatorioBean;
	}

	public List<DadosComunidadeDTO> getDadosComunidade() {
		return dadosComunidade;
	}

	public void setDadosComunidade(List<DadosComunidadeDTO> dadosComunidade) {
		this.dadosComunidade = dadosComunidade;
	}

	public List<Group> getComunidadesDisponiveis() {
		return comunidadesDisponiveis;
	}

	public List<Long> getComunidadesSelecionadas() {
		return comunidadesSelecionadas;
	}

	public void setComunidadesSelecionadas(List<Long> comunidadesSelecionadas) {
		this.comunidadesSelecionadas = comunidadesSelecionadas;
	}

}

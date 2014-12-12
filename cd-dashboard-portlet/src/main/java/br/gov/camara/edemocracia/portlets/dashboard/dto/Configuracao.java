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
package br.gov.camara.edemocracia.portlets.dashboard.dto;

import java.io.Serializable;

import org.joda.time.DateTime;

import br.gov.camara.edemocracia.portlets.dashboard.Recurso;
import br.gov.camara.edemocracia.portlets.dashboard.VisualizacaoDados;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;

public class Configuracao implements Serializable {

	private static final long serialVersionUID = 4249879871902474946L;

	public static final int QUANTIDADE_DE_RECURSOS_PADRAO = 5;
	public static final long GROUPID_COMUNIDADE_PADRAO = 0l;
	public static final int PERIODO_PADRAO = 1;
	
	public static final int TODAS_COMUNIDADES = 0;
	public static final int SOMENTE_COMUNIDADES_PUBLICAS = -1;
	public static final int SOMENTE_COMUNIDADES_PRIVADAS = -2;
	public static final int SOMENTE_COMUNIDADES_RESTRITAS = -3;

	private long comunidadeSelecionada;
	private int periodoEmDias;
	private int qtdDeRecursos;
	private int modoVisualizacao;
	private int recurso;

	public Configuracao(Long comunidadeSelecionada, int periodoEmDias, int qtdDeRecursos, int modoVisualizacao, int recurso) {
		this.comunidadeSelecionada = comunidadeSelecionada;
		this.periodoEmDias = periodoEmDias;
		this.qtdDeRecursos = qtdDeRecursos;
		this.modoVisualizacao = modoVisualizacao;
		this.recurso = recurso;

	}

	public Long getComunidadeSelecionada() {
		return comunidadeSelecionada;
	}

	public void setComunidadeSelecionada(Long comunidadeSelecionada) {
		this.comunidadeSelecionada = comunidadeSelecionada;
	}

	public int getPeriodoEmDias() {
		return periodoEmDias;
	}

	public void setPeriodoEmDias(int periodoEmDias) {
		this.periodoEmDias = periodoEmDias;
	}

	public int getQtdDeRecursos() {
		return qtdDeRecursos;
	}
	
	public void setQtdDeRecursos(int qtdDeRecursos) {
		this.qtdDeRecursos = qtdDeRecursos;
	}

	public int getModoVisualizacao() {
		return modoVisualizacao;
	}

	public void setModoVisualizacao(int modoVisualizacao) {
		this.modoVisualizacao = modoVisualizacao;
	}

	public int getRecurso() {
		return recurso;
	}

	public void setRecurso(int recurso) {
		this.recurso = recurso;
	}

	public String convertToJSON() {
		JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
		jsonSerializer.exclude("class");
		return jsonSerializer.serialize(this);
	}

	public static Configuracao createFromJSON(String json) throws JSONException {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(json);

		long comunidadeSelecionada = jsonObj.getLong("comunidadeSelecionada");
		int periodoEmDias = jsonObj.getInt("periodoEmDias");
		int qtdDeRecursos = jsonObj.getInt("qtdDeRecursos");
		int modoVisualizacao = jsonObj.getInt("modoVisualizacao");
		int recurso = jsonObj.getInt("recurso");

		return new Configuracao(comunidadeSelecionada, periodoEmDias, qtdDeRecursos, modoVisualizacao, recurso);
	}
	
	/**
	 * Uma nova instância de Configuracao com os valores padrão
	 * @return  
	 */
	public static Configuracao getConfiguracaoPadrao() {
		return new Configuracao(GROUPID_COMUNIDADE_PADRAO, PERIODO_PADRAO, QUANTIDADE_DE_RECURSOS_PADRAO, VisualizacaoDados.Tabela.getValue(),
				Recurso.TOPICO.getId());
	}

	public long getDataInicioPeriodoEmMillis() {
		DateTime dataInicio = new DateTime();
		DateTime temp = dataInicio.minusDays(periodoEmDias).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
		return temp.getMillis();
	}

	public long getDataFimPeriodoEmMillis() {
		DateTime dataFim = new DateTime();
		DateTime temp = dataFim.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(0);
		return temp.getMillis();
	}

}

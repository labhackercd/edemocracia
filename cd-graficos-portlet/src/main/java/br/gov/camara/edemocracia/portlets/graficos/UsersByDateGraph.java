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
package br.gov.camara.edemocracia.portlets.graficos;

import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil;

public final class UsersByDateGraph extends EDemocraciaGraphByDate {

	/**
	 * @param companyId
	 * @param tz
	 * @param inicio
	 * @param fim
	 */
	public UsersByDateGraph(long companyId, TimeZone tz, Date inicio, Date fim) {
		super(companyId, tz, inicio, fim);
	}

	/**
	 * @see br.gov.camara.edemocracia.portlets.graficos.EDemocraciaGraph#obtemRelatorio()
	 */
	@Override
	protected Map<String, Integer> obtemRelatorio() {
		return GraficosLocalServiceUtil.getUsuariosPorData(getCompanyId(), getTz(), getInicio(), getFim());
	}

	@Override
	protected String getTitle() {
		return "Usuários por Data";
	}

}

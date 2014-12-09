package br.gov.camara.edemocracia.portlets.graficos;

import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil;


public class UsageGraph extends EDemocraciaGraphByDate {
	
	public UsageGraph(long companyId, TimeZone tz, Date inicio, Date fim) {
		super(companyId, tz, inicio, fim);
	}


	/**
	 * @see br.gov.camara.edemocracia.portlets.graficos.EDemocraciaGraph#obtemRelatorio()
	 */
	@Override
	protected Map<String, Integer> obtemRelatorio() {
		return GraficosLocalServiceUtil.getAtividadePorData(getCompanyId(), getTz(), getInicio(), getFim());
	}


	@Override
	protected String getTitle() {
		return "Uso do e-Democracia";
	}
}

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

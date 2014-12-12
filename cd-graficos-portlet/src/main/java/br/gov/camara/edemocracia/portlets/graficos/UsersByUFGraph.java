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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;

import de.toolforge.googlechartwrapper.BarChart;
import de.toolforge.googlechartwrapper.BarChart.BarChartOrientation;
import de.toolforge.googlechartwrapper.BarChart.BarChartStyle;
import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.data.BarChartDataSerie.BarChartDataSerieBuilder;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.label.AxisLabel;
import de.toolforge.googlechartwrapper.label.AxisLabelContainer;
import de.toolforge.googlechartwrapper.label.AxisRange;
import de.toolforge.googlechartwrapper.label.AxisType;
import de.toolforge.googlechartwrapper.label.ChartTitle;
import de.toolforge.googlechartwrapper.style.BarWidthAndSpacing;

public class UsersByUFGraph extends EDemocraciaGraph {
	
	/**
	 * @param companyId
	 */
	public UsersByUFGraph(long companyId) {
		super(companyId);
	}

	private BarChart getBarChart() {
		
		Country br;
		Map<String, Integer> usersPerUF;
		try {
			br = CountryServiceUtil.getCountryByA2("BR");
			usersPerUF = GraficosLocalServiceUtil.getUsuariosPorUf(getCompanyId(), br);
		} catch (PortalException e) {
			usersPerUF = Collections.emptyMap();
		} catch (SystemException e) {
			usersPerUF = Collections.emptyMap();
		}
		
		List<Integer> data = new ArrayList<Integer>();

		AxisLabelContainer x = new AxisLabelContainer(AxisType.XAxis);
		AxisLabelContainer y = new AxisLabelContainer(AxisType.YAxis);
		// x.setUseLabelPositions(true);
		x.setUseLabels(true);

		int ndAmount = 0;
		
		if(usersPerUF.containsKey("N/D")) {
			ndAmount = usersPerUF.get("N/D");
			usersPerUF.remove("N/D");
		}
		int maxAmount = ndAmount;
		
		List<String> uflist = new ArrayList<String>(usersPerUF.keySet());
		Collections.sort(uflist);
		if(ndAmount > 0) {
			uflist.add("N/D");
			usersPerUF.put("N/D", ndAmount);
		}

		for (String uf : uflist) {
			x.addLabel(new AxisLabel(uf));
			int users = usersPerUF.get(uf);
			if (users > maxAmount)
				maxAmount = users;
			data.add(usersPerUF.get(uf));
		}

		x.setAxisRange(new AxisRange(0, uflist.size()));
		y.setAxisRange(new AxisRange(0, maxAmount));

		BarChart bc = new BarChart(new Dimension(690, 340),
				BarChartOrientation.Horizontal, BarChartStyle.Grouped);
		bc.setBarWidthAndSpacing(BarWidthAndSpacing.newAutomaticallyResize());
		BarChartDataSerieBuilder bcBuilder = new BarChartDataSerieBuilder(data);
		bc.addBarChartDataSerie(bcBuilder.build());
		bc.addDataScalingSet(new DataScalingSet(0, maxAmount));
		bc.setChartTitle(new ChartTitle(getTitle()));
		bc.addAxisLabelContainer(x);
		bc.addAxisLabelContainer(y);

		return bc;

		
	}
	
	
	@Override
	public String getURL() {
		return getBarChart().getUrl();

	}
	
	@Override
	public String getPostRequest() {
		return getBarChart().getPostRequest();
	}

	@Override
	protected String getTitle() {
		return "Usuários por UF";
	}
}

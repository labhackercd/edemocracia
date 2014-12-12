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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.liferay.portal.kernel.util.CalendarUtil;

import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.LineChart;
import de.toolforge.googlechartwrapper.data.DataScalingSet;
import de.toolforge.googlechartwrapper.data.LineChartData;
import de.toolforge.googlechartwrapper.data.LineChartData.LineChartDataBuilder;
import de.toolforge.googlechartwrapper.label.AxisLabel;
import de.toolforge.googlechartwrapper.label.AxisLabelContainer;
import de.toolforge.googlechartwrapper.label.AxisRange;
import de.toolforge.googlechartwrapper.label.AxisType;
import de.toolforge.googlechartwrapper.label.ChartTitle;

/**
 * @author robson
 *
 */
public abstract class EDemocraciaGraphByDate extends EDemocraciaGraph {
	
	private final Date inicio;
	private final Date fim;
	private final TimeZone tz;
	
	public EDemocraciaGraphByDate(long companyId, TimeZone tz, Date inicio,
			Date fim) {
		super(companyId);

		this.tz = tz;
		
		Calendar cal = Calendar.getInstance(tz);
		cal.setTime(inicio);
		this.inicio = CalendarUtil.getGTDate(cal);
		cal.setTime(fim);
		this.fim = CalendarUtil.getLTDate(cal);
	}

	/**
	 * @return the inicio
	 */
	protected Date getInicio() {
		return inicio;
	}
	/**
	 * @return the fim
	 */
	protected Date getFim() {
		return fim;
	}
	/**
	 * @return the tz
	 */
	protected TimeZone getTz() {
		return tz;
	}
	
	protected abstract Map<String, Integer> obtemRelatorio();

	private LineChart getLineChart() {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Map<String, Integer> rep = obtemRelatorio();
	
		List<Float> data = new ArrayList<Float>();
		int maxAmount = 0;
		int dateRangeCount = 0;
	
		AxisLabelContainer x = new AxisLabelContainer(AxisType.XAxis);
		AxisLabelContainer y = new AxisLabelContainer(AxisType.YAxis);
		x.setUseLabelPositions(true);
		x.setUseLabels(true);
		String monthLabel = "";
	
		DateFormat monthDf = new SimpleDateFormat("MMM/yyyy");
		monthDf.setTimeZone(tz);
	
		for (Date d : new DateIterator(inicio, fim)) {
	
			String currentMonth = monthDf.format(d);
	
			if (!monthLabel.equals(currentMonth)) {
				monthLabel = currentMonth;
				AxisLabel l = new AxisLabel(currentMonth);
				l.setPos(dateRangeCount);
				x.addLabel(l);
			}
	
			int amount = 0;
			String key = df.format(d);
			if (rep.containsKey(key)) {
				amount = rep.get(key);
			}
			if (amount > maxAmount) {
				maxAmount = amount;
			}
			data.add((float) amount);
			dateRangeCount++;
		}
	
		x.setAxisRange(new AxisRange(0, dateRangeCount));
		y.setAxisRange(new AxisRange(0, maxAmount));
	
		LineChart lc = new LineChart(new Dimension(690, 340));
		LineChartDataBuilder builder = new LineChartDataBuilder(data);
		LineChartData lcData = builder.build();
		lc.addLineChartData(lcData);
		lc.addDataScalingSet(new DataScalingSet(0, maxAmount));
		lc.setChartTitle(new ChartTitle(getTitle()));
		lc.addAxisLabelContainer(x);
		lc.addAxisLabelContainer(y);
		
		return lc;
	}
	
	
	public String getURL() {
		return getLineChart().getUrl();
	
	}
	
	public String getPostRequest() {
		return getLineChart().getPostRequest();
	}
}

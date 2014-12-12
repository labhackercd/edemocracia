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

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UsuariosData
 */
public class Graficos extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(Graficos.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		PortletPreferences pp = renderRequest.getPreferences();
		Integer tipoGrafico = Integer.parseInt(pp.getValue("tipoGrafico", "1"));
		EDemocraciaGraph report;
		
		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(td.getTimeZone());

		// Pega a data inicial e final
		Date end = CalendarUtil.getLTDate(Calendar.getInstance(td.getTimeZone()));
		Calendar cal = Calendar.getInstance(td.getTimeZone());
		cal.setTime(end);
		cal.add(Calendar.MONTH, -1);
		Date start = CalendarUtil.getGTDate(cal);
		
		String paramStart = ParamUtil.getString(renderRequest, "start");
		String paramEnd = ParamUtil.getString(renderRequest, "end");
		
		Date pStart, pEnd;
		try {
			pStart = df.parse(paramStart);
			pEnd = df.parse(paramEnd);
		} catch (ParseException e) {
			pStart = start;
			pEnd = end;
		}
		
		// Verifica se o há mais que um mês entre data inicial e final
		cal.setTime(pEnd);
		cal.add(Calendar.MONTH, -1);
		
		if(pStart.before(cal.getTime())) {
			pStart = cal.getTime();
		}
		
		boolean showTimeRange = true;
		
		switch(tipoGrafico) {
			
			case 2:
				showTimeRange = false;
				report = new UsersByUFGraph(td.getCompanyId());
				break;
			case 3:
				report = new UsageGraph(td.getCompanyId(), td.getTimeZone(), pStart, pEnd);
				break;
			default: // case 1 
				report = new UsersByDateGraph(td.getCompanyId(), td.getTimeZone(), pStart, pEnd);
				break;
		}
		
		renderRequest.setAttribute("start", df.format(pStart));
		renderRequest.setAttribute("end", df.format(pEnd));
		renderRequest.setAttribute("url", report.getURL());
		renderRequest.setAttribute("showTimeRange", showTimeRange);
	
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException ,PortletException {
		
		PortletPreferences pp = renderRequest.getPreferences();
		Integer tipoGrafico = Integer.parseInt(pp.getValue("tipoGrafico", "1"));
		renderRequest.setAttribute("tipoGrafico", tipoGrafico);
		
		super.doEdit(renderRequest, renderResponse);
	};
	
	public void updateDateRange(ActionRequest request, ActionResponse response) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		
		String strStart = ParamUtil.getString(request, "start", df.format(today));
		String strEnd = ParamUtil.getString(request, "end", df.format(today));
		
		response.setRenderParameter("start", strStart);
		response.setRenderParameter("end", strEnd);
		
	}
	
	public void updateGraphType(ActionRequest request, ActionResponse response) {
		
		PortletPreferences pp = request.getPreferences();
		Integer tipoGrafico = ParamUtil.getInteger(request, "tipografico",1);
		
		try {
			pp.setValue("tipoGrafico", Integer.toString(tipoGrafico));
			pp.store();
			response.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException e) {
			_log.error(e);
		} catch (ValidatorException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		} catch (PortletModeException e) {
			_log.error(e);
		}
	}
}

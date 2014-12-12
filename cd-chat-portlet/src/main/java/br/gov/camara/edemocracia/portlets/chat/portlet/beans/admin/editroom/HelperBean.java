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
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;

import com.liferay.faces.portal.context.LiferayFacesContext;

/**
 * @author p_7339
 * 
 */
@ManagedBean(name = "helperBean")
@ApplicationScoped
public class HelperBean {

	private final List<Integer> hours;

	private final List<Integer> minutes;

	private final List<RoomOpenPolicy> openPolicies;

	public HelperBean() {
		hours = new ArrayList<Integer>();
		for (int i = 0; i < 24; i++)
			hours.add(i);
		minutes = new ArrayList<Integer>();
		for (int i = 0; i < 60; i += 5)
			minutes.add(i);
		openPolicies = Collections.unmodifiableList(Arrays.asList(RoomOpenPolicy.values()));
	}

	public List<Integer> getHours() {
		return Collections.unmodifiableList(hours);
	}

	public List<Integer> getMinutes() {
		return Collections.unmodifiableList(minutes);
	}

	/**
	 * Políticas de abertura de sala
	 * 
	 * @return
	 */
	public List<RoomOpenPolicy> getOpenPolicies() {
		return openPolicies;
	}

	/**
	 * Obtém a timezone do usuário
	 * 
	 * @return
	 */
	public String getTimezone() {
		return LiferayFacesContext.getInstance().getThemeDisplay().getTimeZone().getID();
	}

	/**
	 * Obtém o padrão de data
	 * 
	 * @return
	 */
	public String getDatePattern() {
		Locale locale = LiferayFacesContext.getInstance().getThemeDisplay().getLocale();
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		return ((SimpleDateFormat) formatter).toPattern();
	}

	public ChatVideoType[] getVideoTypes() {
		return ChatVideoType.values();
	}

}

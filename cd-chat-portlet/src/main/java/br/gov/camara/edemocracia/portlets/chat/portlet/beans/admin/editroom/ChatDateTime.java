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

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;

/**
 * @author p_7339
 * 
 */
public class ChatDateTime implements Serializable {

	private Date date;

	private int hour;

	private int minute;

	private DateTimeZone tz;

	public ChatDateTime(DateTime dt) {
		hour = dt.getHourOfDay();
		minute = dt.getMinuteOfHour() / 5 * 5; // Arredondamento
		tz = dt.getZone();

		DateMidnight midnight = new DateMidnight(dt.getMillis(), tz);
		date = midnight.toDate();
	}

	/**
	 * Obtem o novo valor
	 * 
	 * @return
	 */
	public DateTime getDateTime() {
		MutableDateTime dt = new MutableDateTime(date.getTime(), tz);
		dt.setHourOfDay(hour);
		dt.setMinuteOfHour(minute / 5 * 5);
		dt.setSecondOfMinute(0);
		dt.setMillisOfSecond(0);

		return dt.toDateTime();
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}
}

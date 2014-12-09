/**
 * 
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

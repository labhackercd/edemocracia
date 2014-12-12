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

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * TODO Converter para Joda-Time
 * @author p_882148
 *
 */
public class DateIterator implements Iterable<Date> {
	
	private final Calendar start = Calendar.getInstance();
	private final Calendar end = Calendar.getInstance();
	
	DateIterator(Date start,Date end) {
		this.start.setTime(start);
		this.start.add(Calendar.DATE, -1);
		this.end.setTime(end);
		this.end.add(Calendar.DATE, -1);
	
	}

	@Override
	public Iterator<Date> iterator() {
		return new Iterator<Date>() {
			private Calendar current = start;

			@Override
			public boolean hasNext() {
				
				return !current.after(end);
			}

			@Override
			public Date next() {
				current.add(Calendar.DATE,1);
				return current.getTime();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("range is static");
				
			}
			
		}; 
	}

}

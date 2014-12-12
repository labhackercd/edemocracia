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
package br.gov.camara.edemocracia.util;

import junit.framework.Assert;

import org.junit.Test;

public class HtmlStripperTest {

	@Test
	public void tagScriptDeveSerRemovidaPorDefault() {
		HtmlStripper hs = new HtmlStripper();
		Assert.assertTrue(isEmpty(hs.strip("<script></script>")));
	}
	
	@Test
	public void tagPDeveSerPermitidaPorDefault() {
		Assert.assertEquals("<p>teste</p>", new HtmlStripper().strip("<p>teste</p>"));
	}
	
	@Test
	public void adicionarTagPermitidaAposConstrucaoDeveFuncionar() {
		HtmlStripper hs = new HtmlStripper();
		hs.clearAllowedTags();
		Assert.assertTrue(isEmpty(hs.strip("<div></div>")));
		
		hs.addAllowedTag("div");
		Assert.assertEquals("<div></div>", "<div></div>");
	}
	
	@Test
	public void stripNullDeveRetornarStringVazia() {
		Assert.assertEquals("", new HtmlStripper().strip(null));
	}
	
	private static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}
}

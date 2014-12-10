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

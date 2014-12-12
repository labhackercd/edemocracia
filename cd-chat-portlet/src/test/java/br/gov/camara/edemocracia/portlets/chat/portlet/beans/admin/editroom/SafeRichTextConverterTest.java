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

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import br.gov.camara.edemocracia.portlets.chat.portlet.beans.components.SafeRichTextConverter;

import com.liferay.portal.kernel.util.StringUtil;

public class SafeRichTextConverterTest {
	
	private SafeRichTextConverter converter = new SafeRichTextConverter();
	
	@Test
	public void nullOuBrancoNaoDevemSerModificados() {
		assertEquals("",  limpar(""));
		assertEquals(" ", limpar(" "));
		assertNull(limpar(null));
	}

	@Test
	public void linkComUrlHttpDevePassar() {
		assertTextoLimpoNaoFoiModificado("<a href=\"http://www.google.com\">link normal</a>");
	}
	
	@Test
	public void linkComUrlHttpsDevePassar() {
		assertTextoLimpoNaoFoiModificado("<a href=\"https://www.google.com\">link https</a>");
	}
	
	@Test
	public void textoSemTagsNaoDeveSerModificado() {
		assertTextoLimpoNaoFoiModificado("abc blah blah blah");
	}
	
	@Test
	public void tagBrDeveSerPermitida() {
		assertTextoLimpoNaoFoiModificado("<br />teste");
	}
	
	@Test
	public void tagImgDeveSerRemovida() {
		String limpo = limpar("<img src=\"http://www.google.com/teste.gif\">");
		assertTrue(StringUtils.isBlank(limpo));
	}
	
	@Test
	public void tagScriptDeveSerRemovida() {
		String textoLimpo = limpar("<script type=\"text/javascript\">document.cookie</script>");
		assertTrue(StringUtils.isBlank(textoLimpo));
	}

	@Test
	public void tagInputDeveSerRemovida() {
		assertTrue(StringUtils.isBlank(limpar("<input type=\"text\">")));
	}
	
	@Test
	public void tagSpanDeveSerPermitida() {
		assertTextoLimpoNaoFoiModificado("<span style=\"font-size:11pt\">alo</span>");
	}
	
	@Test
	public void tagDivComAtributoStyleDeveSerPermitida() {
		assertTextoLimpoNaoFoiModificado("<div style=\"font-size:11.5pt\">alo</div>");
	}
	
	@Test
	public void tagFontDeveSerPermitida() {
		assertTextoLimpoNaoFoiModificado("<font face=\"Tahoma\" size=\"20\" id=\"teste\">teste</font>");
		assertTrue(limpar("<div><font face=\"Tahoma\" size=\"2\">teste</font></div>").contains("<div><font"));
	}
	
	@Test
	public void tagEmDeveSerPermitida() {
		assertTextoLimpoNaoFoiModificado("<em>teste</em>");
	}
	
	@Test
	public void tagsBoldItalicStrongDevemSerPermitidas() {
		assertTextoLimpoNaoFoiModificado("<span style=\"font-weigth:bold;\"><i><b>teste</b></i></span>");
		assertTextoLimpoNaoFoiModificado("<strong>teste</strong>");
	}
	
	@Test
	public void divComHandlerJavascriptDeveFicarSemHandler() {
		assertFalse(limpar("<div onmouseover=\"alert('a')\">teste</div>").contains("onmouseover"));
		assertFalse(limpar("<div onclick=\"alert('a')\">teste</div>").contains("onclick"));
	}
	
	@Test
	public void getAsStringNaoDeveModificarParametro() {
		String antes = "<a href=\"#\">link</>";
		String depois = converter.getAsString(null, null, antes);
		assertEquals(antes, depois);
	}
	
	@Test
	public void javascriptDentroDoHrefDeveSerRemovido() {
		assertFalse(limpar("<a href=\"alert('a')\">link</a>").contains("alert('a')"));
		assertFalse(limpar("clique aqui <a href=\"javascript:alert('a')\">link</a>").contains("alert('a')"));
	}
	
	@Test
	public void onClickDentroDeLinkDeveSerRemovido() {
		assertFalse(limpar("<a href=\"#\" onclick=\"javascript:alert('a')\">teste</a>").contains("onclick"));
	}
	
	@Test
	public void testeTudoJunto() throws IOException {
		String texto = StringUtil.read(Thread.currentThread().getContextClassLoader(),
				"br/gov/camara/edemocracia/portlets/chat/portlet/beans/admin/editroom/devepassar.txt");
		assertTextoLimpoNaoFoiModificado(texto);
	}
	
	private void assertTextoLimpoNaoFoiModificado(String texto) {
		assertEquals(texto, limpar(texto));
	}
	
	private String limpar(String texto) {
		String textoLimpo = (String) converter.getAsObject(null, null, texto);
		return textoLimpo;
	}
}

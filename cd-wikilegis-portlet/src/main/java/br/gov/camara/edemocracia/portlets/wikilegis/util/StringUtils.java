/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.util.HtmlUtil;

/**
 * @author rpdmiranda
 * 
 */
public class StringUtils {

	private static final Pattern PATTERN_ARTIGO = Pattern.compile("(^Art\\. [0-9]+[º.]?) +.+", Pattern.CASE_INSENSITIVE
			| Pattern.DOTALL);

	private static final Pattern PATTERN_ESTRUTURA = Pattern.compile("^((?:capítulo|seção|subseção|título|livro) [0-9a-z]+) +(?:- +)?(.+)",
			Pattern.CASE_INSENSITIVE);

	/**
	 * Trunca uma string até o tamanho especificado, adicionando o final "..."
	 * caso tenha sido necessário limitar o tamanho máximo
	 * 
	 * @param original
	 * @param length
	 * @return
	 */
	public static String truncate(String original, int length) {
		if (original.length() <= length)
			return original;

		return original.substring(0, length - 3) + "...";
	}

	public static String formataArtigo(String texto, boolean primeiraLinhaInline) {

		// Converte as linhas para páragrafos
		BufferedReader reader = new BufferedReader(new StringReader(texto));
		StringBuilder sb = new StringBuilder();
		String linha;
		int numero = 0;
		try {
			while ((linha = reader.readLine()) != null) {
				Matcher m = PATTERN_ARTIGO.matcher(linha);
				if (m.matches()) {
					StringBuilder sbLinha = new StringBuilder(linha);
					sbLinha.insert(m.end(1), "[/b]");
					sbLinha.insert(0, "[b]");
					linha = sbLinha.toString();
				}
				
				if (numero != 0 || !primeiraLinhaInline)
					sb.append("<p>");
				sb.append(HtmlUtil.escape(linha));
				if (numero != 0 || !primeiraLinhaInline)
					sb.append("</p>");
				numero++;
			}
		} catch (IOException e) {
			// Não deve acontecer
		}

		int pos = 0;
		while ((pos = sb.indexOf("[b]", pos)) != -1) {
			sb.replace(pos, pos + 3, "<b>");
			pos += 3;
		}
		pos = 0;
		while ((pos = sb.indexOf("[/b]", pos)) != -1) {
			sb.replace(pos, pos + 4, "</b>");
			pos += 4;
		}
		return sb.toString();
	}

	/**
	 * Formata a estrutura para exibição
	 * @param texto
	 * @return
	 */
	public static String formataEstrutura(String texto) {
		// Separa em duas linhas
		Matcher m = PATTERN_ESTRUTURA.matcher(texto);
		if (m.matches()) {
			StringBuilder sb = new StringBuilder();
			sb.append(m.group(1));
			sb.append("\n");
			sb.append(m.group(2));
			texto = sb.toString();
		}
		texto = HtmlUtil.escape(texto);
		return texto.replaceAll("\\n", "<br/>");
	}
}

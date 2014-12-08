import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gov.camara.edemocracia.portlets.wikilegis.importer.ArtigoDTO;
import br.gov.camara.edemocracia.portlets.wikilegis.importer.EstruturaDTO;
import br.gov.camara.edemocracia.portlets.wikilegis.importer.XMLCodigoComercialWikilegisImporter;

/**
 * 
 */

/**
 * @author robson
 * 
 */
public class TestaExtracaoDados {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		XMLCodigoComercialWikilegisImporter importer = new XMLCodigoComercialWikilegisImporter();
		String name = "codigocomercial.html";
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(name);

		EstruturaDTO raiz;
		try {
			raiz = importer.processXML(is);
			mostra(-1, raiz);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}

	}

	private static void mostra(int nivel, EstruturaDTO elemento) {
		Pattern pp = Pattern.compile("(?s)^Art\\. ([0-9.]+?[oº]?)\\.? (.+)");
		if (nivel >= 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < nivel; i++)
				sb.append("-");
			sb.append(elemento.getNome());
			System.out.println(sb.toString());
		}
		for (ArtigoDTO artigo : elemento.getArtigos()) {
			String texto = artigo.getProposta();
			Matcher m = pp.matcher(texto);
			if (m.matches()) {
				System.out.println("Art. " + m.group(1));
			} else {
				System.out.println("erro " + texto);
			}
		}
		for (EstruturaDTO filho : elemento.getFilhos())
			mostra(nivel+1, filho);
	}

}

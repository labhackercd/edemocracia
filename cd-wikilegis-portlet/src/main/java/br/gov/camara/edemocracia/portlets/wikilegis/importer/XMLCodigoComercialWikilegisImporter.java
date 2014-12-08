package br.gov.camara.edemocracia.portlets.wikilegis.importer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException;
import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException;
import br.gov.camara.edemocracia.portlets.wikilegis.util.HtmlStripperDiscussion;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class XMLCodigoComercialWikilegisImporter {

	private HtmlStripperDiscussion htmlStripper;

	public XMLCodigoComercialWikilegisImporter() {
		htmlStripper = new HtmlStripperDiscussion();
	}

	private static final Pattern REMOVE_ANCHOR = Pattern
			.compile("<a name=\"(.+?)\"></a>(.+)");

	private static final Pattern PATTERN = Pattern
			.compile(
					"\\[((commentable|original_version) name=\"(.+?)\")\\](.+?)\\[/\\2\\]",
					Pattern.DOTALL);

	private static final Pattern REMOVE_EMPTY_LINES = Pattern.compile(
			"^[\r\n]*(.+?)[\r\n]*$", Pattern.DOTALL);

	private HashMap<EstruturaDTO, List<String>> artigosPorNivel;
	private HashMap<String, String> textoArtigo;
	private HashMap<String, String> legislacaoVigente;

	public EstruturaDTO processXML(InputStream input) throws PortalException,
			SystemException, IOException {
		HashMap<String, EstruturaDTO> estruturas = new HashMap<String, EstruturaDTO>();
		artigosPorNivel = new HashMap<EstruturaDTO, List<String>>();
		textoArtigo = new HashMap<String, String>();
		legislacaoVigente = new HashMap<String, String>();

		// Estrutura raiz
		EstruturaDTO raiz = new EstruturaDTO(null, null);

		// Estrutura atual
		EstruturaDTO estruturaAtual = raiz;

		String xml;
		xml = convertInputStreamToString(input);
		xml = htmlStripper.strip(xml);
		BufferedReader reader = new BufferedReader(new StringReader(xml));
		String linha;
		StringBuilder sbArtigo = new StringBuilder();
		boolean adicionar = false;

		try {
			while ((linha = reader.readLine()) != null) {
				linha = StringEscapeUtils.unescapeHtml(linha.trim());
				if (linha.isEmpty())
					continue;

				int pos = linha.indexOf("<a");
				if (pos != -1) {
					// Estrutura
					Matcher m = REMOVE_ANCHOR.matcher(linha);
					
					if (m.matches()) {
						String codigoEstrutura = m.group(1);
						String titulo = m.group(2);

						// Verifica se o código da estrutura é apenas um número
						// Se for, então ignora
						if (!StringUtils.containsOnly(codigoEstrutura, "0123456789")) {
							
							sbArtigo.append(linha, 0, pos);
							processaArtigo(estruturaAtual, sbArtigo);
							adicionar = false;
	
	
							// Obtém a estrutura pai
							EstruturaDTO estruturaPai;
							int posEstrutura = codigoEstrutura.lastIndexOf('/');
							if (posEstrutura != -1) {
								estruturaPai = estruturas.get(codigoEstrutura
										.substring(0, posEstrutura));
								if (estruturaPai == null)
									throw new NoSuchEstruturaException(
											"Estrutura " + codigoEstrutura + " filha criada antes da estrutura pai");
							} else {
								estruturaPai = raiz;
							}
	
							estruturaAtual = new EstruturaDTO(estruturaPai, titulo.trim());
							estruturas.put(codigoEstrutura, estruturaAtual);
							continue;
						} else {
							linha = m.group(2);	// Pega após o link inválido
						}
					}
				}

				// Ok, é trecho de texto
				pos = linha.indexOf("[commentable name=");
				if (pos == -1)
					pos = linha.indexOf("[original_version name=");
				if (pos != -1) {
					// Processa o artigo anterior
					sbArtigo.append(linha.subSequence(0, pos));
					processaArtigo(estruturaAtual, sbArtigo);

					// Dados do artigo atual
					int end = linha.indexOf("[/commentable]");
					if (end == -1) {
						end = linha.indexOf("[/original_version]");
						if (end != -1)
							end = end + ("[/original_version]".length());
					} else {
						end = end + "[/commentable]".length();
					}
					if (end == -1) {
						// O artigo não termina nesta linha
						sbArtigo.append(linha.subSequence(pos, linha.length()))
								.append("\n");
						adicionar = true;
					} else {
						sbArtigo.append(linha.subSequence(pos, end));
						processaArtigo(estruturaAtual, sbArtigo);
						adicionar = false;
					}
				} else {
					if (adicionar) {
						int end = linha.indexOf("[/commentable]");
						if (end == -1) {
							end = linha.indexOf("[/original_version]");
							if (end != -1)
								end = end + ("[/original_version]".length());
						} else {
							end = end + "[/commentable]".length();
						}
						if (end == -1)
							sbArtigo.append(linha).append("\n");
						else {
							sbArtigo.append(linha.subSequence(0, end));
							processaArtigo(estruturaAtual, sbArtigo);
							adicionar = false;
						}
					}
				}
			}
			processaArtigo(estruturaAtual, sbArtigo);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}

		// Acrescenta os artigos
		for (EstruturaDTO estruturaPai : artigosPorNivel.keySet()) {
			List<String> artigoIds = artigosPorNivel.get(estruturaPai);

			for (String artigoId : artigoIds) {
				String texto = textoArtigo.get(artigoId);
				String vigente = legislacaoVigente.get(artigoId);
				if (vigente == null)
					vigente = "";
				
				estruturaPai.adiconaArtigo(new ArtigoDTO(texto, vigente));
			}
		}
		return raiz;

	}

	/**
	 * Armazena os dados de um artigo
	 * 
	 * @param estrutura
	 * @param sb
	 * @throws IOException
	 * @throws NoSuchArtigoException
	 */
	private void processaArtigo(EstruturaDTO estrutura, StringBuilder sb)
			throws IOException, NoSuchArtigoException {
		if (sb.length() == 0)
			return;
		Matcher m = PATTERN.matcher(sb);
		if (m.matches()) {
			String texto = m.group(4).trim();

			// Retira linhas em branco ao final
			Matcher cleaner = REMOVE_EMPTY_LINES.matcher(texto);
			if (cleaner.matches()) {
				texto = cleaner.group(1);
			} else {
				throw new RuntimeException("Error in regexp");
			}

			String nodeId = m.group(3);
			
			if ("commentable".equals(m.group(2))) {
				List<String> artigos = artigosPorNivel.get(estrutura);
				if (artigos == null) {
					artigos = new ArrayList<String>();
					artigosPorNivel.put(estrutura, artigos);
				}
				if (!artigos.contains(nodeId))
					artigos.add(nodeId);

				if (textoArtigo.containsKey(nodeId))
					throw new NoSuchArtigoException("Artigo " + nodeId + " já acrescentado");
				textoArtigo.put(nodeId, texto);
			} else {
				if (legislacaoVigente.containsKey(nodeId))
					throw new NoSuchArtigoException(
							"Legislação vigente já acrescentada");
				legislacaoVigente.put(nodeId, texto);
			}
		} else {
			throw new RuntimeException("Erro ao importar: " + sb.toString());
		}
		sb.setLength(0);
	}

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {

		if (inputStream != null) {
			StringBuilder sb = new StringBuilder();
			String line;

			try {
				BufferedReader r1 = new BufferedReader(new InputStreamReader(
						inputStream, "UTF-8"));
				while ((line = r1.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				inputStream.close();
			}
			return sb.toString();
		} else {
			return "";
		}

	}
}
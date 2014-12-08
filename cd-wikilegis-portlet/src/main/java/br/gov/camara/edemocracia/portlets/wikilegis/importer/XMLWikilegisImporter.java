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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException;
import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.util.HtmlStripperDiscussion;

public class XMLWikilegisImporter {

	private HtmlStripperDiscussion htmlStripper;

	public XMLWikilegisImporter() {
		htmlStripper = new HtmlStripperDiscussion();
	}

	private static final Pattern REMOVE_ANCHOR = Pattern.compile("<a name=\"(.+?)\">(.+?)</a>(.+)");

	private static final Pattern PATTERN = Pattern.compile("\\[((commentable|original_version) name=\"(.+?)\")\\](.+?)\\[/\\2\\]",
			Pattern.DOTALL);

	private static final Pattern REMOVE_EMPTY_LINES = Pattern.compile("^[\r\n]*(.+?)[\r\n]*$", Pattern.DOTALL);

	private HashMap<String, Long> estruturas;
	private HashMap<Long, Long> ultimaEstruturaPorNivel;
	private HashMap<Long, List<String>> artigosPorNivel;
	private HashMap<String, String> textoArtigo;
	private HashMap<String, String> legislacaoVigente;

	public void processXML(long groupId, InputStream input) throws PortalException, SystemException, IOException {
		estruturas = new HashMap<String, Long>();
		ultimaEstruturaPorNivel = new HashMap<Long, Long>();
		artigosPorNivel = new HashMap<Long, List<String>>();
		textoArtigo = new HashMap<String, String>();
		legislacaoVigente = new HashMap<String, String>();

		// Estrutura raiz
		estruturas.put("", 0l);

		String xml;

		xml = convertInputStreamToString(input);
		xml = htmlStripper.strip(xml);
		BufferedReader reader = new BufferedReader(new StringReader(xml));
		String linha;
		String estruturaAtual = "";
		StringBuilder sbArtigo = new StringBuilder();
		boolean adicionar = false;

		try {
			while ((linha = reader.readLine()) != null) {
				linha = linha.trim();
				if (linha.isEmpty())
					continue;

				int pos = linha.indexOf("<a");
				if (pos != -1) {
					sbArtigo.append(linha, 0, pos);
					processaArtigo(estruturaAtual, sbArtigo);
					adicionar = false;

					// Estrutura
					Matcher m = REMOVE_ANCHOR.matcher(linha);
					if (m.matches()) {
						estruturaAtual = m.group(1);
						String titulo = m.group(2) + " - " + m.group(3);

						// Obtém a estrutura pai
						Long paiEstruturaId;
						int posEstrutura = estruturaAtual.lastIndexOf('/');
						if (posEstrutura != -1) {
							paiEstruturaId = estruturas.get(estruturaAtual.substring(0, posEstrutura));
							if (paiEstruturaId == null)
								throw new NoSuchEstruturaException("Estrutura filha criada antes da estrutura pai");
						} else {
							paiEstruturaId = 0l;
						}

						// Obtém a ordem
						Long ultimoId = ultimaEstruturaPorNivel.get(paiEstruturaId);
						if (ultimoId == null)
							ultimoId = 0l;

						Estrutura novo = EstruturaLocalServiceUtil.criaEstrutura(groupId, paiEstruturaId, ultimoId, titulo);
						ultimaEstruturaPorNivel.put(paiEstruturaId, novo.getEstruturaId());
						estruturas.put(estruturaAtual, novo.getEstruturaId());
						continue;
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
						sbArtigo.append(linha.subSequence(pos, linha.length())).append("\n");
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
		for (Long estruturaPai : artigosPorNivel.keySet()) {
			List<String> artigos = artigosPorNivel.get(estruturaPai);
			long anteriorArtigoId = 0l;

			for (String artigoId : artigos) {
				String texto = textoArtigo.get(artigoId);
				String vigente = legislacaoVigente.get(artigoId);
				if (vigente == null)
					vigente = "";
				Artigo artigo = ArtigoLocalServiceUtil.criaArtigo(groupId, estruturaPai.longValue(), anteriorArtigoId, texto,
						vigente);

				anteriorArtigoId = artigo.getArtigoId();
			}
		}

	}

	/**
	 * Armazena os dados de um artigo
	 * 
	 * @param estrutura
	 * @param sb
	 * @throws IOException
	 * @throws NoSuchArtigoException
	 */
	private void processaArtigo(String estrutura, StringBuilder sb) throws IOException, NoSuchArtigoException {
		if (sb.length() == 0)
			return;
		Matcher m = PATTERN.matcher(sb);
		if (m.matches()) {
			String texto = m.group(4);

			// Retira linhas em branco ao final
			Matcher cleaner = REMOVE_EMPTY_LINES.matcher(texto);
			if (cleaner.matches()) {
				texto = cleaner.group(1);
			} else {
				throw new RuntimeException("Error in regexp");
			}

			String nodeId = m.group(3);

			Long estruturaId = estruturas.get(estrutura);
			List<String> artigos = artigosPorNivel.get(estruturaId);
			if (artigos == null) {
				artigos = new ArrayList<String>();
				artigosPorNivel.put(estruturaId, artigos);
			}
			if (!artigos.contains(nodeId))
				artigos.add(nodeId);

			if ("commentable".equals(m.group(2))) {
				if (textoArtigo.containsKey(nodeId))
					throw new NoSuchArtigoException("Artigo já acrescentado");
				textoArtigo.put(nodeId, texto);
			} else {
				if (legislacaoVigente.containsKey(nodeId))
					throw new NoSuchArtigoException("Legislação vigente já acrescentada");
				legislacaoVigente.put(nodeId, texto);
			}
		} else {
			throw new RuntimeException("Erro ao importar: " + sb.toString());
		}
		sb.setLength(0);
	}

	private static String convertInputStreamToString(InputStream inputStream) throws IOException {

		if (inputStream != null) {
			StringBuilder sb = new StringBuilder();
			String line;

			try {
				BufferedReader r1 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
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
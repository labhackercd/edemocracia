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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import java.io.IOException;
import java.io.InputStream;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import br.gov.camara.edemocracia.portlets.wikilegis.importer.ArtigoDTO;
import br.gov.camara.edemocracia.portlets.wikilegis.importer.EstruturaDTO;
import br.gov.camara.edemocracia.portlets.wikilegis.importer.XMLCodigoComercialWikilegisImporter;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * 
 * @author Bruno
 */

@SuppressWarnings("serial")
public class UploadPage extends WebPage {

	public UploadPage() {

		initMenuWikilegis();

		final FeedbackPanel uploadFeedback = new FeedbackPanel("feedback");

		add(uploadFeedback);

		final FileUploadForm uploadForm = new FileUploadForm("uploadForm");
		add(uploadForm);

	}

	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));
	}

	private class FileUploadForm extends Form<Void> {

		private FileUploadField fileUploadField;

		public FileUploadForm(String name) {
			super(name);

			setMultiPart(true);
			fileUploadField = new FileUploadField("fileInput");
			fileUploadField.setOutputMarkupId(true);
			add(fileUploadField);

			add(new BookmarkablePageLink<HomePage>("cancelar", HomePage.class));

			// setMaxSize(Bytes.kilobytes(100));
		}

		@Override
		protected void onSubmit() {
			final FileUpload uploads = fileUploadField.getFileUpload();

			if (uploads != null) {

				try {
					XMLCodigoComercialWikilegisImporter xmlImporter = new XMLCodigoComercialWikilegisImporter();
					InputStream upload = uploads.getInputStream();
					EstruturaDTO raiz;
					try {
						raiz = xmlImporter.processXML(upload);
					} finally {
						try {
							upload.close();
						} catch (IOException e) {
						}
					}

					// Importa os elementos raiz
					long estruturaIdAnterior = 0l;
					for (EstruturaDTO estruturaDto : raiz.getFilhos()) {
						estruturaIdAnterior = importaEstrutura(estruturaDto,
								0l, estruturaIdAnterior).getEstruturaId();
					}
					importaArtigos(raiz, UIUtils.getScopeGroupId(), 0l);

					info("Arquivo importado com sucesso!");

				} catch (Exception e) {
					error("Erro na importação: " + e.getMessage());
				}

			} else {
				error("Nenhum arquivo encontrado.");

			}
		}

		/**
		 * Importa uma estrutura e seus filhos
		 * 
		 * @param elemento
		 * @param estruturaPaiId
		 * @param estruturaAnteriorId
		 * @return
		 * @throws PortalException
		 * @throws SystemException
		 */
		private Estrutura importaEstrutura(EstruturaDTO elemento,
				long estruturaPaiId, long estruturaAnteriorId)
				throws PortalException, SystemException {

			long groupId = UIUtils.getScopeGroupId();

			Estrutura estrutura = EstruturaLocalServiceUtil.criaEstrutura(
					groupId, estruturaPaiId, estruturaAnteriorId,
					elemento.getNome());

			// Acrescenta estruturas filhas
			long estruturaId = estrutura.getEstruturaId();
			long estruturaIdAnterior = 0l;
			for (EstruturaDTO estruturaDto : elemento.getFilhos()) {
				Estrutura filho = importaEstrutura(estruturaDto, estruturaId,
						estruturaIdAnterior);
				estruturaIdAnterior = filho.getEstruturaId();
			}

			importaArtigos(elemento, groupId, estruturaId);

			return estrutura;
		}

		/**
		 * @param elemento
		 * @param groupId
		 * @param estruturaId
		 * @throws PortalException
		 * @throws SystemException
		 */
		private void importaArtigos(EstruturaDTO elemento, long groupId,
				long estruturaId) throws PortalException, SystemException {
			long artigoIdAnterior = 0l;
			for (ArtigoDTO artigoDto : elemento.getArtigos()) {
				Artigo artigo = ArtigoLocalServiceUtil.criaArtigo(groupId,
						estruturaId, artigoIdAnterior, artigoDto.getProposta(),
						artigoDto.getVigente());
				artigoIdAnterior = artigo.getArtigoId();
			}
		}
	}
}

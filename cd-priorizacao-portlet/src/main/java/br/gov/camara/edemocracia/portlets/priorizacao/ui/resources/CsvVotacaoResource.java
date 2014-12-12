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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.resources;

import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.util.resource.AbstractResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;

import au.com.bytecode.opencsv.CSVWriter;
import br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta;
import br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.PropostaSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.VotoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.nio.charset.CharsetEncoderUtil;

/**
 * Download de arquivo CSV
 * 
 * @author robson
 * 
 */
public class CsvVotacaoResource extends WebResource {

	private final long groupId;

	public CsvVotacaoResource() {
		groupId = UIUtils.getScopeGroupId();
		setCacheable(false);
	}

	@Override
	protected void setHeaders(WebResponse response) {
		response.setContentType("text/csv; charset=ISO-8859-1");
		response.setCharacterEncoding("ISO-8859-1");
		response.setAttachmentHeader("priorizacao-propostas-" + groupId + ".csv");
		super.setHeaders(response);
	}

	@Override
	public IResourceStream getResourceStream() {
		
		AbstractResourceStream stream = new AbstractResourceStream() {
			
			private ByteArrayInputStream bais;
			
			@Override
			public InputStream getInputStream() throws ResourceStreamNotFoundException {
				if (bais == null) {
					PriorizacaoSumario sumario;

					try {
						sumario = PriorizacaoServiceUtil.getSumarioPriorizacao(groupId, new OrdemProposta[] { OrdemProposta.EIXO,
							OrdemProposta.IDENTIFICADOR });
					} catch (SystemException e) {
						throw new ResourceStreamNotFoundException();
					}

					CharArrayWriter writer = new CharArrayWriter(1000);
					CSVWriter csvwriter = new CSVWriter(writer,';');
					try {
						csvwriter.writeNext(new String[] { "eixo", "id_proposta", "proposta","usuário","uf","votos","dataUltimaRevisao"});
						for (PropostaSumario proposta : sumario.getPropostas()) {
							
							for(VotoSumario voto: proposta.getVotos()){
								String dataVoto = (voto.getData() != null) ? voto.getData().toString(): "";
								csvwriter.writeNext(new String[] { proposta.getEixo().getNome(), proposta.getIdentificador(), proposta.getNome(),
								voto.getUsername(), voto.getUserUF(),Integer.toString(voto.getNumeroVotos()) ,dataVoto});
							}
//							csvwriter.writeNext(new String[] { proposta.getEixo().getNome(), proposta.getIdentificador(), proposta.getNome(),
//									Integer.toString(proposta.getNumeroVotos()) });
						}
					} finally {
						try {
							csvwriter.close();
						} catch (IOException e) {
							throw new ResourceStreamNotFoundException();
						}
					} 
					CharBuffer cb = CharBuffer.wrap(writer.toCharArray());
					final ByteBuffer bb = CharsetEncoderUtil.encode("ISO-8859-1", cb);
					bais = new ByteArrayInputStream(bb.array());
				}
				return bais;
			}
			
			@Override
			public void close() throws IOException {
				if (bais != null)
					bais.close();
				bais = null;
			}
		};
		stream.setCharset(Charset.forName("ISO-8859-1"));
		return stream;
	}
}

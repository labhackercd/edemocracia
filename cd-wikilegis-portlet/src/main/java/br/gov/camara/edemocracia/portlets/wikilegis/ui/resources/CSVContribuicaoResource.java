package br.gov.camara.edemocracia.portlets.wikilegis.ui.resources;

import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.sql.SQLException;

import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.util.resource.AbstractResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;

import br.gov.camara.edemocracia.portlets.wikilegis.exporter.csv.ExportacaoCSV;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.charset.CharsetEncoderUtil;

public class CSVContribuicaoResource extends WebResource {

	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactoryUtil.getLog(CSVContribuicaoResource.class);
	private final long groupId;

	public CSVContribuicaoResource() {
		groupId = UIUtils.getScopeGroupId();
		setCacheable(false);
	}

	@Override
	protected void setHeaders(WebResponse response) {
		response.setContentType("text/csv; charset=ISO-8859-1");
		response.setCharacterEncoding("ISO-8859-1");
		response.setAttachmentHeader("contribuicoes-" + groupId + ".csv");
		super.setHeaders(response);
	}

	@Override
	public IResourceStream getResourceStream() {
		
		AbstractResourceStream stream = new AbstractResourceStream() {
			
			private ByteArrayInputStream bais;
			
			@Override
			public InputStream getInputStream() throws ResourceStreamNotFoundException {
				if (bais == null) {
					
					CharArrayWriter writer = new CharArrayWriter(1000);
					try {
						ExportacaoCSV.getContribuicoesCSV(groupId, writer);
					} catch (SystemException e) {
						throw new ResourceStreamNotFoundException();
					} catch (PortalException e) {
						LOG.error("Erro ao exportar sugestões", e);
						throw new ResourceStreamNotFoundException();
					} catch (SQLException e) {
						LOG.error("Erro ao exportar sugestões", e);
						throw new ResourceStreamNotFoundException();
					} catch (IOException e) {
						throw new ResourceStreamNotFoundException();
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

/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.model;

import java.text.DateFormat;

import org.apache.wicket.model.LoadableDetachableModel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

/**
 * @author robson
 * 
 */
public class ComentarioDisplayModel extends LoadableDetachableModel<ComentarioDisplay> {

	private static final Log LOG = LogFactoryUtil.getLog(ComentarioDisplayModel.class);

	/**
	 * Identificador da mensagem
	 */
	private final long messageId;

	/**
	 * Formatador de data
	 */
	private final DateFormat df;

	/**
	 * Monta um modelo baseando-se na mensagem
	 * 
	 * @param message
	 * @throws SystemException
	 */
	public ComentarioDisplayModel(MBMessage message, DateFormat df) throws SystemException {
		super(new ComentarioDisplay(message, df));
		this.messageId = message.getMessageId();
		this.df = df;
	}

	@Override
	protected ComentarioDisplay load() {
		try {
			MBMessage message = MBMessageLocalServiceUtil.getMBMessage(messageId);
			return new ComentarioDisplay(message, df);
		} catch (PortalException e) {
			LOG.info("Mensagem com identificador " + messageId + " não encontrada");
			return null;
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}

}

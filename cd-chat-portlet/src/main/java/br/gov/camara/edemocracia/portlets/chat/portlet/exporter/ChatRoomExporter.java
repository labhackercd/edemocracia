package br.gov.camara.edemocracia.portlets.chat.portlet.exporter;

import java.util.TimeZone;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public interface ChatRoomExporter {

	public String exportChatRoom(long chatRoomId, TimeZone tz) throws PortalException, SystemException;

	public String getFilename(long chatRoomId) throws PortalException, SystemException;

}

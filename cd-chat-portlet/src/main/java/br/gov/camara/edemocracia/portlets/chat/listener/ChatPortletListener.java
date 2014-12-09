package br.gov.camara.edemocracia.portlets.chat.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;

public class ChatPortletListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent sce) {
	    ChatRoomLocalServiceUtil.synchronizeActivityManagerAndDatabase();
    }

	@Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
	
}

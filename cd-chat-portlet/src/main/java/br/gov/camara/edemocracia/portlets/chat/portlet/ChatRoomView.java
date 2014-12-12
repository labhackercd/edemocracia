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
package br.gov.camara.edemocracia.portlets.chat.portlet;

import java.lang.reflect.Constructor;

import br.gov.camara.edemocracia.portlets.chat.portlet.views.AbstractView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.AnonView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.ChatView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.DetailsView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.ErrorView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.HelpVideoWmvView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.HistoryView;
import br.gov.camara.edemocracia.portlets.chat.portlet.views.ListView;

/**
 * Representa uma tela (jsp) do portlet, juntamente com o parâmetro usado na url
 * para mostrá-la e a classe java que processa sua requisição
 * 
 * No caso de alterações do atributo "urlParamValue", verificar se o arquivo
 * cd-chat-friendly-url-routes.xml precisa ser alterado.
 * 
 * @author Victor Bortone
 */
public enum ChatRoomView {
	LIST("list", "/html/room/listview.jsp", ListView.class),
	VIEW("view", "/html/room/view.jsp", ChatView.class),
	MODERATE("moderator", "/html/room/moderatorview.jsp", ChatView.class),
	HISTORY("history", "/html/room/history.jsp", HistoryView.class),
	ANON("anon", "/html/room/anon.jsp", AnonView.class),
	ERROR("error", "/html/room/error.jsp", ErrorView.class),
	HELP("help", "/html/room/helpvideowmv.jsp", HelpVideoWmvView.class),
	DETAILS("details", "/html/room/detailsroom.jsp", DetailsView.class);
	

	public static ChatRoomView fromUrlParamValue(String urlParamValue) {
		for (ChatRoomView view : ChatRoomView.values()) {
			if (view.getUrlParamValue().equalsIgnoreCase(urlParamValue)) {
				return view;
			}
		}
		return null;
	}

	public String getUrlParamValue() {
		return urlParamValue;
	}

	public String getJspName() {
		return jspName;
	}

	public AbstractView createHandler() {
		try {
			Constructor<? extends AbstractView> constructor = viewHandlerClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao instanciar handler para " + name(), e);
		}
	}

	private final String urlParamValue;
	private final String jspName;
	private final Class<? extends AbstractView> viewHandlerClass;

	private ChatRoomView(String paramUrl, String jspName, Class<? extends AbstractView> viewHandlerClass) {
		this.urlParamValue = paramUrl;
		this.jspName = jspName;
		this.viewHandlerClass = viewHandlerClass;
	}
}

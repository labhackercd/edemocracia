package br.gov.camara.edemocracia.portlets.chat.portlet;

import org.junit.Assert;
import org.junit.Test;

import br.gov.camara.edemocracia.portlets.chat.portlet.views.AbstractView;

public class ChatRoomViewTest {

	@Test
	public void createHandlerNaoDeveLancarExcecao() {
		for (ChatRoomView view : ChatRoomView.values()) {
			try {
				view.createHandler();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Falhou para view " + view.name());
			}
		}
	}
	
	@Test
	public void createHandlerNaoDeveRetornarNull() {
		for (ChatRoomView view : ChatRoomView.values()) {
			AbstractView viewHandler = view.createHandler();
			Assert.assertNotNull(viewHandler);
		}
	}
}

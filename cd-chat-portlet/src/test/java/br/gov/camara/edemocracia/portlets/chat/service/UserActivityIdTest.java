package br.gov.camara.edemocracia.portlets.chat.service;

import org.junit.Assert;
import org.junit.Test;

public class UserActivityIdTest {

	@Test
	public void getAsStringDeveSerCompativelComFromStringParaUsuarioEspiao() {
		UserActivityId idSpyUser = UserActivityId.forNewSpyUser();
		String idComoString = idSpyUser.getAsString();
		
		UserActivityId idFromString = UserActivityId.fromString(idComoString);
		Assert.assertEquals(idSpyUser, idFromString);
	}
	
	@Test
	public void getAsStringDeveSerCompativelComFromStringParaUsuarioPersistente() {
		UserActivityId idPersistentUser = UserActivityId.forPersistentUser(9);
		String idComoString = idPersistentUser.getAsString();
		
		UserActivityId idFromString = UserActivityId.fromString(idComoString);
		Assert.assertEquals(idPersistentUser, idFromString);
	}
	
	@Test(expected=Exception.class)
	public void fromStringComArgumentoInvalidoDeveLancarExcecao() {
		UserActivityId.fromString("asdasd asdasd asd");
	}
}

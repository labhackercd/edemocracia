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
package br.gov.camara.edemocracia.portlets.chat.service.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;

public class ChatUserActivityManagerTest {

	private ChatUserActivityManagerLocalMap manager;

	@Before
	public void setup() {
		manager = new ChatUserActivityManagerLocalMap();
	}

	@Test
	public void activityManagerDeveComecarVazio() {
		Collection<UserActivityId> idsInativos = manager.removeInactiveUsers();
		assertTrue(idsInativos.isEmpty());
	}

	@Test
	public void testeInclusao() {
		final long roomId = 10l;
		final UserActivityId idUser = UserActivityId.forNewSpyUser();
		
		assertNull(manager.getLastActivityOfUser(roomId, idUser));
		manager.addUser(roomId, idUser);
		assertNotNull(manager.getLastActivityOfUser(roomId, idUser));
	}
	
	@Test
	public void incluirUsuarioJaIncluidoDeveAtualizarSeuTimestamp() throws InterruptedException {
		final long roomId = 10l;
		final UserActivityId idUser = UserActivityId.forPersistentUser(5);
		
		manager.addUser(roomId, idUser);
		Date timestamp1 = manager.getLastActivityOfUser(roomId, idUser);
		
		Thread.sleep(2);
		
		manager.addUser(roomId, idUser);
		Date timestamp2 = manager.getLastActivityOfUser(roomId, idUser);
		
		assertNotSame(timestamp1, timestamp2);
	}

	@Test
	public void usuarioDeveFicarInativoDepoisDeDezMinutos() {
		final UserActivityId idInactiveUser = UserActivityId.forPersistentUser(1);
		final long roomId = 10l;

		manager.addUser(roomId, idInactiveUser);
		manager.updateUserLastActivity(roomId, idInactiveUser, getTenMinutesAgo());

		final UserActivityId idActiveUser = UserActivityId.forNewSpyUser();
		manager.addUser(roomId, idActiveUser);

		Collection<UserActivityId> inactiveUsers = manager.removeInactiveUsers();

		assertEquals(1, inactiveUsers.size());
		assertTrue(inactiveUsers.contains(idInactiveUser));
	}
	
	@Test
	public void atualizacaoDeUsuarioInexistenteDeveSerIgnorada() {
		final long roomId = 10l;
		final UserActivityId idUser = UserActivityId.forNewSpyUser();
		
		manager.updateUserLastActivity(roomId, idUser);
		assertNull(manager.getLastActivityOfUser(roomId, idUser));
	}

	@Test
	public void deveRemoverUsuarioEspecifico() {
		final UserActivityId idUser = UserActivityId.forPersistentUser(1);
		final long roomId = 10l;

		manager.addUser(roomId, idUser);
		assertNotNull(manager.getLastActivityOfUser(roomId, idUser));

		manager.removeUser(roomId, idUser);
		assertNull(manager.getLastActivityOfUser(roomId, idUser));
	}
	
	@Test
	public void deveRetornarONumeroDeUsuariosNaSala() {
		final UserActivityId usuarioDaSala1 = UserActivityId.forPersistentUser(1);
		final UserActivityId usuario2DaSala1 = UserActivityId.forPersistentUser(2);
		final UserActivityId usuarioDaSala2 = UserActivityId.forPersistentUser(3);
		final UserActivityId usuarioEspiandoNaSala1 = UserActivityId.forNewSpyUser();
		final long sala1 = 1l;
		final long sala2 = 2l;
		
		manager.addUser(sala1, usuarioDaSala1);
		manager.addUser(sala1, usuario2DaSala1);
		manager.addUser(sala1, usuarioEspiandoNaSala1);
		manager.addUser(sala2, usuarioDaSala2);
		
		assertEquals(2, manager.getNumberOfUsersInRoom(sala1));
	}
	
	@Test
	public void deveRetornarZeroParaSalaInexistente() {
		final UserActivityId usuarioDaSala1 = UserActivityId.forPersistentUser(1);
		final long sala1 = 1l;
		final long salaInexistente = 9999l;
		
		manager.addUser(sala1, usuarioDaSala1);
		
		assertEquals(0, manager.getNumberOfUsersInRoom(salaInexistente));
	}
	
	@Test
	public void deveRetornarONumeroDeUsuariosEspiando() {
		final UserActivityId usuarioEspiandoASala1 = UserActivityId.forNewSpyUser();
		final UserActivityId usuario2EspiandoASala1 = UserActivityId.forNewSpyUser();
		
		final UserActivityId usuarioNaSala1 = UserActivityId.forPersistentUser(10);
		
		final UserActivityId usuarioEspiandoASala2 = UserActivityId.forNewSpyUser();
		
		final long sala1 = 1l;
		final long sala2 = 2l;
		
		manager.addUser(sala1, usuarioEspiandoASala1);
		manager.addUser(sala1, usuario2EspiandoASala1);
		manager.addUser(sala2, usuarioEspiandoASala2);
		manager.addUser(sala1, usuarioNaSala1);
		
		assertEquals(2, manager.getNumberOfUsersSpyingInRoom(sala1));
	}
	
	@Test
	public void deveSaberSeUsuarioEstaNaSala() {
		final UserActivityId usuarioPresenteNaSala = UserActivityId.forPersistentUser(1);
		final UserActivityId usuarioAusenteDaSala = UserActivityId.forPersistentUser(2);
		final Long roomId = 10l;
		
		manager.addUser(roomId, usuarioPresenteNaSala);
		
		assertTrue(manager.isUserInRoom(roomId,usuarioPresenteNaSala));
		
		assertFalse(manager.isUserInRoom(roomId, usuarioAusenteDaSala));
	}
	
	private Date getTenMinutesAgo() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, -10);
		return cal.getTime();
	}
}

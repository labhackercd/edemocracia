package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomModelImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageStatus;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class ChatRoomFinderImpl extends BasePersistenceImpl<ChatRoom> implements ChatRoomFinder {

	public List<ChatRoom> findOpenAndEnterableClosedRoomsInCompany(long companyId, boolean userLogado) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			StringBuilder sqlBuilder = new StringBuilder("SELECT {a.*} FROM CDChat_ChatRoom a ");

			sqlBuilder.append("JOIN Group_ b ON a.groupId = b.groupId ");

			sqlBuilder.append("WHERE a.companyId = ? ");

			if (userLogado) {
				sqlBuilder.append("AND (a.status = ? OR ( a.status = ? AND a.openPolicy = ? )) ");
				// RoomStatus.Opened.getValue()
				// RoomStatus.Closed.getValue()
				// RoomOpenPolicy.Manual.getValue()
			} else {
				sqlBuilder.append("AND a.status = ? ");
				sqlBuilder.append("AND b.type != ? ");
				// RoomStatus.Opened.getValue()
			}

			sqlBuilder.append("ORDER BY a.groupId DESC, a.createDate DESC, a.roomId DESC");

			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("a", ChatRoomImpl.class);

			q.setLong(0, companyId);
			if (userLogado) {
				q.setInteger(1, RoomStatus.Opened.getValue());
				q.setInteger(2, RoomStatus.Closed.getValue());
				q.setInteger(3, RoomOpenPolicy.Manual.getValue());
			} else {
				q.setInteger(1, RoomStatus.Opened.getValue());
				q.setInteger(2, GroupConstants.TYPE_SITE_PRIVATE);

			}

			// execute the query and return a list from the db
			@SuppressWarnings("unchecked")
			List<ChatRoom> list = (List<ChatRoom>) q.list();
			return list;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
    public List<ChatRoomUserBean> findAllChatRoomParticipants(long roomId) throws PortalException, SystemException{
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder sqlBuilder = new StringBuilder("SELECT DISTINCT m.senderName, m.senderEmail , m.senderUF FROM CDChat_ChatRoomMessage m ") ;
			sqlBuilder.append("WHERE m.chatRoomId = ? AND m.messagePublic = 1 AND m.adminMessage = 0 AND m.messageStatus = ? AND m.messageType = ? ORDER BY m.senderName ");
		
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.setLong(0, roomId);
			q.setInteger(1, MessageStatus.Approved.getValue());
			q.setInteger(2, MessageType.UserEntered.getValue());
			
			List<Object[]> results = q.list();
			List<ChatRoomUserBean> participants = new ArrayList<ChatRoomUserBean>();
			
			for (Object[] result : results) {
				ChatRoomUserBean participant = new ChatRoomUserBean();
				
				participant.setUserEmail(result[1].toString());
				participant.setUserName(result[0].toString());
				
				long regionID = Long.parseLong(result[2].toString());		
				String regionCode = StringPool.BLANK;
				if (regionID > 0) {
					regionCode = RegionServiceUtil.getRegion(regionID).getRegionCode();
				} else {
					regionCode = "N/A";
				}
				participant.setUserUF(regionCode);
				
				participants.add(participant);
            }
			
			return participants;
			
		} finally {
			closeSession(session);
		}
	}
	
	public List<ChatRoom> findScheduledRoomsInCompany(long companyId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			// Here ends the basic set up;
			// now we build the query. Note that we use the name of the tables
			// from the database!
			StringBuilder sqlBuilder = new StringBuilder("SELECT {a.*} FROM CDChat_ChatRoom a ");
			sqlBuilder.append("JOIN Group_ b ON a.groupId = b.groupId ");
			sqlBuilder.append("WHERE a.companyId = ? ");
			sqlBuilder.append("AND a.openPolicy = ? ");
			sqlBuilder.append("AND a.openFrom >= ? ");
			sqlBuilder.append("ORDER BY a.openFrom ASC, a.roomName asc");
			
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("a", ChatRoomImpl.class);

			q.setLong(0, companyId);
			q.setInteger(1, RoomOpenPolicy.Scheduled.getValue());
			q.setTimestamp(2, new Timestamp(new Date().getTime()));

			// execute the query and return a list from the db
			@SuppressWarnings("unchecked")
			List<ChatRoom> list = (List<ChatRoom>) q.list();
			return list;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
	}

	public List<ChatRoom> findExportedRoomsInCompany(long companyId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			// Here ends the basic set up;
			// now we build the query. Note that we use the name of the tables
			// from the database!
			StringBuilder sqlBuilder = new StringBuilder("SELECT {a.*} FROM CDChat_ChatRoom a ");
			sqlBuilder.append("JOIN Group_ b ON a.groupId = b.groupId ");
			sqlBuilder.append("WHERE a.companyId = ? ");
			sqlBuilder.append("AND a.status = ? ");
			sqlBuilder.append("ORDER BY a.openUntil desc, a.groupId DESC, a.createDate DESC, a.roomId DESC");

			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("a", ChatRoomImpl.class);

			q.setLong(0, companyId);
			q.setInteger(1, RoomStatus.Exported.getValue());

			// execute the query and return a list from the db
			@SuppressWarnings("unchecked")
			List<ChatRoom> list = (List<ChatRoom>) q.list();
			return list;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
	}

	@Override
	public void removerUsuariosBanidosDeSalasFechadas() {
		Session session = null;
		try {
			session = openSession();
			StringBuilder sb = new StringBuilder();
			sb.append("delete from ");
			sb.append(ChatRoomUserImpl.TABLE_NAME).append(" ");
			sb.append("where chatRoomId in (");
			sb.append("select cr.roomId from " + ChatRoomImpl.TABLE_NAME + " cr where cr.status in (?, ?)");
			sb.append(") and banned = 1");

			SQLQuery query = session.createSQLQuery(sb.toString());
			query.setLong(0, RoomStatus.Closed.getValue());
			query.setLong(1, RoomStatus.Exported.getValue());
			if (query.executeUpdate() > 0)
				ChatRoomUserUtil.clearCache();

		} finally {
			closeSession(session);
		}
	}

	public void incrementarNumeroMaximoDeParticipantes(long companyId, long roomId) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ");
			sb.append(ChatRoomModelImpl.TABLE_NAME);
			sb.append(" SET maxSimultaneousUsers = maxSimultaneousUsers + 1");
			sb.append(" WHERE roomId = ? and companyId = ? ");
			
			SQLQuery query = session.createSQLQuery(sb.toString());
			query.setLong(0, roomId);
			query.setLong(1, companyId);
			query.executeUpdate();
			ChatRoomUtil.clearCache();
		} finally {
			closeSession(session);
		}
	}

	public void incrementarNumeroMaximoDeEspioes(long companyId, long roomId) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ");
			sb.append(ChatRoomModelImpl.TABLE_NAME);
			sb.append(" SET maxSimultaneousUsersSpying = maxSimultaneousUsersSpying + 1");
			sb.append(" WHERE roomId = ? and companyId = ? ");
			
			SQLQuery query = session.createSQLQuery(sb.toString());
			query.setLong(0, roomId);
			query.setLong(1, companyId);
			query.executeUpdate();
			ChatRoomUtil.clearCache();
		} finally {
			closeSession(session);
		}
	}
}

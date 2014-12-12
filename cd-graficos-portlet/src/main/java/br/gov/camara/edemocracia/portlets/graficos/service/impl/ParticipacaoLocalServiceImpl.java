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
package br.gov.camara.edemocracia.portlets.graficos.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;

import br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO;
import br.gov.camara.edemocracia.portlets.graficos.DadosUsuarioDTO;
import br.gov.camara.edemocracia.portlets.graficos.service.base.ParticipacaoLocalServiceBaseImpl;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;

/**
 * The implementation of the participacao local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalServiceUtil}
 * to access the participacao local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Bruno Evangelista
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.ParticipacaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalServiceUtil
 */
public class ParticipacaoLocalServiceImpl extends
		ParticipacaoLocalServiceBaseImpl {

	/**
	 * Lista todas as comunidades públicas, privadas e restritas da companhia
	 * 
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	public List<Group> getComunidadesDisponiveis(final long companyId)
			throws SystemException {

		final long groupClassNameId = ClassNameLocalServiceUtil
				.getClassNameId(Group.class);

		final DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				Group.class, PortalClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		query.add(RestrictionsFactoryUtil.eq("classNameId", groupClassNameId));
		query.add(RestrictionsFactoryUtil.in("type", new Object[] {
				GroupConstants.TYPE_SITE_OPEN,
				GroupConstants.TYPE_SITE_PRIVATE,
				GroupConstants.TYPE_SITE_RESTRICTED }));
		query.add(RestrictionsFactoryUtil.eq("parentGroupId",
				GroupConstants.DEFAULT_PARENT_GROUP_ID));
		query.add(RestrictionsFactoryUtil.eq("active", true));
		query.add(RestrictionsFactoryUtil.ne("name",
				GroupConstants.CONTROL_PANEL));
		query.addOrder(OrderFactoryUtil.asc("name"));

		return (List<Group>) GroupLocalServiceUtil.dynamicQuery(query);
	}

	/**
	 * Recupera todos os dados dos usuários que participaram das comunidades
	 * especificadas.
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<DadosComunidadeDTO> getDadosComunidade(final List<Long> groups)
			throws PortalException, SystemException {
		List<DadosComunidadeDTO> retorno = getDadosComunidade(groups, null, null);
		Collections.sort(retorno, new DadosComunidadeDTOComparator());
		return retorno;
	}

	/**
	 * Recupera todos os dados dos usuários que participaram das comunidades
	 * especificadas.
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<DadosComunidadeDTO> getDadosComunidade(List<Long> groups,
			Date dataInicio, Date dataFim) throws PortalException,
			SystemException {

		List<DadosComunidadeDTO> retorno = new ArrayList<DadosComunidadeDTO>();

		for (Long groupId : groups) {
			retorno.add(getDadosComunidade(groupId, dataInicio, dataFim));
		}
		Collections.sort(retorno, new DadosComunidadeDTOComparator());
		return retorno;
	}

	/**
	 * Recupera todos os dados dos usuários que participaram da comunidade
	 * especificada.
	 */
	public DadosComunidadeDTO getDadosComunidade(Long groupId)
			throws PortalException, SystemException {
		return getDadosComunidade(groupId, null, null);
	}

	/**
	 * Recupera todos os dados dos usuários que participaram da comunidade
	 * especificada dentro do periodo especificado.
	 */
	public DadosComunidadeDTO getDadosComunidade(Long groupId, Date dataInicio,
			Date dataFim) throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.getGroup(groupId);

		LinkedHashMap<Long, DadosUsuarioDTO> listaDadosUsuario = new LinkedHashMap<Long, DadosUsuarioDTO>();
		DadosComunidadeDTO dadosComunidade = new DadosComunidadeDTO(groupId,
				group.getName(), listaDadosUsuario);

		Connection conn = null;

		try {
			conn = DataAccess.getConnection();

			ParticipacaoSQLQueries[] participacaoQueries = ParticipacaoSQLQueries
					.values();

			for (ParticipacaoSQLQueries participacaoQuery : participacaoQueries) {
				consultaParticipacao(conn, participacaoQuery,
						listaDadosUsuario, groupId, dataInicio, dataFim);
			}

			consultaMembros(conn, listaDadosUsuario, groupId);

		} catch (SQLException e) {
			throw new SystemException(e);

		} finally {
			DataAccess.cleanUp(conn);
		}

		return dadosComunidade;
	}

	/**
	 * 
	 * Consulta as participações do usuário realizadas no período especificado e
	 * adiciona esses dados a lista passada por parametro.
	 * 
	 * @param conn
	 * @param participacaoQuery
	 * @param listaDadosUsuario
	 *            lista de usuários que fizeram alguma participação na
	 *            comunidade
	 * @param groupId
	 *            comunidade que deseja pesquisar
	 * @param dataInicio
	 *            data de inicio do período
	 * @param dataFim
	 *            data de término do período
	 * @throws SQLException
	 * @throws SystemException
	 */
	private void consultaParticipacao(Connection conn,
			ParticipacaoSQLQueries participacaoQuery,
			Map<Long, DadosUsuarioDTO> listaDadosUsuario, Long groupId,
			Date dataInicio, Date dataFim) throws SQLException, SystemException {

		PreparedStatement pstmt = preparaStatementDeParticipacao(conn,
				participacaoQuery, groupId, dataInicio, dataFim);

		executaConsultaParticipacao(participacaoQuery, listaDadosUsuario, pstmt);

	}

	private void executaConsultaParticipacao(
			ParticipacaoSQLQueries participacaoQuery,
			Map<Long, DadosUsuarioDTO> listaDadosUsuario,
			PreparedStatement pstmt) throws SQLException, SystemException {
		try {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				long userId = rs.getInt(1);

				// Verifica se o usuário já possui o objeto de dados
				// DadosUsuarioDTO
				if (!listaDadosUsuario.containsKey(userId)) {
					String username = rs.getString(2);
					String email = rs.getString(3);
					listaDadosUsuario.put(userId, new DadosUsuarioDTO(userId,
							username, email));
				}

				// Insere dado do resultset na propriedade especificada do bean
				// DadosUsuarioDTO
				try {
					BeanUtils.setProperty(listaDadosUsuario.get(userId),
							participacaoQuery.getPropriedadeBean(),
							rs.getObject(4));

				} catch (IllegalAccessException e) {
					throw new SystemException();
				} catch (InvocationTargetException e) {
					throw new SystemException();
				}
			}

		} finally {
			DataAccess.cleanUp(pstmt);
		}
	}

	private PreparedStatement preparaStatementDeParticipacao(Connection conn,
			ParticipacaoSQLQueries participacaoQuery, Long groupId,
			Date dataInicio, Date dataFim) throws SQLException {
		PreparedStatement pstmt = null;

		if ((dataInicio == null) && (dataFim == null)) {
			String sql = participacaoQuery.getQuery(groupId);
			pstmt = conn.prepareStatement(sql);

		} else {
			// Adicionando periodo de data ao pstmt
			String sql = participacaoQuery.getQueryParaPeriodo(groupId);
			pstmt = conn.prepareStatement(sql);
			TimeZone tz = LiferayFacesContext.getInstance().getUser()
					.getTimeZone();
			MutableDateTime dtInicio = new MutableDateTime(dataInicio,
					DateTimeZone.forTimeZone(tz));
			dtInicio.setTime(0, 0, 0, 0);
			Timestamp inicio = new Timestamp(dtInicio.getMillis());
			MutableDateTime dtFim = new MutableDateTime(dataFim,
					DateTimeZone.forTimeZone(tz));
			dtFim.setTime(23, 59, 59, 999);
			Timestamp fim = new Timestamp(dtFim.getMillis());
			pstmt.setTimestamp(1, inicio);
			pstmt.setTimestamp(2, fim);

		}
		return pstmt;
	}

	/**
	 * Consulta dentre os usuários da listaDadosUsuario especificada, quais são
	 * membros
	 * 
	 * @param conn
	 * @param listaDadosUsuario
	 *            lista de usuários que fizeram alguma participação na
	 *            comunidade
	 * @param groupId
	 *            comunidade a ser pesquisada
	 * @throws SQLException
	 * @throws SystemException
	 */
	private void consultaMembros(Connection conn,
			Map<Long, DadosUsuarioDTO> listaDadosUsuario, Long groupId)
			throws SQLException, SystemException {

		String sql = " SELECT u.userId, u.firstname, u.middlename, u.lastname, u.emailaddress FROM users_groups ug JOIN user_ u ON u.userId = ug.userId WHERE ug.groupId =  ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			pstmt.setLong(1, groupId);
			ResultSet rs = pstmt.executeQuery();

			try {
				while (rs.next()) {
					long userId = rs.getInt(1);

					if (listaDadosUsuario.containsKey(userId)) {
						try {
							BeanUtils.setProperty(
									listaDadosUsuario.get(userId), "membro",
									true);

						} catch (IllegalAccessException e) {
							throw new SystemException();
						} catch (InvocationTargetException e) {
							throw new SystemException();
						}
					} else {
						StringBuilder sb = new StringBuilder();
						String firstName = rs.getString(2);
						String middleName = rs.getString(3);
						String lastName = rs.getString(4);
						String email = rs.getString(5);
						if (firstName != null && !firstName.isEmpty())
							sb.append(firstName).append(' ');
						if (middleName != null && !middleName.isEmpty())
							sb.append(middleName).append(' ');
						if (lastName != null && !lastName.isEmpty())
							sb.append(lastName);
						
						DadosUsuarioDTO dadosUsuario = new DadosUsuarioDTO(userId, sb.toString().trim(), email);
						dadosUsuario.setMembro(true);
						listaDadosUsuario.put(userId, dadosUsuario);
					}
				}

			} finally {
				DataAccess.cleanUp(rs);
			}
		} finally {
			DataAccess.cleanUp(pstmt);
		}
	}

}

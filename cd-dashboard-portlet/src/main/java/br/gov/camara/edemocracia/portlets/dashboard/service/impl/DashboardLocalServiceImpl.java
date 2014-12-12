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
package br.gov.camara.edemocracia.portlets.dashboard.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.gov.camara.edemocracia.portlets.dashboard.Recurso;
import br.gov.camara.edemocracia.portlets.dashboard.cache.util.CacheRecursosDTO;
import br.gov.camara.edemocracia.portlets.dashboard.cache.util.DashboardCacheUtil;
import br.gov.camara.edemocracia.portlets.dashboard.customquery.QueryExecutor;
import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;
import br.gov.camara.edemocracia.portlets.dashboard.service.base.DashboardLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;

/**
 * The implementation of the dashboard local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.gov.camara.edemocracia.portlets.dashboard.service.DashboardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno
 * @see br.gov.camara.edemocracia.portlets.dashboard.service.base.DashboardLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.dashboard.service.DashboardLocalServiceUtil
 */
public class DashboardLocalServiceImpl extends DashboardLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link br.gov.camara.edemocracia.portlets.dashboard.service.DashboardLocalServiceUtil} to access the dashboard local service.
     */
	
	private static final Log LOG = LogFactoryUtil.getLog(DashboardLocalServiceImpl.class);

	/**
	 * Lista todas as comunidades públicas, privadas e restritas da companhia
	 * 
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	public List<Group> getComunidadesDisponiveis(final long companyId) throws SystemException {

		final long groupClassNameId = ClassNameLocalServiceUtil.getClassNameId(Group.class);

		final DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class, PortalClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		query.add(RestrictionsFactoryUtil.eq("classNameId", groupClassNameId));
		query.add(RestrictionsFactoryUtil.in("type", new Object[] { GroupConstants.TYPE_SITE_OPEN, GroupConstants.TYPE_SITE_PRIVATE,
				GroupConstants.TYPE_SITE_RESTRICTED }));
		query.add(RestrictionsFactoryUtil.eq("parentGroupId", GroupConstants.DEFAULT_PARENT_GROUP_ID));
		query.add(RestrictionsFactoryUtil.eq("active", true));
		query.add(RestrictionsFactoryUtil.ne("name", GroupConstants.CONTROL_PANEL));
		query.addOrder(OrderFactoryUtil.asc("name"));

		return (List<Group>) GroupLocalServiceUtil.dynamicQuery(query);
	}

	public List<RecursoDTO> getRecursosComMaiorParticipacao(long companyId, Configuracao config, String portletInstanceId, Recurso recurso) throws SystemException {
		try {
			return getRecursosComMaiorParticipacao(companyId, config, portletInstanceId, recurso.getQueryExecutor().newInstance());
		
		} catch (InstantiationException e) {
			throw new SystemException(e);
		} catch (IllegalAccessException e) {
			throw new SystemException(e);
		}
	}

	private List<RecursoDTO> getRecursosComMaiorParticipacao(long companyId, Configuracao config, String portletInstanceId, QueryExecutor executor) throws SystemException {
		if (config == null || executor == null) {
			throw new IllegalArgumentException("Os paramêtros config e executor não podem ser null");
		}
		if (companyId == 0) {
			throw new IllegalArgumentException("O paramêtro companyId não pode ser 0");
		}
		if (StringUtils.isBlank(portletInstanceId)) {
			throw new IllegalArgumentException("O paramêtro portletInstanceId não pode ser vazio ou null");
		}

		CacheRecursosDTO cache = DashboardCacheUtil.getCacheRecurso(executor.getChaveCache(), portletInstanceId);

		boolean existeCache = cache != null;

		if (existeCache) {
			LOG.info(executor.getChaveCache().getKey() +  ": dados do cache");
			return cache.getRecursos();

		} else {
			List<RecursoDTO> retorno = null;
			Connection connection = null;
			
			try {
				connection = DataAccess.getConnection();
				retorno = executor.listarRecursosComMaiorParticipacao(connection, config, companyId);
			} catch (SQLException e) {
				throw new SystemException(e);
			}  finally {
				DataAccess.cleanUp(connection);
			}

			DashboardCacheUtil.setCacheRecurso(executor.getChaveCache(), portletInstanceId, retorno);
			
			LOG.info(executor.getChaveCache().getKey() +  ": dados do banco");
			return retorno;
		}
	}
	
	
}

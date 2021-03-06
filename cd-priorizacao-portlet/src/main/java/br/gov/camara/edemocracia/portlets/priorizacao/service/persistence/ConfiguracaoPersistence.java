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
package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the configuracao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ConfiguracaoPersistenceImpl
 * @see ConfiguracaoUtil
 * @generated
 */
public interface ConfiguracaoPersistence extends BasePersistence<Configuracao> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ConfiguracaoUtil} to access the configuracao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the configuracao in the entity cache if it is enabled.
    *
    * @param configuracao the configuracao
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao configuracao);

    /**
    * Caches the configuracaos in the entity cache if it is enabled.
    *
    * @param configuracaos the configuracaos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> configuracaos);

    /**
    * Creates a new configuracao with the primary key. Does not add the configuracao to the database.
    *
    * @param configuracaoId the primary key for the new configuracao
    * @return the new configuracao
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao create(
        long configuracaoId);

    /**
    * Removes the configuracao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao remove(
        long configuracaoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao configuracao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the configuracao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException} if it could not be found.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao findByPrimaryKey(
        long configuracaoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the configuracao with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao, or <code>null</code> if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao fetchByPrimaryKey(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the configuracao where groupId = &#63; or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException} if it could not be found.
    *
    * @param groupId the group ID
    * @return the matching configuracao
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException if a matching configuracao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao findByG(
        long groupId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the configuracao where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param groupId the group ID
    * @return the matching configuracao, or <code>null</code> if a matching configuracao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao fetchByG(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the configuracao where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching configuracao, or <code>null</code> if a matching configuracao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao fetchByG(
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the configuracaos.
    *
    * @return the configuracaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the configuracaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of configuracaos
    * @param end the upper bound of the range of configuracaos (not inclusive)
    * @return the range of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the configuracaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of configuracaos
    * @param end the upper bound of the range of configuracaos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the configuracao where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @return the configuracao that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao removeByG(
        long groupId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the configuracaos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of configuracaos where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching configuracaos
    * @throws SystemException if a system exception occurred
    */
    public int countByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of configuracaos.
    *
    * @return the number of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

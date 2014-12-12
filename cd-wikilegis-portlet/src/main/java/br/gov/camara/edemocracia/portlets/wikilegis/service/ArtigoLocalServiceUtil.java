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
package br.gov.camara.edemocracia.portlets.wikilegis.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the artigo local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ArtigoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see ArtigoLocalService
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.ArtigoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ArtigoLocalServiceImpl
 * @generated
 */
public class ArtigoLocalServiceUtil {
    private static ArtigoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ArtigoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the artigo to the database. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @return the artigo that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo addArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addArtigo(artigo);
    }

    /**
    * Creates a new artigo with the primary key. Does not add the artigo to the database.
    *
    * @param artigoId the primary key for the new artigo
    * @return the new artigo
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo createArtigo(
        long artigoId) {
        return getService().createArtigo(artigoId);
    }

    /**
    * Deletes the artigo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo that was removed
    * @throws PortalException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo deleteArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteArtigo(artigoId);
    }

    /**
    * Deletes the artigo from the database. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @return the artigo that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo deleteArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteArtigo(artigo);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchArtigo(artigoId);
    }

    /**
    * Returns the artigo with the primary key.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo
    * @throws PortalException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo getArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getArtigo(artigoId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the artigos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @return the range of artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> getArtigos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getArtigos(start, end);
    }

    /**
    * Returns the number of artigos.
    *
    * @return the number of artigos
    * @throws SystemException if a system exception occurred
    */
    public static int getArtigosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getArtigosCount();
    }

    /**
    * Updates the artigo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @return the artigo that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo updateArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateArtigo(artigo);
    }

    /**
    * Updates the artigo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @param merge whether to merge the artigo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the artigo that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo updateArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateArtigo(artigo, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Lista os filhos do pai especificado
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> listaArtigos(
        long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listaArtigos(groupId, estruturaId);
    }

    /**
    * Lista os filhos do pai especificado, jÃƒÂ¡ formatados para visualizaÃƒÂ§ÃƒÂ£o
    *
    * @param groupId
    * @param estruturaId
    * @return
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay> listaArtigoDisplay(
        long groupId, long estruturaId) {
        return getService().listaArtigoDisplay(groupId, estruturaId);
    }

    /**
    * Lista todos os artigos do grupo especificadoz
    *
    * @param groupId
    * @return
    */
    public static java.util.Map<java.lang.Long, java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay>> listaArtigoDisplay(
        long groupId) {
        return getService().listaArtigoDisplay(groupId);
    }

    /**
    * Cria um artigo no nÃƒÂ³ especificado
    *
    * @param groupId
    * @param estruturaId
    * @param texto
    * @param legislacaoVigente
    * @param ordem
    * @throws SystemException
    * @throws PortalException
    * @return Artigo artigo recÃƒÂ©m-criado
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo criaArtigo(
        long groupId, long estruturaId, long anteriorArtigoId,
        java.lang.String texto, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .criaArtigo(groupId, estruturaId, anteriorArtigoId, texto,
            legislacaoVigente);
    }

    /**
    * Exclui um artigo e seus comentÃƒÂ¡rios
    *
    * @param artigoId
    * @throws SystemException
    * @throws PortalException
    */
    public static void excluiArtigo(long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().excluiArtigo(artigoId);
    }

    /**
    * Atualiza um artigo
    *
    * @param userId
    * @param artigoId
    * @param textoArtigo
    * @param legislacaoVigente
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo atualizaArtigo(
        long userId, long artigoId, long estruturaId, long anteriorArtigoId,
        java.lang.String textoArtigo, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .atualizaArtigo(userId, artigoId, estruturaId,
            anteriorArtigoId, textoArtigo, legislacaoVigente);
    }

    public static void clearService() {
        _service = null;
    }

    public static ArtigoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ArtigoLocalService.class.getName());

            if (invokableLocalService instanceof ArtigoLocalService) {
                _service = (ArtigoLocalService) invokableLocalService;
            } else {
                _service = new ArtigoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ArtigoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ArtigoLocalService service) {
    }
}

package br.gov.camara.edemocracia.portlets.wikilegis.service.base;

import br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalService;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalService;
import br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalService;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisService;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ArtigoFinder;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ArtigoPersistence;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ContribuicaoPersistence;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.EstruturaPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the wiki legis remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl}.
 * </p>
 *
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil
 * @generated
 */
public abstract class WikiLegisServiceBaseImpl extends BaseServiceImpl
    implements WikiLegisService, IdentifiableBean {
    @BeanReference(type = ArtigoLocalService.class)
    protected ArtigoLocalService artigoLocalService;
    @BeanReference(type = ArtigoPersistence.class)
    protected ArtigoPersistence artigoPersistence;
    @BeanReference(type = ArtigoFinder.class)
    protected ArtigoFinder artigoFinder;
    @BeanReference(type = ContribuicaoLocalService.class)
    protected ContribuicaoLocalService contribuicaoLocalService;
    @BeanReference(type = ContribuicaoPersistence.class)
    protected ContribuicaoPersistence contribuicaoPersistence;
    @BeanReference(type = EstruturaLocalService.class)
    protected EstruturaLocalService estruturaLocalService;
    @BeanReference(type = EstruturaPersistence.class)
    protected EstruturaPersistence estruturaPersistence;
    @BeanReference(type = WikiLegisService.class)
    protected WikiLegisService wikiLegisService;
    @BeanReference(type = CounterLocalService.class)
    protected CounterLocalService counterLocalService;
    @BeanReference(type = ResourceLocalService.class)
    protected ResourceLocalService resourceLocalService;
    @BeanReference(type = ResourceService.class)
    protected ResourceService resourceService;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserLocalService.class)
    protected UserLocalService userLocalService;
    @BeanReference(type = UserService.class)
    protected UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private WikiLegisServiceClpInvoker _clpInvoker = new WikiLegisServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil} to access the wiki legis remote service.
     */

    /**
     * Returns the artigo local service.
     *
     * @return the artigo local service
     */
    public ArtigoLocalService getArtigoLocalService() {
        return artigoLocalService;
    }

    /**
     * Sets the artigo local service.
     *
     * @param artigoLocalService the artigo local service
     */
    public void setArtigoLocalService(ArtigoLocalService artigoLocalService) {
        this.artigoLocalService = artigoLocalService;
    }

    /**
     * Returns the artigo persistence.
     *
     * @return the artigo persistence
     */
    public ArtigoPersistence getArtigoPersistence() {
        return artigoPersistence;
    }

    /**
     * Sets the artigo persistence.
     *
     * @param artigoPersistence the artigo persistence
     */
    public void setArtigoPersistence(ArtigoPersistence artigoPersistence) {
        this.artigoPersistence = artigoPersistence;
    }

    /**
     * Returns the artigo finder.
     *
     * @return the artigo finder
     */
    public ArtigoFinder getArtigoFinder() {
        return artigoFinder;
    }

    /**
     * Sets the artigo finder.
     *
     * @param artigoFinder the artigo finder
     */
    public void setArtigoFinder(ArtigoFinder artigoFinder) {
        this.artigoFinder = artigoFinder;
    }

    /**
     * Returns the contribuicao local service.
     *
     * @return the contribuicao local service
     */
    public ContribuicaoLocalService getContribuicaoLocalService() {
        return contribuicaoLocalService;
    }

    /**
     * Sets the contribuicao local service.
     *
     * @param contribuicaoLocalService the contribuicao local service
     */
    public void setContribuicaoLocalService(
        ContribuicaoLocalService contribuicaoLocalService) {
        this.contribuicaoLocalService = contribuicaoLocalService;
    }

    /**
     * Returns the contribuicao persistence.
     *
     * @return the contribuicao persistence
     */
    public ContribuicaoPersistence getContribuicaoPersistence() {
        return contribuicaoPersistence;
    }

    /**
     * Sets the contribuicao persistence.
     *
     * @param contribuicaoPersistence the contribuicao persistence
     */
    public void setContribuicaoPersistence(
        ContribuicaoPersistence contribuicaoPersistence) {
        this.contribuicaoPersistence = contribuicaoPersistence;
    }

    /**
     * Returns the estrutura local service.
     *
     * @return the estrutura local service
     */
    public EstruturaLocalService getEstruturaLocalService() {
        return estruturaLocalService;
    }

    /**
     * Sets the estrutura local service.
     *
     * @param estruturaLocalService the estrutura local service
     */
    public void setEstruturaLocalService(
        EstruturaLocalService estruturaLocalService) {
        this.estruturaLocalService = estruturaLocalService;
    }

    /**
     * Returns the estrutura persistence.
     *
     * @return the estrutura persistence
     */
    public EstruturaPersistence getEstruturaPersistence() {
        return estruturaPersistence;
    }

    /**
     * Sets the estrutura persistence.
     *
     * @param estruturaPersistence the estrutura persistence
     */
    public void setEstruturaPersistence(
        EstruturaPersistence estruturaPersistence) {
        this.estruturaPersistence = estruturaPersistence;
    }

    /**
     * Returns the wiki legis remote service.
     *
     * @return the wiki legis remote service
     */
    public WikiLegisService getWikiLegisService() {
        return wikiLegisService;
    }

    /**
     * Sets the wiki legis remote service.
     *
     * @param wikiLegisService the wiki legis remote service
     */
    public void setWikiLegisService(WikiLegisService wikiLegisService) {
        this.wikiLegisService = wikiLegisService;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the resource remote service.
     *
     * @return the resource remote service
     */
    public ResourceService getResourceService() {
        return resourceService;
    }

    /**
     * Sets the resource remote service.
     *
     * @param resourceService the resource remote service
     */
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * Returns the resource persistence.
     *
     * @return the resource persistence
     */
    public ResourcePersistence getResourcePersistence() {
        return resourcePersistence;
    }

    /**
     * Sets the resource persistence.
     *
     * @param resourcePersistence the resource persistence
     */
    public void setResourcePersistence(ResourcePersistence resourcePersistence) {
        this.resourcePersistence = resourcePersistence;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = InfrastructureUtil.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}

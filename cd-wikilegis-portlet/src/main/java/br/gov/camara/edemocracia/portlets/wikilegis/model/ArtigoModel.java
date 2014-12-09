package br.gov.camara.edemocracia.portlets.wikilegis.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Artigo service. Represents a row in the &quot;CDWL_Artigo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoImpl}.
 * </p>
 *
 * @author robson
 * @see Artigo
 * @see br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoModelImpl
 * @generated
 */
public interface ArtigoModel extends BaseModel<Artigo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a artigo model instance should use the {@link Artigo} interface instead.
     */

    /**
     * Returns the primary key of this artigo.
     *
     * @return the primary key of this artigo
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this artigo.
     *
     * @param primaryKey the primary key of this artigo
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the artigo ID of this artigo.
     *
     * @return the artigo ID of this artigo
     */
    public long getArtigoId();

    /**
     * Sets the artigo ID of this artigo.
     *
     * @param artigoId the artigo ID of this artigo
     */
    public void setArtigoId(long artigoId);

    /**
     * Returns the company ID of this artigo.
     *
     * @return the company ID of this artigo
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this artigo.
     *
     * @param companyId the company ID of this artigo
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this artigo.
     *
     * @return the group ID of this artigo
     */
    public long getGroupId();

    /**
     * Sets the group ID of this artigo.
     *
     * @param groupId the group ID of this artigo
     */
    public void setGroupId(long groupId);

    /**
     * Returns the estrutura ID of this artigo.
     *
     * @return the estrutura ID of this artigo
     */
    public long getEstruturaId();

    /**
     * Sets the estrutura ID of this artigo.
     *
     * @param estruturaId the estrutura ID of this artigo
     */
    public void setEstruturaId(long estruturaId);

    /**
     * Returns the ordem of this artigo.
     *
     * @return the ordem of this artigo
     */
    public int getOrdem();

    /**
     * Sets the ordem of this artigo.
     *
     * @param ordem the ordem of this artigo
     */
    public void setOrdem(int ordem);

    /**
     * Returns the texto of this artigo.
     *
     * @return the texto of this artigo
     */
    @AutoEscape
    public String getTexto();

    /**
     * Sets the texto of this artigo.
     *
     * @param texto the texto of this artigo
     */
    public void setTexto(String texto);

    /**
     * Returns the legislacao vigente of this artigo.
     *
     * @return the legislacao vigente of this artigo
     */
    @AutoEscape
    public String getLegislacaoVigente();

    /**
     * Sets the legislacao vigente of this artigo.
     *
     * @param legislacaoVigente the legislacao vigente of this artigo
     */
    public void setLegislacaoVigente(String legislacaoVigente);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Artigo artigo);

    public int hashCode();

    public CacheModel<Artigo> toCacheModel();

    public Artigo toEscapedModel();

    public String toString();

    public String toXmlString();
}
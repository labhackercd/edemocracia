package br.gov.camara.edemocracia.portlets.guiadiscussao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Configuracao service. Represents a row in the &quot;GD_Configuracao&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.ConfiguracaoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.ConfiguracaoImpl}.
 * </p>
 *
 * @author Robson
 * @see Configuracao
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.ConfiguracaoImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.ConfiguracaoModelImpl
 * @generated
 */
public interface ConfiguracaoModel extends BaseModel<Configuracao> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a configuracao model instance should use the {@link Configuracao} interface instead.
     */

    /**
     * Returns the primary key of this configuracao.
     *
     * @return the primary key of this configuracao
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this configuracao.
     *
     * @param primaryKey the primary key of this configuracao
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the configuracao ID of this configuracao.
     *
     * @return the configuracao ID of this configuracao
     */
    public long getConfiguracaoId();

    /**
     * Sets the configuracao ID of this configuracao.
     *
     * @param configuracaoId the configuracao ID of this configuracao
     */
    public void setConfiguracaoId(long configuracaoId);

    /**
     * Returns the group ID of this configuracao.
     *
     * @return the group ID of this configuracao
     */
    public long getGroupId();

    /**
     * Sets the group ID of this configuracao.
     *
     * @param groupId the group ID of this configuracao
     */
    public void setGroupId(long groupId);

    /**
     * Returns the fase atual ID of this configuracao.
     *
     * @return the fase atual ID of this configuracao
     */
    public long getFaseAtualId();

    /**
     * Sets the fase atual ID of this configuracao.
     *
     * @param faseAtualId the fase atual ID of this configuracao
     */
    public void setFaseAtualId(long faseAtualId);

    /**
     * Returns the texto banner of this configuracao.
     *
     * @return the texto banner of this configuracao
     */
    @AutoEscape
    public String getTextoBanner();

    /**
     * Sets the texto banner of this configuracao.
     *
     * @param textoBanner the texto banner of this configuracao
     */
    public void setTextoBanner(String textoBanner);

    /**
     * Returns the imagem ID banner of this configuracao.
     *
     * @return the imagem ID banner of this configuracao
     */
    public long getImagemIdBanner();

    /**
     * Sets the imagem ID banner of this configuracao.
     *
     * @param imagemIdBanner the imagem ID banner of this configuracao
     */
    public void setImagemIdBanner(long imagemIdBanner);

    /**
     * Returns the url banner of this configuracao.
     *
     * @return the url banner of this configuracao
     */
    @AutoEscape
    public String getUrlBanner();

    /**
     * Sets the url banner of this configuracao.
     *
     * @param urlBanner the url banner of this configuracao
     */
    public void setUrlBanner(String urlBanner);

    /**
     * Returns the url externa of this configuracao.
     *
     * @return the url externa of this configuracao
     */
    public boolean getUrlExterna();

    /**
     * Returns <code>true</code> if this configuracao is url externa.
     *
     * @return <code>true</code> if this configuracao is url externa; <code>false</code> otherwise
     */
    public boolean isUrlExterna();

    /**
     * Sets whether this configuracao is url externa.
     *
     * @param urlExterna the url externa of this configuracao
     */
    public void setUrlExterna(boolean urlExterna);

    /**
     * Returns the titulo banner of this configuracao.
     *
     * @return the titulo banner of this configuracao
     */
    @AutoEscape
    public String getTituloBanner();

    /**
     * Sets the titulo banner of this configuracao.
     *
     * @param tituloBanner the titulo banner of this configuracao
     */
    public void setTituloBanner(String tituloBanner);

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

    public int compareTo(Configuracao configuracao);

    public int hashCode();

    public CacheModel<Configuracao> toCacheModel();

    public Configuracao toEscapedModel();

    public String toString();

    public String toXmlString();
}
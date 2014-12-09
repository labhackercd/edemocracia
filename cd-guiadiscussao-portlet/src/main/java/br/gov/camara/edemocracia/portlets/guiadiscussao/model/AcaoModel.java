package br.gov.camara.edemocracia.portlets.guiadiscussao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Acao service. Represents a row in the &quot;GD_Acao&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoImpl}.
 * </p>
 *
 * @author Robson
 * @see Acao
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoModelImpl
 * @generated
 */
public interface AcaoModel extends BaseModel<Acao> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a acao model instance should use the {@link Acao} interface instead.
     */

    /**
     * Returns the primary key of this acao.
     *
     * @return the primary key of this acao
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this acao.
     *
     * @param primaryKey the primary key of this acao
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the acao ID of this acao.
     *
     * @return the acao ID of this acao
     */
    public long getAcaoId();

    /**
     * Sets the acao ID of this acao.
     *
     * @param acaoId the acao ID of this acao
     */
    public void setAcaoId(long acaoId);

    /**
     * Returns the fase ID of this acao.
     *
     * @return the fase ID of this acao
     */
    public long getFaseId();

    /**
     * Sets the fase ID of this acao.
     *
     * @param faseId the fase ID of this acao
     */
    public void setFaseId(long faseId);

    /**
     * Returns the ordem of this acao.
     *
     * @return the ordem of this acao
     */
    public int getOrdem();

    /**
     * Sets the ordem of this acao.
     *
     * @param ordem the ordem of this acao
     */
    public void setOrdem(int ordem);

    /**
     * Returns the texto of this acao.
     *
     * @return the texto of this acao
     */
    @AutoEscape
    public String getTexto();

    /**
     * Sets the texto of this acao.
     *
     * @param texto the texto of this acao
     */
    public void setTexto(String texto);

    /**
     * Returns the url externa of this acao.
     *
     * @return the url externa of this acao
     */
    public boolean getUrlExterna();

    /**
     * Returns <code>true</code> if this acao is url externa.
     *
     * @return <code>true</code> if this acao is url externa; <code>false</code> otherwise
     */
    public boolean isUrlExterna();

    /**
     * Sets whether this acao is url externa.
     *
     * @param urlExterna the url externa of this acao
     */
    public void setUrlExterna(boolean urlExterna);

    /**
     * Returns the url link of this acao.
     *
     * @return the url link of this acao
     */
    @AutoEscape
    public String getUrlLink();

    /**
     * Sets the url link of this acao.
     *
     * @param urlLink the url link of this acao
     */
    public void setUrlLink(String urlLink);

    /**
     * Returns the icone ID of this acao.
     *
     * @return the icone ID of this acao
     */
    public long getIconeId();

    /**
     * Sets the icone ID of this acao.
     *
     * @param iconeId the icone ID of this acao
     */
    public void setIconeId(long iconeId);

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

    public int compareTo(Acao acao);

    public int hashCode();

    public CacheModel<Acao> toCacheModel();

    public Acao toEscapedModel();

    public String toString();

    public String toXmlString();
}
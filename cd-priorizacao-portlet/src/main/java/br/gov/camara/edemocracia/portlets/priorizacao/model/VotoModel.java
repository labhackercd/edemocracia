package br.gov.camara.edemocracia.portlets.priorizacao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Voto service. Represents a row in the &quot;PR_Voto&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoImpl}.
 * </p>
 *
 * @author robson
 * @see Voto
 * @see br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoModelImpl
 * @generated
 */
public interface VotoModel extends BaseModel<Voto> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a voto model instance should use the {@link Voto} interface instead.
     */

    /**
     * Returns the primary key of this voto.
     *
     * @return the primary key of this voto
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this voto.
     *
     * @param primaryKey the primary key of this voto
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the voto ID of this voto.
     *
     * @return the voto ID of this voto
     */
    public long getVotoId();

    /**
     * Sets the voto ID of this voto.
     *
     * @param votoId the voto ID of this voto
     */
    public void setVotoId(long votoId);

    /**
     * Returns the proposta ID of this voto.
     *
     * @return the proposta ID of this voto
     */
    public long getPropostaId();

    /**
     * Sets the proposta ID of this voto.
     *
     * @param propostaId the proposta ID of this voto
     */
    public void setPropostaId(long propostaId);

    /**
     * Returns the user ID of this voto.
     *
     * @return the user ID of this voto
     */
    public long getUserId();

    /**
     * Sets the user ID of this voto.
     *
     * @param userId the user ID of this voto
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this voto.
     *
     * @return the user uuid of this voto
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this voto.
     *
     * @param userUuid the user uuid of this voto
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this voto.
     *
     * @return the user name of this voto
     */
    @AutoEscape
    public String getUserName();

    /**
     * Sets the user name of this voto.
     *
     * @param userName the user name of this voto
     */
    public void setUserName(String userName);

    /**
     * Returns the numero votos of this voto.
     *
     * @return the numero votos of this voto
     */
    public int getNumeroVotos();

    /**
     * Sets the numero votos of this voto.
     *
     * @param numeroVotos the numero votos of this voto
     */
    public void setNumeroVotos(int numeroVotos);

    /**
     * Returns the votos disponiveis of this voto.
     *
     * @return the votos disponiveis of this voto
     */
    public int getVotosDisponiveis();

    /**
     * Sets the votos disponiveis of this voto.
     *
     * @param votosDisponiveis the votos disponiveis of this voto
     */
    public void setVotosDisponiveis(int votosDisponiveis);

    /**
     * Returns the data of this voto.
     *
     * @return the data of this voto
     */
    public Date getData();

    /**
     * Sets the data of this voto.
     *
     * @param data the data of this voto
     */
    public void setData(Date data);

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

    public int compareTo(Voto voto);

    public int hashCode();

    public CacheModel<Voto> toCacheModel();

    public Voto toEscapedModel();

    public String toString();

    public String toXmlString();
}
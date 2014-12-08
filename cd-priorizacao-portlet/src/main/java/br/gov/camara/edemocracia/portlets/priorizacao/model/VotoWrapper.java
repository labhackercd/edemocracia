package br.gov.camara.edemocracia.portlets.priorizacao.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Voto}.
 * </p>
 *
 * @author    robson
 * @see       Voto
 * @generated
 */
public class VotoWrapper implements Voto, ModelWrapper<Voto> {
    private Voto _voto;

    public VotoWrapper(Voto voto) {
        _voto = voto;
    }

    public Class<?> getModelClass() {
        return Voto.class;
    }

    public String getModelClassName() {
        return Voto.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("votoId", getVotoId());
        attributes.put("propostaId", getPropostaId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("numeroVotos", getNumeroVotos());
        attributes.put("votosDisponiveis", getVotosDisponiveis());
        attributes.put("data", getData());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long votoId = (Long) attributes.get("votoId");

        if (votoId != null) {
            setVotoId(votoId);
        }

        Long propostaId = (Long) attributes.get("propostaId");

        if (propostaId != null) {
            setPropostaId(propostaId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Integer numeroVotos = (Integer) attributes.get("numeroVotos");

        if (numeroVotos != null) {
            setNumeroVotos(numeroVotos);
        }

        Integer votosDisponiveis = (Integer) attributes.get("votosDisponiveis");

        if (votosDisponiveis != null) {
            setVotosDisponiveis(votosDisponiveis);
        }

        Date data = (Date) attributes.get("data");

        if (data != null) {
            setData(data);
        }
    }

    /**
    * Returns the primary key of this voto.
    *
    * @return the primary key of this voto
    */
    public long getPrimaryKey() {
        return _voto.getPrimaryKey();
    }

    /**
    * Sets the primary key of this voto.
    *
    * @param primaryKey the primary key of this voto
    */
    public void setPrimaryKey(long primaryKey) {
        _voto.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the voto ID of this voto.
    *
    * @return the voto ID of this voto
    */
    public long getVotoId() {
        return _voto.getVotoId();
    }

    /**
    * Sets the voto ID of this voto.
    *
    * @param votoId the voto ID of this voto
    */
    public void setVotoId(long votoId) {
        _voto.setVotoId(votoId);
    }

    /**
    * Returns the proposta ID of this voto.
    *
    * @return the proposta ID of this voto
    */
    public long getPropostaId() {
        return _voto.getPropostaId();
    }

    /**
    * Sets the proposta ID of this voto.
    *
    * @param propostaId the proposta ID of this voto
    */
    public void setPropostaId(long propostaId) {
        _voto.setPropostaId(propostaId);
    }

    /**
    * Returns the user ID of this voto.
    *
    * @return the user ID of this voto
    */
    public long getUserId() {
        return _voto.getUserId();
    }

    /**
    * Sets the user ID of this voto.
    *
    * @param userId the user ID of this voto
    */
    public void setUserId(long userId) {
        _voto.setUserId(userId);
    }

    /**
    * Returns the user uuid of this voto.
    *
    * @return the user uuid of this voto
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _voto.getUserUuid();
    }

    /**
    * Sets the user uuid of this voto.
    *
    * @param userUuid the user uuid of this voto
    */
    public void setUserUuid(java.lang.String userUuid) {
        _voto.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this voto.
    *
    * @return the user name of this voto
    */
    public java.lang.String getUserName() {
        return _voto.getUserName();
    }

    /**
    * Sets the user name of this voto.
    *
    * @param userName the user name of this voto
    */
    public void setUserName(java.lang.String userName) {
        _voto.setUserName(userName);
    }

    /**
    * Returns the numero votos of this voto.
    *
    * @return the numero votos of this voto
    */
    public int getNumeroVotos() {
        return _voto.getNumeroVotos();
    }

    /**
    * Sets the numero votos of this voto.
    *
    * @param numeroVotos the numero votos of this voto
    */
    public void setNumeroVotos(int numeroVotos) {
        _voto.setNumeroVotos(numeroVotos);
    }

    /**
    * Returns the votos disponiveis of this voto.
    *
    * @return the votos disponiveis of this voto
    */
    public int getVotosDisponiveis() {
        return _voto.getVotosDisponiveis();
    }

    /**
    * Sets the votos disponiveis of this voto.
    *
    * @param votosDisponiveis the votos disponiveis of this voto
    */
    public void setVotosDisponiveis(int votosDisponiveis) {
        _voto.setVotosDisponiveis(votosDisponiveis);
    }

    /**
    * Returns the data of this voto.
    *
    * @return the data of this voto
    */
    public java.util.Date getData() {
        return _voto.getData();
    }

    /**
    * Sets the data of this voto.
    *
    * @param data the data of this voto
    */
    public void setData(java.util.Date data) {
        _voto.setData(data);
    }

    public boolean isNew() {
        return _voto.isNew();
    }

    public void setNew(boolean n) {
        _voto.setNew(n);
    }

    public boolean isCachedModel() {
        return _voto.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _voto.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _voto.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _voto.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _voto.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _voto.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _voto.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new VotoWrapper((Voto) _voto.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto) {
        return _voto.compareTo(voto);
    }

    @Override
    public int hashCode() {
        return _voto.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> toCacheModel() {
        return _voto.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto toEscapedModel() {
        return new VotoWrapper(_voto.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _voto.toString();
    }

    public java.lang.String toXmlString() {
        return _voto.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _voto.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Voto getWrappedVoto() {
        return _voto;
    }

    public Voto getWrappedModel() {
        return _voto;
    }

    public void resetOriginalValues() {
        _voto.resetOriginalValues();
    }
}

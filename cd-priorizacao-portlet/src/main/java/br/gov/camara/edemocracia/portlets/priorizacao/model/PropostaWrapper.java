package br.gov.camara.edemocracia.portlets.priorizacao.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Proposta}.
 * </p>
 *
 * @author    robson
 * @see       Proposta
 * @generated
 */
public class PropostaWrapper implements Proposta, ModelWrapper<Proposta> {
    private Proposta _proposta;

    public PropostaWrapper(Proposta proposta) {
        _proposta = proposta;
    }

    public Class<?> getModelClass() {
        return Proposta.class;
    }

    public String getModelClassName() {
        return Proposta.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("propostaId", getPropostaId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("eixoId", getEixoId());
        attributes.put("identificador", getIdentificador());
        attributes.put("ementa", getEmenta());
        attributes.put("texto", getTexto());
        attributes.put("threadId", getThreadId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long propostaId = (Long) attributes.get("propostaId");

        if (propostaId != null) {
            setPropostaId(propostaId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long eixoId = (Long) attributes.get("eixoId");

        if (eixoId != null) {
            setEixoId(eixoId);
        }

        String identificador = (String) attributes.get("identificador");

        if (identificador != null) {
            setIdentificador(identificador);
        }

        String ementa = (String) attributes.get("ementa");

        if (ementa != null) {
            setEmenta(ementa);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        Long threadId = (Long) attributes.get("threadId");

        if (threadId != null) {
            setThreadId(threadId);
        }
    }

    /**
    * Returns the primary key of this proposta.
    *
    * @return the primary key of this proposta
    */
    public long getPrimaryKey() {
        return _proposta.getPrimaryKey();
    }

    /**
    * Sets the primary key of this proposta.
    *
    * @param primaryKey the primary key of this proposta
    */
    public void setPrimaryKey(long primaryKey) {
        _proposta.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the proposta ID of this proposta.
    *
    * @return the proposta ID of this proposta
    */
    public long getPropostaId() {
        return _proposta.getPropostaId();
    }

    /**
    * Sets the proposta ID of this proposta.
    *
    * @param propostaId the proposta ID of this proposta
    */
    public void setPropostaId(long propostaId) {
        _proposta.setPropostaId(propostaId);
    }

    /**
    * Returns the company ID of this proposta.
    *
    * @return the company ID of this proposta
    */
    public long getCompanyId() {
        return _proposta.getCompanyId();
    }

    /**
    * Sets the company ID of this proposta.
    *
    * @param companyId the company ID of this proposta
    */
    public void setCompanyId(long companyId) {
        _proposta.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this proposta.
    *
    * @return the group ID of this proposta
    */
    public long getGroupId() {
        return _proposta.getGroupId();
    }

    /**
    * Sets the group ID of this proposta.
    *
    * @param groupId the group ID of this proposta
    */
    public void setGroupId(long groupId) {
        _proposta.setGroupId(groupId);
    }

    /**
    * Returns the eixo ID of this proposta.
    *
    * @return the eixo ID of this proposta
    */
    public long getEixoId() {
        return _proposta.getEixoId();
    }

    /**
    * Sets the eixo ID of this proposta.
    *
    * @param eixoId the eixo ID of this proposta
    */
    public void setEixoId(long eixoId) {
        _proposta.setEixoId(eixoId);
    }

    /**
    * Returns the identificador of this proposta.
    *
    * @return the identificador of this proposta
    */
    public java.lang.String getIdentificador() {
        return _proposta.getIdentificador();
    }

    /**
    * Sets the identificador of this proposta.
    *
    * @param identificador the identificador of this proposta
    */
    public void setIdentificador(java.lang.String identificador) {
        _proposta.setIdentificador(identificador);
    }

    /**
    * Returns the ementa of this proposta.
    *
    * @return the ementa of this proposta
    */
    public java.lang.String getEmenta() {
        return _proposta.getEmenta();
    }

    /**
    * Sets the ementa of this proposta.
    *
    * @param ementa the ementa of this proposta
    */
    public void setEmenta(java.lang.String ementa) {
        _proposta.setEmenta(ementa);
    }

    /**
    * Returns the texto of this proposta.
    *
    * @return the texto of this proposta
    */
    public java.lang.String getTexto() {
        return _proposta.getTexto();
    }

    /**
    * Sets the texto of this proposta.
    *
    * @param texto the texto of this proposta
    */
    public void setTexto(java.lang.String texto) {
        _proposta.setTexto(texto);
    }

    /**
    * Returns the thread ID of this proposta.
    *
    * @return the thread ID of this proposta
    */
    public long getThreadId() {
        return _proposta.getThreadId();
    }

    /**
    * Sets the thread ID of this proposta.
    *
    * @param threadId the thread ID of this proposta
    */
    public void setThreadId(long threadId) {
        _proposta.setThreadId(threadId);
    }

    public boolean isNew() {
        return _proposta.isNew();
    }

    public void setNew(boolean n) {
        _proposta.setNew(n);
    }

    public boolean isCachedModel() {
        return _proposta.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _proposta.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _proposta.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _proposta.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _proposta.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _proposta.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _proposta.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PropostaWrapper((Proposta) _proposta.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta) {
        return _proposta.compareTo(proposta);
    }

    @Override
    public int hashCode() {
        return _proposta.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> toCacheModel() {
        return _proposta.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta toEscapedModel() {
        return new PropostaWrapper(_proposta.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _proposta.toString();
    }

    public java.lang.String toXmlString() {
        return _proposta.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _proposta.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Proposta getWrappedProposta() {
        return _proposta;
    }

    public Proposta getWrappedModel() {
        return _proposta;
    }

    public void resetOriginalValues() {
        _proposta.resetOriginalValues();
    }
}

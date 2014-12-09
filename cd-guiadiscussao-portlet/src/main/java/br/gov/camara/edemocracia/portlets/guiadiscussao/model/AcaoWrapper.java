package br.gov.camara.edemocracia.portlets.guiadiscussao.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Acao}.
 * </p>
 *
 * @author    Robson
 * @see       Acao
 * @generated
 */
public class AcaoWrapper implements Acao, ModelWrapper<Acao> {
    private Acao _acao;

    public AcaoWrapper(Acao acao) {
        _acao = acao;
    }

    public Class<?> getModelClass() {
        return Acao.class;
    }

    public String getModelClassName() {
        return Acao.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("acaoId", getAcaoId());
        attributes.put("faseId", getFaseId());
        attributes.put("ordem", getOrdem());
        attributes.put("texto", getTexto());
        attributes.put("urlExterna", getUrlExterna());
        attributes.put("urlLink", getUrlLink());
        attributes.put("iconeId", getIconeId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long acaoId = (Long) attributes.get("acaoId");

        if (acaoId != null) {
            setAcaoId(acaoId);
        }

        Long faseId = (Long) attributes.get("faseId");

        if (faseId != null) {
            setFaseId(faseId);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        Boolean urlExterna = (Boolean) attributes.get("urlExterna");

        if (urlExterna != null) {
            setUrlExterna(urlExterna);
        }

        String urlLink = (String) attributes.get("urlLink");

        if (urlLink != null) {
            setUrlLink(urlLink);
        }

        Long iconeId = (Long) attributes.get("iconeId");

        if (iconeId != null) {
            setIconeId(iconeId);
        }
    }

    /**
    * Returns the primary key of this acao.
    *
    * @return the primary key of this acao
    */
    public long getPrimaryKey() {
        return _acao.getPrimaryKey();
    }

    /**
    * Sets the primary key of this acao.
    *
    * @param primaryKey the primary key of this acao
    */
    public void setPrimaryKey(long primaryKey) {
        _acao.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the acao ID of this acao.
    *
    * @return the acao ID of this acao
    */
    public long getAcaoId() {
        return _acao.getAcaoId();
    }

    /**
    * Sets the acao ID of this acao.
    *
    * @param acaoId the acao ID of this acao
    */
    public void setAcaoId(long acaoId) {
        _acao.setAcaoId(acaoId);
    }

    /**
    * Returns the fase ID of this acao.
    *
    * @return the fase ID of this acao
    */
    public long getFaseId() {
        return _acao.getFaseId();
    }

    /**
    * Sets the fase ID of this acao.
    *
    * @param faseId the fase ID of this acao
    */
    public void setFaseId(long faseId) {
        _acao.setFaseId(faseId);
    }

    /**
    * Returns the ordem of this acao.
    *
    * @return the ordem of this acao
    */
    public int getOrdem() {
        return _acao.getOrdem();
    }

    /**
    * Sets the ordem of this acao.
    *
    * @param ordem the ordem of this acao
    */
    public void setOrdem(int ordem) {
        _acao.setOrdem(ordem);
    }

    /**
    * Returns the texto of this acao.
    *
    * @return the texto of this acao
    */
    public java.lang.String getTexto() {
        return _acao.getTexto();
    }

    /**
    * Sets the texto of this acao.
    *
    * @param texto the texto of this acao
    */
    public void setTexto(java.lang.String texto) {
        _acao.setTexto(texto);
    }

    /**
    * Returns the url externa of this acao.
    *
    * @return the url externa of this acao
    */
    public boolean getUrlExterna() {
        return _acao.getUrlExterna();
    }

    /**
    * Returns <code>true</code> if this acao is url externa.
    *
    * @return <code>true</code> if this acao is url externa; <code>false</code> otherwise
    */
    public boolean isUrlExterna() {
        return _acao.isUrlExterna();
    }

    /**
    * Sets whether this acao is url externa.
    *
    * @param urlExterna the url externa of this acao
    */
    public void setUrlExterna(boolean urlExterna) {
        _acao.setUrlExterna(urlExterna);
    }

    /**
    * Returns the url link of this acao.
    *
    * @return the url link of this acao
    */
    public java.lang.String getUrlLink() {
        return _acao.getUrlLink();
    }

    /**
    * Sets the url link of this acao.
    *
    * @param urlLink the url link of this acao
    */
    public void setUrlLink(java.lang.String urlLink) {
        _acao.setUrlLink(urlLink);
    }

    /**
    * Returns the icone ID of this acao.
    *
    * @return the icone ID of this acao
    */
    public long getIconeId() {
        return _acao.getIconeId();
    }

    /**
    * Sets the icone ID of this acao.
    *
    * @param iconeId the icone ID of this acao
    */
    public void setIconeId(long iconeId) {
        _acao.setIconeId(iconeId);
    }

    public boolean isNew() {
        return _acao.isNew();
    }

    public void setNew(boolean n) {
        _acao.setNew(n);
    }

    public boolean isCachedModel() {
        return _acao.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _acao.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _acao.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _acao.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _acao.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _acao.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _acao.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AcaoWrapper((Acao) _acao.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao) {
        return _acao.compareTo(acao);
    }

    @Override
    public int hashCode() {
        return _acao.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> toCacheModel() {
        return _acao.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao toEscapedModel() {
        return new AcaoWrapper(_acao.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _acao.toString();
    }

    public java.lang.String toXmlString() {
        return _acao.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _acao.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Acao getWrappedAcao() {
        return _acao;
    }

    public Acao getWrappedModel() {
        return _acao;
    }

    public void resetOriginalValues() {
        _acao.resetOriginalValues();
    }
}

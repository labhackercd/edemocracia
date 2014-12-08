package br.gov.camara.edemocracia.portlets.wikilegis.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contribuicao}.
 * </p>
 *
 * @author    robson
 * @see       Contribuicao
 * @generated
 */
public class ContribuicaoWrapper implements Contribuicao,
    ModelWrapper<Contribuicao> {
    private Contribuicao _contribuicao;

    public ContribuicaoWrapper(Contribuicao contribuicao) {
        _contribuicao = contribuicao;
    }

    public Class<?> getModelClass() {
        return Contribuicao.class;
    }

    public String getModelClassName() {
        return Contribuicao.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contribuicaoId", getContribuicaoId());
        attributes.put("artigoId", getArtigoId());
        attributes.put("texto", getTexto());
        attributes.put("descricao", getDescricao());
        attributes.put("data", getData());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long contribuicaoId = (Long) attributes.get("contribuicaoId");

        if (contribuicaoId != null) {
            setContribuicaoId(contribuicaoId);
        }

        Long artigoId = (Long) attributes.get("artigoId");

        if (artigoId != null) {
            setArtigoId(artigoId);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        String descricao = (String) attributes.get("descricao");

        if (descricao != null) {
            setDescricao(descricao);
        }

        Date data = (Date) attributes.get("data");

        if (data != null) {
            setData(data);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }
    }

    /**
    * Returns the primary key of this contribuicao.
    *
    * @return the primary key of this contribuicao
    */
    public long getPrimaryKey() {
        return _contribuicao.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contribuicao.
    *
    * @param primaryKey the primary key of this contribuicao
    */
    public void setPrimaryKey(long primaryKey) {
        _contribuicao.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contribuicao ID of this contribuicao.
    *
    * @return the contribuicao ID of this contribuicao
    */
    public long getContribuicaoId() {
        return _contribuicao.getContribuicaoId();
    }

    /**
    * Sets the contribuicao ID of this contribuicao.
    *
    * @param contribuicaoId the contribuicao ID of this contribuicao
    */
    public void setContribuicaoId(long contribuicaoId) {
        _contribuicao.setContribuicaoId(contribuicaoId);
    }

    /**
    * Returns the artigo ID of this contribuicao.
    *
    * @return the artigo ID of this contribuicao
    */
    public long getArtigoId() {
        return _contribuicao.getArtigoId();
    }

    /**
    * Sets the artigo ID of this contribuicao.
    *
    * @param artigoId the artigo ID of this contribuicao
    */
    public void setArtigoId(long artigoId) {
        _contribuicao.setArtigoId(artigoId);
    }

    /**
    * Returns the texto of this contribuicao.
    *
    * @return the texto of this contribuicao
    */
    public java.lang.String getTexto() {
        return _contribuicao.getTexto();
    }

    /**
    * Sets the texto of this contribuicao.
    *
    * @param texto the texto of this contribuicao
    */
    public void setTexto(java.lang.String texto) {
        _contribuicao.setTexto(texto);
    }

    /**
    * Returns the descricao of this contribuicao.
    *
    * @return the descricao of this contribuicao
    */
    public java.lang.String getDescricao() {
        return _contribuicao.getDescricao();
    }

    /**
    * Sets the descricao of this contribuicao.
    *
    * @param descricao the descricao of this contribuicao
    */
    public void setDescricao(java.lang.String descricao) {
        _contribuicao.setDescricao(descricao);
    }

    /**
    * Returns the data of this contribuicao.
    *
    * @return the data of this contribuicao
    */
    public java.util.Date getData() {
        return _contribuicao.getData();
    }

    /**
    * Sets the data of this contribuicao.
    *
    * @param data the data of this contribuicao
    */
    public void setData(java.util.Date data) {
        _contribuicao.setData(data);
    }

    /**
    * Returns the user ID of this contribuicao.
    *
    * @return the user ID of this contribuicao
    */
    public long getUserId() {
        return _contribuicao.getUserId();
    }

    /**
    * Sets the user ID of this contribuicao.
    *
    * @param userId the user ID of this contribuicao
    */
    public void setUserId(long userId) {
        _contribuicao.setUserId(userId);
    }

    /**
    * Returns the user uuid of this contribuicao.
    *
    * @return the user uuid of this contribuicao
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicao.getUserUuid();
    }

    /**
    * Sets the user uuid of this contribuicao.
    *
    * @param userUuid the user uuid of this contribuicao
    */
    public void setUserUuid(java.lang.String userUuid) {
        _contribuicao.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this contribuicao.
    *
    * @return the user name of this contribuicao
    */
    public java.lang.String getUserName() {
        return _contribuicao.getUserName();
    }

    /**
    * Sets the user name of this contribuicao.
    *
    * @param userName the user name of this contribuicao
    */
    public void setUserName(java.lang.String userName) {
        _contribuicao.setUserName(userName);
    }

    public boolean isNew() {
        return _contribuicao.isNew();
    }

    public void setNew(boolean n) {
        _contribuicao.setNew(n);
    }

    public boolean isCachedModel() {
        return _contribuicao.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _contribuicao.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _contribuicao.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _contribuicao.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contribuicao.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contribuicao.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contribuicao.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContribuicaoWrapper((Contribuicao) _contribuicao.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao) {
        return _contribuicao.compareTo(contribuicao);
    }

    @Override
    public int hashCode() {
        return _contribuicao.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> toCacheModel() {
        return _contribuicao.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao toEscapedModel() {
        return new ContribuicaoWrapper(_contribuicao.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contribuicao.toString();
    }

    public java.lang.String toXmlString() {
        return _contribuicao.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contribuicao.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Contribuicao getWrappedContribuicao() {
        return _contribuicao;
    }

    public Contribuicao getWrappedModel() {
        return _contribuicao;
    }

    public void resetOriginalValues() {
        _contribuicao.resetOriginalValues();
    }
}

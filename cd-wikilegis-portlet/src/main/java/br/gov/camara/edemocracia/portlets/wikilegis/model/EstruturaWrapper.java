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
package br.gov.camara.edemocracia.portlets.wikilegis.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Estrutura}.
 * </p>
 *
 * @author    robson
 * @see       Estrutura
 * @generated
 */
public class EstruturaWrapper implements Estrutura, ModelWrapper<Estrutura> {
    private Estrutura _estrutura;

    public EstruturaWrapper(Estrutura estrutura) {
        _estrutura = estrutura;
    }

    public Class<?> getModelClass() {
        return Estrutura.class;
    }

    public String getModelClassName() {
        return Estrutura.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("estruturaId", getEstruturaId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("texto", getTexto());
        attributes.put("ordem", getOrdem());
        attributes.put("paiEstruturaId", getPaiEstruturaId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long estruturaId = (Long) attributes.get("estruturaId");

        if (estruturaId != null) {
            setEstruturaId(estruturaId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }

        Long paiEstruturaId = (Long) attributes.get("paiEstruturaId");

        if (paiEstruturaId != null) {
            setPaiEstruturaId(paiEstruturaId);
        }
    }

    /**
    * Returns the primary key of this estrutura.
    *
    * @return the primary key of this estrutura
    */
    public long getPrimaryKey() {
        return _estrutura.getPrimaryKey();
    }

    /**
    * Sets the primary key of this estrutura.
    *
    * @param primaryKey the primary key of this estrutura
    */
    public void setPrimaryKey(long primaryKey) {
        _estrutura.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the estrutura ID of this estrutura.
    *
    * @return the estrutura ID of this estrutura
    */
    public long getEstruturaId() {
        return _estrutura.getEstruturaId();
    }

    /**
    * Sets the estrutura ID of this estrutura.
    *
    * @param estruturaId the estrutura ID of this estrutura
    */
    public void setEstruturaId(long estruturaId) {
        _estrutura.setEstruturaId(estruturaId);
    }

    /**
    * Returns the company ID of this estrutura.
    *
    * @return the company ID of this estrutura
    */
    public long getCompanyId() {
        return _estrutura.getCompanyId();
    }

    /**
    * Sets the company ID of this estrutura.
    *
    * @param companyId the company ID of this estrutura
    */
    public void setCompanyId(long companyId) {
        _estrutura.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this estrutura.
    *
    * @return the group ID of this estrutura
    */
    public long getGroupId() {
        return _estrutura.getGroupId();
    }

    /**
    * Sets the group ID of this estrutura.
    *
    * @param groupId the group ID of this estrutura
    */
    public void setGroupId(long groupId) {
        _estrutura.setGroupId(groupId);
    }

    /**
    * Returns the texto of this estrutura.
    *
    * @return the texto of this estrutura
    */
    public java.lang.String getTexto() {
        return _estrutura.getTexto();
    }

    /**
    * Sets the texto of this estrutura.
    *
    * @param texto the texto of this estrutura
    */
    public void setTexto(java.lang.String texto) {
        _estrutura.setTexto(texto);
    }

    /**
    * Returns the ordem of this estrutura.
    *
    * @return the ordem of this estrutura
    */
    public int getOrdem() {
        return _estrutura.getOrdem();
    }

    /**
    * Sets the ordem of this estrutura.
    *
    * @param ordem the ordem of this estrutura
    */
    public void setOrdem(int ordem) {
        _estrutura.setOrdem(ordem);
    }

    /**
    * Returns the pai estrutura ID of this estrutura.
    *
    * @return the pai estrutura ID of this estrutura
    */
    public long getPaiEstruturaId() {
        return _estrutura.getPaiEstruturaId();
    }

    /**
    * Sets the pai estrutura ID of this estrutura.
    *
    * @param paiEstruturaId the pai estrutura ID of this estrutura
    */
    public void setPaiEstruturaId(long paiEstruturaId) {
        _estrutura.setPaiEstruturaId(paiEstruturaId);
    }

    public boolean isNew() {
        return _estrutura.isNew();
    }

    public void setNew(boolean n) {
        _estrutura.setNew(n);
    }

    public boolean isCachedModel() {
        return _estrutura.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _estrutura.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _estrutura.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _estrutura.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _estrutura.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _estrutura.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _estrutura.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EstruturaWrapper((Estrutura) _estrutura.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura) {
        return _estrutura.compareTo(estrutura);
    }

    @Override
    public int hashCode() {
        return _estrutura.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> toCacheModel() {
        return _estrutura.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura toEscapedModel() {
        return new EstruturaWrapper(_estrutura.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _estrutura.toString();
    }

    public java.lang.String toXmlString() {
        return _estrutura.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _estrutura.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Estrutura getWrappedEstrutura() {
        return _estrutura;
    }

    public Estrutura getWrappedModel() {
        return _estrutura;
    }

    public void resetOriginalValues() {
        _estrutura.resetOriginalValues();
    }
}

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
package br.gov.camara.edemocracia.portlets.priorizacao.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Eixo}.
 * </p>
 *
 * @author    robson
 * @see       Eixo
 * @generated
 */
public class EixoWrapper implements Eixo, ModelWrapper<Eixo> {
    private Eixo _eixo;

    public EixoWrapper(Eixo eixo) {
        _eixo = eixo;
    }

    public Class<?> getModelClass() {
        return Eixo.class;
    }

    public String getModelClassName() {
        return Eixo.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("eixoId", getEixoId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("titulo", getTitulo());
        attributes.put("sumario", getSumario());
        attributes.put("ordem", getOrdem());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long eixoId = (Long) attributes.get("eixoId");

        if (eixoId != null) {
            setEixoId(eixoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String titulo = (String) attributes.get("titulo");

        if (titulo != null) {
            setTitulo(titulo);
        }

        String sumario = (String) attributes.get("sumario");

        if (sumario != null) {
            setSumario(sumario);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }
    }

    /**
    * Returns the primary key of this eixo.
    *
    * @return the primary key of this eixo
    */
    public long getPrimaryKey() {
        return _eixo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this eixo.
    *
    * @param primaryKey the primary key of this eixo
    */
    public void setPrimaryKey(long primaryKey) {
        _eixo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the eixo ID of this eixo.
    *
    * @return the eixo ID of this eixo
    */
    public long getEixoId() {
        return _eixo.getEixoId();
    }

    /**
    * Sets the eixo ID of this eixo.
    *
    * @param eixoId the eixo ID of this eixo
    */
    public void setEixoId(long eixoId) {
        _eixo.setEixoId(eixoId);
    }

    /**
    * Returns the company ID of this eixo.
    *
    * @return the company ID of this eixo
    */
    public long getCompanyId() {
        return _eixo.getCompanyId();
    }

    /**
    * Sets the company ID of this eixo.
    *
    * @param companyId the company ID of this eixo
    */
    public void setCompanyId(long companyId) {
        _eixo.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this eixo.
    *
    * @return the group ID of this eixo
    */
    public long getGroupId() {
        return _eixo.getGroupId();
    }

    /**
    * Sets the group ID of this eixo.
    *
    * @param groupId the group ID of this eixo
    */
    public void setGroupId(long groupId) {
        _eixo.setGroupId(groupId);
    }

    /**
    * Returns the category ID of this eixo.
    *
    * @return the category ID of this eixo
    */
    public long getCategoryId() {
        return _eixo.getCategoryId();
    }

    /**
    * Sets the category ID of this eixo.
    *
    * @param categoryId the category ID of this eixo
    */
    public void setCategoryId(long categoryId) {
        _eixo.setCategoryId(categoryId);
    }

    /**
    * Returns the titulo of this eixo.
    *
    * @return the titulo of this eixo
    */
    public java.lang.String getTitulo() {
        return _eixo.getTitulo();
    }

    /**
    * Sets the titulo of this eixo.
    *
    * @param titulo the titulo of this eixo
    */
    public void setTitulo(java.lang.String titulo) {
        _eixo.setTitulo(titulo);
    }

    /**
    * Returns the sumario of this eixo.
    *
    * @return the sumario of this eixo
    */
    public java.lang.String getSumario() {
        return _eixo.getSumario();
    }

    /**
    * Sets the sumario of this eixo.
    *
    * @param sumario the sumario of this eixo
    */
    public void setSumario(java.lang.String sumario) {
        _eixo.setSumario(sumario);
    }

    /**
    * Returns the ordem of this eixo.
    *
    * @return the ordem of this eixo
    */
    public int getOrdem() {
        return _eixo.getOrdem();
    }

    /**
    * Sets the ordem of this eixo.
    *
    * @param ordem the ordem of this eixo
    */
    public void setOrdem(int ordem) {
        _eixo.setOrdem(ordem);
    }

    public boolean isNew() {
        return _eixo.isNew();
    }

    public void setNew(boolean n) {
        _eixo.setNew(n);
    }

    public boolean isCachedModel() {
        return _eixo.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _eixo.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _eixo.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _eixo.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _eixo.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _eixo.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _eixo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EixoWrapper((Eixo) _eixo.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo) {
        return _eixo.compareTo(eixo);
    }

    @Override
    public int hashCode() {
        return _eixo.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> toCacheModel() {
        return _eixo.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo toEscapedModel() {
        return new EixoWrapper(_eixo.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _eixo.toString();
    }

    public java.lang.String toXmlString() {
        return _eixo.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eixo.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Eixo getWrappedEixo() {
        return _eixo;
    }

    public Eixo getWrappedModel() {
        return _eixo;
    }

    public void resetOriginalValues() {
        _eixo.resetOriginalValues();
    }
}

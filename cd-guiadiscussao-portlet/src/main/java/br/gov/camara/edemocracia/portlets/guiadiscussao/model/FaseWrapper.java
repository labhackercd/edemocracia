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
package br.gov.camara.edemocracia.portlets.guiadiscussao.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Fase}.
 * </p>
 *
 * @author    Robson
 * @see       Fase
 * @generated
 */
public class FaseWrapper implements Fase, ModelWrapper<Fase> {
    private Fase _fase;

    public FaseWrapper(Fase fase) {
        _fase = fase;
    }

    public Class<?> getModelClass() {
        return Fase.class;
    }

    public String getModelClassName() {
        return Fase.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("faseId", getFaseId());
        attributes.put("configuracaoId", getConfiguracaoId());
        attributes.put("ordem", getOrdem());
        attributes.put("titulo", getTitulo());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long faseId = (Long) attributes.get("faseId");

        if (faseId != null) {
            setFaseId(faseId);
        }

        Long configuracaoId = (Long) attributes.get("configuracaoId");

        if (configuracaoId != null) {
            setConfiguracaoId(configuracaoId);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }

        String titulo = (String) attributes.get("titulo");

        if (titulo != null) {
            setTitulo(titulo);
        }
    }

    /**
    * Returns the primary key of this fase.
    *
    * @return the primary key of this fase
    */
    public long getPrimaryKey() {
        return _fase.getPrimaryKey();
    }

    /**
    * Sets the primary key of this fase.
    *
    * @param primaryKey the primary key of this fase
    */
    public void setPrimaryKey(long primaryKey) {
        _fase.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the fase ID of this fase.
    *
    * @return the fase ID of this fase
    */
    public long getFaseId() {
        return _fase.getFaseId();
    }

    /**
    * Sets the fase ID of this fase.
    *
    * @param faseId the fase ID of this fase
    */
    public void setFaseId(long faseId) {
        _fase.setFaseId(faseId);
    }

    /**
    * Returns the configuracao ID of this fase.
    *
    * @return the configuracao ID of this fase
    */
    public long getConfiguracaoId() {
        return _fase.getConfiguracaoId();
    }

    /**
    * Sets the configuracao ID of this fase.
    *
    * @param configuracaoId the configuracao ID of this fase
    */
    public void setConfiguracaoId(long configuracaoId) {
        _fase.setConfiguracaoId(configuracaoId);
    }

    /**
    * Returns the ordem of this fase.
    *
    * @return the ordem of this fase
    */
    public int getOrdem() {
        return _fase.getOrdem();
    }

    /**
    * Sets the ordem of this fase.
    *
    * @param ordem the ordem of this fase
    */
    public void setOrdem(int ordem) {
        _fase.setOrdem(ordem);
    }

    /**
    * Returns the titulo of this fase.
    *
    * @return the titulo of this fase
    */
    public java.lang.String getTitulo() {
        return _fase.getTitulo();
    }

    /**
    * Sets the titulo of this fase.
    *
    * @param titulo the titulo of this fase
    */
    public void setTitulo(java.lang.String titulo) {
        _fase.setTitulo(titulo);
    }

    public boolean isNew() {
        return _fase.isNew();
    }

    public void setNew(boolean n) {
        _fase.setNew(n);
    }

    public boolean isCachedModel() {
        return _fase.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _fase.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _fase.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _fase.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _fase.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _fase.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _fase.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FaseWrapper((Fase) _fase.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase) {
        return _fase.compareTo(fase);
    }

    @Override
    public int hashCode() {
        return _fase.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> toCacheModel() {
        return _fase.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase toEscapedModel() {
        return new FaseWrapper(_fase.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _fase.toString();
    }

    public java.lang.String toXmlString() {
        return _fase.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _fase.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Fase getWrappedFase() {
        return _fase;
    }

    public Fase getWrappedModel() {
        return _fase;
    }

    public void resetOriginalValues() {
        _fase.resetOriginalValues();
    }
}

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
package br.gov.camara.edemocracia.portlets.graficos.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContadorAcesso}.
 * </p>
 *
 * @author    Robson Miranda
 * @see       ContadorAcesso
 * @generated
 */
public class ContadorAcessoWrapper implements ContadorAcesso,
    ModelWrapper<ContadorAcesso> {
    private ContadorAcesso _contadorAcesso;

    public ContadorAcessoWrapper(ContadorAcesso contadorAcesso) {
        _contadorAcesso = contadorAcesso;
    }

    public Class<?> getModelClass() {
        return ContadorAcesso.class;
    }

    public String getModelClassName() {
        return ContadorAcesso.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contadorId", getContadorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("data", getData());
        attributes.put("dataAtualizacao", getDataAtualizacao());
        attributes.put("cache", getCache());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long contadorId = (Long) attributes.get("contadorId");

        if (contadorId != null) {
            setContadorId(contadorId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Date data = (Date) attributes.get("data");

        if (data != null) {
            setData(data);
        }

        Date dataAtualizacao = (Date) attributes.get("dataAtualizacao");

        if (dataAtualizacao != null) {
            setDataAtualizacao(dataAtualizacao);
        }

        String cache = (String) attributes.get("cache");

        if (cache != null) {
            setCache(cache);
        }
    }

    /**
    * Returns the primary key of this contador acesso.
    *
    * @return the primary key of this contador acesso
    */
    public long getPrimaryKey() {
        return _contadorAcesso.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contador acesso.
    *
    * @param primaryKey the primary key of this contador acesso
    */
    public void setPrimaryKey(long primaryKey) {
        _contadorAcesso.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contador ID of this contador acesso.
    *
    * @return the contador ID of this contador acesso
    */
    public long getContadorId() {
        return _contadorAcesso.getContadorId();
    }

    /**
    * Sets the contador ID of this contador acesso.
    *
    * @param contadorId the contador ID of this contador acesso
    */
    public void setContadorId(long contadorId) {
        _contadorAcesso.setContadorId(contadorId);
    }

    /**
    * Returns the company ID of this contador acesso.
    *
    * @return the company ID of this contador acesso
    */
    public long getCompanyId() {
        return _contadorAcesso.getCompanyId();
    }

    /**
    * Sets the company ID of this contador acesso.
    *
    * @param companyId the company ID of this contador acesso
    */
    public void setCompanyId(long companyId) {
        _contadorAcesso.setCompanyId(companyId);
    }

    /**
    * Returns the data of this contador acesso.
    *
    * @return the data of this contador acesso
    */
    public java.util.Date getData() {
        return _contadorAcesso.getData();
    }

    /**
    * Sets the data of this contador acesso.
    *
    * @param data the data of this contador acesso
    */
    public void setData(java.util.Date data) {
        _contadorAcesso.setData(data);
    }

    /**
    * Returns the data atualizacao of this contador acesso.
    *
    * @return the data atualizacao of this contador acesso
    */
    public java.util.Date getDataAtualizacao() {
        return _contadorAcesso.getDataAtualizacao();
    }

    /**
    * Sets the data atualizacao of this contador acesso.
    *
    * @param dataAtualizacao the data atualizacao of this contador acesso
    */
    public void setDataAtualizacao(java.util.Date dataAtualizacao) {
        _contadorAcesso.setDataAtualizacao(dataAtualizacao);
    }

    /**
    * Returns the cache of this contador acesso.
    *
    * @return the cache of this contador acesso
    */
    public java.lang.String getCache() {
        return _contadorAcesso.getCache();
    }

    /**
    * Sets the cache of this contador acesso.
    *
    * @param cache the cache of this contador acesso
    */
    public void setCache(java.lang.String cache) {
        _contadorAcesso.setCache(cache);
    }

    public boolean isNew() {
        return _contadorAcesso.isNew();
    }

    public void setNew(boolean n) {
        _contadorAcesso.setNew(n);
    }

    public boolean isCachedModel() {
        return _contadorAcesso.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _contadorAcesso.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _contadorAcesso.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _contadorAcesso.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contadorAcesso.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contadorAcesso.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contadorAcesso.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContadorAcessoWrapper((ContadorAcesso) _contadorAcesso.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso) {
        return _contadorAcesso.compareTo(contadorAcesso);
    }

    @Override
    public int hashCode() {
        return _contadorAcesso.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> toCacheModel() {
        return _contadorAcesso.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso toEscapedModel() {
        return new ContadorAcessoWrapper(_contadorAcesso.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contadorAcesso.toString();
    }

    public java.lang.String toXmlString() {
        return _contadorAcesso.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contadorAcesso.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ContadorAcesso getWrappedContadorAcesso() {
        return _contadorAcesso;
    }

    public ContadorAcesso getWrappedModel() {
        return _contadorAcesso;
    }

    public void resetOriginalValues() {
        _contadorAcesso.resetOriginalValues();
    }
}

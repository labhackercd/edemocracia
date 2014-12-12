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
 * This class is a wrapper for {@link Artigo}.
 * </p>
 *
 * @author    robson
 * @see       Artigo
 * @generated
 */
public class ArtigoWrapper implements Artigo, ModelWrapper<Artigo> {
    private Artigo _artigo;

    public ArtigoWrapper(Artigo artigo) {
        _artigo = artigo;
    }

    public Class<?> getModelClass() {
        return Artigo.class;
    }

    public String getModelClassName() {
        return Artigo.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("artigoId", getArtigoId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("estruturaId", getEstruturaId());
        attributes.put("ordem", getOrdem());
        attributes.put("texto", getTexto());
        attributes.put("legislacaoVigente", getLegislacaoVigente());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long artigoId = (Long) attributes.get("artigoId");

        if (artigoId != null) {
            setArtigoId(artigoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long estruturaId = (Long) attributes.get("estruturaId");

        if (estruturaId != null) {
            setEstruturaId(estruturaId);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        String legislacaoVigente = (String) attributes.get("legislacaoVigente");

        if (legislacaoVigente != null) {
            setLegislacaoVigente(legislacaoVigente);
        }
    }

    /**
    * Returns the primary key of this artigo.
    *
    * @return the primary key of this artigo
    */
    public long getPrimaryKey() {
        return _artigo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this artigo.
    *
    * @param primaryKey the primary key of this artigo
    */
    public void setPrimaryKey(long primaryKey) {
        _artigo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the artigo ID of this artigo.
    *
    * @return the artigo ID of this artigo
    */
    public long getArtigoId() {
        return _artigo.getArtigoId();
    }

    /**
    * Sets the artigo ID of this artigo.
    *
    * @param artigoId the artigo ID of this artigo
    */
    public void setArtigoId(long artigoId) {
        _artigo.setArtigoId(artigoId);
    }

    /**
    * Returns the company ID of this artigo.
    *
    * @return the company ID of this artigo
    */
    public long getCompanyId() {
        return _artigo.getCompanyId();
    }

    /**
    * Sets the company ID of this artigo.
    *
    * @param companyId the company ID of this artigo
    */
    public void setCompanyId(long companyId) {
        _artigo.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this artigo.
    *
    * @return the group ID of this artigo
    */
    public long getGroupId() {
        return _artigo.getGroupId();
    }

    /**
    * Sets the group ID of this artigo.
    *
    * @param groupId the group ID of this artigo
    */
    public void setGroupId(long groupId) {
        _artigo.setGroupId(groupId);
    }

    /**
    * Returns the estrutura ID of this artigo.
    *
    * @return the estrutura ID of this artigo
    */
    public long getEstruturaId() {
        return _artigo.getEstruturaId();
    }

    /**
    * Sets the estrutura ID of this artigo.
    *
    * @param estruturaId the estrutura ID of this artigo
    */
    public void setEstruturaId(long estruturaId) {
        _artigo.setEstruturaId(estruturaId);
    }

    /**
    * Returns the ordem of this artigo.
    *
    * @return the ordem of this artigo
    */
    public int getOrdem() {
        return _artigo.getOrdem();
    }

    /**
    * Sets the ordem of this artigo.
    *
    * @param ordem the ordem of this artigo
    */
    public void setOrdem(int ordem) {
        _artigo.setOrdem(ordem);
    }

    /**
    * Returns the texto of this artigo.
    *
    * @return the texto of this artigo
    */
    public java.lang.String getTexto() {
        return _artigo.getTexto();
    }

    /**
    * Sets the texto of this artigo.
    *
    * @param texto the texto of this artigo
    */
    public void setTexto(java.lang.String texto) {
        _artigo.setTexto(texto);
    }

    /**
    * Returns the legislacao vigente of this artigo.
    *
    * @return the legislacao vigente of this artigo
    */
    public java.lang.String getLegislacaoVigente() {
        return _artigo.getLegislacaoVigente();
    }

    /**
    * Sets the legislacao vigente of this artigo.
    *
    * @param legislacaoVigente the legislacao vigente of this artigo
    */
    public void setLegislacaoVigente(java.lang.String legislacaoVigente) {
        _artigo.setLegislacaoVigente(legislacaoVigente);
    }

    public boolean isNew() {
        return _artigo.isNew();
    }

    public void setNew(boolean n) {
        _artigo.setNew(n);
    }

    public boolean isCachedModel() {
        return _artigo.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _artigo.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _artigo.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _artigo.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _artigo.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _artigo.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _artigo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ArtigoWrapper((Artigo) _artigo.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo) {
        return _artigo.compareTo(artigo);
    }

    @Override
    public int hashCode() {
        return _artigo.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> toCacheModel() {
        return _artigo.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo toEscapedModel() {
        return new ArtigoWrapper(_artigo.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _artigo.toString();
    }

    public java.lang.String toXmlString() {
        return _artigo.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _artigo.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Artigo getWrappedArtigo() {
        return _artigo;
    }

    public Artigo getWrappedModel() {
        return _artigo;
    }

    public void resetOriginalValues() {
        _artigo.resetOriginalValues();
    }
}

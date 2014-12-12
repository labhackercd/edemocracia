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
 * This class is a wrapper for {@link Configuracao}.
 * </p>
 *
 * @author    Robson
 * @see       Configuracao
 * @generated
 */
public class ConfiguracaoWrapper implements Configuracao,
    ModelWrapper<Configuracao> {
    private Configuracao _configuracao;

    public ConfiguracaoWrapper(Configuracao configuracao) {
        _configuracao = configuracao;
    }

    public Class<?> getModelClass() {
        return Configuracao.class;
    }

    public String getModelClassName() {
        return Configuracao.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("configuracaoId", getConfiguracaoId());
        attributes.put("groupId", getGroupId());
        attributes.put("faseAtualId", getFaseAtualId());
        attributes.put("textoBanner", getTextoBanner());
        attributes.put("imagemIdBanner", getImagemIdBanner());
        attributes.put("urlBanner", getUrlBanner());
        attributes.put("urlExterna", getUrlExterna());
        attributes.put("tituloBanner", getTituloBanner());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long configuracaoId = (Long) attributes.get("configuracaoId");

        if (configuracaoId != null) {
            setConfiguracaoId(configuracaoId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long faseAtualId = (Long) attributes.get("faseAtualId");

        if (faseAtualId != null) {
            setFaseAtualId(faseAtualId);
        }

        String textoBanner = (String) attributes.get("textoBanner");

        if (textoBanner != null) {
            setTextoBanner(textoBanner);
        }

        Long imagemIdBanner = (Long) attributes.get("imagemIdBanner");

        if (imagemIdBanner != null) {
            setImagemIdBanner(imagemIdBanner);
        }

        String urlBanner = (String) attributes.get("urlBanner");

        if (urlBanner != null) {
            setUrlBanner(urlBanner);
        }

        Boolean urlExterna = (Boolean) attributes.get("urlExterna");

        if (urlExterna != null) {
            setUrlExterna(urlExterna);
        }

        String tituloBanner = (String) attributes.get("tituloBanner");

        if (tituloBanner != null) {
            setTituloBanner(tituloBanner);
        }
    }

    /**
    * Returns the primary key of this configuracao.
    *
    * @return the primary key of this configuracao
    */
    public long getPrimaryKey() {
        return _configuracao.getPrimaryKey();
    }

    /**
    * Sets the primary key of this configuracao.
    *
    * @param primaryKey the primary key of this configuracao
    */
    public void setPrimaryKey(long primaryKey) {
        _configuracao.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the configuracao ID of this configuracao.
    *
    * @return the configuracao ID of this configuracao
    */
    public long getConfiguracaoId() {
        return _configuracao.getConfiguracaoId();
    }

    /**
    * Sets the configuracao ID of this configuracao.
    *
    * @param configuracaoId the configuracao ID of this configuracao
    */
    public void setConfiguracaoId(long configuracaoId) {
        _configuracao.setConfiguracaoId(configuracaoId);
    }

    /**
    * Returns the group ID of this configuracao.
    *
    * @return the group ID of this configuracao
    */
    public long getGroupId() {
        return _configuracao.getGroupId();
    }

    /**
    * Sets the group ID of this configuracao.
    *
    * @param groupId the group ID of this configuracao
    */
    public void setGroupId(long groupId) {
        _configuracao.setGroupId(groupId);
    }

    /**
    * Returns the fase atual ID of this configuracao.
    *
    * @return the fase atual ID of this configuracao
    */
    public long getFaseAtualId() {
        return _configuracao.getFaseAtualId();
    }

    /**
    * Sets the fase atual ID of this configuracao.
    *
    * @param faseAtualId the fase atual ID of this configuracao
    */
    public void setFaseAtualId(long faseAtualId) {
        _configuracao.setFaseAtualId(faseAtualId);
    }

    /**
    * Returns the texto banner of this configuracao.
    *
    * @return the texto banner of this configuracao
    */
    public java.lang.String getTextoBanner() {
        return _configuracao.getTextoBanner();
    }

    /**
    * Sets the texto banner of this configuracao.
    *
    * @param textoBanner the texto banner of this configuracao
    */
    public void setTextoBanner(java.lang.String textoBanner) {
        _configuracao.setTextoBanner(textoBanner);
    }

    /**
    * Returns the imagem ID banner of this configuracao.
    *
    * @return the imagem ID banner of this configuracao
    */
    public long getImagemIdBanner() {
        return _configuracao.getImagemIdBanner();
    }

    /**
    * Sets the imagem ID banner of this configuracao.
    *
    * @param imagemIdBanner the imagem ID banner of this configuracao
    */
    public void setImagemIdBanner(long imagemIdBanner) {
        _configuracao.setImagemIdBanner(imagemIdBanner);
    }

    /**
    * Returns the url banner of this configuracao.
    *
    * @return the url banner of this configuracao
    */
    public java.lang.String getUrlBanner() {
        return _configuracao.getUrlBanner();
    }

    /**
    * Sets the url banner of this configuracao.
    *
    * @param urlBanner the url banner of this configuracao
    */
    public void setUrlBanner(java.lang.String urlBanner) {
        _configuracao.setUrlBanner(urlBanner);
    }

    /**
    * Returns the url externa of this configuracao.
    *
    * @return the url externa of this configuracao
    */
    public boolean getUrlExterna() {
        return _configuracao.getUrlExterna();
    }

    /**
    * Returns <code>true</code> if this configuracao is url externa.
    *
    * @return <code>true</code> if this configuracao is url externa; <code>false</code> otherwise
    */
    public boolean isUrlExterna() {
        return _configuracao.isUrlExterna();
    }

    /**
    * Sets whether this configuracao is url externa.
    *
    * @param urlExterna the url externa of this configuracao
    */
    public void setUrlExterna(boolean urlExterna) {
        _configuracao.setUrlExterna(urlExterna);
    }

    /**
    * Returns the titulo banner of this configuracao.
    *
    * @return the titulo banner of this configuracao
    */
    public java.lang.String getTituloBanner() {
        return _configuracao.getTituloBanner();
    }

    /**
    * Sets the titulo banner of this configuracao.
    *
    * @param tituloBanner the titulo banner of this configuracao
    */
    public void setTituloBanner(java.lang.String tituloBanner) {
        _configuracao.setTituloBanner(tituloBanner);
    }

    public boolean isNew() {
        return _configuracao.isNew();
    }

    public void setNew(boolean n) {
        _configuracao.setNew(n);
    }

    public boolean isCachedModel() {
        return _configuracao.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _configuracao.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _configuracao.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _configuracao.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _configuracao.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _configuracao.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _configuracao.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ConfiguracaoWrapper((Configuracao) _configuracao.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao) {
        return _configuracao.compareTo(configuracao);
    }

    @Override
    public int hashCode() {
        return _configuracao.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao> toCacheModel() {
        return _configuracao.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao toEscapedModel() {
        return new ConfiguracaoWrapper(_configuracao.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _configuracao.toString();
    }

    public java.lang.String toXmlString() {
        return _configuracao.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _configuracao.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Configuracao getWrappedConfiguracao() {
        return _configuracao;
    }

    public Configuracao getWrappedModel() {
        return _configuracao;
    }

    public void resetOriginalValues() {
        _configuracao.resetOriginalValues();
    }
}

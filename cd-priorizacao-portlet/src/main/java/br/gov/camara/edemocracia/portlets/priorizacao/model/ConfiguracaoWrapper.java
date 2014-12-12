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
 * This class is a wrapper for {@link Configuracao}.
 * </p>
 *
 * @author    robson
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
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("maximoVotos", getMaximoVotos());
        attributes.put("maxVotosProposta", getMaxVotosProposta());
        attributes.put("votacaoAberta", getVotacaoAberta());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long configuracaoId = (Long) attributes.get("configuracaoId");

        if (configuracaoId != null) {
            setConfiguracaoId(configuracaoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Integer maximoVotos = (Integer) attributes.get("maximoVotos");

        if (maximoVotos != null) {
            setMaximoVotos(maximoVotos);
        }

        Integer maxVotosProposta = (Integer) attributes.get("maxVotosProposta");

        if (maxVotosProposta != null) {
            setMaxVotosProposta(maxVotosProposta);
        }

        Boolean votacaoAberta = (Boolean) attributes.get("votacaoAberta");

        if (votacaoAberta != null) {
            setVotacaoAberta(votacaoAberta);
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
    * Returns the company ID of this configuracao.
    *
    * @return the company ID of this configuracao
    */
    public long getCompanyId() {
        return _configuracao.getCompanyId();
    }

    /**
    * Sets the company ID of this configuracao.
    *
    * @param companyId the company ID of this configuracao
    */
    public void setCompanyId(long companyId) {
        _configuracao.setCompanyId(companyId);
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
    * Returns the maximo votos of this configuracao.
    *
    * @return the maximo votos of this configuracao
    */
    public int getMaximoVotos() {
        return _configuracao.getMaximoVotos();
    }

    /**
    * Sets the maximo votos of this configuracao.
    *
    * @param maximoVotos the maximo votos of this configuracao
    */
    public void setMaximoVotos(int maximoVotos) {
        _configuracao.setMaximoVotos(maximoVotos);
    }

    /**
    * Returns the max votos proposta of this configuracao.
    *
    * @return the max votos proposta of this configuracao
    */
    public int getMaxVotosProposta() {
        return _configuracao.getMaxVotosProposta();
    }

    /**
    * Sets the max votos proposta of this configuracao.
    *
    * @param maxVotosProposta the max votos proposta of this configuracao
    */
    public void setMaxVotosProposta(int maxVotosProposta) {
        _configuracao.setMaxVotosProposta(maxVotosProposta);
    }

    /**
    * Returns the votacao aberta of this configuracao.
    *
    * @return the votacao aberta of this configuracao
    */
    public boolean getVotacaoAberta() {
        return _configuracao.getVotacaoAberta();
    }

    /**
    * Returns <code>true</code> if this configuracao is votacao aberta.
    *
    * @return <code>true</code> if this configuracao is votacao aberta; <code>false</code> otherwise
    */
    public boolean isVotacaoAberta() {
        return _configuracao.isVotacaoAberta();
    }

    /**
    * Sets whether this configuracao is votacao aberta.
    *
    * @param votacaoAberta the votacao aberta of this configuracao
    */
    public void setVotacaoAberta(boolean votacaoAberta) {
        _configuracao.setVotacaoAberta(votacaoAberta);
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
        br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao configuracao) {
        return _configuracao.compareTo(configuracao);
    }

    @Override
    public int hashCode() {
        return _configuracao.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> toCacheModel() {
        return _configuracao.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao toEscapedModel() {
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

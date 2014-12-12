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

import br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class ConfiguracaoClp extends BaseModelImpl<Configuracao>
    implements Configuracao {
    private long _configuracaoId;
    private long _companyId;
    private long _groupId;
    private int _maximoVotos;
    private int _maxVotosProposta;
    private boolean _votacaoAberta;
    private BaseModel<?> _configuracaoRemoteModel;

    public ConfiguracaoClp() {
    }

    public Class<?> getModelClass() {
        return Configuracao.class;
    }

    public String getModelClassName() {
        return Configuracao.class.getName();
    }

    public long getPrimaryKey() {
        return _configuracaoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setConfiguracaoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_configuracaoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getConfiguracaoId() {
        return _configuracaoId;
    }

    public void setConfiguracaoId(long configuracaoId) {
        _configuracaoId = configuracaoId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public int getMaximoVotos() {
        return _maximoVotos;
    }

    public void setMaximoVotos(int maximoVotos) {
        _maximoVotos = maximoVotos;
    }

    public int getMaxVotosProposta() {
        return _maxVotosProposta;
    }

    public void setMaxVotosProposta(int maxVotosProposta) {
        _maxVotosProposta = maxVotosProposta;
    }

    public boolean getVotacaoAberta() {
        return _votacaoAberta;
    }

    public boolean isVotacaoAberta() {
        return _votacaoAberta;
    }

    public void setVotacaoAberta(boolean votacaoAberta) {
        _votacaoAberta = votacaoAberta;
    }

    public BaseModel<?> getConfiguracaoRemoteModel() {
        return _configuracaoRemoteModel;
    }

    public void setConfiguracaoRemoteModel(BaseModel<?> configuracaoRemoteModel) {
        _configuracaoRemoteModel = configuracaoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ConfiguracaoLocalServiceUtil.addConfiguracao(this);
        } else {
            ConfiguracaoLocalServiceUtil.updateConfiguracao(this);
        }
    }

    @Override
    public Configuracao toEscapedModel() {
        return (Configuracao) Proxy.newProxyInstance(Configuracao.class.getClassLoader(),
            new Class[] { Configuracao.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ConfiguracaoClp clone = new ConfiguracaoClp();

        clone.setConfiguracaoId(getConfiguracaoId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setMaximoVotos(getMaximoVotos());
        clone.setMaxVotosProposta(getMaxVotosProposta());
        clone.setVotacaoAberta(getVotacaoAberta());

        return clone;
    }

    public int compareTo(Configuracao configuracao) {
        long primaryKey = configuracao.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ConfiguracaoClp configuracao = null;

        try {
            configuracao = (ConfiguracaoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = configuracao.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{configuracaoId=");
        sb.append(getConfiguracaoId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", maximoVotos=");
        sb.append(getMaximoVotos());
        sb.append(", maxVotosProposta=");
        sb.append(getMaxVotosProposta());
        sb.append(", votacaoAberta=");
        sb.append(getVotacaoAberta());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>configuracaoId</column-name><column-value><![CDATA[");
        sb.append(getConfiguracaoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maximoVotos</column-name><column-value><![CDATA[");
        sb.append(getMaximoVotos());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maxVotosProposta</column-name><column-value><![CDATA[");
        sb.append(getMaxVotosProposta());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>votacaoAberta</column-name><column-value><![CDATA[");
        sb.append(getVotacaoAberta());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

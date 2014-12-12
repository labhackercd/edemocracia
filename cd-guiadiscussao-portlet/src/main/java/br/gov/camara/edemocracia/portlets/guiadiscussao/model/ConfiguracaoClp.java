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

import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;

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
    private long _groupId;
    private long _faseAtualId;
    private String _textoBanner;
    private long _imagemIdBanner;
    private String _urlBanner;
    private boolean _urlExterna;
    private String _tituloBanner;
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
        attributes.put("groupId", getGroupId());
        attributes.put("faseAtualId", getFaseAtualId());
        attributes.put("textoBanner", getTextoBanner());
        attributes.put("imagemIdBanner", getImagemIdBanner());
        attributes.put("urlBanner", getUrlBanner());
        attributes.put("urlExterna", getUrlExterna());
        attributes.put("tituloBanner", getTituloBanner());

        return attributes;
    }

    @Override
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

    public long getConfiguracaoId() {
        return _configuracaoId;
    }

    public void setConfiguracaoId(long configuracaoId) {
        _configuracaoId = configuracaoId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getFaseAtualId() {
        return _faseAtualId;
    }

    public void setFaseAtualId(long faseAtualId) {
        _faseAtualId = faseAtualId;
    }

    public String getTextoBanner() {
        return _textoBanner;
    }

    public void setTextoBanner(String textoBanner) {
        _textoBanner = textoBanner;
    }

    public long getImagemIdBanner() {
        return _imagemIdBanner;
    }

    public void setImagemIdBanner(long imagemIdBanner) {
        _imagemIdBanner = imagemIdBanner;
    }

    public String getUrlBanner() {
        return _urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        _urlBanner = urlBanner;
    }

    public boolean getUrlExterna() {
        return _urlExterna;
    }

    public boolean isUrlExterna() {
        return _urlExterna;
    }

    public void setUrlExterna(boolean urlExterna) {
        _urlExterna = urlExterna;
    }

    public String getTituloBanner() {
        return _tituloBanner;
    }

    public void setTituloBanner(String tituloBanner) {
        _tituloBanner = tituloBanner;
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
        clone.setGroupId(getGroupId());
        clone.setFaseAtualId(getFaseAtualId());
        clone.setTextoBanner(getTextoBanner());
        clone.setImagemIdBanner(getImagemIdBanner());
        clone.setUrlBanner(getUrlBanner());
        clone.setUrlExterna(getUrlExterna());
        clone.setTituloBanner(getTituloBanner());

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
        StringBundler sb = new StringBundler(17);

        sb.append("{configuracaoId=");
        sb.append(getConfiguracaoId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", faseAtualId=");
        sb.append(getFaseAtualId());
        sb.append(", textoBanner=");
        sb.append(getTextoBanner());
        sb.append(", imagemIdBanner=");
        sb.append(getImagemIdBanner());
        sb.append(", urlBanner=");
        sb.append(getUrlBanner());
        sb.append(", urlExterna=");
        sb.append(getUrlExterna());
        sb.append(", tituloBanner=");
        sb.append(getTituloBanner());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>configuracaoId</column-name><column-value><![CDATA[");
        sb.append(getConfiguracaoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>faseAtualId</column-name><column-value><![CDATA[");
        sb.append(getFaseAtualId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>textoBanner</column-name><column-value><![CDATA[");
        sb.append(getTextoBanner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imagemIdBanner</column-name><column-value><![CDATA[");
        sb.append(getImagemIdBanner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlBanner</column-name><column-value><![CDATA[");
        sb.append(getUrlBanner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlExterna</column-name><column-value><![CDATA[");
        sb.append(getUrlExterna());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tituloBanner</column-name><column-value><![CDATA[");
        sb.append(getTituloBanner());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

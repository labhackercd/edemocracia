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

import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class AcaoClp extends BaseModelImpl<Acao> implements Acao {
    private long _acaoId;
    private long _faseId;
    private int _ordem;
    private String _texto;
    private boolean _urlExterna;
    private String _urlLink;
    private long _iconeId;
    private BaseModel<?> _acaoRemoteModel;

    public AcaoClp() {
    }

    public Class<?> getModelClass() {
        return Acao.class;
    }

    public String getModelClassName() {
        return Acao.class.getName();
    }

    public long getPrimaryKey() {
        return _acaoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setAcaoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_acaoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("acaoId", getAcaoId());
        attributes.put("faseId", getFaseId());
        attributes.put("ordem", getOrdem());
        attributes.put("texto", getTexto());
        attributes.put("urlExterna", getUrlExterna());
        attributes.put("urlLink", getUrlLink());
        attributes.put("iconeId", getIconeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long acaoId = (Long) attributes.get("acaoId");

        if (acaoId != null) {
            setAcaoId(acaoId);
        }

        Long faseId = (Long) attributes.get("faseId");

        if (faseId != null) {
            setFaseId(faseId);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        Boolean urlExterna = (Boolean) attributes.get("urlExterna");

        if (urlExterna != null) {
            setUrlExterna(urlExterna);
        }

        String urlLink = (String) attributes.get("urlLink");

        if (urlLink != null) {
            setUrlLink(urlLink);
        }

        Long iconeId = (Long) attributes.get("iconeId");

        if (iconeId != null) {
            setIconeId(iconeId);
        }
    }

    public long getAcaoId() {
        return _acaoId;
    }

    public void setAcaoId(long acaoId) {
        _acaoId = acaoId;
    }

    public long getFaseId() {
        return _faseId;
    }

    public void setFaseId(long faseId) {
        _faseId = faseId;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
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

    public String getUrlLink() {
        return _urlLink;
    }

    public void setUrlLink(String urlLink) {
        _urlLink = urlLink;
    }

    public long getIconeId() {
        return _iconeId;
    }

    public void setIconeId(long iconeId) {
        _iconeId = iconeId;
    }

    public BaseModel<?> getAcaoRemoteModel() {
        return _acaoRemoteModel;
    }

    public void setAcaoRemoteModel(BaseModel<?> acaoRemoteModel) {
        _acaoRemoteModel = acaoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            AcaoLocalServiceUtil.addAcao(this);
        } else {
            AcaoLocalServiceUtil.updateAcao(this);
        }
    }

    @Override
    public Acao toEscapedModel() {
        return (Acao) Proxy.newProxyInstance(Acao.class.getClassLoader(),
            new Class[] { Acao.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AcaoClp clone = new AcaoClp();

        clone.setAcaoId(getAcaoId());
        clone.setFaseId(getFaseId());
        clone.setOrdem(getOrdem());
        clone.setTexto(getTexto());
        clone.setUrlExterna(getUrlExterna());
        clone.setUrlLink(getUrlLink());
        clone.setIconeId(getIconeId());

        return clone;
    }

    public int compareTo(Acao acao) {
        int value = 0;

        if (getOrdem() < acao.getOrdem()) {
            value = -1;
        } else if (getOrdem() > acao.getOrdem()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        AcaoClp acao = null;

        try {
            acao = (AcaoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = acao.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{acaoId=");
        sb.append(getAcaoId());
        sb.append(", faseId=");
        sb.append(getFaseId());
        sb.append(", ordem=");
        sb.append(getOrdem());
        sb.append(", texto=");
        sb.append(getTexto());
        sb.append(", urlExterna=");
        sb.append(getUrlExterna());
        sb.append(", urlLink=");
        sb.append(getUrlLink());
        sb.append(", iconeId=");
        sb.append(getIconeId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>acaoId</column-name><column-value><![CDATA[");
        sb.append(getAcaoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>faseId</column-name><column-value><![CDATA[");
        sb.append(getFaseId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ordem</column-name><column-value><![CDATA[");
        sb.append(getOrdem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>texto</column-name><column-value><![CDATA[");
        sb.append(getTexto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlExterna</column-name><column-value><![CDATA[");
        sb.append(getUrlExterna());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlLink</column-name><column-value><![CDATA[");
        sb.append(getUrlLink());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iconeId</column-name><column-value><![CDATA[");
        sb.append(getIconeId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

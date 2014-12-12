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

import br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ContadorAcessoClp extends BaseModelImpl<ContadorAcesso>
    implements ContadorAcesso {
    private long _contadorId;
    private long _companyId;
    private Date _data;
    private Date _dataAtualizacao;
    private String _cache;
    private BaseModel<?> _contadorAcessoRemoteModel;

    public ContadorAcessoClp() {
    }

    public Class<?> getModelClass() {
        return ContadorAcesso.class;
    }

    public String getModelClassName() {
        return ContadorAcesso.class.getName();
    }

    public long getPrimaryKey() {
        return _contadorId;
    }

    public void setPrimaryKey(long primaryKey) {
        setContadorId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_contadorId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contadorId", getContadorId());
        attributes.put("companyId", getCompanyId());
        attributes.put("data", getData());
        attributes.put("dataAtualizacao", getDataAtualizacao());
        attributes.put("cache", getCache());

        return attributes;
    }

    @Override
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

    public long getContadorId() {
        return _contadorId;
    }

    public void setContadorId(long contadorId) {
        _contadorId = contadorId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public Date getData() {
        return _data;
    }

    public void setData(Date data) {
        _data = data;
    }

    public Date getDataAtualizacao() {
        return _dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        _dataAtualizacao = dataAtualizacao;
    }

    public String getCache() {
        return _cache;
    }

    public void setCache(String cache) {
        _cache = cache;
    }

    public BaseModel<?> getContadorAcessoRemoteModel() {
        return _contadorAcessoRemoteModel;
    }

    public void setContadorAcessoRemoteModel(
        BaseModel<?> contadorAcessoRemoteModel) {
        _contadorAcessoRemoteModel = contadorAcessoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ContadorAcessoLocalServiceUtil.addContadorAcesso(this);
        } else {
            ContadorAcessoLocalServiceUtil.updateContadorAcesso(this);
        }
    }

    @Override
    public ContadorAcesso toEscapedModel() {
        return (ContadorAcesso) Proxy.newProxyInstance(ContadorAcesso.class.getClassLoader(),
            new Class[] { ContadorAcesso.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContadorAcessoClp clone = new ContadorAcessoClp();

        clone.setContadorId(getContadorId());
        clone.setCompanyId(getCompanyId());
        clone.setData(getData());
        clone.setDataAtualizacao(getDataAtualizacao());
        clone.setCache(getCache());

        return clone;
    }

    public int compareTo(ContadorAcesso contadorAcesso) {
        long primaryKey = contadorAcesso.getPrimaryKey();

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

        ContadorAcessoClp contadorAcesso = null;

        try {
            contadorAcesso = (ContadorAcessoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = contadorAcesso.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{contadorId=");
        sb.append(getContadorId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", data=");
        sb.append(getData());
        sb.append(", dataAtualizacao=");
        sb.append(getDataAtualizacao());
        sb.append(", cache=");
        sb.append(getCache());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contadorId</column-name><column-value><![CDATA[");
        sb.append(getContadorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataAtualizacao</column-name><column-value><![CDATA[");
        sb.append(getDataAtualizacao());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cache</column-name><column-value><![CDATA[");
        sb.append(getCache());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

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

import br.gov.camara.edemocracia.portlets.wikilegis.service.ArtigoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class ArtigoClp extends BaseModelImpl<Artigo> implements Artigo {
    private long _artigoId;
    private long _companyId;
    private long _groupId;
    private long _estruturaId;
    private int _ordem;
    private String _texto;
    private String _legislacaoVigente;
    private BaseModel<?> _artigoRemoteModel;

    public ArtigoClp() {
    }

    public Class<?> getModelClass() {
        return Artigo.class;
    }

    public String getModelClassName() {
        return Artigo.class.getName();
    }

    public long getPrimaryKey() {
        return _artigoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setArtigoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_artigoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getArtigoId() {
        return _artigoId;
    }

    public void setArtigoId(long artigoId) {
        _artigoId = artigoId;
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

    public long getEstruturaId() {
        return _estruturaId;
    }

    public void setEstruturaId(long estruturaId) {
        _estruturaId = estruturaId;
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

    public String getLegislacaoVigente() {
        return _legislacaoVigente;
    }

    public void setLegislacaoVigente(String legislacaoVigente) {
        _legislacaoVigente = legislacaoVigente;
    }

    public BaseModel<?> getArtigoRemoteModel() {
        return _artigoRemoteModel;
    }

    public void setArtigoRemoteModel(BaseModel<?> artigoRemoteModel) {
        _artigoRemoteModel = artigoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ArtigoLocalServiceUtil.addArtigo(this);
        } else {
            ArtigoLocalServiceUtil.updateArtigo(this);
        }
    }

    @Override
    public Artigo toEscapedModel() {
        return (Artigo) Proxy.newProxyInstance(Artigo.class.getClassLoader(),
            new Class[] { Artigo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ArtigoClp clone = new ArtigoClp();

        clone.setArtigoId(getArtigoId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setEstruturaId(getEstruturaId());
        clone.setOrdem(getOrdem());
        clone.setTexto(getTexto());
        clone.setLegislacaoVigente(getLegislacaoVigente());

        return clone;
    }

    public int compareTo(Artigo artigo) {
        long primaryKey = artigo.getPrimaryKey();

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

        ArtigoClp artigo = null;

        try {
            artigo = (ArtigoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = artigo.getPrimaryKey();

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

        sb.append("{artigoId=");
        sb.append(getArtigoId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", estruturaId=");
        sb.append(getEstruturaId());
        sb.append(", ordem=");
        sb.append(getOrdem());
        sb.append(", texto=");
        sb.append(getTexto());
        sb.append(", legislacaoVigente=");
        sb.append(getLegislacaoVigente());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>artigoId</column-name><column-value><![CDATA[");
        sb.append(getArtigoId());
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
            "<column><column-name>estruturaId</column-name><column-value><![CDATA[");
        sb.append(getEstruturaId());
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
            "<column><column-name>legislacaoVigente</column-name><column-value><![CDATA[");
        sb.append(getLegislacaoVigente());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

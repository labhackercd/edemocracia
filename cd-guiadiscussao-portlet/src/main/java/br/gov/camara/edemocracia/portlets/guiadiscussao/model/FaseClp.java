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

import br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class FaseClp extends BaseModelImpl<Fase> implements Fase {
    private long _faseId;
    private long _configuracaoId;
    private int _ordem;
    private String _titulo;
    private BaseModel<?> _faseRemoteModel;

    public FaseClp() {
    }

    public Class<?> getModelClass() {
        return Fase.class;
    }

    public String getModelClassName() {
        return Fase.class.getName();
    }

    public long getPrimaryKey() {
        return _faseId;
    }

    public void setPrimaryKey(long primaryKey) {
        setFaseId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_faseId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("faseId", getFaseId());
        attributes.put("configuracaoId", getConfiguracaoId());
        attributes.put("ordem", getOrdem());
        attributes.put("titulo", getTitulo());

        return attributes;
    }

    @Override
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

    public long getFaseId() {
        return _faseId;
    }

    public void setFaseId(long faseId) {
        _faseId = faseId;
    }

    public long getConfiguracaoId() {
        return _configuracaoId;
    }

    public void setConfiguracaoId(long configuracaoId) {
        _configuracaoId = configuracaoId;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String titulo) {
        _titulo = titulo;
    }

    public BaseModel<?> getFaseRemoteModel() {
        return _faseRemoteModel;
    }

    public void setFaseRemoteModel(BaseModel<?> faseRemoteModel) {
        _faseRemoteModel = faseRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            FaseLocalServiceUtil.addFase(this);
        } else {
            FaseLocalServiceUtil.updateFase(this);
        }
    }

    @Override
    public Fase toEscapedModel() {
        return (Fase) Proxy.newProxyInstance(Fase.class.getClassLoader(),
            new Class[] { Fase.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FaseClp clone = new FaseClp();

        clone.setFaseId(getFaseId());
        clone.setConfiguracaoId(getConfiguracaoId());
        clone.setOrdem(getOrdem());
        clone.setTitulo(getTitulo());

        return clone;
    }

    public int compareTo(Fase fase) {
        int value = 0;

        if (getOrdem() < fase.getOrdem()) {
            value = -1;
        } else if (getOrdem() > fase.getOrdem()) {
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

        FaseClp fase = null;

        try {
            fase = (FaseClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = fase.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{faseId=");
        sb.append(getFaseId());
        sb.append(", configuracaoId=");
        sb.append(getConfiguracaoId());
        sb.append(", ordem=");
        sb.append(getOrdem());
        sb.append(", titulo=");
        sb.append(getTitulo());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>faseId</column-name><column-value><![CDATA[");
        sb.append(getFaseId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>configuracaoId</column-name><column-value><![CDATA[");
        sb.append(getConfiguracaoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ordem</column-name><column-value><![CDATA[");
        sb.append(getOrdem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>titulo</column-name><column-value><![CDATA[");
        sb.append(getTitulo());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

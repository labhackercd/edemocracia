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

import br.gov.camara.edemocracia.portlets.priorizacao.service.VotoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class VotoClp extends BaseModelImpl<Voto> implements Voto {
    private long _votoId;
    private long _propostaId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private int _numeroVotos;
    private int _votosDisponiveis;
    private Date _data;
    private BaseModel<?> _votoRemoteModel;

    public VotoClp() {
    }

    public Class<?> getModelClass() {
        return Voto.class;
    }

    public String getModelClassName() {
        return Voto.class.getName();
    }

    public long getPrimaryKey() {
        return _votoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setVotoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_votoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("votoId", getVotoId());
        attributes.put("propostaId", getPropostaId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("numeroVotos", getNumeroVotos());
        attributes.put("votosDisponiveis", getVotosDisponiveis());
        attributes.put("data", getData());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long votoId = (Long) attributes.get("votoId");

        if (votoId != null) {
            setVotoId(votoId);
        }

        Long propostaId = (Long) attributes.get("propostaId");

        if (propostaId != null) {
            setPropostaId(propostaId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Integer numeroVotos = (Integer) attributes.get("numeroVotos");

        if (numeroVotos != null) {
            setNumeroVotos(numeroVotos);
        }

        Integer votosDisponiveis = (Integer) attributes.get("votosDisponiveis");

        if (votosDisponiveis != null) {
            setVotosDisponiveis(votosDisponiveis);
        }

        Date data = (Date) attributes.get("data");

        if (data != null) {
            setData(data);
        }
    }

    public long getVotoId() {
        return _votoId;
    }

    public void setVotoId(long votoId) {
        _votoId = votoId;
    }

    public long getPropostaId() {
        return _propostaId;
    }

    public void setPropostaId(long propostaId) {
        _propostaId = propostaId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public int getNumeroVotos() {
        return _numeroVotos;
    }

    public void setNumeroVotos(int numeroVotos) {
        _numeroVotos = numeroVotos;
    }

    public int getVotosDisponiveis() {
        return _votosDisponiveis;
    }

    public void setVotosDisponiveis(int votosDisponiveis) {
        _votosDisponiveis = votosDisponiveis;
    }

    public Date getData() {
        return _data;
    }

    public void setData(Date data) {
        _data = data;
    }

    public BaseModel<?> getVotoRemoteModel() {
        return _votoRemoteModel;
    }

    public void setVotoRemoteModel(BaseModel<?> votoRemoteModel) {
        _votoRemoteModel = votoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            VotoLocalServiceUtil.addVoto(this);
        } else {
            VotoLocalServiceUtil.updateVoto(this);
        }
    }

    @Override
    public Voto toEscapedModel() {
        return (Voto) Proxy.newProxyInstance(Voto.class.getClassLoader(),
            new Class[] { Voto.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        VotoClp clone = new VotoClp();

        clone.setVotoId(getVotoId());
        clone.setPropostaId(getPropostaId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setNumeroVotos(getNumeroVotos());
        clone.setVotosDisponiveis(getVotosDisponiveis());
        clone.setData(getData());

        return clone;
    }

    public int compareTo(Voto voto) {
        long primaryKey = voto.getPrimaryKey();

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

        VotoClp voto = null;

        try {
            voto = (VotoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = voto.getPrimaryKey();

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

        sb.append("{votoId=");
        sb.append(getVotoId());
        sb.append(", propostaId=");
        sb.append(getPropostaId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", numeroVotos=");
        sb.append(getNumeroVotos());
        sb.append(", votosDisponiveis=");
        sb.append(getVotosDisponiveis());
        sb.append(", data=");
        sb.append(getData());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.priorizacao.model.Voto");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>votoId</column-name><column-value><![CDATA[");
        sb.append(getVotoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>propostaId</column-name><column-value><![CDATA[");
        sb.append(getPropostaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numeroVotos</column-name><column-value><![CDATA[");
        sb.append(getNumeroVotos());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>votosDisponiveis</column-name><column-value><![CDATA[");
        sb.append(getVotosDisponiveis());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

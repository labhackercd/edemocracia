package br.gov.camara.edemocracia.portlets.priorizacao.model;

import br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class PropostaClp extends BaseModelImpl<Proposta> implements Proposta {
    private long _propostaId;
    private long _companyId;
    private long _groupId;
    private long _eixoId;
    private String _identificador;
    private String _ementa;
    private String _texto;
    private long _threadId;
    private BaseModel<?> _propostaRemoteModel;

    public PropostaClp() {
    }

    public Class<?> getModelClass() {
        return Proposta.class;
    }

    public String getModelClassName() {
        return Proposta.class.getName();
    }

    public long getPrimaryKey() {
        return _propostaId;
    }

    public void setPrimaryKey(long primaryKey) {
        setPropostaId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_propostaId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("propostaId", getPropostaId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("eixoId", getEixoId());
        attributes.put("identificador", getIdentificador());
        attributes.put("ementa", getEmenta());
        attributes.put("texto", getTexto());
        attributes.put("threadId", getThreadId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long propostaId = (Long) attributes.get("propostaId");

        if (propostaId != null) {
            setPropostaId(propostaId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long eixoId = (Long) attributes.get("eixoId");

        if (eixoId != null) {
            setEixoId(eixoId);
        }

        String identificador = (String) attributes.get("identificador");

        if (identificador != null) {
            setIdentificador(identificador);
        }

        String ementa = (String) attributes.get("ementa");

        if (ementa != null) {
            setEmenta(ementa);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        Long threadId = (Long) attributes.get("threadId");

        if (threadId != null) {
            setThreadId(threadId);
        }
    }

    public long getPropostaId() {
        return _propostaId;
    }

    public void setPropostaId(long propostaId) {
        _propostaId = propostaId;
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

    public long getEixoId() {
        return _eixoId;
    }

    public void setEixoId(long eixoId) {
        _eixoId = eixoId;
    }

    public String getIdentificador() {
        return _identificador;
    }

    public void setIdentificador(String identificador) {
        _identificador = identificador;
    }

    public String getEmenta() {
        return _ementa;
    }

    public void setEmenta(String ementa) {
        _ementa = ementa;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public long getThreadId() {
        return _threadId;
    }

    public void setThreadId(long threadId) {
        _threadId = threadId;
    }

    public BaseModel<?> getPropostaRemoteModel() {
        return _propostaRemoteModel;
    }

    public void setPropostaRemoteModel(BaseModel<?> propostaRemoteModel) {
        _propostaRemoteModel = propostaRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            PropostaLocalServiceUtil.addProposta(this);
        } else {
            PropostaLocalServiceUtil.updateProposta(this);
        }
    }

    @Override
    public Proposta toEscapedModel() {
        return (Proposta) Proxy.newProxyInstance(Proposta.class.getClassLoader(),
            new Class[] { Proposta.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PropostaClp clone = new PropostaClp();

        clone.setPropostaId(getPropostaId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setEixoId(getEixoId());
        clone.setIdentificador(getIdentificador());
        clone.setEmenta(getEmenta());
        clone.setTexto(getTexto());
        clone.setThreadId(getThreadId());

        return clone;
    }

    public int compareTo(Proposta proposta) {
        long primaryKey = proposta.getPrimaryKey();

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

        PropostaClp proposta = null;

        try {
            proposta = (PropostaClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = proposta.getPrimaryKey();

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

        sb.append("{propostaId=");
        sb.append(getPropostaId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", eixoId=");
        sb.append(getEixoId());
        sb.append(", identificador=");
        sb.append(getIdentificador());
        sb.append(", ementa=");
        sb.append(getEmenta());
        sb.append(", texto=");
        sb.append(getTexto());
        sb.append(", threadId=");
        sb.append(getThreadId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>propostaId</column-name><column-value><![CDATA[");
        sb.append(getPropostaId());
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
            "<column><column-name>eixoId</column-name><column-value><![CDATA[");
        sb.append(getEixoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>identificador</column-name><column-value><![CDATA[");
        sb.append(getIdentificador());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ementa</column-name><column-value><![CDATA[");
        sb.append(getEmenta());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>texto</column-name><column-value><![CDATA[");
        sb.append(getTexto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>threadId</column-name><column-value><![CDATA[");
        sb.append(getThreadId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

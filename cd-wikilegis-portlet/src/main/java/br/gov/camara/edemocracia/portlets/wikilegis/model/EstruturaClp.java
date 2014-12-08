package br.gov.camara.edemocracia.portlets.wikilegis.model;

import br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class EstruturaClp extends BaseModelImpl<Estrutura> implements Estrutura {
    private long _estruturaId;
    private long _companyId;
    private long _groupId;
    private String _texto;
    private int _ordem;
    private long _paiEstruturaId;
    private BaseModel<?> _estruturaRemoteModel;

    public EstruturaClp() {
    }

    public Class<?> getModelClass() {
        return Estrutura.class;
    }

    public String getModelClassName() {
        return Estrutura.class.getName();
    }

    public long getPrimaryKey() {
        return _estruturaId;
    }

    public void setPrimaryKey(long primaryKey) {
        setEstruturaId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_estruturaId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("estruturaId", getEstruturaId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("texto", getTexto());
        attributes.put("ordem", getOrdem());
        attributes.put("paiEstruturaId", getPaiEstruturaId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long estruturaId = (Long) attributes.get("estruturaId");

        if (estruturaId != null) {
            setEstruturaId(estruturaId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }

        Long paiEstruturaId = (Long) attributes.get("paiEstruturaId");

        if (paiEstruturaId != null) {
            setPaiEstruturaId(paiEstruturaId);
        }
    }

    public long getEstruturaId() {
        return _estruturaId;
    }

    public void setEstruturaId(long estruturaId) {
        _estruturaId = estruturaId;
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

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public long getPaiEstruturaId() {
        return _paiEstruturaId;
    }

    public void setPaiEstruturaId(long paiEstruturaId) {
        _paiEstruturaId = paiEstruturaId;
    }

    public BaseModel<?> getEstruturaRemoteModel() {
        return _estruturaRemoteModel;
    }

    public void setEstruturaRemoteModel(BaseModel<?> estruturaRemoteModel) {
        _estruturaRemoteModel = estruturaRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            EstruturaLocalServiceUtil.addEstrutura(this);
        } else {
            EstruturaLocalServiceUtil.updateEstrutura(this);
        }
    }

    @Override
    public Estrutura toEscapedModel() {
        return (Estrutura) Proxy.newProxyInstance(Estrutura.class.getClassLoader(),
            new Class[] { Estrutura.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EstruturaClp clone = new EstruturaClp();

        clone.setEstruturaId(getEstruturaId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setTexto(getTexto());
        clone.setOrdem(getOrdem());
        clone.setPaiEstruturaId(getPaiEstruturaId());

        return clone;
    }

    public int compareTo(Estrutura estrutura) {
        long primaryKey = estrutura.getPrimaryKey();

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

        EstruturaClp estrutura = null;

        try {
            estrutura = (EstruturaClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = estrutura.getPrimaryKey();

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

        sb.append("{estruturaId=");
        sb.append(getEstruturaId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", texto=");
        sb.append(getTexto());
        sb.append(", ordem=");
        sb.append(getOrdem());
        sb.append(", paiEstruturaId=");
        sb.append(getPaiEstruturaId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>estruturaId</column-name><column-value><![CDATA[");
        sb.append(getEstruturaId());
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
            "<column><column-name>texto</column-name><column-value><![CDATA[");
        sb.append(getTexto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ordem</column-name><column-value><![CDATA[");
        sb.append(getOrdem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>paiEstruturaId</column-name><column-value><![CDATA[");
        sb.append(getPaiEstruturaId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

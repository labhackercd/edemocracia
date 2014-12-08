package br.gov.camara.edemocracia.portlets.priorizacao.model;

import br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class EixoClp extends BaseModelImpl<Eixo> implements Eixo {
    private long _eixoId;
    private long _companyId;
    private long _groupId;
    private long _categoryId;
    private String _titulo;
    private String _sumario;
    private int _ordem;
    private BaseModel<?> _eixoRemoteModel;

    public EixoClp() {
    }

    public Class<?> getModelClass() {
        return Eixo.class;
    }

    public String getModelClassName() {
        return Eixo.class.getName();
    }

    public long getPrimaryKey() {
        return _eixoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setEixoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_eixoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("eixoId", getEixoId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("titulo", getTitulo());
        attributes.put("sumario", getSumario());
        attributes.put("ordem", getOrdem());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long eixoId = (Long) attributes.get("eixoId");

        if (eixoId != null) {
            setEixoId(eixoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String titulo = (String) attributes.get("titulo");

        if (titulo != null) {
            setTitulo(titulo);
        }

        String sumario = (String) attributes.get("sumario");

        if (sumario != null) {
            setSumario(sumario);
        }

        Integer ordem = (Integer) attributes.get("ordem");

        if (ordem != null) {
            setOrdem(ordem);
        }
    }

    public long getEixoId() {
        return _eixoId;
    }

    public void setEixoId(long eixoId) {
        _eixoId = eixoId;
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

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String titulo) {
        _titulo = titulo;
    }

    public String getSumario() {
        return _sumario;
    }

    public void setSumario(String sumario) {
        _sumario = sumario;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public BaseModel<?> getEixoRemoteModel() {
        return _eixoRemoteModel;
    }

    public void setEixoRemoteModel(BaseModel<?> eixoRemoteModel) {
        _eixoRemoteModel = eixoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            EixoLocalServiceUtil.addEixo(this);
        } else {
            EixoLocalServiceUtil.updateEixo(this);
        }
    }

    @Override
    public Eixo toEscapedModel() {
        return (Eixo) Proxy.newProxyInstance(Eixo.class.getClassLoader(),
            new Class[] { Eixo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EixoClp clone = new EixoClp();

        clone.setEixoId(getEixoId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setCategoryId(getCategoryId());
        clone.setTitulo(getTitulo());
        clone.setSumario(getSumario());
        clone.setOrdem(getOrdem());

        return clone;
    }

    public int compareTo(Eixo eixo) {
        long primaryKey = eixo.getPrimaryKey();

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

        EixoClp eixo = null;

        try {
            eixo = (EixoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = eixo.getPrimaryKey();

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

        sb.append("{eixoId=");
        sb.append(getEixoId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", titulo=");
        sb.append(getTitulo());
        sb.append(", sumario=");
        sb.append(getSumario());
        sb.append(", ordem=");
        sb.append(getOrdem());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>eixoId</column-name><column-value><![CDATA[");
        sb.append(getEixoId());
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
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>titulo</column-name><column-value><![CDATA[");
        sb.append(getTitulo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sumario</column-name><column-value><![CDATA[");
        sb.append(getSumario());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ordem</column-name><column-value><![CDATA[");
        sb.append(getOrdem());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

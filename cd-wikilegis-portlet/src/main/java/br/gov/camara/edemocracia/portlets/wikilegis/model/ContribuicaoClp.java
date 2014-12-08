package br.gov.camara.edemocracia.portlets.wikilegis.model;

import br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalServiceUtil;

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


public class ContribuicaoClp extends BaseModelImpl<Contribuicao>
    implements Contribuicao {
    private long _contribuicaoId;
    private long _artigoId;
    private String _texto;
    private String _descricao;
    private Date _data;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private BaseModel<?> _contribuicaoRemoteModel;

    public ContribuicaoClp() {
    }

    public Class<?> getModelClass() {
        return Contribuicao.class;
    }

    public String getModelClassName() {
        return Contribuicao.class.getName();
    }

    public long getPrimaryKey() {
        return _contribuicaoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setContribuicaoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_contribuicaoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contribuicaoId", getContribuicaoId());
        attributes.put("artigoId", getArtigoId());
        attributes.put("texto", getTexto());
        attributes.put("descricao", getDescricao());
        attributes.put("data", getData());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contribuicaoId = (Long) attributes.get("contribuicaoId");

        if (contribuicaoId != null) {
            setContribuicaoId(contribuicaoId);
        }

        Long artigoId = (Long) attributes.get("artigoId");

        if (artigoId != null) {
            setArtigoId(artigoId);
        }

        String texto = (String) attributes.get("texto");

        if (texto != null) {
            setTexto(texto);
        }

        String descricao = (String) attributes.get("descricao");

        if (descricao != null) {
            setDescricao(descricao);
        }

        Date data = (Date) attributes.get("data");

        if (data != null) {
            setData(data);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }
    }

    public long getContribuicaoId() {
        return _contribuicaoId;
    }

    public void setContribuicaoId(long contribuicaoId) {
        _contribuicaoId = contribuicaoId;
    }

    public long getArtigoId() {
        return _artigoId;
    }

    public void setArtigoId(long artigoId) {
        _artigoId = artigoId;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String descricao) {
        _descricao = descricao;
    }

    public Date getData() {
        return _data;
    }

    public void setData(Date data) {
        _data = data;
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

    public BaseModel<?> getContribuicaoRemoteModel() {
        return _contribuicaoRemoteModel;
    }

    public void setContribuicaoRemoteModel(BaseModel<?> contribuicaoRemoteModel) {
        _contribuicaoRemoteModel = contribuicaoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ContribuicaoLocalServiceUtil.addContribuicao(this);
        } else {
            ContribuicaoLocalServiceUtil.updateContribuicao(this);
        }
    }

    @Override
    public Contribuicao toEscapedModel() {
        return (Contribuicao) Proxy.newProxyInstance(Contribuicao.class.getClassLoader(),
            new Class[] { Contribuicao.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContribuicaoClp clone = new ContribuicaoClp();

        clone.setContribuicaoId(getContribuicaoId());
        clone.setArtigoId(getArtigoId());
        clone.setTexto(getTexto());
        clone.setDescricao(getDescricao());
        clone.setData(getData());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());

        return clone;
    }

    public int compareTo(Contribuicao contribuicao) {
        long primaryKey = contribuicao.getPrimaryKey();

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

        ContribuicaoClp contribuicao = null;

        try {
            contribuicao = (ContribuicaoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = contribuicao.getPrimaryKey();

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

        sb.append("{contribuicaoId=");
        sb.append(getContribuicaoId());
        sb.append(", artigoId=");
        sb.append(getArtigoId());
        sb.append(", texto=");
        sb.append(getTexto());
        sb.append(", descricao=");
        sb.append(getDescricao());
        sb.append(", data=");
        sb.append(getData());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contribuicaoId</column-name><column-value><![CDATA[");
        sb.append(getContribuicaoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>artigoId</column-name><column-value><![CDATA[");
        sb.append(getArtigoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>texto</column-name><column-value><![CDATA[");
        sb.append(getTexto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descricao</column-name><column-value><![CDATA[");
        sb.append(getDescricao());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

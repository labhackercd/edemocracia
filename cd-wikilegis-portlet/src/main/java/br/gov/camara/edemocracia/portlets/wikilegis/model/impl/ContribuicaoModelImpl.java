package br.gov.camara.edemocracia.portlets.wikilegis.model.impl;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;
import br.gov.camara.edemocracia.portlets.wikilegis.model.ContribuicaoModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Contribuicao service. Represents a row in the &quot;CDWL_Contribuicao&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.gov.camara.edemocracia.portlets.wikilegis.model.ContribuicaoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContribuicaoImpl}.
 * </p>
 *
 * @author robson
 * @see ContribuicaoImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao
 * @see br.gov.camara.edemocracia.portlets.wikilegis.model.ContribuicaoModel
 * @generated
 */
public class ContribuicaoModelImpl extends BaseModelImpl<Contribuicao>
    implements ContribuicaoModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contribuicao model instance should use the {@link br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao} interface instead.
     */
    public static final String TABLE_NAME = "CDWL_Contribuicao";
    public static final Object[][] TABLE_COLUMNS = {
            { "contribuicaoId", Types.BIGINT },
            { "artigoId", Types.BIGINT },
            { "texto", Types.VARCHAR },
            { "descricao", Types.VARCHAR },
            { "data_", Types.TIMESTAMP },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table CDWL_Contribuicao (contribuicaoId LONG not null primary key,artigoId LONG,texto TEXT null,descricao TEXT null,data_ DATE null,userId LONG,userName VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table CDWL_Contribuicao";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao"),
            true);
    public static long ARTIGOID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao"));
    private static ClassLoader _classLoader = Contribuicao.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            Contribuicao.class
        };
    private long _contribuicaoId;
    private long _artigoId;
    private long _originalArtigoId;
    private boolean _setOriginalArtigoId;
    private String _texto;
    private String _descricao;
    private Date _data;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private long _columnBitmask;
    private Contribuicao _escapedModelProxy;

    public ContribuicaoModelImpl() {
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

    public Class<?> getModelClass() {
        return Contribuicao.class;
    }

    public String getModelClassName() {
        return Contribuicao.class.getName();
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
        _columnBitmask |= ARTIGOID_COLUMN_BITMASK;

        if (!_setOriginalArtigoId) {
            _setOriginalArtigoId = true;

            _originalArtigoId = _artigoId;
        }

        _artigoId = artigoId;
    }

    public long getOriginalArtigoId() {
        return _originalArtigoId;
    }

    public String getTexto() {
        if (_texto == null) {
            return StringPool.BLANK;
        } else {
            return _texto;
        }
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public String getDescricao() {
        if (_descricao == null) {
            return StringPool.BLANK;
        } else {
            return _descricao;
        }
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
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Contribuicao.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Contribuicao toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (Contribuicao) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        ContribuicaoImpl contribuicaoImpl = new ContribuicaoImpl();

        contribuicaoImpl.setContribuicaoId(getContribuicaoId());
        contribuicaoImpl.setArtigoId(getArtigoId());
        contribuicaoImpl.setTexto(getTexto());
        contribuicaoImpl.setDescricao(getDescricao());
        contribuicaoImpl.setData(getData());
        contribuicaoImpl.setUserId(getUserId());
        contribuicaoImpl.setUserName(getUserName());

        contribuicaoImpl.resetOriginalValues();

        return contribuicaoImpl;
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

        Contribuicao contribuicao = null;

        try {
            contribuicao = (Contribuicao) obj;
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
    public void resetOriginalValues() {
        ContribuicaoModelImpl contribuicaoModelImpl = this;

        contribuicaoModelImpl._originalArtigoId = contribuicaoModelImpl._artigoId;

        contribuicaoModelImpl._setOriginalArtigoId = false;

        contribuicaoModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Contribuicao> toCacheModel() {
        ContribuicaoCacheModel contribuicaoCacheModel = new ContribuicaoCacheModel();

        contribuicaoCacheModel.contribuicaoId = getContribuicaoId();

        contribuicaoCacheModel.artigoId = getArtigoId();

        contribuicaoCacheModel.texto = getTexto();

        String texto = contribuicaoCacheModel.texto;

        if ((texto != null) && (texto.length() == 0)) {
            contribuicaoCacheModel.texto = null;
        }

        contribuicaoCacheModel.descricao = getDescricao();

        String descricao = contribuicaoCacheModel.descricao;

        if ((descricao != null) && (descricao.length() == 0)) {
            contribuicaoCacheModel.descricao = null;
        }

        Date data = getData();

        if (data != null) {
            contribuicaoCacheModel.data = data.getTime();
        } else {
            contribuicaoCacheModel.data = Long.MIN_VALUE;
        }

        contribuicaoCacheModel.userId = getUserId();

        contribuicaoCacheModel.userName = getUserName();

        String userName = contribuicaoCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            contribuicaoCacheModel.userName = null;
        }

        return contribuicaoCacheModel;
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
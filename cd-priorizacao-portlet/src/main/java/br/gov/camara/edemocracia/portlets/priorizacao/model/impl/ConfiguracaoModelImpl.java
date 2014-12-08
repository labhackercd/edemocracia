package br.gov.camara.edemocracia.portlets.priorizacao.model.impl;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Configuracao service. Represents a row in the &quot;PR_Configuracao&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConfiguracaoImpl}.
 * </p>
 *
 * @author robson
 * @see ConfiguracaoImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao
 * @see br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoModel
 * @generated
 */
public class ConfiguracaoModelImpl extends BaseModelImpl<Configuracao>
    implements ConfiguracaoModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a configuracao model instance should use the {@link br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao} interface instead.
     */
    public static final String TABLE_NAME = "PR_Configuracao";
    public static final Object[][] TABLE_COLUMNS = {
            { "configuracaoId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "maximoVotos", Types.INTEGER },
            { "maxVotosProposta", Types.INTEGER },
            { "votacaoAberta", Types.BOOLEAN }
        };
    public static final String TABLE_SQL_CREATE = "create table PR_Configuracao (configuracaoId LONG not null primary key,companyId LONG,groupId LONG,maximoVotos INTEGER,maxVotosProposta INTEGER,votacaoAberta BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table PR_Configuracao";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao"),
            true);
    public static long GROUPID_COLUMN_BITMASK = 1L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao"));
    private static ClassLoader _classLoader = Configuracao.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            Configuracao.class
        };
    private long _configuracaoId;
    private long _companyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private int _maximoVotos;
    private int _maxVotosProposta;
    private boolean _votacaoAberta;
    private long _columnBitmask;
    private Configuracao _escapedModelProxy;

    public ConfiguracaoModelImpl() {
    }

    public long getPrimaryKey() {
        return _configuracaoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setConfiguracaoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_configuracaoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return Configuracao.class;
    }

    public String getModelClassName() {
        return Configuracao.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("configuracaoId", getConfiguracaoId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("maximoVotos", getMaximoVotos());
        attributes.put("maxVotosProposta", getMaxVotosProposta());
        attributes.put("votacaoAberta", getVotacaoAberta());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long configuracaoId = (Long) attributes.get("configuracaoId");

        if (configuracaoId != null) {
            setConfiguracaoId(configuracaoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Integer maximoVotos = (Integer) attributes.get("maximoVotos");

        if (maximoVotos != null) {
            setMaximoVotos(maximoVotos);
        }

        Integer maxVotosProposta = (Integer) attributes.get("maxVotosProposta");

        if (maxVotosProposta != null) {
            setMaxVotosProposta(maxVotosProposta);
        }

        Boolean votacaoAberta = (Boolean) attributes.get("votacaoAberta");

        if (votacaoAberta != null) {
            setVotacaoAberta(votacaoAberta);
        }
    }

    public long getConfiguracaoId() {
        return _configuracaoId;
    }

    public void setConfiguracaoId(long configuracaoId) {
        _configuracaoId = configuracaoId;
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
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    public int getMaximoVotos() {
        return _maximoVotos;
    }

    public void setMaximoVotos(int maximoVotos) {
        _maximoVotos = maximoVotos;
    }

    public int getMaxVotosProposta() {
        return _maxVotosProposta;
    }

    public void setMaxVotosProposta(int maxVotosProposta) {
        _maxVotosProposta = maxVotosProposta;
    }

    public boolean getVotacaoAberta() {
        return _votacaoAberta;
    }

    public boolean isVotacaoAberta() {
        return _votacaoAberta;
    }

    public void setVotacaoAberta(boolean votacaoAberta) {
        _votacaoAberta = votacaoAberta;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Configuracao.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Configuracao toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (Configuracao) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        ConfiguracaoImpl configuracaoImpl = new ConfiguracaoImpl();

        configuracaoImpl.setConfiguracaoId(getConfiguracaoId());
        configuracaoImpl.setCompanyId(getCompanyId());
        configuracaoImpl.setGroupId(getGroupId());
        configuracaoImpl.setMaximoVotos(getMaximoVotos());
        configuracaoImpl.setMaxVotosProposta(getMaxVotosProposta());
        configuracaoImpl.setVotacaoAberta(getVotacaoAberta());

        configuracaoImpl.resetOriginalValues();

        return configuracaoImpl;
    }

    public int compareTo(Configuracao configuracao) {
        long primaryKey = configuracao.getPrimaryKey();

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

        Configuracao configuracao = null;

        try {
            configuracao = (Configuracao) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = configuracao.getPrimaryKey();

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
        ConfiguracaoModelImpl configuracaoModelImpl = this;

        configuracaoModelImpl._originalGroupId = configuracaoModelImpl._groupId;

        configuracaoModelImpl._setOriginalGroupId = false;

        configuracaoModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Configuracao> toCacheModel() {
        ConfiguracaoCacheModel configuracaoCacheModel = new ConfiguracaoCacheModel();

        configuracaoCacheModel.configuracaoId = getConfiguracaoId();

        configuracaoCacheModel.companyId = getCompanyId();

        configuracaoCacheModel.groupId = getGroupId();

        configuracaoCacheModel.maximoVotos = getMaximoVotos();

        configuracaoCacheModel.maxVotosProposta = getMaxVotosProposta();

        configuracaoCacheModel.votacaoAberta = getVotacaoAberta();

        return configuracaoCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{configuracaoId=");
        sb.append(getConfiguracaoId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", maximoVotos=");
        sb.append(getMaximoVotos());
        sb.append(", maxVotosProposta=");
        sb.append(getMaxVotosProposta());
        sb.append(", votacaoAberta=");
        sb.append(getVotacaoAberta());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>configuracaoId</column-name><column-value><![CDATA[");
        sb.append(getConfiguracaoId());
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
            "<column><column-name>maximoVotos</column-name><column-value><![CDATA[");
        sb.append(getMaximoVotos());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maxVotosProposta</column-name><column-value><![CDATA[");
        sb.append(getMaxVotosProposta());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>votacaoAberta</column-name><column-value><![CDATA[");
        sb.append(getVotacaoAberta());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
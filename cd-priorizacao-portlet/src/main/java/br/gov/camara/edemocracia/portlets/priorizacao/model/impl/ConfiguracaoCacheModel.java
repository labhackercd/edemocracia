package br.gov.camara.edemocracia.portlets.priorizacao.model.impl;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Configuracao in entity cache.
 *
 * @author robson
 * @see Configuracao
 * @generated
 */
public class ConfiguracaoCacheModel implements CacheModel<Configuracao>,
    Serializable {
    public long configuracaoId;
    public long companyId;
    public long groupId;
    public int maximoVotos;
    public int maxVotosProposta;
    public boolean votacaoAberta;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{configuracaoId=");
        sb.append(configuracaoId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", maximoVotos=");
        sb.append(maximoVotos);
        sb.append(", maxVotosProposta=");
        sb.append(maxVotosProposta);
        sb.append(", votacaoAberta=");
        sb.append(votacaoAberta);
        sb.append("}");

        return sb.toString();
    }

    public Configuracao toEntityModel() {
        ConfiguracaoImpl configuracaoImpl = new ConfiguracaoImpl();

        configuracaoImpl.setConfiguracaoId(configuracaoId);
        configuracaoImpl.setCompanyId(companyId);
        configuracaoImpl.setGroupId(groupId);
        configuracaoImpl.setMaximoVotos(maximoVotos);
        configuracaoImpl.setMaxVotosProposta(maxVotosProposta);
        configuracaoImpl.setVotacaoAberta(votacaoAberta);

        configuracaoImpl.resetOriginalValues();

        return configuracaoImpl;
    }
}

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

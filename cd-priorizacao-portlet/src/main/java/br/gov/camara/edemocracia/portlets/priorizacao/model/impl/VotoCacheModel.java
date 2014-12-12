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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Voto in entity cache.
 *
 * @author robson
 * @see Voto
 * @generated
 */
public class VotoCacheModel implements CacheModel<Voto>, Serializable {
    public long votoId;
    public long propostaId;
    public long userId;
    public String userName;
    public int numeroVotos;
    public int votosDisponiveis;
    public long data;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{votoId=");
        sb.append(votoId);
        sb.append(", propostaId=");
        sb.append(propostaId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", numeroVotos=");
        sb.append(numeroVotos);
        sb.append(", votosDisponiveis=");
        sb.append(votosDisponiveis);
        sb.append(", data=");
        sb.append(data);
        sb.append("}");

        return sb.toString();
    }

    public Voto toEntityModel() {
        VotoImpl votoImpl = new VotoImpl();

        votoImpl.setVotoId(votoId);
        votoImpl.setPropostaId(propostaId);
        votoImpl.setUserId(userId);

        if (userName == null) {
            votoImpl.setUserName(StringPool.BLANK);
        } else {
            votoImpl.setUserName(userName);
        }

        votoImpl.setNumeroVotos(numeroVotos);
        votoImpl.setVotosDisponiveis(votosDisponiveis);

        if (data == Long.MIN_VALUE) {
            votoImpl.setData(null);
        } else {
            votoImpl.setData(new Date(data));
        }

        votoImpl.resetOriginalValues();

        return votoImpl;
    }
}

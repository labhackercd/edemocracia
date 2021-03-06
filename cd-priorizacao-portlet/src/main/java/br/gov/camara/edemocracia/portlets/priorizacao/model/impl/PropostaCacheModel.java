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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Proposta in entity cache.
 *
 * @author robson
 * @see Proposta
 * @generated
 */
public class PropostaCacheModel implements CacheModel<Proposta>, Serializable {
    public long propostaId;
    public long companyId;
    public long groupId;
    public long eixoId;
    public String identificador;
    public String ementa;
    public String texto;
    public long threadId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{propostaId=");
        sb.append(propostaId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", eixoId=");
        sb.append(eixoId);
        sb.append(", identificador=");
        sb.append(identificador);
        sb.append(", ementa=");
        sb.append(ementa);
        sb.append(", texto=");
        sb.append(texto);
        sb.append(", threadId=");
        sb.append(threadId);
        sb.append("}");

        return sb.toString();
    }

    public Proposta toEntityModel() {
        PropostaImpl propostaImpl = new PropostaImpl();

        propostaImpl.setPropostaId(propostaId);
        propostaImpl.setCompanyId(companyId);
        propostaImpl.setGroupId(groupId);
        propostaImpl.setEixoId(eixoId);

        if (identificador == null) {
            propostaImpl.setIdentificador(StringPool.BLANK);
        } else {
            propostaImpl.setIdentificador(identificador);
        }

        if (ementa == null) {
            propostaImpl.setEmenta(StringPool.BLANK);
        } else {
            propostaImpl.setEmenta(ementa);
        }

        if (texto == null) {
            propostaImpl.setTexto(StringPool.BLANK);
        } else {
            propostaImpl.setTexto(texto);
        }

        propostaImpl.setThreadId(threadId);

        propostaImpl.resetOriginalValues();

        return propostaImpl;
    }
}

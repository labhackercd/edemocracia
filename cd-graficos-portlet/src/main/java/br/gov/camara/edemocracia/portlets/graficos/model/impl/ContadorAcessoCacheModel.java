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
package br.gov.camara.edemocracia.portlets.graficos.model.impl;

import br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ContadorAcesso in entity cache.
 *
 * @author Robson Miranda
 * @see ContadorAcesso
 * @generated
 */
public class ContadorAcessoCacheModel implements CacheModel<ContadorAcesso>,
    Serializable {
    public long contadorId;
    public long companyId;
    public long data;
    public long dataAtualizacao;
    public String cache;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{contadorId=");
        sb.append(contadorId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", data=");
        sb.append(data);
        sb.append(", dataAtualizacao=");
        sb.append(dataAtualizacao);
        sb.append(", cache=");
        sb.append(cache);
        sb.append("}");

        return sb.toString();
    }

    public ContadorAcesso toEntityModel() {
        ContadorAcessoImpl contadorAcessoImpl = new ContadorAcessoImpl();

        contadorAcessoImpl.setContadorId(contadorId);
        contadorAcessoImpl.setCompanyId(companyId);

        if (data == Long.MIN_VALUE) {
            contadorAcessoImpl.setData(null);
        } else {
            contadorAcessoImpl.setData(new Date(data));
        }

        if (dataAtualizacao == Long.MIN_VALUE) {
            contadorAcessoImpl.setDataAtualizacao(null);
        } else {
            contadorAcessoImpl.setDataAtualizacao(new Date(dataAtualizacao));
        }

        if (cache == null) {
            contadorAcessoImpl.setCache(StringPool.BLANK);
        } else {
            contadorAcessoImpl.setCache(cache);
        }

        contadorAcessoImpl.resetOriginalValues();

        return contadorAcessoImpl;
    }
}

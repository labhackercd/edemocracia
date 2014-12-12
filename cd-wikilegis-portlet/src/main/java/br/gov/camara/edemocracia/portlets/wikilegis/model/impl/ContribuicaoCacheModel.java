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
package br.gov.camara.edemocracia.portlets.wikilegis.model.impl;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Contribuicao in entity cache.
 *
 * @author robson
 * @see Contribuicao
 * @generated
 */
public class ContribuicaoCacheModel implements CacheModel<Contribuicao>,
    Serializable {
    public long contribuicaoId;
    public long artigoId;
    public String texto;
    public String descricao;
    public long data;
    public long userId;
    public String userName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{contribuicaoId=");
        sb.append(contribuicaoId);
        sb.append(", artigoId=");
        sb.append(artigoId);
        sb.append(", texto=");
        sb.append(texto);
        sb.append(", descricao=");
        sb.append(descricao);
        sb.append(", data=");
        sb.append(data);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append("}");

        return sb.toString();
    }

    public Contribuicao toEntityModel() {
        ContribuicaoImpl contribuicaoImpl = new ContribuicaoImpl();

        contribuicaoImpl.setContribuicaoId(contribuicaoId);
        contribuicaoImpl.setArtigoId(artigoId);

        if (texto == null) {
            contribuicaoImpl.setTexto(StringPool.BLANK);
        } else {
            contribuicaoImpl.setTexto(texto);
        }

        if (descricao == null) {
            contribuicaoImpl.setDescricao(StringPool.BLANK);
        } else {
            contribuicaoImpl.setDescricao(descricao);
        }

        if (data == Long.MIN_VALUE) {
            contribuicaoImpl.setData(null);
        } else {
            contribuicaoImpl.setData(new Date(data));
        }

        contribuicaoImpl.setUserId(userId);

        if (userName == null) {
            contribuicaoImpl.setUserName(StringPool.BLANK);
        } else {
            contribuicaoImpl.setUserName(userName);
        }

        contribuicaoImpl.resetOriginalValues();

        return contribuicaoImpl;
    }
}

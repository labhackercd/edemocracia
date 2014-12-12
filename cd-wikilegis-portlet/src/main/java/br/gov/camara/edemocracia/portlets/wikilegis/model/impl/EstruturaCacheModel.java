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

import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Estrutura in entity cache.
 *
 * @author robson
 * @see Estrutura
 * @generated
 */
public class EstruturaCacheModel implements CacheModel<Estrutura>, Serializable {
    public long estruturaId;
    public long companyId;
    public long groupId;
    public String texto;
    public int ordem;
    public long paiEstruturaId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{estruturaId=");
        sb.append(estruturaId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", texto=");
        sb.append(texto);
        sb.append(", ordem=");
        sb.append(ordem);
        sb.append(", paiEstruturaId=");
        sb.append(paiEstruturaId);
        sb.append("}");

        return sb.toString();
    }

    public Estrutura toEntityModel() {
        EstruturaImpl estruturaImpl = new EstruturaImpl();

        estruturaImpl.setEstruturaId(estruturaId);
        estruturaImpl.setCompanyId(companyId);
        estruturaImpl.setGroupId(groupId);

        if (texto == null) {
            estruturaImpl.setTexto(StringPool.BLANK);
        } else {
            estruturaImpl.setTexto(texto);
        }

        estruturaImpl.setOrdem(ordem);
        estruturaImpl.setPaiEstruturaId(paiEstruturaId);

        estruturaImpl.resetOriginalValues();

        return estruturaImpl;
    }
}

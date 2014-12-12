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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Eixo in entity cache.
 *
 * @author robson
 * @see Eixo
 * @generated
 */
public class EixoCacheModel implements CacheModel<Eixo>, Serializable {
    public long eixoId;
    public long companyId;
    public long groupId;
    public long categoryId;
    public String titulo;
    public String sumario;
    public int ordem;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{eixoId=");
        sb.append(eixoId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", categoryId=");
        sb.append(categoryId);
        sb.append(", titulo=");
        sb.append(titulo);
        sb.append(", sumario=");
        sb.append(sumario);
        sb.append(", ordem=");
        sb.append(ordem);
        sb.append("}");

        return sb.toString();
    }

    public Eixo toEntityModel() {
        EixoImpl eixoImpl = new EixoImpl();

        eixoImpl.setEixoId(eixoId);
        eixoImpl.setCompanyId(companyId);
        eixoImpl.setGroupId(groupId);
        eixoImpl.setCategoryId(categoryId);

        if (titulo == null) {
            eixoImpl.setTitulo(StringPool.BLANK);
        } else {
            eixoImpl.setTitulo(titulo);
        }

        if (sumario == null) {
            eixoImpl.setSumario(StringPool.BLANK);
        } else {
            eixoImpl.setSumario(sumario);
        }

        eixoImpl.setOrdem(ordem);

        eixoImpl.resetOriginalValues();

        return eixoImpl;
    }
}

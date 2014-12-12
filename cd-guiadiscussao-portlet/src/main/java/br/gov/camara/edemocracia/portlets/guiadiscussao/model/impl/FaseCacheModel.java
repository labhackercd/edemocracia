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
package br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Fase in entity cache.
 *
 * @author Robson
 * @see Fase
 * @generated
 */
public class FaseCacheModel implements CacheModel<Fase>, Serializable {
    public long faseId;
    public long configuracaoId;
    public int ordem;
    public String titulo;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{faseId=");
        sb.append(faseId);
        sb.append(", configuracaoId=");
        sb.append(configuracaoId);
        sb.append(", ordem=");
        sb.append(ordem);
        sb.append(", titulo=");
        sb.append(titulo);
        sb.append("}");

        return sb.toString();
    }

    public Fase toEntityModel() {
        FaseImpl faseImpl = new FaseImpl();

        faseImpl.setFaseId(faseId);
        faseImpl.setConfiguracaoId(configuracaoId);
        faseImpl.setOrdem(ordem);

        if (titulo == null) {
            faseImpl.setTitulo(StringPool.BLANK);
        } else {
            faseImpl.setTitulo(titulo);
        }

        faseImpl.resetOriginalValues();

        return faseImpl;
    }
}

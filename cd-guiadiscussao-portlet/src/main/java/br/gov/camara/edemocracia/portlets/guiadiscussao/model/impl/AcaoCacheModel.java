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

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Acao in entity cache.
 *
 * @author Robson
 * @see Acao
 * @generated
 */
public class AcaoCacheModel implements CacheModel<Acao>, Serializable {
    public long acaoId;
    public long faseId;
    public int ordem;
    public String texto;
    public boolean urlExterna;
    public String urlLink;
    public long iconeId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{acaoId=");
        sb.append(acaoId);
        sb.append(", faseId=");
        sb.append(faseId);
        sb.append(", ordem=");
        sb.append(ordem);
        sb.append(", texto=");
        sb.append(texto);
        sb.append(", urlExterna=");
        sb.append(urlExterna);
        sb.append(", urlLink=");
        sb.append(urlLink);
        sb.append(", iconeId=");
        sb.append(iconeId);
        sb.append("}");

        return sb.toString();
    }

    public Acao toEntityModel() {
        AcaoImpl acaoImpl = new AcaoImpl();

        acaoImpl.setAcaoId(acaoId);
        acaoImpl.setFaseId(faseId);
        acaoImpl.setOrdem(ordem);

        if (texto == null) {
            acaoImpl.setTexto(StringPool.BLANK);
        } else {
            acaoImpl.setTexto(texto);
        }

        acaoImpl.setUrlExterna(urlExterna);

        if (urlLink == null) {
            acaoImpl.setUrlLink(StringPool.BLANK);
        } else {
            acaoImpl.setUrlLink(urlLink);
        }

        acaoImpl.setIconeId(iconeId);

        acaoImpl.resetOriginalValues();

        return acaoImpl;
    }
}

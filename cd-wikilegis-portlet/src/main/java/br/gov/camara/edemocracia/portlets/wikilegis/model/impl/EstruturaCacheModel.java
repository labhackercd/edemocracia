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

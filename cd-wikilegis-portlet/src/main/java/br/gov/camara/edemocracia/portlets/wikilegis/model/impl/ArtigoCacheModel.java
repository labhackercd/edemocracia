package br.gov.camara.edemocracia.portlets.wikilegis.model.impl;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Artigo in entity cache.
 *
 * @author robson
 * @see Artigo
 * @generated
 */
public class ArtigoCacheModel implements CacheModel<Artigo>, Serializable {
    public long artigoId;
    public long companyId;
    public long groupId;
    public long estruturaId;
    public int ordem;
    public String texto;
    public String legislacaoVigente;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{artigoId=");
        sb.append(artigoId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", estruturaId=");
        sb.append(estruturaId);
        sb.append(", ordem=");
        sb.append(ordem);
        sb.append(", texto=");
        sb.append(texto);
        sb.append(", legislacaoVigente=");
        sb.append(legislacaoVigente);
        sb.append("}");

        return sb.toString();
    }

    public Artigo toEntityModel() {
        ArtigoImpl artigoImpl = new ArtigoImpl();

        artigoImpl.setArtigoId(artigoId);
        artigoImpl.setCompanyId(companyId);
        artigoImpl.setGroupId(groupId);
        artigoImpl.setEstruturaId(estruturaId);
        artigoImpl.setOrdem(ordem);

        if (texto == null) {
            artigoImpl.setTexto(StringPool.BLANK);
        } else {
            artigoImpl.setTexto(texto);
        }

        if (legislacaoVigente == null) {
            artigoImpl.setLegislacaoVigente(StringPool.BLANK);
        } else {
            artigoImpl.setLegislacaoVigente(legislacaoVigente);
        }

        artigoImpl.resetOriginalValues();

        return artigoImpl;
    }
}

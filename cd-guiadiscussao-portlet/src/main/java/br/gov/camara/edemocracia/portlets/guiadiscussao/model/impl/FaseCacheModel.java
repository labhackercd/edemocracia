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

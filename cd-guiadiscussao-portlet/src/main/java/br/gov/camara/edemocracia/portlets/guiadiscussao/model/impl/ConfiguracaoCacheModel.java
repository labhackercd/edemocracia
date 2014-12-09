package br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Configuracao in entity cache.
 *
 * @author Robson
 * @see Configuracao
 * @generated
 */
public class ConfiguracaoCacheModel implements CacheModel<Configuracao>,
    Serializable {
    public long configuracaoId;
    public long groupId;
    public long faseAtualId;
    public String textoBanner;
    public long imagemIdBanner;
    public String urlBanner;
    public boolean urlExterna;
    public String tituloBanner;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{configuracaoId=");
        sb.append(configuracaoId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", faseAtualId=");
        sb.append(faseAtualId);
        sb.append(", textoBanner=");
        sb.append(textoBanner);
        sb.append(", imagemIdBanner=");
        sb.append(imagemIdBanner);
        sb.append(", urlBanner=");
        sb.append(urlBanner);
        sb.append(", urlExterna=");
        sb.append(urlExterna);
        sb.append(", tituloBanner=");
        sb.append(tituloBanner);
        sb.append("}");

        return sb.toString();
    }

    public Configuracao toEntityModel() {
        ConfiguracaoImpl configuracaoImpl = new ConfiguracaoImpl();

        configuracaoImpl.setConfiguracaoId(configuracaoId);
        configuracaoImpl.setGroupId(groupId);
        configuracaoImpl.setFaseAtualId(faseAtualId);

        if (textoBanner == null) {
            configuracaoImpl.setTextoBanner(StringPool.BLANK);
        } else {
            configuracaoImpl.setTextoBanner(textoBanner);
        }

        configuracaoImpl.setImagemIdBanner(imagemIdBanner);

        if (urlBanner == null) {
            configuracaoImpl.setUrlBanner(StringPool.BLANK);
        } else {
            configuracaoImpl.setUrlBanner(urlBanner);
        }

        configuracaoImpl.setUrlExterna(urlExterna);

        if (tituloBanner == null) {
            configuracaoImpl.setTituloBanner(StringPool.BLANK);
        } else {
            configuracaoImpl.setTituloBanner(tituloBanner);
        }

        configuracaoImpl.resetOriginalValues();

        return configuracaoImpl;
    }
}

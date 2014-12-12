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
package br.gov.camara.edemocracia.portlets.guiadiscussao.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Robson
 * @generated
 */
public class ConfiguracaoSoap implements Serializable {
    private long _configuracaoId;
    private long _groupId;
    private long _faseAtualId;
    private String _textoBanner;
    private long _imagemIdBanner;
    private String _urlBanner;
    private boolean _urlExterna;
    private String _tituloBanner;

    public ConfiguracaoSoap() {
    }

    public static ConfiguracaoSoap toSoapModel(Configuracao model) {
        ConfiguracaoSoap soapModel = new ConfiguracaoSoap();

        soapModel.setConfiguracaoId(model.getConfiguracaoId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setFaseAtualId(model.getFaseAtualId());
        soapModel.setTextoBanner(model.getTextoBanner());
        soapModel.setImagemIdBanner(model.getImagemIdBanner());
        soapModel.setUrlBanner(model.getUrlBanner());
        soapModel.setUrlExterna(model.getUrlExterna());
        soapModel.setTituloBanner(model.getTituloBanner());

        return soapModel;
    }

    public static ConfiguracaoSoap[] toSoapModels(Configuracao[] models) {
        ConfiguracaoSoap[] soapModels = new ConfiguracaoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ConfiguracaoSoap[][] toSoapModels(Configuracao[][] models) {
        ConfiguracaoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ConfiguracaoSoap[models.length][models[0].length];
        } else {
            soapModels = new ConfiguracaoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ConfiguracaoSoap[] toSoapModels(List<Configuracao> models) {
        List<ConfiguracaoSoap> soapModels = new ArrayList<ConfiguracaoSoap>(models.size());

        for (Configuracao model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ConfiguracaoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _configuracaoId;
    }

    public void setPrimaryKey(long pk) {
        setConfiguracaoId(pk);
    }

    public long getConfiguracaoId() {
        return _configuracaoId;
    }

    public void setConfiguracaoId(long configuracaoId) {
        _configuracaoId = configuracaoId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getFaseAtualId() {
        return _faseAtualId;
    }

    public void setFaseAtualId(long faseAtualId) {
        _faseAtualId = faseAtualId;
    }

    public String getTextoBanner() {
        return _textoBanner;
    }

    public void setTextoBanner(String textoBanner) {
        _textoBanner = textoBanner;
    }

    public long getImagemIdBanner() {
        return _imagemIdBanner;
    }

    public void setImagemIdBanner(long imagemIdBanner) {
        _imagemIdBanner = imagemIdBanner;
    }

    public String getUrlBanner() {
        return _urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        _urlBanner = urlBanner;
    }

    public boolean getUrlExterna() {
        return _urlExterna;
    }

    public boolean isUrlExterna() {
        return _urlExterna;
    }

    public void setUrlExterna(boolean urlExterna) {
        _urlExterna = urlExterna;
    }

    public String getTituloBanner() {
        return _tituloBanner;
    }

    public void setTituloBanner(String tituloBanner) {
        _tituloBanner = tituloBanner;
    }
}

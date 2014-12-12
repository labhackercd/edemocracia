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
package br.gov.camara.edemocracia.portlets.priorizacao.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    robson
 * @generated
 */
public class ConfiguracaoSoap implements Serializable {
    private long _configuracaoId;
    private long _companyId;
    private long _groupId;
    private int _maximoVotos;
    private int _maxVotosProposta;
    private boolean _votacaoAberta;

    public ConfiguracaoSoap() {
    }

    public static ConfiguracaoSoap toSoapModel(Configuracao model) {
        ConfiguracaoSoap soapModel = new ConfiguracaoSoap();

        soapModel.setConfiguracaoId(model.getConfiguracaoId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setMaximoVotos(model.getMaximoVotos());
        soapModel.setMaxVotosProposta(model.getMaxVotosProposta());
        soapModel.setVotacaoAberta(model.getVotacaoAberta());

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

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public int getMaximoVotos() {
        return _maximoVotos;
    }

    public void setMaximoVotos(int maximoVotos) {
        _maximoVotos = maximoVotos;
    }

    public int getMaxVotosProposta() {
        return _maxVotosProposta;
    }

    public void setMaxVotosProposta(int maxVotosProposta) {
        _maxVotosProposta = maxVotosProposta;
    }

    public boolean getVotacaoAberta() {
        return _votacaoAberta;
    }

    public boolean isVotacaoAberta() {
        return _votacaoAberta;
    }

    public void setVotacaoAberta(boolean votacaoAberta) {
        _votacaoAberta = votacaoAberta;
    }
}

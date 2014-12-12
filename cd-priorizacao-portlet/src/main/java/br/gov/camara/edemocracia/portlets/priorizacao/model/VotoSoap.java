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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    robson
 * @generated
 */
public class VotoSoap implements Serializable {
    private long _votoId;
    private long _propostaId;
    private long _userId;
    private String _userName;
    private int _numeroVotos;
    private int _votosDisponiveis;
    private Date _data;

    public VotoSoap() {
    }

    public static VotoSoap toSoapModel(Voto model) {
        VotoSoap soapModel = new VotoSoap();

        soapModel.setVotoId(model.getVotoId());
        soapModel.setPropostaId(model.getPropostaId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setNumeroVotos(model.getNumeroVotos());
        soapModel.setVotosDisponiveis(model.getVotosDisponiveis());
        soapModel.setData(model.getData());

        return soapModel;
    }

    public static VotoSoap[] toSoapModels(Voto[] models) {
        VotoSoap[] soapModels = new VotoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static VotoSoap[][] toSoapModels(Voto[][] models) {
        VotoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new VotoSoap[models.length][models[0].length];
        } else {
            soapModels = new VotoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static VotoSoap[] toSoapModels(List<Voto> models) {
        List<VotoSoap> soapModels = new ArrayList<VotoSoap>(models.size());

        for (Voto model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new VotoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _votoId;
    }

    public void setPrimaryKey(long pk) {
        setVotoId(pk);
    }

    public long getVotoId() {
        return _votoId;
    }

    public void setVotoId(long votoId) {
        _votoId = votoId;
    }

    public long getPropostaId() {
        return _propostaId;
    }

    public void setPropostaId(long propostaId) {
        _propostaId = propostaId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public int getNumeroVotos() {
        return _numeroVotos;
    }

    public void setNumeroVotos(int numeroVotos) {
        _numeroVotos = numeroVotos;
    }

    public int getVotosDisponiveis() {
        return _votosDisponiveis;
    }

    public void setVotosDisponiveis(int votosDisponiveis) {
        _votosDisponiveis = votosDisponiveis;
    }

    public Date getData() {
        return _data;
    }

    public void setData(Date data) {
        _data = data;
    }
}

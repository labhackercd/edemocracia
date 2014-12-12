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
package br.gov.camara.edemocracia.portlets.wikilegis.model;

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
public class ContribuicaoSoap implements Serializable {
    private long _contribuicaoId;
    private long _artigoId;
    private String _texto;
    private String _descricao;
    private Date _data;
    private long _userId;
    private String _userName;

    public ContribuicaoSoap() {
    }

    public static ContribuicaoSoap toSoapModel(Contribuicao model) {
        ContribuicaoSoap soapModel = new ContribuicaoSoap();

        soapModel.setContribuicaoId(model.getContribuicaoId());
        soapModel.setArtigoId(model.getArtigoId());
        soapModel.setTexto(model.getTexto());
        soapModel.setDescricao(model.getDescricao());
        soapModel.setData(model.getData());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());

        return soapModel;
    }

    public static ContribuicaoSoap[] toSoapModels(Contribuicao[] models) {
        ContribuicaoSoap[] soapModels = new ContribuicaoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContribuicaoSoap[][] toSoapModels(Contribuicao[][] models) {
        ContribuicaoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContribuicaoSoap[models.length][models[0].length];
        } else {
            soapModels = new ContribuicaoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContribuicaoSoap[] toSoapModels(List<Contribuicao> models) {
        List<ContribuicaoSoap> soapModels = new ArrayList<ContribuicaoSoap>(models.size());

        for (Contribuicao model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContribuicaoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contribuicaoId;
    }

    public void setPrimaryKey(long pk) {
        setContribuicaoId(pk);
    }

    public long getContribuicaoId() {
        return _contribuicaoId;
    }

    public void setContribuicaoId(long contribuicaoId) {
        _contribuicaoId = contribuicaoId;
    }

    public long getArtigoId() {
        return _artigoId;
    }

    public void setArtigoId(long artigoId) {
        _artigoId = artigoId;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String descricao) {
        _descricao = descricao;
    }

    public Date getData() {
        return _data;
    }

    public void setData(Date data) {
        _data = data;
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
}

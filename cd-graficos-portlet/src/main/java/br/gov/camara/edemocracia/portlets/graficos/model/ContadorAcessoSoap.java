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
package br.gov.camara.edemocracia.portlets.graficos.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Robson Miranda
 * @generated
 */
public class ContadorAcessoSoap implements Serializable {
    private long _contadorId;
    private long _companyId;
    private Date _data;
    private Date _dataAtualizacao;
    private String _cache;

    public ContadorAcessoSoap() {
    }

    public static ContadorAcessoSoap toSoapModel(ContadorAcesso model) {
        ContadorAcessoSoap soapModel = new ContadorAcessoSoap();

        soapModel.setContadorId(model.getContadorId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setData(model.getData());
        soapModel.setDataAtualizacao(model.getDataAtualizacao());
        soapModel.setCache(model.getCache());

        return soapModel;
    }

    public static ContadorAcessoSoap[] toSoapModels(ContadorAcesso[] models) {
        ContadorAcessoSoap[] soapModels = new ContadorAcessoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContadorAcessoSoap[][] toSoapModels(ContadorAcesso[][] models) {
        ContadorAcessoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContadorAcessoSoap[models.length][models[0].length];
        } else {
            soapModels = new ContadorAcessoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContadorAcessoSoap[] toSoapModels(List<ContadorAcesso> models) {
        List<ContadorAcessoSoap> soapModels = new ArrayList<ContadorAcessoSoap>(models.size());

        for (ContadorAcesso model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContadorAcessoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contadorId;
    }

    public void setPrimaryKey(long pk) {
        setContadorId(pk);
    }

    public long getContadorId() {
        return _contadorId;
    }

    public void setContadorId(long contadorId) {
        _contadorId = contadorId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public Date getData() {
        return _data;
    }

    public void setData(Date data) {
        _data = data;
    }

    public Date getDataAtualizacao() {
        return _dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        _dataAtualizacao = dataAtualizacao;
    }

    public String getCache() {
        return _cache;
    }

    public void setCache(String cache) {
        _cache = cache;
    }
}

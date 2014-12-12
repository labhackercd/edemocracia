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
public class EixoSoap implements Serializable {
    private long _eixoId;
    private long _companyId;
    private long _groupId;
    private long _categoryId;
    private String _titulo;
    private String _sumario;
    private int _ordem;

    public EixoSoap() {
    }

    public static EixoSoap toSoapModel(Eixo model) {
        EixoSoap soapModel = new EixoSoap();

        soapModel.setEixoId(model.getEixoId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setTitulo(model.getTitulo());
        soapModel.setSumario(model.getSumario());
        soapModel.setOrdem(model.getOrdem());

        return soapModel;
    }

    public static EixoSoap[] toSoapModels(Eixo[] models) {
        EixoSoap[] soapModels = new EixoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EixoSoap[][] toSoapModels(Eixo[][] models) {
        EixoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EixoSoap[models.length][models[0].length];
        } else {
            soapModels = new EixoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EixoSoap[] toSoapModels(List<Eixo> models) {
        List<EixoSoap> soapModels = new ArrayList<EixoSoap>(models.size());

        for (Eixo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EixoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _eixoId;
    }

    public void setPrimaryKey(long pk) {
        setEixoId(pk);
    }

    public long getEixoId() {
        return _eixoId;
    }

    public void setEixoId(long eixoId) {
        _eixoId = eixoId;
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

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String titulo) {
        _titulo = titulo;
    }

    public String getSumario() {
        return _sumario;
    }

    public void setSumario(String sumario) {
        _sumario = sumario;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }
}

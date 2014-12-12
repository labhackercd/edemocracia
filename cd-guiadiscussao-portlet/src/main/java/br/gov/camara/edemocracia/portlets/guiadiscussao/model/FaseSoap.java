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
public class FaseSoap implements Serializable {
    private long _faseId;
    private long _configuracaoId;
    private int _ordem;
    private String _titulo;

    public FaseSoap() {
    }

    public static FaseSoap toSoapModel(Fase model) {
        FaseSoap soapModel = new FaseSoap();

        soapModel.setFaseId(model.getFaseId());
        soapModel.setConfiguracaoId(model.getConfiguracaoId());
        soapModel.setOrdem(model.getOrdem());
        soapModel.setTitulo(model.getTitulo());

        return soapModel;
    }

    public static FaseSoap[] toSoapModels(Fase[] models) {
        FaseSoap[] soapModels = new FaseSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FaseSoap[][] toSoapModels(Fase[][] models) {
        FaseSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FaseSoap[models.length][models[0].length];
        } else {
            soapModels = new FaseSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FaseSoap[] toSoapModels(List<Fase> models) {
        List<FaseSoap> soapModels = new ArrayList<FaseSoap>(models.size());

        for (Fase model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FaseSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _faseId;
    }

    public void setPrimaryKey(long pk) {
        setFaseId(pk);
    }

    public long getFaseId() {
        return _faseId;
    }

    public void setFaseId(long faseId) {
        _faseId = faseId;
    }

    public long getConfiguracaoId() {
        return _configuracaoId;
    }

    public void setConfiguracaoId(long configuracaoId) {
        _configuracaoId = configuracaoId;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public String getTitulo() {
        return _titulo;
    }

    public void setTitulo(String titulo) {
        _titulo = titulo;
    }
}

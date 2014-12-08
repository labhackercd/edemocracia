package br.gov.camara.edemocracia.portlets.wikilegis.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    robson
 * @generated
 */
public class ArtigoSoap implements Serializable {
    private long _artigoId;
    private long _companyId;
    private long _groupId;
    private long _estruturaId;
    private int _ordem;
    private String _texto;
    private String _legislacaoVigente;

    public ArtigoSoap() {
    }

    public static ArtigoSoap toSoapModel(Artigo model) {
        ArtigoSoap soapModel = new ArtigoSoap();

        soapModel.setArtigoId(model.getArtigoId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setEstruturaId(model.getEstruturaId());
        soapModel.setOrdem(model.getOrdem());
        soapModel.setTexto(model.getTexto());
        soapModel.setLegislacaoVigente(model.getLegislacaoVigente());

        return soapModel;
    }

    public static ArtigoSoap[] toSoapModels(Artigo[] models) {
        ArtigoSoap[] soapModels = new ArtigoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ArtigoSoap[][] toSoapModels(Artigo[][] models) {
        ArtigoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ArtigoSoap[models.length][models[0].length];
        } else {
            soapModels = new ArtigoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ArtigoSoap[] toSoapModels(List<Artigo> models) {
        List<ArtigoSoap> soapModels = new ArrayList<ArtigoSoap>(models.size());

        for (Artigo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ArtigoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _artigoId;
    }

    public void setPrimaryKey(long pk) {
        setArtigoId(pk);
    }

    public long getArtigoId() {
        return _artigoId;
    }

    public void setArtigoId(long artigoId) {
        _artigoId = artigoId;
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

    public long getEstruturaId() {
        return _estruturaId;
    }

    public void setEstruturaId(long estruturaId) {
        _estruturaId = estruturaId;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public String getLegislacaoVigente() {
        return _legislacaoVigente;
    }

    public void setLegislacaoVigente(String legislacaoVigente) {
        _legislacaoVigente = legislacaoVigente;
    }
}

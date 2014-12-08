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
public class EstruturaSoap implements Serializable {
    private long _estruturaId;
    private long _companyId;
    private long _groupId;
    private String _texto;
    private int _ordem;
    private long _paiEstruturaId;

    public EstruturaSoap() {
    }

    public static EstruturaSoap toSoapModel(Estrutura model) {
        EstruturaSoap soapModel = new EstruturaSoap();

        soapModel.setEstruturaId(model.getEstruturaId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setTexto(model.getTexto());
        soapModel.setOrdem(model.getOrdem());
        soapModel.setPaiEstruturaId(model.getPaiEstruturaId());

        return soapModel;
    }

    public static EstruturaSoap[] toSoapModels(Estrutura[] models) {
        EstruturaSoap[] soapModels = new EstruturaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EstruturaSoap[][] toSoapModels(Estrutura[][] models) {
        EstruturaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EstruturaSoap[models.length][models[0].length];
        } else {
            soapModels = new EstruturaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EstruturaSoap[] toSoapModels(List<Estrutura> models) {
        List<EstruturaSoap> soapModels = new ArrayList<EstruturaSoap>(models.size());

        for (Estrutura model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EstruturaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _estruturaId;
    }

    public void setPrimaryKey(long pk) {
        setEstruturaId(pk);
    }

    public long getEstruturaId() {
        return _estruturaId;
    }

    public void setEstruturaId(long estruturaId) {
        _estruturaId = estruturaId;
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

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public int getOrdem() {
        return _ordem;
    }

    public void setOrdem(int ordem) {
        _ordem = ordem;
    }

    public long getPaiEstruturaId() {
        return _paiEstruturaId;
    }

    public void setPaiEstruturaId(long paiEstruturaId) {
        _paiEstruturaId = paiEstruturaId;
    }
}

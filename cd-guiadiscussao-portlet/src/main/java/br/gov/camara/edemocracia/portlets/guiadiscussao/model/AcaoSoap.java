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
public class AcaoSoap implements Serializable {
    private long _acaoId;
    private long _faseId;
    private int _ordem;
    private String _texto;
    private boolean _urlExterna;
    private String _urlLink;
    private long _iconeId;

    public AcaoSoap() {
    }

    public static AcaoSoap toSoapModel(Acao model) {
        AcaoSoap soapModel = new AcaoSoap();

        soapModel.setAcaoId(model.getAcaoId());
        soapModel.setFaseId(model.getFaseId());
        soapModel.setOrdem(model.getOrdem());
        soapModel.setTexto(model.getTexto());
        soapModel.setUrlExterna(model.getUrlExterna());
        soapModel.setUrlLink(model.getUrlLink());
        soapModel.setIconeId(model.getIconeId());

        return soapModel;
    }

    public static AcaoSoap[] toSoapModels(Acao[] models) {
        AcaoSoap[] soapModels = new AcaoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AcaoSoap[][] toSoapModels(Acao[][] models) {
        AcaoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AcaoSoap[models.length][models[0].length];
        } else {
            soapModels = new AcaoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AcaoSoap[] toSoapModels(List<Acao> models) {
        List<AcaoSoap> soapModels = new ArrayList<AcaoSoap>(models.size());

        for (Acao model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AcaoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _acaoId;
    }

    public void setPrimaryKey(long pk) {
        setAcaoId(pk);
    }

    public long getAcaoId() {
        return _acaoId;
    }

    public void setAcaoId(long acaoId) {
        _acaoId = acaoId;
    }

    public long getFaseId() {
        return _faseId;
    }

    public void setFaseId(long faseId) {
        _faseId = faseId;
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

    public boolean getUrlExterna() {
        return _urlExterna;
    }

    public boolean isUrlExterna() {
        return _urlExterna;
    }

    public void setUrlExterna(boolean urlExterna) {
        _urlExterna = urlExterna;
    }

    public String getUrlLink() {
        return _urlLink;
    }

    public void setUrlLink(String urlLink) {
        _urlLink = urlLink;
    }

    public long getIconeId() {
        return _iconeId;
    }

    public void setIconeId(long iconeId) {
        _iconeId = iconeId;
    }
}

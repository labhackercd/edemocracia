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
public class PropostaSoap implements Serializable {
    private long _propostaId;
    private long _companyId;
    private long _groupId;
    private long _eixoId;
    private String _identificador;
    private String _ementa;
    private String _texto;
    private long _threadId;

    public PropostaSoap() {
    }

    public static PropostaSoap toSoapModel(Proposta model) {
        PropostaSoap soapModel = new PropostaSoap();

        soapModel.setPropostaId(model.getPropostaId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setEixoId(model.getEixoId());
        soapModel.setIdentificador(model.getIdentificador());
        soapModel.setEmenta(model.getEmenta());
        soapModel.setTexto(model.getTexto());
        soapModel.setThreadId(model.getThreadId());

        return soapModel;
    }

    public static PropostaSoap[] toSoapModels(Proposta[] models) {
        PropostaSoap[] soapModels = new PropostaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PropostaSoap[][] toSoapModels(Proposta[][] models) {
        PropostaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PropostaSoap[models.length][models[0].length];
        } else {
            soapModels = new PropostaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PropostaSoap[] toSoapModels(List<Proposta> models) {
        List<PropostaSoap> soapModels = new ArrayList<PropostaSoap>(models.size());

        for (Proposta model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PropostaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _propostaId;
    }

    public void setPrimaryKey(long pk) {
        setPropostaId(pk);
    }

    public long getPropostaId() {
        return _propostaId;
    }

    public void setPropostaId(long propostaId) {
        _propostaId = propostaId;
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

    public long getEixoId() {
        return _eixoId;
    }

    public void setEixoId(long eixoId) {
        _eixoId = eixoId;
    }

    public String getIdentificador() {
        return _identificador;
    }

    public void setIdentificador(String identificador) {
        _identificador = identificador;
    }

    public String getEmenta() {
        return _ementa;
    }

    public void setEmenta(String ementa) {
        _ementa = ementa;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        _texto = texto;
    }

    public long getThreadId() {
        return _threadId;
    }

    public void setThreadId(long threadId) {
        _threadId = threadId;
    }
}

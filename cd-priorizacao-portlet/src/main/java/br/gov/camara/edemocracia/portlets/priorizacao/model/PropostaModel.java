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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Proposta service. Represents a row in the &quot;PR_Proposta&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaImpl}.
 * </p>
 *
 * @author robson
 * @see Proposta
 * @see br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaModelImpl
 * @generated
 */
public interface PropostaModel extends BaseModel<Proposta> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a proposta model instance should use the {@link Proposta} interface instead.
     */

    /**
     * Returns the primary key of this proposta.
     *
     * @return the primary key of this proposta
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this proposta.
     *
     * @param primaryKey the primary key of this proposta
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the proposta ID of this proposta.
     *
     * @return the proposta ID of this proposta
     */
    public long getPropostaId();

    /**
     * Sets the proposta ID of this proposta.
     *
     * @param propostaId the proposta ID of this proposta
     */
    public void setPropostaId(long propostaId);

    /**
     * Returns the company ID of this proposta.
     *
     * @return the company ID of this proposta
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this proposta.
     *
     * @param companyId the company ID of this proposta
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this proposta.
     *
     * @return the group ID of this proposta
     */
    public long getGroupId();

    /**
     * Sets the group ID of this proposta.
     *
     * @param groupId the group ID of this proposta
     */
    public void setGroupId(long groupId);

    /**
     * Returns the eixo ID of this proposta.
     *
     * @return the eixo ID of this proposta
     */
    public long getEixoId();

    /**
     * Sets the eixo ID of this proposta.
     *
     * @param eixoId the eixo ID of this proposta
     */
    public void setEixoId(long eixoId);

    /**
     * Returns the identificador of this proposta.
     *
     * @return the identificador of this proposta
     */
    @AutoEscape
    public String getIdentificador();

    /**
     * Sets the identificador of this proposta.
     *
     * @param identificador the identificador of this proposta
     */
    public void setIdentificador(String identificador);

    /**
     * Returns the ementa of this proposta.
     *
     * @return the ementa of this proposta
     */
    @AutoEscape
    public String getEmenta();

    /**
     * Sets the ementa of this proposta.
     *
     * @param ementa the ementa of this proposta
     */
    public void setEmenta(String ementa);

    /**
     * Returns the texto of this proposta.
     *
     * @return the texto of this proposta
     */
    @AutoEscape
    public String getTexto();

    /**
     * Sets the texto of this proposta.
     *
     * @param texto the texto of this proposta
     */
    public void setTexto(String texto);

    /**
     * Returns the thread ID of this proposta.
     *
     * @return the thread ID of this proposta
     */
    public long getThreadId();

    /**
     * Sets the thread ID of this proposta.
     *
     * @param threadId the thread ID of this proposta
     */
    public void setThreadId(long threadId);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Proposta proposta);

    public int hashCode();

    public CacheModel<Proposta> toCacheModel();

    public Proposta toEscapedModel();

    public String toString();

    public String toXmlString();
}

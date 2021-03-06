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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Fase service. Represents a row in the &quot;GD_Fase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseImpl}.
 * </p>
 *
 * @author Robson
 * @see Fase
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseModelImpl
 * @generated
 */
public interface FaseModel extends BaseModel<Fase> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a fase model instance should use the {@link Fase} interface instead.
     */

    /**
     * Returns the primary key of this fase.
     *
     * @return the primary key of this fase
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this fase.
     *
     * @param primaryKey the primary key of this fase
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the fase ID of this fase.
     *
     * @return the fase ID of this fase
     */
    public long getFaseId();

    /**
     * Sets the fase ID of this fase.
     *
     * @param faseId the fase ID of this fase
     */
    public void setFaseId(long faseId);

    /**
     * Returns the configuracao ID of this fase.
     *
     * @return the configuracao ID of this fase
     */
    public long getConfiguracaoId();

    /**
     * Sets the configuracao ID of this fase.
     *
     * @param configuracaoId the configuracao ID of this fase
     */
    public void setConfiguracaoId(long configuracaoId);

    /**
     * Returns the ordem of this fase.
     *
     * @return the ordem of this fase
     */
    public int getOrdem();

    /**
     * Sets the ordem of this fase.
     *
     * @param ordem the ordem of this fase
     */
    public void setOrdem(int ordem);

    /**
     * Returns the titulo of this fase.
     *
     * @return the titulo of this fase
     */
    @AutoEscape
    public String getTitulo();

    /**
     * Sets the titulo of this fase.
     *
     * @param titulo the titulo of this fase
     */
    public void setTitulo(String titulo);

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

    public int compareTo(Fase fase);

    public int hashCode();

    public CacheModel<Fase> toCacheModel();

    public Fase toEscapedModel();

    public String toString();

    public String toXmlString();
}

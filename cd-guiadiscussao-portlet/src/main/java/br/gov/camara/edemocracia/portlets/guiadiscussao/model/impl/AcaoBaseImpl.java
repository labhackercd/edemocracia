package br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Acao service. Represents a row in the &quot;GD_Acao&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AcaoImpl}.
 * </p>
 *
 * @author Robson
 * @see AcaoImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao
 * @generated
 */
public abstract class AcaoBaseImpl extends AcaoModelImpl implements Acao {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a acao model instance should use the {@link Acao} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            AcaoLocalServiceUtil.addAcao(this);
        } else {
            AcaoLocalServiceUtil.updateAcao(this);
        }
    }
}
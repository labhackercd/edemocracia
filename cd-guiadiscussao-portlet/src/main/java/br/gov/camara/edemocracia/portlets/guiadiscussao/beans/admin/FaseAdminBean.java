package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.camara.edemocracia.portlets.guiadiscussao.CantFaseMoveDownException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.CantFaseMoveUpException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean(name = "faseAdminBean")
@ViewScoped
public class FaseAdminBean implements Serializable {

	private static final long serialVersionUID = -3787023870893069005L;
	private Fase fase;

	// Lista de fases e ações cadastradas
	private List<DadosFaseDisplay> dadosDisplay;
	private DadosFaseDisplay dadosFaseSelecionada;

	@ManagedProperty(value = "#{configuracaoAdminBean}")
	private ConfiguracaoAdminBean configuracaoAdminBean;

	private static final Log LOG = LogFactoryUtil.getLog(FaseAdminBean.class);

	public FaseAdminBean() {
		this.fase = new FaseImpl();
		this.dadosDisplay = new ArrayList<DadosFaseDisplay>();
	}

	@PostConstruct
	private void init() {
		atualizaFases();
	}

	public void editarFase(long faseId) {

		try {
			this.fase = FaseLocalServiceUtil.getFase(faseId);

		} catch (PortalException e) {
			LOG.error("#{i18n['fase-nao-encontrada']}", e);
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-encontrada']}");
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}

	public void saveFase() {

		try {
			this.fase.setConfiguracaoId(configuracaoAdminBean.getConfig()
					.getConfiguracaoId());
			if (fase.getFaseId() == 0) {
				FaseLocalServiceUtil.criaFase(this.fase);
				configuracaoAdminBean.atualizaConfiguracao();
			} else {
				FaseLocalServiceUtil.updateFase(fase, true);
			}

		} catch (SystemException e) {
			throw new RuntimeException(e);
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Ocorreu um erro ao gravar fase.");
			LOG.error("Ocorreu um erro ao gravar fase",e);
		}

		atualizaFases();
		this.fase = new FaseImpl();

	}

	public void moverParaCima(long faseId) throws SystemException {

		try {
			Fase fase = FaseLocalServiceUtil.getFase(faseId);
			if (fase != null) {
				FaseLocalServiceUtil.moverFaseParaCima(fase.getFaseId());
			} else {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"#{i18n['fase-nao-encontrada']}");
			}

		} catch (CantFaseMoveUpException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-move-cima']}");
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-encontrada']}");
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		atualizaFases();
	}

	public void moverParaBaixo(long faseId) {

		try {
			Fase fase = FaseLocalServiceUtil.getFase(faseId);
			if (fase != null) {
				FaseLocalServiceUtil.moverFaseParaBaixo(faseId);
			} else {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"#{i18n['fase-nao-encontrada']}");
			}

		} catch (CantFaseMoveDownException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-move-baixo']}");
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-encontrada']}");
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		atualizaFases();
	}

	public void excluir(long faseId) {

		try {
			Fase fase = FaseLocalServiceUtil.getFase(faseId);
			if (fase != null) {
				FaseLocalServiceUtil.excluirFase(fase.getFaseId());
				configuracaoAdminBean.atualizaConfiguracao();
			} else {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"#{i18n['fase-nao-encontrada']}");
			}

		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-encontrada']}");
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		atualizaFases();

	}

	public void atualizaFases() {
		dadosDisplay = new ArrayList<DadosFaseDisplay>();
		try {
			List<Fase> fases = FaseLocalServiceUtil
					.getFasesByConfiguracaoId(configuracaoAdminBean.getConfig()
							.getConfiguracaoId());

			for (Fase fase : fases) {
				dadosDisplay
						.add(new DadosFaseDisplay(fase, AcaoLocalServiceUtil
								.getAcoesByFaseId(fase.getFaseId())));
			}

		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {

		this.fase = fase;
	}

	public List<DadosFaseDisplay> getDadosDisplay() {
		return dadosDisplay;
	}

	public void setDadosDisplay(List<DadosFaseDisplay> dadosDisplay) {
		this.dadosDisplay = dadosDisplay;
	}

	public ConfiguracaoAdminBean getConfiguracaoAdminBean() {
		return configuracaoAdminBean;
	}

	public void setConfiguracaoAdminBean(
			ConfiguracaoAdminBean configuracaoAdminBean) {
		this.configuracaoAdminBean = configuracaoAdminBean;
	}

	public DadosFaseDisplay getDadosFaseSelecionada() {
		return dadosFaseSelecionada;
	}

	public void setDadosFaseSelecionada(DadosFaseDisplay dadosFaseSelecionada) {
		this.dadosFaseSelecionada = dadosFaseSelecionada;
	}

}

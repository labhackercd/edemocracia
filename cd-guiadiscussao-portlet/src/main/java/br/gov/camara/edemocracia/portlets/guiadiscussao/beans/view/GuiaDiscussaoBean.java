/**
 * 
 */
package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.BibliotecaImagensUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.URLUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "guiaDiscussaoBean")
@RequestScoped
public class GuiaDiscussaoBean {

	private Configuracao config;
	private List<Fase> fases;
	private Fase faseAtual;
	private HashMap<Long, List<Acao>> acoesPorFase;

	@PostConstruct
	public void carregaFases() {
		long groupId = LiferayFacesContext.getInstance().getScopeGroupId();
		try {
			config = ConfiguracaoLocalServiceUtil.getByGroupId(groupId);
			fases = FaseLocalServiceUtil.getFasesByConfiguracaoId(config
					.getConfiguracaoId());
			recuperaFaseAtual();
			recuperaAcoesDasFasesCarregadas();
		} catch (SystemException e) {
			fases = null;
			throw new RuntimeException(e);
		}

	}

	private void recuperaFaseAtual() {
		for (Fase fase : fases) {
			if (fase.getFaseId() == config.getFaseAtualId()) {
				faseAtual = fase;
				break;
			}
		}
	}

	private void recuperaAcoesDasFasesCarregadas() throws SystemException {
		acoesPorFase = new HashMap<Long, List<Acao>>();
		for (Fase fase : fases) {
			long faseId = fase.getFaseId();
			acoesPorFase.put(faseId,
					AcaoLocalServiceUtil.getAcoesByFaseId(faseId));
		}
	}

	public List<Fase> getFases() {
		return fases;
	}

	public String tipoFase(Fase fase) {
		if (faseAtual == null || fase.getOrdem() > faseAtual.getOrdem())
			return "Fase futura";
		else if (fase.getOrdem() == faseAtual.getOrdem())
			return "Fase atual";
		else
			return "Fase encerrada";
	}

	public String classeFase(Fase fase) {
//		String tipo;
//		if (faseAtual == null || fase.getOrdem() > faseAtual.getOrdem())
//			tipo = "futura";
//		else if (fase.getOrdem() == faseAtual.getOrdem())
//			tipo = "atual";
//		else
//			tipo = "encerrada";
//
//		if (fases.size() == 1) {
//			tipo = tipo + " " + tipo + "Unica";
//		}
//
//		if (fase.equals(fases.get(0)))
//			tipo = tipo + " " + tipo + "Inicio";
//		if (fase.equals(fases.get(fases.size() - 1)))
//			tipo = tipo + " " + tipo + "Fim";
		
		if(fase == faseAtual)
			return "atual selecionada";
		else 
			return "";

	}
	
	public int getIndexFaseAtual(){
		if(faseAtual !=  null)
			return faseAtual.getOrdem();
		else 
			return 1;
	}
	
	public boolean isFaseSelecionada(Fase fase) {
		return (faseAtual != null)
				&& (fase.getFaseId() == faseAtual.getFaseId());
	}

	public List<Acao> getAcoesPorFase(Fase fase) {
		if (fase == null) {
			return Collections.emptyList();
		}
		long faseId = fase.getFaseId();
		if (!acoesPorFase.containsKey(faseId))
			return Collections.emptyList();
		else
			return Collections.unmodifiableList(acoesPorFase.get(faseId));
	}

	public String urlImagem(Acao acao) {
		return BibliotecaImagensUtil.getUrlImagem(acao.getIconeId());
	}

	public String constroiUrlAcao(Acao acao) {
		String url = acao.getUrlLink();
		boolean urlExterna = acao.isUrlExterna();
		return URLUtil.construirURL(url, urlExterna); 
	}
}

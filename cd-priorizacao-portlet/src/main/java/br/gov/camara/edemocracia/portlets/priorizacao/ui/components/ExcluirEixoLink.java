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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.link.Link;

import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ExcluirEixoLink extends Link<Void> {

	private static final long serialVersionUID = 1L;
	private long eixoId;
	private static final Log LOG = LogFactoryUtil.getLog(ExcluirEixoLink.class);

	public ExcluirEixoLink(String id, long eixoId) {
		super(id);
		this.eixoId = eixoId;
		this.add(new SimpleAttributeModifier(
				"onclick",
				"if(!confirm('Ao excluir o eixo, todas as propostas vinculadas ao mesmo também serão excluidas.Confirma exclusão?')) return false;"));
	}

	@Override
	public void onClick() {
		excluir();
	}

	private void excluir() {
		try {
			PriorizacaoServiceUtil.deleteEixo(eixoId);
			info("Eixo excluido com sucesso!");
		} catch (PortalException e) {
			error("Erro ao excluir eixo");
			LOG.error("Erro ao deletar eixo");
		} catch (SystemException e) {
			error("Erro ao excluir eixo");
			LOG.error("Erro ao deletar eixo");
		}
	}

}

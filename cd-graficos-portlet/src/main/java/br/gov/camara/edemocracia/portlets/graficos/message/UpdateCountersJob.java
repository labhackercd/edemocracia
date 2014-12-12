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
package br.gov.camara.edemocracia.portlets.graficos.message;

import java.util.List;

import br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;

/**
 * Atualiza os contadores
 * 
 * @author p_7339
 *
 */
public class UpdateCountersJob implements MessageListener {

	private static final Log log = LogFactoryUtil.getLog(UpdateCountersJob.class);
	
	/**
	 * Atualiza os contadores
	 */
	@Override
	public void receive(Message message) {
		
		
		log.info("Inciando atualização de estatísticas");
		List<Company> companhias;
		try {
			companhias = CompanyLocalServiceUtil.getCompanies();
		} catch (SystemException e) {
			log.error("Erro ao recuperar companhias", e);
			return;
		}
		
		for (Company companhia : companhias) {
			try {
				ContadorAcessoLocalServiceUtil.getCSV(companhia.getCompanyId());
			} catch (Exception e) {
				log.error("Erro ao atualizar dados da companhia " + companhia.getCompanyId(), e);
			}
		}
		log.info("Fim da atualização de estatísticas");
	}
}

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
package br.gov.camara.edemocracia.portlets.wikilegis.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.service.base.EstruturaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The implementation of the no local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil}
 * to access the no local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.EstruturaLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil
 */
public class EstruturaLocalServiceImpl extends EstruturaLocalServiceBaseImpl {

	/**
	 * Comparador de nós
	 * 
	 * @author rpdmiranda
	 * 
	 */
	private static class NoComparator implements Comparator<Estrutura> {
		@Override
		public int compare(Estrutura o1, Estrutura o2) {
			if (o1 == o2)
				return 0;
			if (o1.getOrdem() < o2.getOrdem())
				return -1;
			else
				return 1;
		}
	}

	/**
	 * Lista todos os nós
	 * 
	 * @return
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	public List<Estrutura> listaTodos(long groupId) throws SystemException {
		List<Estrutura> raizes = new ArrayList<Estrutura>(
				estruturaPersistence.findByG_P(groupId, 0l));
		Collections.sort(raizes, new NoComparator());

		ArrayList<Estrutura> retorno = new ArrayList<Estrutura>();
		for (Estrutura no : raizes) {
			adicionaFilhos(retorno, no);
		}
		return retorno;
	}

	/**
	 * Recupera os filhos e adiciona na lista
	 * 
	 * @param retorno
	 * @param no
	 * @throws SystemException
	 */
	private void adicionaFilhos(ArrayList<Estrutura> retorno, Estrutura no)
			throws SystemException {
		retorno.add(no);
		List<Estrutura> filhos =new ArrayList<Estrutura>(estruturaPersistence.findByG_P(
				no.getGroupId(), no.getEstruturaId()));
		Collections.sort(filhos,new NoComparator());
		for (Estrutura filho : filhos) {
			adicionaFilhos(retorno, filho);
		}
	}

	/**
	 * Lista os elementos filhos
	 * 
	 * @param groupId
	 * @param estruturaPaiId
	 * @return
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Estrutura> listaFilhos(long groupId, long estruturaPaiId)
			throws SystemException {
		List<Estrutura> filhos = new ArrayList<Estrutura>(
				estruturaPersistence.findByG_P(groupId, estruturaPaiId));
		Collections.sort(filhos, new NoComparator());
		return filhos;
	}

	/**
	 * Cria uma nova estrutura
	 * 
	 * @param groupId
	 * @param paiEstruturaId
	 * @param depoisDeEstruturaId
	 * @param texto
	 * @throws SystemException
	 * @throws PortalException
	 * @return Estrutura recém-criada
	 */
	@Override
	public Estrutura criaEstrutura(long groupId, long paiEstruturaId,
			long depoisDeEstruturaId, String texto) throws SystemException,
			PortalException {
		int ordem = 0;
		if (depoisDeEstruturaId > 0l) {
			Estrutura anterior = getEstrutura(depoisDeEstruturaId);
			ordem = anterior.getOrdem() + 1;
		}

		// Cria espaço
		List<Estrutura> filhos = estruturaPersistence.findByG_P(groupId,
				paiEstruturaId);
		for (Estrutura filho : filhos) {
			if (filho.getOrdem() >= ordem) {
				filho.setOrdem(filho.getOrdem() + 1);
				updateEstrutura(filho, true);
			}
		}

		// Cria a nova estrutura
		Estrutura nova = createEstrutura(counterLocalService.increment());
		nova.setGroupId(groupId);
		nova.setPaiEstruturaId(paiEstruturaId);
		nova.setOrdem(ordem);
		nova.setTexto(texto);
		return addEstrutura(nova);
	}

	@Transactional(rollbackFor = NoSuchEstruturaException.class)
	public Estrutura atualizaEstrutura(long estruturaId, long groupId,
			long estruturaPaiId, long depoisDeEstruturaId, String texto)
			throws PortalException, SystemException {

		// Atualiza o texto
		if (texto == null)
			texto = "";
		texto = texto.trim();
		
		Estrutura estrutura = estruturaPersistence.findByPrimaryKey(estruturaId);
		estrutura.setTexto(texto);
		
		long estruturaPaiAtual = estrutura.getPaiEstruturaId();

		List<Estrutura> estruturas = listaFilhos(groupId, estruturaPaiAtual);
		int ordemAnterior = estrutura.getOrdem();

		// Altera a numeração, retirando o nó da hierarquia existente
		estrutura.setOrdem(-1);
		estruturaPersistence.update(estrutura, false);

		for (Estrutura anterior : estruturas) {
			if (anterior.getEstruturaId() != estrutura.getEstruturaId()
					&& anterior.getOrdem() > ordemAnterior) {
				anterior.setOrdem(anterior.getOrdem() - 1);
				estruturaPersistence.update(anterior, false);
			}
		}

		estrutura.setPaiEstruturaId(estruturaPaiId);

		int ordem = atualizaPosicaoEstruturas(groupId, estruturaPaiId, depoisDeEstruturaId);
				
		estrutura.setOrdem(ordem);

		return estruturaPersistence.update(estrutura, false);

	}
	
	private int atualizaPosicaoEstruturas(long groupId, long estruturaPaiId,
			long anteriorEstruturaId) throws PortalException, SystemException {
		
		int ordem = 0;
							
		if (anteriorEstruturaId > 0l) {
				
			Estrutura anterior = getEstrutura(anteriorEstruturaId);				
			// Deve estar na mesma estrutura
			if (anterior.getPaiEstruturaId() == estruturaPaiId)
				ordem = anterior.getOrdem() + 1;
		}		
		
		List<Estrutura> listFilhos = listaFilhos(groupId,estruturaPaiId);

		for (Estrutura estruturaFilho : listFilhos) {
			if (estruturaFilho.getOrdem() >= ordem) {
				estruturaFilho.setOrdem(estruturaFilho.getOrdem() + 1);
				estruturaPersistence.update(estruturaFilho, false);
			}
		}
		
		return ordem;
	}


}

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
package br.gov.camara.edemocracia.portlets.cancelamentoassinatura.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.liferay.faces.portal.context.LiferayFacesContext;

import br.gov.camara.edemocracia.portlets.cancelamentoassinatura.dto.Assinatura;
import br.gov.camara.edemocracia.portlets.cancelamentoassinatura.dto.TipoAssinatura;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Subscription;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portlet.announcements.model.AnnouncementsDelivery;
import com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalServiceUtil;
import com.liferay.portlet.messageboards.NoSuchCategoryException;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

/**
 * @author p_7339
 * 
 */
@ManagedBean(name = "assinaturasBean")
@ViewScoped
public class AssinaturasBean {

	
	private List<Assinatura> assinaturas;
	
	public List<Assinatura> getAssinaturas() {
		if (assinaturas != null)
			return assinaturas;

		long userId = LiferayFacesContext.getInstance().getUserId();
		long companyId = LiferayFacesContext.getInstance().getCompanyId();
		Locale locale = LiferayFacesContext.getInstance().getLocale();

		assinaturas = new ArrayList<Assinatura>();
		
		// Assinaturas de notificações - acrescenta-as à comunidade padrão
		try {
			Group comunidadeGuest = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);
			String nomeComunidadeGuest = comunidadeGuest.getDescriptiveName();
			
			List<AnnouncementsDelivery> deliveries = AnnouncementsDeliveryLocalServiceUtil
					.getUserDeliveries(userId);

			for (AnnouncementsDelivery delivery : deliveries) {
				if (delivery.getEmail()) {
					Assinatura assinatura = new Assinatura();
					assinatura.setComunidade(nomeComunidadeGuest);
					assinatura.setTipo(TipoAssinatura.ANUNCIO);
					assinatura.setIdentificador("n" + delivery.getType());
					assinatura
							.setNome(LanguageUtil.get(locale, delivery.getType()));
					assinaturas.add(assinatura);
				}
			}
		} catch (PortalException e) {
			// TODO Log
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		// Verifica onde o usuário está inscrito
		try {
			assinaturasCategoriaForum(userId, locale);
			assinaturasThreadForum(userId);
			assinaturasNoWiki(userId);
			assinaturasPaginaWiki(userId);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		Collections.sort(assinaturas, new Comparator<Assinatura>() {

			@Override
			public int compare(Assinatura o1, Assinatura o2) {
				if (o1.getComunidade() == null && o2.getComunidade() != null)
					return -1;
				else if (o1.getComunidade() != null
						&& o2.getComunidade() == null)
					return 1;
				else if (o1.getComunidade() == o2.getComunidade()
						|| o1.getComunidade().equalsIgnoreCase(
								o2.getComunidade())) {
					if (!o1.getTipo().equals(o2.getTipo()))
						return (o1.getTipo().compareTo(o2.getTipo()));
					return o1.getNome().compareToIgnoreCase(o2.getNome());
				} else {
					// comunidades são != null e são diferentes entre si
					return o1.getComunidade().compareToIgnoreCase(
							o2.getComunidade());
				}
			}
		});
		return assinaturas;
	}

	/**
	 * @param userId
	 * @param locale
	 * @throws SystemException
	 * @throws PortalException
	 */
	private void assinaturasCategoriaForum(long userId, Locale locale) throws SystemException {
		// Categorias de Forum e forums de grupo
		List<Subscription> subscricoes = SubscriptionLocalServiceUtil
				.getUserSubscriptions(userId, MBCategory.class.getName());
		for (Subscription subscricao : subscricoes) {
			try {
				MBCategory categoria = MBCategoryLocalServiceUtil
						.getCategory(subscricao.getClassPK());
				Group grupo = GroupLocalServiceUtil.getGroup(categoria
						.getGroupId());
				adicionaAssinatura(assinaturas, subscricao,
						TipoAssinatura.FORUM_CATEGORY, grupo,
						categoria.getDescription());
			} catch (NoSuchCategoryException e) {
				try {
					Group grupo = GroupLocalServiceUtil.getGroup(subscricao
							.getClassPK());
					adicionaAssinatura(assinaturas, subscricao,
							TipoAssinatura.FORUM_CATEGORY, grupo,
							LanguageUtil.get(locale, "community-forum"));
				} catch (PortalException e2) {
					// Ignore
				}
			} catch (PortalException e) {
				// Ignore
			}
		}
	}

	/**
	 * @param userId
	 * @throws SystemException
	 */
	private void assinaturasThreadForum(long userId) throws SystemException {
		List<Subscription> subscricoes;
		// Threads de forum
		subscricoes = SubscriptionLocalServiceUtil.getUserSubscriptions(userId,
				MBThread.class.getName());
		for (Subscription subscricao : subscricoes) {
			try {
				MBThread thread = MBThreadLocalServiceUtil
						.getMBThread(subscricao.getClassPK());
				MBMessage mensagemRaiz = MBMessageLocalServiceUtil
						.getMBMessage(thread.getRootMessageId());
				if (mensagemRaiz.getClassPK() != 0)
					continue;
				Group grupo = GroupLocalServiceUtil.getGroup(thread
						.getGroupId());
				adicionaAssinatura(assinaturas, subscricao,
						TipoAssinatura.FORUM_THREAD, grupo,
						mensagemRaiz.getSubject());
			} catch (PortalException e) {
				// TODO log
			}
		}
	}

	/**
	 * @param userId
	 * @throws SystemException
	 */
	private void assinaturasNoWiki(long userId) throws SystemException {
		List<Subscription> subscricoes;
		// Nós de wiki
		subscricoes = SubscriptionLocalServiceUtil.getUserSubscriptions(userId,
				WikiNode.class.getName());
		for (Subscription subscricao : subscricoes) {
			try {
				WikiNode noWiki = WikiNodeLocalServiceUtil
						.getWikiNode(subscricao.getClassPK());
				Group grupo = GroupLocalServiceUtil.getGroup(noWiki
						.getGroupId());

				adicionaAssinatura(assinaturas, subscricao,
						TipoAssinatura.WIKI_NODE, grupo,
						noWiki.getDescription());
			} catch (PortalException e) {
				// TODO log
			}
		}
	}

	/**
	 * @param userId
	 * @throws SystemException
	 */
	private void assinaturasPaginaWiki(long userId) throws SystemException {
		List<Subscription> subscricoes;
		// Páginas wiki
		subscricoes = SubscriptionLocalServiceUtil.getUserSubscriptions(userId,
				WikiPage.class.getName());
		for (Subscription subscricao : subscricoes) {
			try {
				WikiPage paginaWiki = WikiPageLocalServiceUtil
						.getWikiPage(subscricao.getClassPK());
				Group grupo = GroupLocalServiceUtil.getGroup(paginaWiki
						.getGroupId());

				adicionaAssinatura(assinaturas, subscricao,
						TipoAssinatura.WIKI_PAGE, grupo, paginaWiki.getTitle());
			} catch (PortalException e) {
				// TODO log
			}
		}
	}

	/**
	 * @param assinaturas
	 * @param subscricao
	 * @param mensagemRaiz
	 * @param grupo
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void adicionaAssinatura(List<Assinatura> assinaturas,
			Subscription subscricao, TipoAssinatura tipo, Group grupo,
			String titulo) throws PortalException, SystemException {

		Assinatura assinatura = new Assinatura();
		assinatura.setComunidade(constroiNomeGrupo(grupo));
		assinatura.setTipo(tipo);
		assinatura.setIdentificador("s" + subscricao.getSubscriptionId());
		assinatura.setNome(StringUtil.shorten(titulo, 100));
		assinaturas.add(assinatura);
	}

	private String constroiNomeGrupo(Group grupo) throws PortalException,
			SystemException {
		String nomeGrupo;
		if (!grupo.isLayout())
			nomeGrupo = grupo.getDescriptiveName();
		else {
			Group grupoPai = GroupLocalServiceUtil.getGroup(grupo.getClassPK());
			nomeGrupo = grupoPai.getDescriptiveName() + " / "
					+ grupo.getDescriptiveName();
		}
		return nomeGrupo;
	}

	/**
	 * Cancela uma assinatura
	 * 
	 * @param identificador
	 */
	public String cancelar(String identificador) {
		if (identificador == null)
			return null;
		identificador = identificador.trim();
		long userId = LiferayFacesContext.getInstance().getUserId();

		if (identificador.length() < 2)
			return null;
		try {
			if (identificador.startsWith("n")) {
				String tipo = identificador.substring(1);

				AnnouncementsDelivery ad = AnnouncementsDeliveryLocalServiceUtil
						.getUserDelivery(userId, tipo);
				if (ad.getEmail()) {
					ad.setEmail(false);
					AnnouncementsDeliveryLocalServiceUtil
							.updateAnnouncementsDelivery(ad);
				}
			} else if (identificador.startsWith("s")) {
				long subscricaoId;
				try {
					subscricaoId = Long.parseLong(identificador.substring(1));
				} catch (Exception e) {
					return null;
				}
				Subscription subscricao = SubscriptionLocalServiceUtil
						.getSubscription(subscricaoId);
				if (subscricao.getUserId() != userId)
					return null;
				SubscriptionLocalServiceUtil.deleteSubscription(subscricao);
			}
		} catch (PortalException e) {
			// TODO Log
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		assinaturas = null;		// Força recarregar
		return null;
	}
}

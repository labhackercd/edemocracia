/**
 * 
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 * 
 */

package br.gov.camara.edemocracia.liferay.wiki.service.impl;

import java.io.IOException;
import java.io.StringWriter;

import javax.portlet.PortletPreferences;
import javax.portlet.WindowState;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Attributes;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.impl.WikiPageLocalServiceImpl;
import com.liferay.portlet.wiki.util.WikiUtil;

/**
 * @author Robson Miranda
 * 
 * Altera os links de mensagens do Wiki, de forma a apontar corretamente para os 
 */
public class CDWikiPageLocalServiceImpl extends WikiPageLocalServiceImpl {

	protected void notifySubscribers(
			WikiNode node, WikiPage page, ServiceContext serviceContext,
			boolean update)
		throws PortalException, SystemException {

		PortletPreferences preferences =
			ServiceContextUtil.getPortletPreferences(serviceContext);

		if (preferences == null) {
			long ownerId = node.getGroupId();
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
			long plid = PortletKeys.PREFS_PLID_SHARED;
			String portletId = PortletKeys.WIKI;
			String defaultPreferences = null;

			preferences = portletPreferencesLocalService.getPreferences(
				node.getCompanyId(), ownerId, ownerType, plid, portletId,
				defaultPreferences);
		}

		if (!update && WikiUtil.getEmailPageAddedEnabled(preferences)) {
		}
		else if (update && WikiUtil.getEmailPageUpdatedEnabled(preferences)) {
		}
		else {
			return;
		}

		String portalURL = serviceContext.getPortalURL();
		String layoutFullURL = serviceContext.getLayoutFullURL();

		WikiPage previousVersionPage = getPreviousVersionPage(page);

		String attachmentURLPrefix =
			portalURL + serviceContext.getPathMain() +
				"/wiki/get_page_attachment?p_l_id=" + serviceContext.getPlid() +
					"&nodeId=" + page.getNodeId() + "&title=" +
						HttpUtil.encodeURL(page.getTitle()) + "&fileName=";

		String pageDiffs = StringPool.BLANK;

		try {
			pageDiffs = WikiUtil.diffHtml(
				previousVersionPage, page, null, null, attachmentURLPrefix);
		}
		catch (Exception e) {
		}

		String pageContent = null;

		if (Validator.equals(page.getFormat(), "creole")) {
			pageContent = WikiUtil.convert(
				page, null, null, attachmentURLPrefix);
		}
		else {
			pageContent = page.getContent();
			pageContent = WikiUtil.processContent(pageContent);
		}

		String pageURL = StringPool.BLANK;
		String diffsURL = StringPool.BLANK;

		if (Validator.isNotNull(layoutFullURL)) {
			pageURL =
				layoutFullURL + Portal.FRIENDLY_URL_SEPARATOR + "wiki/" +
					node.getNodeId() + StringPool.SLASH +
						HttpUtil.encodeURL(page.getTitle());

			if (previousVersionPage != null) {
				StringBundler sb = new StringBundler(16);

				sb.append(layoutFullURL);
				sb.append("?p_p_id=");
				sb.append(PortletKeys.WIKI);
				sb.append("&p_p_state=");
				sb.append(WindowState.MAXIMIZED);
				sb.append("&struts_action=");
				sb.append(HttpUtil.encodeURL("/wiki/compare_versions"));
				sb.append("&nodeId=");
				sb.append(node.getNodeId());
				sb.append("&title=");
				sb.append(HttpUtil.encodeURL(page.getTitle()));
				sb.append("&sourceVersion=");
				sb.append(previousVersionPage.getVersion());
				sb.append("&targetVersion=");
				sb.append(page.getVersion());
				sb.append("&type=html");

				diffsURL = sb.toString();
			}
		}

		String fromName = WikiUtil.getEmailFromName(
			preferences, page.getCompanyId());
		String fromAddress = WikiUtil.getEmailFromAddress(
			preferences, page.getCompanyId());

		String subjectPrefix = null;
		String body = null;
		String signature = null;

		if (update) {
			subjectPrefix = WikiUtil.getEmailPageUpdatedSubjectPrefix(
				preferences);
			body = WikiUtil.getEmailPageUpdatedBody(preferences);
			signature = WikiUtil.getEmailPageUpdatedSignature(preferences);
		}
		else {
			subjectPrefix = WikiUtil.getEmailPageAddedSubjectPrefix(
				preferences);
			body = WikiUtil.getEmailPageAddedBody(preferences);
			signature = WikiUtil.getEmailPageAddedSignature(preferences);
		}

		String subject = page.getTitle();

		if (subject.indexOf(subjectPrefix) == -1) {
			subject = subjectPrefix + StringPool.SPACE + subject;
		}

		if (Validator.isNotNull(signature)) {
			body += "\n" + signature;
		}

		if (pageContent != null)
			pageContent = converteLinks(portalURL, pageContent);
		if (pageDiffs != null)
			pageDiffs = converteLinks(portalURL, pageDiffs);
		
		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(page.getCompanyId());
		subscriptionSender.setContextAttributes(
			"[$DIFFS_URL$]", diffsURL, "[$NODE_NAME$]", node.getName(),
			"[$PAGE_DATE_UPDATE$]", page.getModifiedDate(), "[$PAGE_ID$]",
			page.getPageId(), "[$PAGE_SUMMARY$]", page.getSummary(),
			"[$PAGE_TITLE$]", page.getTitle(), "[$PAGE_URL$]", pageURL);
		subscriptionSender.setContextAttribute(
			"[$PAGE_CONTENT$]", pageContent, false);
		subscriptionSender.setContextAttribute(
			"[$PAGE_DIFFS$]", replaceStyles(pageDiffs), false);
		subscriptionSender.setContextUserPrefix("PAGE");
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId(
			"wiki_page", page.getNodeId(), page.getPageId());
		subscriptionSender.setPortletId(PortletKeys.WIKI);
		subscriptionSender.setReplyToAddress(fromAddress);
		subscriptionSender.setScopeGroupId(node.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUserId(page.getUserId());

		subscriptionSender.addPersistedSubscribers(
			WikiNode.class.getName(), node.getNodeId());
		subscriptionSender.addPersistedSubscribers(
			WikiPage.class.getName(), page.getResourcePrimKey());

		subscriptionSender.flushNotificationsAsync();
	}
	
	private String converteLinks(String portalURL, String pageContent) {
		// ****************************************
		// Corrige links, imagens e estilos, utilizando
		// o Jericho HTML Parser
		Source source = new Source(pageContent);
		OutputDocument output = new OutputDocument(source);
		for (StartTag img: source.getAllStartTags()) {
			String tagName = img.getName();
			if (!HTMLElementName.IMG.equalsIgnoreCase(tagName) && 
					!HTMLElementName.LINK.equalsIgnoreCase(tagName) && 
					!HTMLElementName.A.equalsIgnoreCase(tagName))
				continue;
			Attributes atts = img.getAttributes();
			Attribute att = null;
			if (HTMLElementName.IMG.equalsIgnoreCase(tagName))
				att = atts.get("src");
			else 
				att = atts.get("href");
			
			if (att != null && att.getValue() != null && att.getValue().startsWith("/")) {
				StringBuilder sb = new StringBuilder(att.getName()).append("=\"");
				sb.append(portalURL).append(att.getValue());
				sb.append("\"");
				output.replace(att, sb.toString());
			}
		}
		StringWriter writer = new StringWriter();
		try {
			output.writeTo(writer);
		} catch (IOException ignore) {
			// Nunca deve ocorrer em stringwriter
		} finally {
			try {
				writer.close();
			} catch (IOException ignore) {}
		}
		pageContent = writer.toString();
		return pageContent;
	}
}
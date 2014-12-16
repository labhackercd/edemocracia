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

package com.liferay.portlet.messageboards.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.NumericalStringComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.messageboards.util.MBLabelKeys;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String tabs2 = ParamUtil.getString(actionRequest, "tabs2");

		if (tabs2.equals("email-from")) {
			validateEmailFrom(actionRequest);
		}
		else if (tabs2.equals("message-added-email")) {
			validateEmailMessageAdded(actionRequest);
		}
		else if (tabs2.equals("message-updated-email")) {
			validateEmailMessageUpdated(actionRequest);
		}
		else if (tabs2.equals("thread-priorities")) {
			updateThreadPriorities(actionRequest);
		}
		else if (tabs2.equals("user-ranks")) {
			updateUserRanks(actionRequest);
		} 
		else if(tabs2.equals("terms-used")){
			updateLabels(actionRequest);
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected boolean isValidUserRank(String rank) {
		if ((StringUtil.count(rank, StringPool.EQUAL) != 1) ||
			rank.startsWith(StringPool.EQUAL) ||
			rank.endsWith(StringPool.EQUAL)) {

			return false;
		}

		return true;
	}

	protected void updateThreadPriorities(ActionRequest actionRequest)
		throws Exception {

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (int i = 0; i < locales.length; i++) {
			String languageId = LocaleUtil.toLanguageId(locales[i]);

			List<String> priorities = new ArrayList<String>();

			for (int j = 0; j < 10; j++) {
				String name = ParamUtil.getString(
					actionRequest, "priorityName" + j + "_" + languageId);
				String image = ParamUtil.getString(
					actionRequest, "priorityImage" + j + "_" + languageId);
				double value = ParamUtil.getDouble(
					actionRequest, "priorityValue" + j + "_" + languageId);

				if (Validator.isNotNull(name) || Validator.isNotNull(image) ||
					(value != 0.0)) {

					priorities.add(
						name + StringPool.COMMA + image + StringPool.COMMA +
							value);
				}
			}

			String preferenceName = LocalizationUtil.getPreferencesKey(
				"priorities", languageId);

			setPreference(
				actionRequest, preferenceName,
				priorities.toArray(new String[priorities.size()]));
		}
	}

	protected void updateUserRanks(ActionRequest actionRequest)
		throws Exception {

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String languageId = LocaleUtil.toLanguageId(locale);

			String[] ranks = StringUtil.splitLines(
				ParamUtil.getString(actionRequest, "ranks_" + languageId));

			Map<String, String> map = new TreeMap<String, String>(
				new NumericalStringComparator());

			for (String rank : ranks) {
				if (!isValidUserRank(rank)) {
					SessionErrors.add(actionRequest, "userRank");

					return;
				}

				String[] kvp = StringUtil.split(rank, CharPool.EQUAL);

				String kvpName = kvp[0];
				String kvpValue = kvp[1];

				map.put(kvpValue, kvpName);
			}

			ranks = new String[map.size()];

			int count = 0;

			Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();

				String kvpValue = entry.getKey();
				String kvpName = entry.getValue();

				ranks[count++] = kvpName + StringPool.EQUAL + kvpValue;
			}

			String preferenceName = LocalizationUtil.getPreferencesKey(
				"ranks", languageId);

			setPreference(actionRequest, preferenceName, ranks);
		}
	}

	protected void validateEmailFrom(ActionRequest actionRequest)
		throws Exception {

		String emailFromName = getParameter(actionRequest, "emailFromName");
		String emailFromAddress = getParameter(
			actionRequest, "emailFromAddress");

		if (Validator.isNull(emailFromName)) {
			SessionErrors.add(actionRequest, "emailFromName");
		}
		else if (!Validator.isEmailAddress(emailFromAddress) &&
				 !Validator.isVariableTerm(emailFromAddress)) {

			SessionErrors.add(actionRequest, "emailFromAddress");
		}
	}

	protected void validateEmailMessageAdded(ActionRequest actionRequest)
		throws Exception {

		String emailMessageAddedSubjectPrefix = getParameter(
			actionRequest, "emailMessageAddedSubjectPrefix");
		String emailMessageAddedBody = getParameter(
			actionRequest, "emailMessageAddedBody");

		if (Validator.isNull(emailMessageAddedSubjectPrefix)) {
			SessionErrors.add(actionRequest, "emailMessageAddedSubjectPrefix");
		}
		else if (Validator.isNull(emailMessageAddedBody)) {
			SessionErrors.add(actionRequest, "emailMessageAddedBody");
		}
	}

	protected void validateEmailMessageUpdated(ActionRequest actionRequest)
		throws Exception {

		String emailMessageUpdatedSubjectPrefix = getParameter(
			actionRequest, "emailMessageUpdatedSubjectPrefix");
		String emailMessageUpdatedBody = getParameter(
			actionRequest, "emailMessageUpdatedBody");

		if (Validator.isNull(emailMessageUpdatedSubjectPrefix)) {
			SessionErrors.add(
				actionRequest, "emailMessageUpdatedSubjectPrefix");
		}
		else if (Validator.isNull(emailMessageUpdatedBody)) {
			SessionErrors.add(actionRequest, "emailMessageUpdatedBody");
		}
	}
	
	private void updateLabels(ActionRequest actionRequest) throws Exception {
		
		//Menus
		setPreference(actionRequest, MBLabelKeys.RECENT_POSTS, getLabelFromRequest(actionRequest, "label-recent-posts" , MBLabelKeys.RECENT_POSTS));
		
		//Botões
		setPreference(actionRequest, MBLabelKeys.FORUM_ADD_CATEGORY, getLabelFromRequest(actionRequest, "label-add-category", MBLabelKeys.FORUM_ADD_CATEGORY));
		setPreference(actionRequest, MBLabelKeys.FORUM_ADD_SUBCATEGORY, getLabelFromRequest(actionRequest, "label-add-subcategory", MBLabelKeys.FORUM_ADD_SUBCATEGORY));
		setPreference(actionRequest, MBLabelKeys.POST_NEW_THREAD, getLabelFromRequest(actionRequest, "label-post-new-thread", MBLabelKeys.POST_NEW_THREAD));

		//Termos
		setPreference(actionRequest, MBLabelKeys.FORUM_CATEGORY, getLabelFromRequest(actionRequest, "label-category", MBLabelKeys.FORUM_CATEGORY));
		setPreference(actionRequest, MBLabelKeys.FORUM_CATEGORIES, getLabelFromRequest(actionRequest, "label-categories", MBLabelKeys.FORUM_CATEGORIES));
		setPreference(actionRequest, MBLabelKeys.FORUM_SUBCATEGORIES, getLabelFromRequest(actionRequest, "label-subcategories", MBLabelKeys.FORUM_SUBCATEGORIES));
		setPreference(actionRequest, MBLabelKeys.THREAD, getLabelFromRequest(actionRequest, "label-thread",  MBLabelKeys.THREAD));
		setPreference(actionRequest, MBLabelKeys.THREADS, getLabelFromRequest(actionRequest, "label-threads", MBLabelKeys.THREADS));
		setPreference(actionRequest, MBLabelKeys.POSTS,  getLabelFromRequest(actionRequest, "label-posts", MBLabelKeys.POSTS));
		setPreference(actionRequest, MBLabelKeys.FORUM_NEW_CATEGORY, getLabelFromRequest(actionRequest, "label-new-category", MBLabelKeys.FORUM_NEW_CATEGORY));
		setPreference(actionRequest, MBLabelKeys.NUM_OF_CATEGORIES,getLabelFromRequest(actionRequest, "label-num-of-categories", MBLabelKeys.NUM_OF_CATEGORIES));
		setPreference(actionRequest, MBLabelKeys.FORUM_PARENT_CATEGORY, getLabelFromRequest(actionRequest, "label-parent-category", MBLabelKeys.FORUM_PARENT_CATEGORY));
		setPreference(actionRequest, MBLabelKeys.MERGE_WITH_PARENT_CATEGORY, getLabelFromRequest(actionRequest, "label-merge-category", MBLabelKeys.MERGE_WITH_PARENT_CATEGORY));
		setPreference(actionRequest, MBLabelKeys.NEW_MESSAGE, getLabelFromRequest(actionRequest, "label-new-message", MBLabelKeys.NEW_MESSAGE));

		//Ações
		setPreference(actionRequest, MBLabelKeys.LOCK_THREAD, getLabelFromRequest(actionRequest, "label-lock-thread", MBLabelKeys.LOCK_THREAD));
		setPreference(actionRequest, MBLabelKeys.UNLOCK_THREAD, getLabelFromRequest(actionRequest, "label-unlock-thread", MBLabelKeys.UNLOCK_THREAD));
		setPreference(actionRequest, MBLabelKeys.MOVE_THREAD, getLabelFromRequest(actionRequest, "label-move-thread", MBLabelKeys.MOVE_THREAD));
		
		//Mensagens
		setPreference(actionRequest, MBLabelKeys.NO_THREADS_IN_THIS_CATEGORY, getLabelFromRequest(actionRequest, "msg-no-threads", MBLabelKeys.NO_THREADS_IN_THIS_CATEGORY));
		setPreference(actionRequest, MBLabelKeys.NO_SUBSCRIBED_TO_ANY_CATEGORIES, getLabelFromRequest(actionRequest, "msg-no-subscribed-to-categories", MBLabelKeys.NO_SUBSCRIBED_TO_ANY_CATEGORIES));
		setPreference(actionRequest, MBLabelKeys.NO_SUBSCRIBED_TO_ANY_THREADS, getLabelFromRequest(actionRequest, "msg-no-subscribed-to-threads", MBLabelKeys.NO_SUBSCRIBED_TO_ANY_THREADS));
		
	}
	
	private String getLabelFromRequest(PortletRequest actionRequest, String paramName, String defaultValue) {
		String value = ParamUtil.getString(actionRequest,paramName);
		String label = StringUtils.isNotBlank(value) ? value: defaultValue;   
		return label;
	}

}
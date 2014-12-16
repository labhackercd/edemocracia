
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

package br.gov.camara.edemocracia.liferay.parsers;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.parsers.bbcode.BBCodeItem;
import com.liferay.portal.parsers.bbcode.BBCodeParser;
import com.liferay.portal.parsers.bbcode.HtmlBBCodeTranslatorImpl;
import com.liferay.portal.util.PropsUtil;

/**
 * Permite o uso da tag "vídeo"
 * @author Robson Miranda
 */
public class CDHtmlBBCodeTranslatorImpl extends HtmlBBCodeTranslatorImpl {

	@Override
	protected boolean isValidTag(String tag) {
		return ("youtube".equals(tag) || super.isValidTag(tag));
	}

	@Override
	protected void handleTagStart(
		StringBundler sb, List<BBCodeItem> bbCodeItems, Stack<String> tags,
		IntegerWrapper marker, BBCodeItem bbCodeItem) {

		String tag = bbCodeItem.getValue();

		if (!isValidTag(tag)) {
			return;
		}

		if (tag.equals("b")) {
			handleBold(sb, tags);
		}
		else if (tag.equals("center") || tag.equals("justify") ||
				 tag.equals("left") || tag.equals("right")) {

			handleTextAlign(sb, tags, bbCodeItem);
		}
		else if (tag.equals("code")) {
			handleCode(sb, bbCodeItems, marker);
		}
		else if (tag.equals("color") || tag.equals("colour")) {
			handleColor(sb, tags, bbCodeItem);
		}
		else if (tag.equals("email")) {
			handleEmail(sb, bbCodeItems, tags, marker, bbCodeItem);
		}
		else if (tag.equals("font")) {
			handleFontFamily(sb, tags, bbCodeItem);
		}
		else if (tag.equals("i")) {
			handleItalic(sb, tags);
		}
		else if (tag.equals("img")) {
			handleImage(sb, bbCodeItems, marker);
		}
		else if (tag.equals("li") || tag.equals("*")) {
			handleListItem(sb, tags);
		}
		else if (tag.equals("list")) {
			handleList(sb, tags, bbCodeItem);
		}
		else if (tag.equals("q") || tag.equals("quote")) {
			handleQuote(sb, tags, bbCodeItem);
		}
		else if (tag.equals("s")) {
			handleStrikeThrough(sb, tags);
		}
		else if (tag.equals("size")) {
			handleFontSize(sb, tags, bbCodeItem);
		}
		else if (tag.equals("table")) {
			handleTable(sb, tags);
		}
		else if (tag.equals("td")) {
			handleTableCell(sb, tags);
		}
		else if (tag.equals("th")) {
			handleTableHeader(sb, tags);
		}
		else if (tag.equals("tr")) {
			handleTableRow(sb, tags);
		}
		else if (tag.equals("url")) {
			handleURL(sb, bbCodeItems, tags, marker, bbCodeItem);
		}
		else if (tag.equals("youtube")) {
			handleVideo(sb, bbCodeItems, marker);
		}
		else {
			handleSimpleTag(sb, tags, bbCodeItem);
		}
	}

	protected void handleVideo(StringBundler sb, List<BBCodeItem> bbCodeItems, IntegerWrapper marker) {
		int videoHeight = GetterUtil.get(PropsUtil.get("forum.video.height"), 349);
		int videoWidth = GetterUtil.get(PropsUtil.get("forum.video.width"), 560);

		String videoId = extractData(
				bbCodeItems, marker, "video", BBCodeParser.TYPE_DATA, true);

		if (videoId != null && videoId.trim().length() > 0) {
			// Extrai o identificador do video, parar criar o embbed
			for (Pattern p : _youtube_patterns) {
				Matcher m = p.matcher(videoId.trim());
				if (m.find()) {
					sb.append("<iframe ");
					sb.append("width=\"").append(videoWidth).append("\" ");
					sb.append("height=\"").append(videoHeight).append("\" ");
					sb.append("src=\"http://www.youtube.com/embed/");
					sb.append(m.group(1));
					sb.append("\" frameborder=\"0\" allowfullscreen></iframe>");
					break;
				}
			}
		}
	}


	private Pattern[] _youtube_patterns = new Pattern[] {
		Pattern.compile("https?://(?:www\\.)?youtube\\.com/watch\\?v=([A-Za-z0-9_-]+)"),
		Pattern.compile("https?://(?:www\\.)?youtube\\.com/embed/([A-Za-z0-9_-]+)"),
		Pattern.compile("https?://(?:www\\.)?youtube\\.com/v/([A-Za-z0-9_-]+)"),
		Pattern.compile("https?://youtu\\.be/([A-Za-z0-9_-]+)"),
		Pattern.compile("https?://(?:www\\.)?youtube\\.com/user/.+/([A-Za-z0-9_-]+)"),
		Pattern.compile("https?://(?:www\\.)?youtube\\.com/user/.+/([A-Za-z0-9_-]+)"),
		Pattern.compile("https?://(?:www\\.)?youtube-nocookie\\.com/v/([A-Za-z0-9_-]+)"),
		Pattern.compile("([A-Za-z0-9_-]{11})")	// Fallback
	};

}
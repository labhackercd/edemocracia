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
package br.gov.camara.edemocracia.hook.events;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

/**
 * @author p_7339
 * 
 */
public class ImagemComunidadeAction extends Action {

    @SuppressWarnings("unchecked")
    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
	Map<String, Object> vmVariables = null;

	if (request.getAttribute(WebKeys.VM_VARIABLES) == null) {
	    vmVariables = new HashMap<String, Object>();
	    request.setAttribute(WebKeys.VM_VARIABLES, vmVariables);
	} else {
	    vmVariables = (Map<String,Object>) request.getAttribute(WebKeys.VM_VARIABLES);
	}
	
	String urlImagem = "/e-democracia-theme/images/custom/simbol-edemocracia.png";
	String urlImagemThumb = urlImagem;
	
	try {
	    ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(td.getScopeGroupId(), 0, "icone");
	    if (fileEntry != null) {
		FileVersion versaoAtual = fileEntry.getFileVersion();
		if (versaoAtual != null) {
		    String nomeImage = HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()), true);
		    urlImagem = td.getPortalURL() + td.getPathContext() + "/documents/" + fileEntry.getRepositoryId() + "/" + fileEntry.getFolderId() + "/" + nomeImage + "?version=" + versaoAtual.getVersion() + "&t=" + versaoAtual.getModifiedDate().getTime();
		    urlImagemThumb = urlImagem + "&imageThumbnail=1";
		}
	    }
	} catch (Exception e) {
	}

/*	#set($caminhoImg = )
	#set($dlService = $serviceLocator.findService("com.liferay.portlet.documentlibrary.service.DLAppLocalService"))
	#set($imageEntry = $dlService.getFileEntry($themeDisplay.scopeGroupId, 0, "icone"))
	#if ($imageEntry)
	 #set($fileVersion = $imageEntry.fileVersion)
	 #if ($fileVersion)
	  #set($imageName = $httpUtil.encodeURL($htmlUtil.unescape($imageEntry.title),true))
	  #set($caminhoImg = $themeDisplay.portalURL + $themeDisplay.pathContext + "/documents/" + $imageEntry.repositoryId + "/" + $imageEntry.folderId + "/" + $imageName + "?version=" + $fileVersion.version + "&t=" + $fileVersion.modifiedDate.time + "&imageThumbnail=1")
	 #end
	#end
*/
	
	vmVariables.put("caminho_img", urlImagemThumb);
	vmVariables.put("caminho_img_orig", urlImagem);
    }
}

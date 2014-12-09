<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />

<portlet:renderURL var="backUrl">
	<portlet:param name="<%= ChatPortletConstants.VIEW_PARAM %>" value='<%=request.getParameter(ChatPortletConstants.BACK_VIEW_PARAM )%>'/>
	<portlet:param name="<%=ChatPortletConstants.ROOM_ID_PARAM %>" value="<%=request.getParameter(ChatPortletConstants.ROOM_ID_PARAM) %>" />
</portlet:renderURL>

<a class="portlet-icon-back" style="display:block; margin-top:10px;" href="${backUrl}">Retornar para página anterior</a>

<h1 ><span> Exibição de vídeos wmv </span></h1>

<div>
	<div class="wiki-body">
		<p class="western">Alguns vídeos do portal estão disponíveis em
			formato wmv, e alguns navegadores e/ou sistemas operacionais podem
			precisar de configurações especiais para que você consiga reproduzir
			os vídeos.</p>
		<h3>Internet Explorer</h3>
		<p class="western">Uma solução é atualizar sua versão do Windows
			Media Player, pelo link:</p>
		<p class="western" style="margin-left: 40px;">
			<a
				href="http://www.microsoft.com/downloads/Browse.aspx?displaylang=pt-br&categoryid=4"
				target="_blank">http://www.microsoft.com/downloads/Browse.aspx?displaylang=pt-br&amp;categoryid=4</a>
		</p>
		<h3>No Firefox</h3>
		<p class="western">O Firefox precisa de um plugin Windows Media Player para reproduzir os vídeos wmv.</p>
		<ol>
			<li> <p class="western" >Caso o sistema operacional seja Windows 7 e a versão do Firefox seja 4.0 ou superior:</p> 
				<ul>
					<li>Acesse o <a href="http://www.interoperabilitybridges.com/html5-extension-for-wmp-plugin"> link </a> e clique em "Install the Add-on" </li>
					<li>Caso haja alguma solicitação de permissão para instalar o plugin, clique em permitir </li>
					<li>Após a instalação, reinicie o navegador para que as alterações sejam aplicadas </li>
				</ul>
			</li>
			<li> <p class="western" >Para versões anteriores do Windows ou do Firefox:</p> 
				<ul>
					<li>Acesse o <a href="http://www.interoperabilitybridges.com/windows-media-player-firefox-plugin-download"> link </a> e clique em "Download Now"</li>
					<li>Execute o arquivo baixado para instalação do plugin </li>
					<li>Após a instalação, reinicie o navegador para que as alterações sejam aplicadas </li>
				</ul>
			</li>
		</ol>
		
		<p class="western">Esta página contém orientações avançadas (em
			inglês):</p>
		<p class="western" style="margin-left: 40px;">
			<a href="http://kb.mozillazine.org/Windows_Media_Player">http://kb.mozillazine.org/Windows_Media_Player</a>
		</p>
		<h3>No Mac</h3>
		<p class="western">Para Mac, a solução é instalar um plugin de wmv
			para o QuickTime: Flip4Mac.</p>
		<p class="western">Procure no google "flip4mac" ou "wmv mac" que
			irá encontra-lo. Ou veja mais informações sobre esse plugin aqui:</p>
		<p class="western" style="margin-left: 40px;">
			<a
				href="http://windows.microsoft.com/en-US/windows/products/windows-media-player/wmcomponents">http://windows.microsoft.com/en-US/windows/products/windows-media-player/wmcomponents</a>
		</p>
		<h3>No Linux</h3>
		<p class="western">A reprodução de vídeos em Linux foi testada com
			a seguinte configuração:</p>
		<p class="western" style="margin-bottom: 0cm; margin-left: 40px;">
			Ubuntu/Linux 10.04; Mozilla Firefox 3.6;</p>
		<p class="western" style="margin-bottom: 0cm; margin-left: 40px;">
			Plugin para Firefox: Totem 2.30.1;</p>
		<p class="western" style="margin-bottom: 0cm; margin-left: 40px;">
			Reprodutor de Filmes GStreamer 0.10.28 (instalado pelo Totem).</p>
		<h3>Reprodução por um player na sua máquina (VLC)</h3>
		<p class="western">Se as orientações acima não foram suficientes,
			uma solução alternativa é baixar e instalar o player livre VLC na sua
			máquina. O download do VLC pode ser feito pelo link</p>
		<p class="western" style="margin-left: 40px;">
			<a href="http://www.videolan.org/" target="_blank">http://www.videolan.org/</a>
		</p>
		<p class="western">Importante: se você optar por utilizar o VLC,
			deve usar o link direto do stream de vídeo (se for disponibilizado)
			ou fazer o download do arquivo de vídeo para sua máquina; depois,
			abrir o VLC e abrir o link do stream ou o arquivo de vídeo vídeo. O
			VLC não roda direto do site, mas apenas na sua máquina.</p>
		<p class="western">No VLC Media Player, para abrir o stream, use o
			menu "Mídia" / "Abrir fluxo de rede" e informe o link do vídeo (ex.:
			rtsp://stream.camara.gov.br/plenario13).</p>
		<p class="western">&nbsp;</p>
		<p class="western">Essas orientações devem ajudar a resolver o
			problema. Avise-nos se continuar com dificuldades...</p>
	</div>
</div>

package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletConfig;

import net.htmlparser.jericho.HTMLElementName;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;

import br.gov.camara.edemocracia.portlets.chat.RoomWithSameNameInCommunityException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomTwitterImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomVideoLocalServiceUtil;
import br.gov.camara.edemocracia.util.HtmlStripper;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author p_7339
 */
@ManagedBean(name = "editBean")
@ViewScoped
public class ChatRoomEditBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{roomImage}")
	private ChatRoomImageBean imageBean;
	private long roomId;
	private String name;
	private String description;
	private RoomOpenPolicy openPolicy;
	private ChatDateTime openFrom;
	private ChatDateTime openUntil;
	private boolean moderated;
	private int capacity;
	private boolean anonymousAllowed;
	private String guestName;
	private long imageId;
	private boolean usePolicyEnabled;
	private String usePolicyURL;
	private ChatRoomTwitter twitter;
	private ChatRoomVideo videoLive;
	private ChatRoomVideo videoRecorded;

	/**
	 * Recupera o identificador da sala
	 */
	@PostConstruct
	public void init() {
		String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (param == null) {
			roomId = 0l;
		} else {
			try {
				roomId = Long.parseLong(param);
			} catch (NumberFormatException e) {
				roomId = 0l;
			}
		}

		/**
		 * Recupera os dados da sala
		 */
		DateTimeZone dtz = DateTimeZone.forTimeZone(LiferayFacesContext.getInstance().getThemeDisplay().getTimeZone());

		if (roomId != 0) {
			try {
				if (!fetchDataFromRoom(dtz, roomId)) {
					roomId = 0;
					clearRoomData(dtz);
				}
			} catch (PortalException e) {
				roomId = 0; // Sala não encontrada
				clearRoomData(dtz);
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
		} else {
			clearRoomData(dtz);
		}

	}

	/**
	 * Limpa os dados da sala
	 * 
	 * @param dtz
	 */
	private void clearRoomData(DateTimeZone dtz) {
		name = "";
		description = "";
		openPolicy = RoomOpenPolicy.Always;
		MutableDateTime now = new MutableDateTime(dtz);
		now.setMinuteOfHour(now.getMinuteOfHour() / 5 * 5);

		openFrom = new ChatDateTime(now.toDateTime());
		now.addHours(4);
		openUntil = new ChatDateTime(now.toDateTime());
		moderated = false;
		capacity = 150;
		anonymousAllowed = true;
		guestName = "";
		imageId = 0l;
		usePolicyEnabled = false;
		usePolicyURL = "";

		twitter = new ChatRoomTwitterImpl();
		videoLive = new ChatRoomVideoImpl();
		videoRecorded = new ChatRoomVideoImpl();

	}

	/**
	 * Recupera os dados da sala especificada
	 * 
	 * @param roomId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private boolean fetchDataFromRoom(DateTimeZone dtz, long roomId) throws PortalException, SystemException {
		ChatRoom room = ChatRoomServiceUtil.getRoom(roomId);

		// Verifica se a sala é do grupo correto
		if (room.getGroupId() != LiferayFacesContext.getInstance().getScopeGroupId()) {
			return false;
		}

		name = room.getRoomName();
		description = room.getDescription();
		openPolicy = RoomOpenPolicy.withValue(room.getOpenPolicy());

		// Sala agendada
		DateTime dt;
		if (room.getOpenFrom() != null) {
			dt = new DateTime(room.getOpenFrom(), dtz);
		} else {
			dt = new DateTime(dtz);
		}
		openFrom = new ChatDateTime(dt);

		if (room.getOpenUntil() != null) {
			dt = new DateTime(room.getOpenUntil(), dtz);
		} else {
			MutableDateTime mdt = new MutableDateTime(dt.getMillis());
			mdt.addHours(4);
			dt = mdt.toDateTime();
		}
		openUntil = new ChatDateTime(dt);
		moderated = room.isModerated();
		capacity = room.getCapacity();
		anonymousAllowed = room.isAnonymousAllowed();
		if (room.getGuestId() != 0) {
			try {
				User user = UserLocalServiceUtil.getUser(room.getGroupId());
				guestName = user.getFullName();
			} catch (PortalException e) {
				guestName = room.getGuestName();
			}
		} else {
			guestName = "";
		}

		imageId = room.getImageId();

		usePolicyEnabled = room.getUsePolicyEnabled();
		usePolicyURL = room.getUsePolicyURL();

		ChatRoomTwitter twitter = ChatRoomTwitterLocalServiceUtil.getTwitter(roomId);
		if (twitter != null)
			this.twitter = twitter;
		else
			this.twitter = new ChatRoomTwitterImpl();

		ChatRoomVideo videoLive = ChatRoomVideoLocalServiceUtil.getVideo(room.getVideoLiveId());
		if (videoLive != null)
			this.videoLive = videoLive;
		else
			this.videoLive = new ChatRoomVideoImpl();

		ChatRoomVideo videoRecorded = ChatRoomVideoLocalServiceUtil.getVideo(room.getVideoRecordedId());
		if (videoRecorded != null)
			this.videoRecorded = videoRecorded;
		else
			this.videoRecorded = new ChatRoomVideoImpl();

		return true;
	}

	/**
	 * Remove a imagem da sala atual
	 * 
	 * @return
	 */
	public String removeImage() {
		imageId = 0l;
		imageBean.deleteUploadedFile();
		return null;
	}

	/**
	 * Grava a sala em edição
	 * 
	 * @return
	 */
	public String saveRoom() {
		ChatRoom room;
		PermissionChecker permissionChecker = LiferayFacesContext.getInstance().getPermissionChecker();
		long groupId = LiferayFacesContext.getInstance().getScopeGroupId();

		if (roomId == 0l) {
			if (!permissionChecker.hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, "ADD_ROOM")) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage("Sem permissão para criar sala");
				return null;
			}
			room = new ChatRoomImpl();
			room.setGroupId(groupId);
			room.setCompanyId(LiferayFacesContext.getInstance().getCompanyId());
		} else {
			try {
				room = ChatRoomServiceUtil.getRoom(roomId);
			} catch (PortalException e) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage("Sala inexistente");
				return null;
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
			// TODO Alterar essa permissão
			if (!permissionChecker.hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, "ADD_ROOM") || room.getGroupId() != groupId) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage("Sem permissão para editar sala");
				return null;
			}
		}

		Locale locale = LiferayFacesContext.getInstance().getLocale();
		PortletConfig config = LiferayFacesContext.getInstance().getPortletConfig();

		// Verificações
		if (openPolicy.getValue() == RoomOpenPolicy.Scheduled.getValue()) {
			if (openFrom == null) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "invalid-from-date"));
			}
			if (openUntil == null) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "invalid-to-date"));
			}
			if (openFrom != null && openUntil != null && openFrom.getDateTime().isAfter(openUntil.getDateTime())) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "close-date-before-open"));
			}
		}

		if (name == null || name.trim().length() < 2)
			LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "room-name-empty"));

		if (usePolicyEnabled && StringUtils.isBlank(usePolicyURL)) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "use-policy-link-empty"));
		}
		
		validaDescricao();
		validaDadosDoTwitter(locale, config);
		validaDadosDoVideo(locale, config);

		long guestId = 0l;
		if (guestName != null && !guestName.trim().isEmpty()) {
			boolean found = false;
			try {
				List<User> users = UserLocalServiceUtil.getGroupUsers(groupId);
				for (User u : users) {
					if (u.getFullName().equalsIgnoreCase(guestName.trim())) {
						guestId = u.getUserId();
						guestName = u.getFullName();
						found = true;
						break;
					}
				}
				if (!found) {
					LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "cant-find-guest-name"));
				}
			} catch (SystemException e) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "cant-find-guest-name"));
			}
		}

		for (FacesMessage message : FacesContext.getCurrentInstance().getMessageList()) {
			if (message.getSeverity() == FacesMessage.SEVERITY_ERROR)
				return null;
		}
		/////////////////////////////////////////////////////////////////////////////////////
		try {
			File imageFile = imageBean.getFile();
			if (imageFile != null && imageFile.exists()) {
				// Atualização do arquivo
				if (imageId != 0l) {
					ImageLocalServiceUtil.deleteImage(room.getImageId());
					imageId = 0;
				}
				long newImageId = CounterLocalServiceUtil.increment();
				Image img = ImageLocalServiceUtil.updateImage(newImageId, imageFile);
				if (img != null)
					imageId = newImageId;
				imageBean.deleteUploadedFile();

			}
		} catch (SystemException e) {
			throw new RuntimeException(e);
		} catch (PortalException e) {

		}

		room.setAnonymousAllowed(anonymousAllowed);
		room.setCapacity(capacity);

		HtmlStripper htmlStripper = criarHtmlStripper();
		room.setDescription(htmlStripper.strip(description));

		room.setImageId(imageId);
		room.setModerated(moderated);
		room.setRoomName(name);
		room.setGuestId(guestId);
		room.setGuestName(guestName);
		room.setUsePolicyEnabled(usePolicyEnabled);
		room.setUsePolicyURL(usePolicyURL);
		room.changeOpenPolicy(openPolicy, openFrom.getDateTime().toDate(), openUntil.getDateTime().toDate());

		try {

			// Salvando sala
			if (roomId == 0) {
				room = ChatRoomServiceUtil.addChatRoom(room);
			} else {
				ChatRoomServiceUtil.updateChatRoom(room, true);
			}

			// Salvando videos
			ChatRoomVideo videoLive = saveChatRoomVideo(this.videoLive);
			ChatRoomVideo videoRecorded = saveChatRoomVideo(this.videoRecorded);

			// Adicionando referencias dos videos ao chatRoom
			if (videoLive != null)
				room.setVideoLiveId(videoLive.getVideoId());

			if (videoRecorded != null)
				room.setVideoRecordedId(videoRecorded.getVideoId());

			// Atualizando sala
			ChatRoomServiceUtil.updateChatRoom(room, true);

			saveChatRoomTwitter(room.getRoomId());

		} catch (RoomWithSameNameInCommunityException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "room-with-same-name"));
			return null;
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		LiferayFacesContext.getInstance().getExternalContext().getFlash().setKeepMessages(true);
		LiferayFacesContext.getInstance().addGlobalSuccessInfoMessage();
		return "ok";
	}

	private HtmlStripper criarHtmlStripper() {
		HtmlStripper stripper = new HtmlStripper();
		stripper.addAllowedTags(HTMLElementName.DIV, HTMLElementName.HR, HTMLElementName.FONT);
		stripper.addAllowedAttributes("size", "face", "style", "color");
		return stripper;
	}

	private void saveChatRoomTwitter(long roomId) {
		try {
			if (this.twitter.getTwitterId() == 0) {

				if (this.twitter.isTwitterEnabled()) {
					ChatRoomTwitter twitter = ChatRoomTwitterLocalServiceUtil.createChatRoomTwitter(roomId);
					twitter.setTwitterDescription(this.twitter.getTwitterDescription());
					twitter.setTwitterEnabled(this.twitter.isTwitterEnabled());
					twitter.setTwitterDataWidgetId(this.twitter.getTwitterDataWidgetId());
					twitter.setTwitterTitle(this.twitter.getTwitterTitle());
					ChatRoomTwitterLocalServiceUtil.addChatRoomTwitter(twitter);
				}

			} else {
				ChatRoomTwitterLocalServiceUtil.updateChatRoomTwitter(this.twitter, true);
			}
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

	}

	private ChatRoomVideo saveChatRoomVideo(ChatRoomVideo video) {
		try {
			if (video.getVideoId() == 0) {
				if (video.isVideoEnabled()) {
					long videoId = CounterLocalServiceUtil.increment(ChatRoomVideo.class.getName());
					ChatRoomVideo chatRoomVideo = ChatRoomVideoLocalServiceUtil.createChatRoomVideo(videoId);
					chatRoomVideo.setVideoDescription(video.getVideoDescription());
					chatRoomVideo.setVideoEnabled(video.isVideoEnabled());
					chatRoomVideo.setVideoSubtitle(video.getVideoSubtitle());
					chatRoomVideo.setVideoTitle(video.getVideoTitle());
					chatRoomVideo.setVideoType(video.getVideoType());
					chatRoomVideo.setVideoUrl(video.getVideoUrl());
					return ChatRoomVideoLocalServiceUtil.addChatRoomVideo(chatRoomVideo);
				} else {
					return null;
				}

			} else {
				return ChatRoomVideoLocalServiceUtil.updateChatRoomVideo(video, true);
			}
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void validaDescricao() {
		if (this.description != null && this.description.length() > 3900) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("O tamanho do campo descrição junto com a formatação excedeu o limite de 3900 caracteres. Tamanho atual: " + description.length());
		}
	}

	private void validaDadosDoTwitter(Locale locale, PortletConfig config) {
		if (twitter.isTwitterEnabled()) {
			if (twitter.getTwitterDataWidgetId() == null || twitter.getTwitterDataWidgetId().trim().length() < 2)
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-twitter-datawidgetid"));
			if (twitter.getTwitterTitle() == null || twitter.getTwitterTitle().isEmpty()) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-twitter-title"));
			}
		}
	}

	private void validaDadosDoVideo(Locale locale, PortletConfig config) {

		if (videoLive.isVideoEnabled()) {

			if (videoLive.getVideoTitle() == null || videoLive.getVideoTitle().isEmpty()) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-title"));
			}

			if (videoLive.getVideoType() == null || videoLive.getVideoType().isEmpty()) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-type"));
			}

			if (videoLive.getVideoUrl() == null || videoLive.getVideoUrl().trim().length() < 2) {

				if (videoLive.getVideoType() != null && !videoLive.getVideoType().equals(ChatVideoType.youtube)) {
					LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-url"));
				} else {
					LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-youtube"));
				}

			}

		}

		if (videoRecorded.isVideoEnabled()) {

			if (videoRecorded.getVideoUrl() == null || videoRecorded.getVideoUrl().trim().length() < 2) {

				if (videoRecorded.getVideoType() != null && !videoRecorded.getVideoType().equals(ChatVideoType.youtube)) {
					LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-recorded-url"));
				} else {
					LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-recorded-youtube"));
				}
			}

			if (videoRecorded.getVideoType() == null || videoRecorded.getVideoType().isEmpty()) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-recorded-type"));
			}

			if (videoRecorded.getVideoTitle() == null || videoRecorded.getVideoTitle().isEmpty()) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(LanguageUtil.get(config, locale, "specify-video-recorded-title"));
			}
		}

	}

	/**
	 * Obtém a URL da imagem atual
	 */
	public String getImageUrl() {
		if (imageBean.getFile() != null && imageBean.getFile().exists()) {
			String path = imageBean.getFile().getAbsolutePath();
			String root = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
			path = path.substring(root.length());
			path = path.replace('\\', '/');
			if (!path.startsWith("/"))
				path = "/" + path;
			path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/" + path;
			return path;
		} else if (imageId != 0) {
			return PortalUtil.getPathImage() + "/chat?img_id=" + imageId;
		} else {
			return "";
		}
	}

	/**
	 * Volta para a tela principal
	 * 
	 * @return
	 */
	public String cancel() {
		return "ok";
	}

	/**
	 * Atualiza o bean de imagem
	 * 
	 * @param roomImage
	 */
	public void setImageBean(ChatRoomImageBean roomImage) {
		this.imageBean = roomImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RoomOpenPolicy getOpenPolicy() {
		return openPolicy;
	}

	public void setOpenPolicy(RoomOpenPolicy openPolicy) {
		this.openPolicy = openPolicy;
	}

	public ChatDateTime getOpenFrom() {
		return openFrom;
	}

	public ChatDateTime getOpenUntil() {
		return openUntil;
	}

	public boolean isModerated() {
		return moderated;
	}

	public void setModerated(boolean moderated) {
		this.moderated = moderated;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAnonymousAllowed() {
		return anonymousAllowed;
	}

	public void setAnonymousAllowed(boolean anonymousAllowed) {
		this.anonymousAllowed = anonymousAllowed;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	/**
	 * Obtém o identificador da imagem
	 * 
	 * @return
	 */
	public long getImageId() {
		return imageId;
	}

	public ChatRoomTwitter getTwitter() {
		return twitter;
	}

	public void setTwitter(ChatRoomTwitter twitter) {
		this.twitter = twitter;
	}

	public ChatRoomVideo getVideoLive() {
		return videoLive;
	}

	public void setVideoLive(ChatRoomVideo videoLive) {
		this.videoLive = videoLive;
	}

	public ChatRoomVideo getVideoRecorded() {
		return videoRecorded;
	}

	public void setVideoRecorded(ChatRoomVideo videoRecorded) {
		this.videoRecorded = videoRecorded;
	}

	public boolean isUsePolicyEnabled() {
		return usePolicyEnabled;
	}

	public void setUsePolicyEnabled(boolean usePolicyEnabled) {
		this.usePolicyEnabled = usePolicyEnabled;
	}

	public void setUsePolicyURL(String usePolicyURL) {
		this.usePolicyURL = usePolicyURL;
	}

	public String getUsePolicyURL() {
		return usePolicyURL;
	}
}

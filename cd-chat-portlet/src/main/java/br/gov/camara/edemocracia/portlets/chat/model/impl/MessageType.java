package br.gov.camara.edemocracia.portlets.chat.model.impl;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;

public enum MessageType {
	Null(-1) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return "";
		}
	},
	Standard(0) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return standardMessage(msg);
		}
	},
	UserEntered(1) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return userEnteredMessage(msg);
		}
	},
	UserLeft(2) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return "<strong>" + escapeHtml(msg.getSenderName()) + "</strong> saiu da sala";
		}
	},
	UserPromoted(3) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return userEnteredMessage(msg);
		}
	},
	UserBanned(4) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return "<strong>" + escapeHtml(msg.getSenderName()) + "</strong> foi banido da sala";
		}
	},
	UserUnBanned(5) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return "<strong>" + escapeHtml(msg.getSenderName()) + "</strong> n&atilde;o est&aacute; mais banido";
		}
	},
	AwatingApproval(6) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return "Sua mensagem est&aacute; aguardando a aprova&ccedil;&atilde;o do moderador";
		}
	},
	Rejected(7) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return standardMessage(msg);
		}
	},
	Approved(8) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return standardMessage(msg);
		}
	},
	RoomClosed(9) {
		@Override
		public String formattedMessage(ChatRoomMessage msg) {
			return "Esta sala foi fechada";
		}
	};

	private int value;

	private MessageType(int value) {
		this.value = value;
	}

	public static MessageType withValue(int value) {
		MessageType[] types = MessageType.values();
		MessageType result = Standard;
		for (MessageType type : types) {
			if (type.getValue() == value) {
				result = type;
			}
		}
		return result;
	}

	public int getValue() {
		return value;
	}

	public abstract String formattedMessage(ChatRoomMessage msg);

	protected String standardMessage(ChatRoomMessage msg) {
		StringBuilder sb = new StringBuilder("<strong>");
		MessageTextType textType = MessageTextType.withValue(msg.getTextType());
		sb.append(escapeHtml(msg.getSenderName()));
		sb.append("</strong> ");
		if (msg.getRecipientUserId() != 0) {
			sb.append(textType.getVerb());
			sb.append(" ");
			String recipient = msg.getRecipientUserName();
			if (recipient.length() > 0) {
				if (!msg.isMessagePublic()) {
					sb.append("reservadamente ");
				}
				sb.append(textType.getPreposition());
				sb.append(" <strong>");
				sb.append(escapeHtml(recipient));
				sb.append("</strong> ");
			}
		}
		sb.append(": ");
		sb.append(escapeHtml(msg.getMessageText()));
		return sb.toString();
	}

	protected String userEnteredMessage(ChatRoomMessage msg) {
		return "<strong>" + escapeHtml(msg.getSenderName()) + "</strong> entrou na sala";
	}

}
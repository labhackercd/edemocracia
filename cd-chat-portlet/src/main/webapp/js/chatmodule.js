/*global CD:true, $:true, window:true */
CD.eDemocracia.chat.chatModule = function (moduleSetup) {
	
	// Importing
	var userType = CD.eDemocracia.chat.userType,
		formatDate = CD.utils.dateHelper.formatDate,
		getDateFromIsoString = CD.utils.dateHelper.getDateFromIsoString,
		numToString = CD.utils.stringHelper.numToString,
	// Setup
		ns = moduleSetup.ns,
		inAudience = moduleSetup.usrAudience,
		since = moduleSetup.initialSince,
	
	//Helpers
		makeSelector = CD.utils.makeSelector(ns),
		userHelper = makeSelector.itemsHelper("usrid_"),
		messageHelper = makeSelector.itemsHelper("msgid_"),
	
	// Selectors
		msgListId = makeSelector.id("msglist"),
		usersListId = makeSelector.id("usrslist"),
		privateCheckboxId = makeSelector.id("private"),
		sendFormItemClass = makeSelector.classSel("sendFormItem"),
		formId = makeSelector.id("msgForm"),
		leaveId = makeSelector.id("leave"),
		textTypeSelectId = makeSelector.id("textType"),
		textTypePrepositionId = makeSelector.id("text_type_preposition"),
		messageTextId = makeSelector.id("msg"),
		autoScrollCheckboxId = makeSelector.id("autoscroll"),
		roomClosedId = makeSelector.id("roomClosed"),
		todosId = "#" + userHelper.generateId("-1"),
		
		roomClosed = false,
	
		textTypeVerb = ["fala", "pergunta", "responde", "concorda", "discorda"],
		textTypePreposition = ["para", "para", "para", "com", "de"],		
		generateStandardMessageHtml = function (msg) {

			var html = "<strong>" + msg.sender + "</strong> ";
			//if (msg.recipientUser !== "") {
				html = html + textTypeVerb[msg.textType] + " ";
				if (!msg.pub) {
					html = html + "reservadamente ";
				}
				html = html + textTypePreposition[msg.textType] + " <strong>";
				if (msg.recipientUser != "")
					html = html + msg.recipientUser;
				else
					html = html + "Todos";
				html = html + "</strong>";
			//}
			html = html + " : " + msg.text;
			return html;

		},

		generateUserEnteredHtml = function (msg) {
			return "<strong>" + msg.sender + "</strong> entrou na sala";
		},

		generateUserLeftHtml = function (msg) {
			return "<strong>" + msg.sender + "</strong> saiu da sala";
		},

		generateUserBannedHtml = function (msg) {
			return "<strong>" + msg.sender + "</strong> foi banido da sala";
		},

		generateUserUnBannedHtml = function (msg) {
			return "<strong>" + msg.sender
				+ "</strong> n&atilde;o est&aacute; mais banido";
		},

		generateAwatingApprovalHtml = function (msg) {
			return "sua mensagem est&aacute; aguardando a aprova&ccedil;&atilde;o do moderador";
		},
		
		generateRoomClosedHtml = function (msg) {
			return "esta sala foi fechada";
		},

		empty = function (msg) {
		},
		
		generateHtml = [ generateStandardMessageHtml, generateUserEnteredHtml,
		                 generateUserLeftHtml, generateUserEnteredHtml,
		                 generateUserBannedHtml, generateUserUnBannedHtml,
		                 generateAwatingApprovalHtml, generateStandardMessageHtml,
		                 generateStandardMessageHtml, generateRoomClosedHtml ],
		                 
		getSelectedUser = function () {
			var selUserId = $(".cdchat_selected_user").attr("id");
			return userHelper.parseId(selUserId);
		},

		promoteUser = function (msg) {
			if (msg.senderId == moduleSetup.currentUserId) {
				inAudience = false;
				$(sendFormItemClass).removeAttr("disabled");
				if (getSelectedUser() === -1) {
					$(privateCheckboxId).attr("disabled", "disabled");
				}
			}
		},
		
		banUser = function (msg) {
			if (msg.senderId == moduleSetup.currentUserId) {
				var url = $(leaveId).attr("href");
				window.location = url;
			}
		},
		
        typeProcessing = [ empty, empty, banUser, promoteUser, banUser, empty,
                           empty, empty, empty, empty ];			                 

	
	
	function getImageUrl(user) {
		return "/image/user_portrait?img_id=" + user.imgid;
	}

	function update_since(ts_as_string) {
		var ts = getDateFromIsoString(ts_as_string),
			tsMillis = ts.getTime(),
			sinceMillis = since.getTime();
		if (tsMillis > sinceMillis) {
			since = ts;
		}
	}

	function userClick() {
		$(".cdchat_selected_user").removeClass("cdchat_selected_user");
		$(this).addClass("cdchat_selected_user");
		var id = userHelper.parseId($(this).attr("id"));
		$(".cdchat_sendto_user").text($.trim($(this).text()));
		if (id === -1) {
			$(privateCheckboxId).attr("disabled", "disabled");
			$(privateCheckboxId).removeAttr("checked");
		} else {
			$(privateCheckboxId).removeAttr("disabled");
		}
	}

	function generateMessageTimestampHtml(tsString) {
		var ts = getDateFromIsoString(tsString);
		return "<em>(" + numToString(ts.getHours(), 2) + ":"
			+ numToString(ts.getMinutes(), 2) + ")</em> - ";
	}
	
	function genHtml(msg) {
		var senderType = msg.senderType,
			html = '<li id="' + messageHelper.generateId(msg.id) + '"';
		if (senderType === userType.moderator) {
			html = html + ' class="cdchat_moderator"';
		} else if (senderType === userType.guest) {
			html = html + ' class="cdchat_special_guest"';
		}
		html = html + '>' + generateMessageTimestampHtml(msg.ts);
		html = html + generateHtml[msg.type](msg);
		html = html + "</li>";
		
		return html;
	}

	function update_msglist(msg, first) {

		var html = genHtml(msg),
			item = $(msgListId).append(html);
		if (msg.status === -1) {
			item.addClass("cdchat_rejected");
		}
		if (!first) {
			typeProcessing[msg.type](msg);
		}

	}

	function scroll_msglist(msgs) {
		if (msgs.length > 0) { 
			if ($(autoScrollCheckboxId).attr("checked")) {
				$(msgListId).each(
					function () {
						var scrollHeight = Math.max(this.scrollHeight,
								this.clientHeight);
						this.scrollTop = scrollHeight - this.clientHeight;
					}
				);
			}
		}
	}

	function update_users_first(users) {
		var seluser = getSelectedUser(),
			found = false,
			foundId = todosId;
		
		$(usersListId + " li.usr").remove();
		$.each(users, function (index, usr) {
			var userClass = "usr cdchat_user",
				id = usr.id,
				name = "<img style=\"width: 25px;\" src=\"" + getImageUrl(usr) + '" />&nbsp;' + usr.name,
				liid = userHelper.generateId(id),
				url = $(leaveId).attr("href");
			if (usr.type === userType.moderator) {
				userClass = userClass + " cdchat_moderator";
			} else if (usr.type === userType.guest) {
				userClass = userClass + " cdchat_special_guest";
			}
			if (!usr.audience && !usr.banned) {
				$("<li>")
					.appendTo($(usersListId))
					.addClass(userClass)
					.attr("id", liid)
					.attr("title", "Enviar mensagem para " + usr.name)
					.html(name);

				if (!inAudience) {
					$("#" + liid).click(userClick);
				}
				if (id == seluser) {
					found = true;
					foundId = "#" + liid;
				}
			} else if (!usr.audience && usr.banned && id === moduleSetup.currentUserId) {	
				window.location = url;
			}
		});

		$(".cdchat_selected_user").removeClass("cdchat_selected_user");
		$(foundId).addClass("cdchat_selected_user");
		if (found) {
			if (seluser === -1) {
				$(privateCheckboxId).attr("disabled", "disabled");
				$(privateCheckboxId).removeAttr("checked");
			} else {
				$(privateCheckboxId).removeAttr("disabled");
			}
		} else {
			$(privateCheckboxId).attr("disabled", "disabled");
			$(privateCheckboxId).removeAttr("checked");
		}

	}
	
	function update_room_status(msgs) {
		var closed = msgs.closed;
		if (closed == null)
			closed = true;
		if (closed ^ roomClosed) {
			if (closed)
				$(roomClosedId).css("display", "inline");
			else
				$(roomClosedId).css("display", "none");
			roomClosed = closed;
		}
	}

	function update_msgs_first(msgs) {

		var msgs_arr = msgs.msgs;
		$.each(msgs_arr, function (index, msg) {
			update_since(msg.ts);
			update_msglist(msg, true);
		});
		scroll_msglist(msgs_arr);
		update_users_first(msgs.users);
		update_room_status(msgs);
	}

	function updateMsgs(msgs) {

		var msgs_arr = msgs.msgs;
		$.each(msgs_arr, function (index, msg) {
			update_since(msg.ts);
			update_msglist(msg, false);
		});
		scroll_msglist(msgs_arr);
		update_users_first(msgs.users);
		update_room_status(msgs);
	}

	function postMessageCallback(msg) {
		if (msg === "ok") {
			$(messageTextId).val("");
		}
	}
	
	function enableSendButton(req, status) {
		$(messageTextId).removeAttr("disabled");
		$(formId + " [type=submit]").removeAttr("disabled");
		$(messageTextId).focus();
	}
	
	function updateMessages(first) { 
		var data = {},
		successFn = first ? update_msgs_first : updateMsgs,
	    completedFn = function() {
			setTimeout(function() {
				updateMessages(false);
//				AUI().use('liferay-session', function(A) {
//					Liferay.Session.extend();
//				});
			}, 2000);
		};
		data[ns + "chat_since"] = formatDate(since);
		data[ns + "roomId"] = moduleSetup.roomId;
		data[ns + "chatUserId"] = moduleSetup.currentUserId;
		data[ns + "first"] = first;
		
		$.ajax({
			type : 'POST',
			url : moduleSetup.updateURL,
			timeout : 3000,
			dataType : "json",
			success : successFn,
			complete : completedFn,
			data : data
		});
	}

	return {
		updateTimer : function () {
			updateMessages(true);
		},
		postMessage : function () {

			var msg = $(messageTextId).val(),
				todos = -1,
				user = getSelectedUser(),
				privmsg = false,
				textType = $(textTypeSelectId + " option:selected").val(),
				data = {};

			if (user !== todos) {
				privmsg = $(privateCheckboxId).is(":checked");
			}
			
			// Desabilita o botão de enviar e o campo de texto
			$(messageTextId).attr("disabled", "true");
			$(formId + " [type=submit]").attr("disabled", "true");

			data[ns + "msgText"] = msg;
			data[ns + "roomId"] = moduleSetup.roomId;
			data[ns + "user"] = user;
			data[ns + "priv"] = privmsg;
			data[ns + "textType"] = textType;
			data[ns + "chatUserId"] = moduleSetup.currentUserId;

			$.ajax({
				type : 'POST',
				url : moduleSetup.postMsgURL,
				timeout : 3000,
				success : postMessageCallback,
				complete : enableSendButton,
				data : data
			});
			return false;
		},
		textTypeChange : function () {
			var textType = $(textTypeSelectId + " option:selected").val();
			$(textTypePrepositionId).text(textTypePreposition[textType]);
		},
		userClick : userClick

	};
};
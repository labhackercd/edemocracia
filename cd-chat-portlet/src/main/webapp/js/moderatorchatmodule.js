CD.eDemocracia.chat.moderatorChatModule = function(moduleSetup) {
	
	
	// Importing 
	var userType = CD.eDemocracia.chat.userType;
	var msgType = CD.eDemocracia.chat.msgType;
	var getDateFromIsoString = CD.utils.dateHelper.getDateFromIsoString;
	var numToString = CD.utils.stringHelper.numToString;
	var formatDate = CD.utils.dateHelper.formatDate;

	
	// Setup Parameters
	var ns = moduleSetup.portletNamespace;
	var inAudience = moduleSetup.userInAudience;
	var since = moduleSetup.initialSince;
	
	//Helpers
	var makeSelector = CD.utils.makeSelector(ns);
	var userHelper = makeSelector.itemsHelper("usrid_");
	var bannedUserHelper = makeSelector.itemsHelper("banusrid_");
	var messageHelper = makeSelector.itemsHelper("msgid_");
	
	// defining selectors
	
	var adminMsgListId = makeSelector.id("admmsglist"); 
	var msgListId = makeSelector.id("msglist");
	var usersListId = makeSelector.id("usrslist");
	var formId = makeSelector.id("msgForm");
	var adminFormId = makeSelector.id("admmsgForm");
	var bannedUsersListId = makeSelector.id("banusrlist");
	var privateCheckboxId = makeSelector.id("private");
	var autoScrollCheckboxId = makeSelector.id("autoscroll");
	var autoScrollAdmCheckboxId = makeSelector.id("autoscrolladm");
	var sendFormItemClass = makeSelector.classSel("sendFormItem");
	var sendAsSelect = makeSelector.id("sendAsSelect");
	var banButtonId = makeSelector.formItemName("banButton");
	var unbanButtonId = makeSelector.formItemName("unbanButton");
	var leaveId = makeSelector.id("leave");
	var messageTextId = makeSelector.id("msg");
	var adminMessageTextId = makeSelector.id("admmsg");
	var textTypeSelectId = makeSelector.id("textType");
	var textTypePrepositionId = makeSelector.id("text_type_preposition");
	var todosId = "#" + userHelper.generateId("-1");
	var openRoomSpanId = makeSelector.id("openRoomSpan");
	var closeRoomSpanId = makeSelector.id("closeRoomSpan");
	var sendAsChkboxId = makeSelector.id("sendAsChkbox");
	
	var textTypeVerb = ["fala","pergunta","responde","concorda","discorda"];
	var textTypePreposition = ["para","para","para","com","de"];

    var firstTime = true;

	function getImageUrl(user) {
		return "/image/user_portrait?img_id=" + user.imgid;
	}

	function getSelectedUser() {
		var seluserNode = $(".cdchat_selected_user");
		if (seluserNode.size() != 0) {
			return userHelper.parseId(seluserNode.attr("id"));
		} else {
			return null;
		}
	}

	function getSelectedBannedUser() {
		var seluserNode = $(".cdchat_selected_banned_user");
		if (seluserNode.size() != 0) {
			return bannedUserHelper.parseId(seluserNode.attr("id"));
		} else {
			return null;
		}
	}

	function update_since(timestampAsString) {
		var ts = getDateFromIsoString(timestampAsString);
		var tsMillis = ts.getTime();
		var sinceMillis = since.getTime();
		if (tsMillis > sinceMillis) {
			since = ts;
		}
	}
	
	function userClick() {
		$(".cdchat_selected_user").removeClass("cdchat_selected_user");
		$(".cdchat_selected_banned_user").removeClass(
				"cdchat_selected_banned_user");
		$(this).addClass("cdchat_selected_user");
		var name = $.trim($(this).text());
		//alert("'"+name+"'");
		$(".cdchat_sendto_user").text(name);
		var id = userHelper.parseId($(this).attr("id"));
		if (id == -1) {
			$(privateCheckboxId).attr("disabled", "disabled");
			$(privateCheckboxId).removeAttr("checked");
			$(banButtonId).attr("disabled", "disabled");
			$(unbanButtonId).attr("disabled", "disabled");
		} else {
			$(privateCheckboxId).removeAttr("disabled");
			if (id == moduleSetup.currentUserId) {
				$(banButtonId).attr("disabled", "disabled");
			} else {
				$(banButtonId).removeAttr("disabled");
			}
			$(unbanButtonId).attr("disabled", "disabled");

		}
	}

	function bannedUserClick() {
		$(".cdchat_selected_user").removeClass("cdchat_selected_user");
		$(".cdchat_selected_banned_user").removeClass(
				"cdchat_selected_banned_user");
		$(this).addClass("cdchat_selected_banned_user");
		var id = bannedUserHelper.parseId($(this).attr("id"));
		/*if($(sendAsSelect).val() == id) {
			$(sendAsSelect).val("-1");
		}*/
		$(banButtonId).attr("disabled", "disabled");
		$(unbanButtonId).removeAttr("disabled");
		$(privateCheckboxId).attr("disabled", "disabled");
		$(privateCheckboxId).removeAttr("checked");
	}

	function generateMessageTimestampHtml(tsString) {
		var ts = getDateFromIsoString(tsString);
		return "<em>(" + numToString(ts.getHours(), 2) + ":"
				+ numToString(ts.getMinutes(), 2) + ")</em> - ";
	}

	function generateStandardMessageHtml(msg) {

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
		html = html + ": " + msg.text;
		return html;

	}

	function generateUserEnteredHtml(msg) {
		return "<strong>" + msg.sender + "</strong> entrou na sala";
	}

	function generateUserLeftHtml(msg) {
		return "<strong>" + msg.sender + "</strong> saiu da sala";
	}

	function generateUserBannedHtml(msg) {
		return "<strong>" + msg.sender + "</strong> foi banido da sala";
	}

	function generateUserUnBannedHtml(msg) {
		return "<strong>" + msg.sender
				+ "</strong> n&atilde;o est&aacute; mais banido";
	}

	function generateAwatingApprovalHtml(msg) {
		return "sua mensagem est&aacute; aguardando a aprova&ccedil;&atilde;o do moderador";
	}

	function generateEmptyHtml(msg) {
		return "";
	}
	
	function generateRoomClosedHtml() {
		return "esta sala foi fechada";
	}

	var generateHtml = [ generateStandardMessageHtml, generateUserEnteredHtml,
			generateUserLeftHtml, generateUserEnteredHtml,
			generateUserBannedHtml, generateUserUnBannedHtml,
			generateAwatingApprovalHtml, generateStandardMessageHtml,
			generateStandardMessageHtml, generateRoomClosedHtml ];

	function empty(msg) {
	}

	function userLeft(msg) {
		if (msg.senderId == moduleSetup.currentUserId) {
			var url = $(leaveId).attr("href");
			window.location = url;
		}
	}

	function approveMessageCallback(msg) {
		if (msg.ok) {
			$("#" + messageHelper.generateId(msg.id)).removeClass("cdchat_rejected");
			$("#" + messageHelper.generateId(msg.id) + " a").remove();
		}
	}

	function rejectMessageCallback(msg) {
		if (msg.ok) {
			$("#" + messageHelper.generateId(msg.id)).addClass("cdchat_rejected");
			$("#" + messageHelper.generateId(msg.id) + " a").remove();
		}
	}

	var typeProcessing = [ empty, empty, userLeft, empty, empty, empty,
			empty, empty, empty, empty ];

	function processRejected(msg, item) {
		item.addClass("cdchat_rejected");
	}
	
	function generateApprovalLink(msg,item,url,callback,iconPath) {
		var result = $("<a>").attr("href", "#").click(function() {
				var data = {};
				data[ns + "msgId"] = msg.id;
				data[ns + "roomId"] = moduleSetup.roomId;
				
				$.ajax( {
					type : 'POST',
					url : url,
					timeout : 3000,
					dataType : "json",
					success : callback,
					data : data
				});
				
				return false;
			});
		$("<img>").attr("src", moduleSetup.contextPath + iconPath)
		.appendTo(result);
		
		result.appendTo(item);
	}

	function processPending(msg, item) {
		item.append("&nbsp;");
		generateApprovalLink(msg,item,moduleSetup.approveMessageURL,approveMessageCallback,"/html/images/approve.png");
		generateApprovalLink(msg,item,moduleSetup.rejectMessageURL,rejectMessageCallback,"/html/images/reject.png");

	}

	function processApproved(msg, item) {
		//
	}

	var statusProcessing = [ processRejected, processPending, processApproved ];

	function update_msglist(msg) {

		var id = messageHelper.generateId(msg.id);
		var parent = messageHelper.generateId(msg.parent);
		var html = generateMessageTimestampHtml(msg.ts)
				+ generateHtml[msg.type](msg);
		var item = $("<li>").attr("id", id).html(html);
		if(msg.senderType == userType.moderator) {
			item.addClass("cdchat_moderator");
		} else if(msg.senderType == userType.guest) {
			item.addClass("cdchat_special_guest");
		}
		statusProcessing[msg.status + 1](msg, item);
		var listId = msg.admin ? adminMsgListId : msgListId;
		var idExists = $("#" + id).length > 0;
		var parentExists = $("#" + parent).length > 0;
		if (!idExists) {
			if (!parentExists || (msg.type != msgType.rejected && msg.type != msgType.approved)) {
				item.appendTo($(listId));
			} else {
				$("#" + parent + " a").remove();
				if (msg.type == msgType.rejected)
					$("#" + parent).addClass("cdchat_rejected");
			}
		}
		typeProcessing[msg.type](msg);

	}

	function scrollMsgList(listId) {
		$(listId).each(
				function() {
					var scrollHeight = Math.max(this.scrollHeight,
							this.clientHeight);
					this.scrollTop = scrollHeight - this.clientHeight;
				});
	}
	
	function scroll_msgs(msgs) {
		if (msgs.length > 0) {
			if($(autoScrollCheckboxId).attr("checked")) {
				scrollMsgList(msgListId);
			}
			if($(autoScrollAdmCheckboxId).attr("checked")) {
				scrollMsgList(adminMsgListId);
			}
		}
	}
	
	function considerSendAs() {
		return $(sendAsChkboxId).is(":checked");
	}

	function update_users_first(users) {
		var seluser = getSelectedUser();
		//var selSendAsUser = $(sendAsSelect).val();
		if (seluser == null) {
			seluser = getSelectedBannedUser();
		}
		$(usersListId + " li.usr").remove();
		$(bannedUsersListId + " li.usr").remove();
		//$(sendAsSelect + " option.cdchat_sendas_user").remove();

		var found = false;
		var foundId = todosId;
		var foundSpecialGuest = false;
		var specialGuestId = -1;
		//var foundSendAs = false;
		var foundBanned = false;
		$.each(users, function(index, usr) {
			var id = usr.id;
			var name = "<img style=\"width: 25px;\" src=\""+ getImageUrl(usr) + "\" />&nbsp;" + usr.name;
			var listId;
			var userClass = "usr";
			var generateIdFn;
			var clickFn;
			if (usr.type == userType.moderator) {
				userClass = userClass + " cdchat_moderator";
			} else if(usr.type == userType.guest) {
				userClass = userClass + " cdchat_special_guest";
				foundSpecialGuest = true;
				specialGuestId = usr.id;
			}
			if (usr.banned) {
				listId = bannedUsersListId;
				userClass = userClass + " cdchat_banned_user";
				generateIdFn = bannedUserHelper.generateId;
				clickFn = bannedUserClick;
			} else {
				listId = usersListId;
				userClass = userClass + " cdchat_user";
				generateIdFn = userHelper.generateId;
				clickFn = userClick;
			}

			if (!usr.audience || usr.banned) {
				var liid = generateIdFn(id);
				$("<li>")
						.addClass(userClass)
						.attr("id", liid)
						.attr("title","Enviar mensagem para " + usr.name)
						.html(name)
						.appendTo($(listId));
			/*	if(!usr.banned) {
					$("<option>")
						.attr("value",id)
						.addClass("cdchat_sendas_user")
						.html(usr.name)
						.appendTo(sendAsSelect);
				}*/
				if (!inAudience) {
					$("#" + liid).click(clickFn);
				}
				if (id == seluser) {
					found = true;
					foundId = "#" + liid;
					foundBanned = usr.banned;
				}
			/*	if(id == selSendAsUser) {
					foundSendAs = true;
				}*/
			}
		});

		$(".cdchat_selected_user").removeClass("cdchat_selected_user");
		$(".cdchat_selected_banned_user").removeClass(
				"cdchat_selected_banned_user");
		if (foundBanned) {
			$(foundId).addClass("cdchat_selected_banned_user");
		} else {
			$(foundId).addClass("cdchat_selected_user");
		}
		
		if (foundSpecialGuest) {
			$(sendAsChkboxId).removeAttr("disabled");
			$(sendAsSelect + " option").val(specialGuestId);
		} else {
			$(sendAsChkboxId).attr("disabled","disabled");
		}
	/*	if(foundSendAs && considerSendAs()) {
			$(sendAsSelect).val(selSendAsUser);
		} else {
			$(sendAsSelect).val(moduleSetup.currentUserId);
		} */
		if (found) {
			if (seluser == -1) {
				$(privateCheckboxId).attr("disabled", "disabled");
				$(privateCheckboxId).removeAttr("checked");
				$(banButtonId).attr("disabled", "disabled");
				$(unbanButtonId).attr("disabled", "disabled");
			} else {
				$(privateCheckboxId).removeAttr("disabled");
				if (foundBanned) {
					$(banButtonId).attr("disabled", "disabled");
					$(unbanButtonId).removeAttr("disabled");
					$(privateCheckboxId).attr("disabled", "disabled");
					$(privateCheckboxId).removeAttr("checked");
				} else {
					if (seluser == moduleSetup.currentUserId) {
						$(banButtonId).attr("disabled", "disabled");
					} else {
						$(banButtonId).removeAttr("disabled");
					}
					$(unbanButtonId).attr("disabled", "disabled");
				}
			}
		} else {
			$(privateCheckboxId).attr("disabled", "disabled");
			$(banButtonId).attr("disabled", "disabled");
			$(unbanButtonId).attr("disabled", "disabled");
			$(privateCheckboxId).removeAttr("checked");
		}

	}

	function update_msgs_first(msgs) {

		var msgs_arr = msgs.msgs;
		$.each(msgs_arr, function(index, msg) {
			update_since(msg.ts);
			update_msglist(msg);
		});
		scroll_msgs(msgs_arr);
		update_users_first(msgs.users);
	}

	function update_msgs(msgs) {

		var msgs_arr = msgs.msgs;
		$.each(msgs_arr, function(index, msg) {
			update_since(msg.ts);
			update_msglist(msg);
		});
		scroll_msgs(msgs_arr);
		update_users_first(msgs.users);

	}

	function makePostMessageCallback(admin) {

		return function(msg) {
			if (msg == "ok") {
				if (admin) {
					$(adminMessageTextId).val("");
				} else {
					$(messageTextId).val("");
				}
			}
		};
	}
	
	function enableSendButton(req, status) {
		$(messageTextId).removeAttr("disabled");
		$(adminMessageTextId).removeAttr("disabled");
		$(formId + " [type=submit]").removeAttr("disabled");
		$(adminFormId + " [type=submit]").removeAttr("disabled");
		if (this.adminMessage) {
			$(adminMessageTextId).focus();
		} else {
			$(messageTextId).focus();
		}
		
	}

	var postMessageCallback = makePostMessageCallback(false);
	var postAdminMessageCallback = makePostMessageCallback(true);

	function banUserCallback(msg) {
		if (msg == "ok") {
			var seluser = $(".cdchat_selected_user");
			var id = bannedUserHelper.generateId(seluser.attr("id"));
			var content = seluser.html();
			seluser.remove();
			$("<li>")
					.appendTo($(bannedUsersListId))
					.attr("id", id)
					.addClass(
							"usr cdchat_banned_user cdchat_selected_banned_user")
					.html(content).click(bannedUserClick);
			$(banButtonId).attr("disabled", "disabled");
			$(unbanButtonId).removeAttr("disabled");
			$(privateCheckboxId).attr("disabled", "disabled");
			$(privateCheckboxId).removeAttr("checked");

			userClick.call($(todosId));
		}

	}

	function unbanUserCallback(msg) {
		if (msg == "ok") {
			var seluser = $(".cdchat_selected_banned_user");
			seluser.remove();
			$("todosId").addClass("cdchat_selected_user");
			$(banButtonId).attr("disabled", "disabled");
			$(unbanButtonId).attr("disabled", "disabled");
			$(privateCheckboxId).attr("disabled", "disabled");
			$(privateCheckboxId).removeAttr("checked");
		}
	}
	
	
	function openRoomCallback(msg) {
		if(msg.ok) {
			disableOpenRoomLink();
			enableCloseRoomLink();
		}
	}
	
	function closeRoomCallback(msg) {
		if(msg.ok) {
			disableCloseRoomLink();
			enableOpenRoomLink();
		}
	}
	
	function makeDisableRoomLink(spanId) {
		return function() {
			var linkText = $(spanId + " a").text();
			$(spanId).empty().text(linkText);
			$(spanId).addClass("desativado");
		};
	}
	
	var disableCloseRoomLink = makeDisableRoomLink(closeRoomSpanId); 
	var disableOpenRoomLink = makeDisableRoomLink(openRoomSpanId);
	
	function makeEnableRoomLink(spanId,clickFn) {
		return function() {
			var span = $(spanId);
			$(spanId).removeClass("desativado");
			var linkText = span.text();
			span.empty();
			$("<a href='#' onclick='return false;' ></a>").appendTo(span).click(clickFn).text(linkText);
		};
	}
	
	var enableCloseRoomLink = makeEnableRoomLink(closeRoomSpanId,closeRoom);
	var enableOpenRoomLink = makeEnableRoomLink(openRoomSpanId,openRoom);
	
	function openRoom() {
		var data = {};
		data[ns + "roomId"] = moduleSetup.roomId;
		$.ajax( {
			type: 'POST',
			url: moduleSetup.openRoomURL,
			timeout: 3000,
			dataType : "json",
			success: openRoomCallback,
			data: data
		});
	}
	
	function closeRoom() {
		var data = {};
		data[ns + "roomId"] = moduleSetup.roomId;
		$.ajax( {
			type: 'POST',
			url: moduleSetup.closeRoomURL,
			timeout: 3000,
			dataType : "json",
			success: closeRoomCallback,
			data: data
		});
	}
	
	function updateMessages(first) { 
		var data = {},
			successFn = first ? update_msgs_first : update_msgs,
		    completedFn = function() {
				setTimeout(function() {
					updateMessages(false);
//					AUI().use('liferay-session', function(A) {
//						Liferay.Session.extend();
//					});
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
		updateTimer : function() {
			updateMessages(true);
		},
		postMessage : function(admin) {

			var msg = "";
			var callback = null;
			if (admin) {
				msg = $(adminMessageTextId).val();
				callback = postAdminMessageCallback;
			} else {
				msg = $(messageTextId).val();
				callback = postMessageCallback;
			}
			var todos = -1;
			var user = getSelectedUser();
			var privmsg = false;
			
			var textType = $(textTypeSelectId + " option:selected").val();

			if (user != todos) {
				privmsg = $(privateCheckboxId).is(":checked");
			}
			
			// Desabilita o botão de enviar e o campo de texto
			$(messageTextId).disabled = true;
			$(adminMessageTextId).disabled = true;
			$(formId + " [type=submit]").attr("disabled", "true");
			$(adminFormId + " [type=submit]").attr("disabled", "true");

			var data = {};
			data[ns + "msgText"] = msg;
			data[ns + "roomId"] = moduleSetup.roomId;
			data[ns + "user"] = admin ? todos : user;
			data[ns + "priv"] = admin ? false : privmsg;
			data[ns + "admin"] = admin;
			data[ns + "textType"] = admin ? 0 : textType;
			data[ns + "chatUserId"] = moduleSetup.currentUserId;
			if(!admin && considerSendAs()) {
				var sendAsUser = $(sendAsSelect).val();
				if(sendAsUser != -1) {
					data[ns + "sendAs"] = sendAsUser;
				} 
			}

			$.ajax( {
				type : 'POST',
				url : moduleSetup.postMessageURL,
				timeout : 3000,
				success : callback,
				complete : enableSendButton,
				adminMessage : admin,
				data : data
			});
			return false;
		},
		userClick : userClick,
		banUser : function() {
			var user = getSelectedUser();
			var data = {};
			data[ns + "user"] = user;
			data[ns + "roomId"] = moduleSetup.roomId;
			$.ajax( {
				type : 'POST',
				url : moduleSetup.banUserURL,
				timeout : 3000,
				success : banUserCallback,
				data : data
			});
			return false;
		},
		unbanUser : function() {
			var user = getSelectedBannedUser();
			var data = {};
			data[ns + "user"] = user;
			data[ns + "roomId"] = moduleSetup.roomId;
			$.ajax( {
				type : 'POST',
				url : moduleSetup.unbanUserURL,
				timeout : 3000,
				success : unbanUserCallback,
				data : data
			});
			return false;
		},
		textTypeChange : function() {
			var textType = $(textTypeSelectId + " option:selected").val();
			$(textTypePrepositionId).text(textTypePreposition[textType]);
		},
		sendAsChkboxClick : function() {
			
			if(considerSendAs()) {
				$(sendAsSelect).removeAttr("disabled");
			} else {
				$(sendAsSelect).attr("disabled","disabled");
				/*$(sendAsSelect).val(moduleSetup.currentUserId);*/
			}
			
		},
		openRoom : openRoom,
		closeRoom : closeRoom
	};
};
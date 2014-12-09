   CD.eDemocracia.chat.exportButtonClick = function (ns,url) {
		var first = true,
		    textmsgsid = "",
		    prefixLength = ns.length + 4,
		    idText;
		    
		$("#"+ns+"exportmsglist li").each(function (idx,item) {
			if(first) {
				first = false;
			} else {
				textmsgsid = textmsgsid + " ";
			}
			idText = $(item).attr("id").substr(prefixLength);
			if($(item).hasClass("cdchat_removed_message")) {
				idText = "-" + idText;
			}
			textmsgsid = textmsgsid + "" + idText;
		});
		$("#"+ns+"sortedmsgstext").val(textmsgsid);
		return true;
		
	};
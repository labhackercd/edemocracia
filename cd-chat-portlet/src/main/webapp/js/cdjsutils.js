var CD = {};
CD.utils = {};
CD.utils.makeSelector = function(ns) {
	function makeSel(prefix,suffix) {
		return function(selectorName) { return prefix + ns + selectorName + suffix; };
	}
	function makePrefixSel(prefix) {
		return makeSel(prefix,"");
	}
	var itemsHelper = function(itemPrefix) {
		var prefixLength = ns.length + itemPrefix.length;
		return {
			parseId : function(id) {
				return id.substr(prefixLength);
			},
			generateId: function(id) {
				return ns + itemPrefix + id;
			}
		};
	};
	
	return {
		id: makePrefixSel("#"),
		classSel: makePrefixSel("."),
		formItemName: makeSel("[name=","]"),
		itemsHelper: itemsHelper
	};
};

CD.utils.stringHelper = (function() {
	function numToString(num, len) {
		var base = " 00000";
		var rs1 = base + num;
		var lrs1 = rs1.length;
		var res = rs1.slice(lrs1 - len, lrs1);
		return res;
	}
	
	return { numToString: numToString };
})();


CD.utils.dateHelper = (function() {
	
	var numToString = CD.utils.stringHelper.numToString;
	
	function getDateFromIsoString(str) {
		str = str.replace(/\D/g, " ");
		var dtcomps = str.split(" ");
		// modify month between 1 based ISO 8601 and zero based Date
		dtcomps[1]--;
		return new Date(Date.UTC(dtcomps[0], dtcomps[1], dtcomps[2],
				dtcomps[3], dtcomps[4], dtcomps[5], dtcomps[6]));
	}
	
	function formatDate(date) {
		var y = date.getUTCFullYear();
		var m = date.getUTCMonth() + 1;
		var d = date.getUTCDate();
		var h = date.getUTCHours();
		var min = date.getUTCMinutes();
		var s = date.getUTCSeconds();
		var ms = date.getUTCMilliseconds();

		return numToString(y, 4) + "-" + numToString(m, 2) + "-"
				+ numToString(d, 2) + "T" + numToString(h, 2) + ":"
				+ numToString(min, 2) + ":" + numToString(s, 2) + "."
				+ numToString(ms, 3) + "Z";

	}
	
	return { getDateFromIsoString: getDateFromIsoString, formatDate: formatDate };
})();

CD.eDemocracia = {};
CD.eDemocracia.chat = {};

CD.eDemocracia.chat.msgStatus = { 
		pending: 0,
		approved: 1,
		rejected: -1
};
CD.eDemocracia.chat.msgType = { 
		standard: 0,
		userEntered: 1,
		userLeft: 2,
		userPromoted: 3,
		userBanned: 4,
		userUnbanned: 5,
		awatingApproval: 6,
		rejected: 7,
		approved: 8
};
CD.eDemocracia.chat.roomOpenPolicy = { 
		always: 0,
		manual: 1,
		scheduled: 2
};
CD.eDemocracia.chat.roomStatus = {
		closed: 0,
		exported: 1,
		opened: 2
};
CD.eDemocracia.chat.userType = { 
		standard: 0,
		moderator: 1,
		guest: 2
};



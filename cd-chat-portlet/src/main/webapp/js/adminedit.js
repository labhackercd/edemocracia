/*global CD:true, $:true */
var CDChatAdminEdit = function (setup) {
	
	var getUsers = setup.getUsers,
		ns = setup.ns || "",
		openFrom = setup.openFrom,
		openUntil = setup.openUntil,
		makeSelector = CD.utils.makeSelector(ns),
		policy = CD.eDemocracia.chat.roomOpenPolicy,
	// Form items
		nameId = makeSelector.id("name"),
	//var descriptionId = makeSelector.id("description");
		moderatedId = makeSelector.id("moderated"),
		moderatedChkId = makeSelector.id("moderatedchk"),
        allowAnonymousId = makeSelector.id("anonallowed"),
        allowAnonymousChkId = makeSelector.id("anonymouschk"),
	//var capacityId = makeSelector.id("capacity");
		openPolicySelectId = makeSelector.id("opSelect"),
		guestNameId = makeSelector.id("guestName"),
		openFromId = makeSelector.id("openFrom"),
		openUntilId = makeSelector.id("openUntil"),
		datePickerOpenClass = makeSelector.classSel("dpopen"),
		openingDatesClass = makeSelector.classSel("dateopen"),
		openPolicy = $(openPolicySelectId).val(),
		policyScheduledClass = ".cdchat_policyScheduled";
		
	function openPolicyChange() {
		var openPolicy = $(openPolicySelectId).val();
		if (openPolicy === policy.always) {
			$(datePickerOpenClass).datepicker("disable");
			$(openingDatesClass).attr("disabled", "disabled");
			$(policyScheduledClass).fadeOut();
		} else {
			$(policyScheduledClass).fadeIn();
			$(datePickerOpenClass).datepicker("enable");
			$(openingDatesClass).removeAttr("disabled");
		}
		
	}
	
	function moderated_on_click() {
		var alwaysOpen = $(moderatedChkId + ":checked").val();
		if (alwaysOpen !== null) {
			$(moderatedId).attr("value", "true");
		} else {
			$(moderatedId).attr("value", "false");
		}
	}

    function allowAnonymous_on_click() {
        var allowAnonymous = $(allowAnonymousChkId + ":checked").val();
        if (allowAnonymous !== null) {
            $(allowAnonymousId).attr("value","true");
        } else {
            $(allowAnonymousId).attr("value","false");
        }
    }

	$(guestNameId).autocomplete({source: getUsers});
	$(datePickerOpenClass).datepicker({dateFormat: "dd/mm/yy", showOn: 'both', buttonImageOnly: true, buttonImage: '/html/icons/calendar.png'});
	$(datePickerOpenClass).datepicker("disable");
	$(openFromId).datepicker('setDate', openFrom);
	$(openUntilId).datepicker('setDate', openUntil);
	$(policyScheduledClass).css("display", "none");
	$(datePickerOpenClass).blur();
	if (openPolicy !== policy.always) {
		$(policyScheduledClass).css("display", "block");
		$(datePickerOpenClass).datepicker("enable");
	}
	$(moderatedChkId).click(moderated_on_click);
    $(allowAnonymousChkId).click(allowAnonymous_on_click);
	$(openPolicySelectId).change(openPolicyChange);
	$(nameId).focus();
};
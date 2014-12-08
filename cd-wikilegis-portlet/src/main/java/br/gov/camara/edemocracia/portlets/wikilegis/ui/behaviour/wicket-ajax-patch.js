/**
 * Overrides the attachFocusEvent function registered by wicket-ajax.js. The
 * original version traverses all anchor and button tags on the page which
 * incurs a major performance penalty on pages with many links. This version
 * skips these elements in the scanning.
 */
if (typeof (Wicket) != "undefined") {
	if (typeof (Wicket.Focus) != "undefined") {
		// Deregister old attachFocusEvent function
		var handlers = Wicket.Event.domReadyHandlers;
		var filteredHandlers = new Array();
		for (var i = 0; i < handlers.length; i++) {
			if (handlers[i] != Wicket.Focus.attachFocusEvent) {
				filteredHandlers.push(handlers[i]);
			}
		}
		Wicket.Event.domReadyHandlers = filteredHandlers;

		// Redefine and re-register attachFocusEvent
		Wicket.Focus.attachFocusEvent = function() {
//			Wicket.Focus.setFocusOnElements(document
//					.getElementsByTagName("input"));
//			Wicket.Focus.setFocusOnElements(document
//					.getElementsByTagName("select"));
//			Wicket.Focus.setFocusOnElements(document
//					.getElementsByTagName("textarea"));

// Wicket.Focus.setFocusOnElements(document.getElementsByTagName("button"));
// Wicket.Focus.setFocusOnElements(document.getElementsByTagName("a"));
		};
		Wicket.Event.addDomReadyEvent(Wicket.Focus.attachFocusEvent);
	}
}
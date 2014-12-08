package br.gov.camara.edemocracia.portlets.wikilegis.ui.behaviour;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;


/**
 * {...@link IBehavior} that should be added to {...@link Page}s that need to 
prevent
 * the page load performance penalty incurred when wicket-ajax.js traverses all
 * &lt;a&gt; tags in the page markup.
 *
 * <p/>
 * For background information, see <a
href="http://www.nabble.com/wicket-ajax-and-IE-performance-problems-for-pages-with-many-links-td23078336.html";
 * >this mailing list thread</a>
 * <p/>
 * This behavior simply makes sure that our patch gets applied to wicket-ajax.js
 * (by forcing wicket-ajax.js to be added to the page head prior to
 * wicket-ajax-patch.js).
 *
 */
public class WicketAjaxJsPatch extends AbstractDefaultAjaxBehavior {

	private static final long serialVersionUID = 1L;

	@Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.renderJavascriptReference(new ResourceReference(
            WicketAjaxJsPatch.class, "wicket-ajax-patch.js"));
    }

    @Override
    protected void respond(AjaxRequestTarget target) {
        // Does nothing. The fact that we are extending
        // AbstractDefaultAjaxBehavior means that we will pull in
        // wicket-event.js and wicket-ajax.js. The job of this behavior is to
        // make sure that our wicket-ajax-patch.js script gets added to the page
        // head after those scripts.
    }
}


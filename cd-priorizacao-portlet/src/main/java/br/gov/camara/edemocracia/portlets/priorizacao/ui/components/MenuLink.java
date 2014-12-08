package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class MenuLink<T> extends BookmarkablePageLink<T> {

	private static final long serialVersionUID = 1L;

	public <C extends Page> MenuLink(String id, Class<C> pageClass) {
		super(id, pageClass);		
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		setAutoEnable(true);
	}
	
	@Override
	protected void disableLink(ComponentTag tag) {
		super.disableLink(tag);
		tag.remove("class");
	}
		
	
	
}

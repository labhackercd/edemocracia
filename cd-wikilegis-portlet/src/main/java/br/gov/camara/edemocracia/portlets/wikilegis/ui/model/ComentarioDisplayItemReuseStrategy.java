/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.model;

import java.util.Iterator;
import java.util.Map;

import org.apache.wicket.markup.repeater.IItemFactory;
import org.apache.wicket.markup.repeater.IItemReuseStrategy;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.lang.Generics;

/**
 * @author robson
 * 
 */
public class ComentarioDisplayItemReuseStrategy implements IItemReuseStrategy {

	private static final long serialVersionUID = 1L;

	private static final ComentarioDisplayItemReuseStrategy instance = new ComentarioDisplayItemReuseStrategy();

	public static ComentarioDisplayItemReuseStrategy getInstance() {
		return instance;
	}

	private ComentarioDisplayItemReuseStrategy() {

	}

	/**
	 * Infelizmente, a interface não permite especializar o tipo
	 * 
	 * @see org.apache.wicket.markup.repeater.IItemReuseStrategy#getItems(org.apache.wicket.markup.repeater.IItemFactory,
	 *      java.util.Iterator, java.util.Iterator)
	 */
	@Override
	public <T> Iterator<Item<T>> getItems(final IItemFactory<T> factory, final Iterator<IModel<T>> newModels, Iterator<Item<T>> existingItems) {

		final Map<Long, Item<ComentarioDisplay>> modelToItem = Generics.newHashMap();
		
		while (existingItems.hasNext()) {
			@SuppressWarnings("unchecked")
			final Item<ComentarioDisplay> item = (Item<ComentarioDisplay>) existingItems.next();
			if (item.getModel().getObject() != null)
				modelToItem.put(item.getModel().getObject().getMessageId(), item);
		}

		return new Iterator<Item<T>>() {
			private int index = 0;

			public boolean hasNext() {
				return newModels.hasNext();
			}

			@SuppressWarnings("unchecked")
			public Item<T> next() {
				final IModel<ComentarioDisplay> model = (IModel<ComentarioDisplay>) newModels.next();
				final Item<ComentarioDisplay> oldItem = modelToItem.get(model.getObject().getMessageId());

				final Item<ComentarioDisplay> item;
				if (oldItem == null) {
					item = (Item<ComentarioDisplay>) factory.newItem(index, (IModel<T>) model);
				} else {
					oldItem.setIndex(index);
					item = oldItem;
				}
				index++;

				return (Item<T>) item;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}
}

/**
 * 
 */
package br.gov.camara.edemocracia.portlets.bloqueioforum;

import java.io.Serializable;

/**
 * @author p_7339
 *
 */
public class DadosCategoria implements Serializable {

	private static final long serialVersionUID = 1L;

	private long categoryId;
	
	private String categoryName;

	public DadosCategoria(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryId
	 */
	public final long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public final void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public final String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public final void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}

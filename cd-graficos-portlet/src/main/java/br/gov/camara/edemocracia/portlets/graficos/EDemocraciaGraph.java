package br.gov.camara.edemocracia.portlets.graficos;


public abstract class EDemocraciaGraph {

	protected abstract String getTitle();

	private final long companyId;
	
	public EDemocraciaGraph(long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * @return the companyId
	 */
	protected long getCompanyId() {
		return companyId;
	}

	
	public abstract String getURL();
	
	public abstract String getPostRequest();
}
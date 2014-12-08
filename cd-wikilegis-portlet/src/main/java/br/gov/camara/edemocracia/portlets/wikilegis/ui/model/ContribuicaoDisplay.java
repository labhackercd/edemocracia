/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.model;

import java.io.Serializable;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * Modelo de dados para visualização de contribuição
 * 
 * @author robson
 *
 */
public class ContribuicaoDisplay implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identificador da contribuição
	 */
	private final long contribuicaoId;
	/**
	 * Nome do usuário
	 */
	private final String userName;
	
	/**
	 * Identificador do usuário
	 */
	private final long userId;
	
	/**
	 * Texto da contribuição
	 */
	private final String texto;
	
	/**
	 * Descrição da contribuição
	 */
	private final String descricao;
	
	
	public ContribuicaoDisplay(Contribuicao contribuicao) {
		this.contribuicaoId = contribuicao.getContribuicaoId();
		this.userId = contribuicao.getUserId();
		String userName = contribuicao.getUserName();
		if (this.userId > 0) {
			try {
				userName = UserLocalServiceUtil.getUser(userId).getFullName();
			} catch (PortalException e) {
			} catch (SystemException e) {
			}
		}
		this.userName = userName;
		this.texto = contribuicao.getTexto();
		this.descricao = contribuicao.getDescricao();
	}
	

	public long getContribuicaoId() {
		return contribuicaoId;
	}


	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}

	/**
	 * @return the userId
	 */
	public final long getUserId() {
		return userId;
	}

	/**
	 * @return the texto
	 */
	public final String getTexto() {
		return texto;
	}

	/**
	 * @return the descricao
	 */
	public final String getDescricao() {
		return descricao;
	}
}

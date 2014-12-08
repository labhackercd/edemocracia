/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Exceção lançada ao tentar alterar a configuração e existir um ou mais
 * usuários que não satisfaz a nova condição para o número total de votos
 * 
 * @author p_7339
 * 
 */
public class UsuariosComMaisVotosTotaisException extends PortalException {

}

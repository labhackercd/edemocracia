/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Exceção lançada quando, durante uma mudança de configuração, detectar que há
 * usuários que já votaram mais do que o novo máximo permitido em uma proposta
 * 
 * @author p_7339
 * 
 */
public class UsuariosComMaisVotosPorPropostaException extends PortalException {

}

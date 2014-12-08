/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import java.util.List;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author p_7339
 *
 */
public class VotoFinderImpl extends BasePersistenceImpl<Voto> implements VotoFinder {

    /**
     * Conta o número de propostas mais votos do que o informado
     * 
     * @return
     */
    @Override
    public int countUserIdComMaisVotosPorProposta(long groupId, int votosPorProposta) throws SystemException {
        Session session = null;
        try {
            session = openSession();
            SQLQuery q = session.createSQLQuery(
            		"SELECT COUNT(*) FROM (" +
            		"SELECT DISTINCT vv.userId FROM " +
            		"(SELECT v.propostaId AS propostaId, v.userId AS userId, SUM(v.numeroVotos) AS numeroVotos FROM " +
            		"PR_Proposta p JOIN PR_Voto v ON v.propostaId = p.propostaId WHERE p.groupId = ? " +
            		"GROUP BY v.propostaId, v.userId HAVING SUM(v.numeroVotos) > ?) AS vv) AS v2");
            q.setLong(0, groupId);
            q.setInteger(1, votosPorProposta);
            List<?> ret = q.list();
            return ((Number)ret.get(0)).intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }
    
    /**
     * Conta o número de userId que já votaram mais vezes do que o informado
     * @param groupId
     * @param totalVotos
     * @return
     * @throws SystemException
     */
    @Override
    public int countUserIdComMaisVotosTotal(long groupId, int totalVotos) throws SystemException {
    	Session session = null;
        try {
            session = openSession();
            SQLQuery q = session.createSQLQuery("SELECT COUNT(*) FROM " +
            		"(SELECT v.userId, SUM(v.numeroVotos) AS numeroVotos FROM PR_Proposta p JOIN PR_Voto v ON p.propostaId = v.propostaId " +
            		"WHERE p.groupId = ? GROUP BY v.userId HAVING SUM(v.numeroVotos) > ?) AS s" );
            q.setLong(0, groupId);
            q.setInteger(1, totalVotos);
            List<?> ret = q.list();
            return ((Number)ret.get(0)).intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }	
    }
}

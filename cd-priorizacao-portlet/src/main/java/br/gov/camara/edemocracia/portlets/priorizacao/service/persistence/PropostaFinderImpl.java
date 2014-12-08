/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaImpl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author p_7339
 * 
 */
public class PropostaFinderImpl extends BasePersistenceImpl<Proposta> implements
		PropostaFinder {

	/**
	 * Lista todas as propostas de um eixo e a situação da votação
	 * 
	 * @param userId
	 * @param eixoId
	 * @param podeVerVotos
	 * @param podeVotar
	 * @return
	 * @throws SystemException
	 */
	public List<PropostaDisplay> findPropostaDisplayByUserEixo(
			final long userId, final long eixoId, final int votosDisponiveis, final boolean podeVerVotos,
			boolean podeVotar) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery q;
			if (userId > 0) {
				q = session
						.createSQLQuery("SELECT {p.*}, "
								+ "(SELECT SUM(vv.numeroVotos) FROM PR_Voto vv WHERE vv.propostaId = p.propostaId GROUP BY vv.propostaId) AS totalVotos, "
								+ "v.numeroVotos, v.votosDisponiveis "
								+ "FROM "
								+ "PR_Proposta p LEFT OUTER JOIN PR_Voto v ON p.propostaId = v.propostaId AND v.userId = ? "
								+ "WHERE p.eixoId = ?");
				q.setLong(0, userId);
				q.setLong(1, eixoId);
			} else {
				q = session
						.createSQLQuery("SELECT {p.*}, "
								+ "(SELECT SUM(vv.numeroVotos) FROM PR_Voto vv WHERE vv.propostaId = p.propostaId GROUP BY vv.propostaId) AS totalVotos, "
								+ "0, 0 FROM PR_Proposta p "
								+ "WHERE p.eixoId = ?");
				q.setLong(0, eixoId);
				podeVotar = false;
			}
			q.addEntity("p", PropostaImpl.class);
			q.addScalar("totalVotos", Type.INTEGER);
			q.addScalar("numeroVotos", Type.INTEGER);
			q.addScalar("votosDisponiveis", Type.INTEGER);
			ArrayList<PropostaDisplay> retorno = new ArrayList<PropostaDisplay>();
			Map<Long, Eixo> eixos = new HashMap<Long, Eixo>();

			@SuppressWarnings("unchecked")
			List<Object[]> result = q.list();
			for (Object[] linha : result) {

				// Recupera a proposta, o eixo, a situação global da votação e a
				// situação do usuário
				Proposta proposta = (Proposta) linha[0];
				Eixo eixo;
				if (eixos.containsKey(proposta.getEixoId())) {
					eixo = eixos.get(proposta.getEixoId());
				} else {
					eixo = EixoUtil.fetchByPrimaryKey(proposta.getEixoId());
					eixos.put(proposta.getEixoId(), eixo);
				}
				int totalVotos = (linha[1] != null && podeVerVotos) ? (Integer) linha[1]
						: 0;
				int votosUsuario = linha[2] != null ? (Integer) linha[2] : 0;

				boolean votoPermitido = podeVotar & (votosDisponiveis > 0);
				boolean podeCancelar = podeVotar & (votosUsuario > 0);
				if (votoPermitido
						&& !(linha[3] == null || ((Integer) linha[3]) > 0)) {
					votoPermitido = false;
				}

				retorno.add(new PropostaDisplay(proposta, eixo, totalVotos,
						votosUsuario, votosDisponiveis, votoPermitido, podeCancelar));
			}
			return retorno;
		} catch (Exception e) {
               throw processException(e);
		} finally {
			closeSession(session);
		}
	}
}

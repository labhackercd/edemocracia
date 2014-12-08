package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ArtigoFinderImpl extends BasePersistenceImpl<Artigo> implements ArtigoFinder {

	private static final String FIND_ALL_ARTIGO_DISPLAY = ArtigoFinderImpl.class.getName() + ".findAllArtigoDisplay";
	
	private static final String FIND_ARTIGO_DISPLAY_BY_G_E = ArtigoFinderImpl.class.getName() + ".findArtigoDisplayByGE";
	
	/**
	 * Lista todos os artigos do grupo
	 * @param groupId
	 * @return
	 */
	@Override
	public Map<Long, List<ArtigoDisplay>> findAllArtigoDisplay(long groupId) {
		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(CustomSQLUtil.get(FIND_ALL_ARTIGO_DISPLAY));

			q.setCacheable(true);
			q.addEntity("art", ArtigoImpl.class);
			q.addScalar("contribuicoes", Type.INTEGER);
			q.addScalar("comentarios", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);

			List<Object[]> list = (List<Object[]>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			Map<Long, List<ArtigoDisplay>> artigosPorEstrutura = new HashMap<Long, List<ArtigoDisplay>>();

			long estruturaIdAtual = Long.MIN_VALUE;
			ArrayList<ArtigoDisplay> listaAtual = null;
			for (Object[] obj : list) {
				Artigo artigo = (Artigo) obj[0];
				int contribuicoes = (Integer)obj[1];
				int comentarios = (Integer)obj[2];
				
				if (estruturaIdAtual != artigo.getEstruturaId()) {
					if (listaAtual != null && !listaAtual.isEmpty()) 
						artigosPorEstrutura.put(estruturaIdAtual, Collections.unmodifiableList(listaAtual));
					listaAtual = new ArrayList<ArtigoDisplay>();
					estruturaIdAtual = artigo.getEstruturaId();
				}
				
				listaAtual.add(new ArtigoDisplay(artigo, comentarios, contribuicoes));
			}
			
			if (listaAtual != null && !listaAtual.isEmpty())
				artigosPorEstrutura.put(estruturaIdAtual, Collections.unmodifiableList(listaAtual));

			return Collections.unmodifiableMap(artigosPorEstrutura);

		} finally {
			closeSession(session);
		}
	}
	
	/**
	 * Lista os artigos filhos da estrutura especificada
	 * 
	 * @param estruturaId
	 * @return
	 */
	@Override
	public List<ArtigoDisplay> findDisplayByG_E(long groupId, long estruturaId) {
		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(CustomSQLUtil.get(FIND_ARTIGO_DISPLAY_BY_G_E));

			q.setCacheable(true);
			q.addEntity("art", ArtigoImpl.class);
			q.addScalar("contribuicoes", Type.INTEGER);
			q.addScalar("comentarios", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(estruturaId);

			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<ArtigoDisplay> artigos = new ArrayList<ArtigoDisplay>();

			for (Object[] obj : list) {
				Artigo artigo = (Artigo) obj[0];
				int contribuicoes = (Integer)obj[1];
				int comentarios = (Integer)obj[2];
				
				artigos.add(new ArtigoDisplay(artigo, comentarios, contribuicoes));
			}
			
			return Collections.unmodifiableList(artigos);

		} finally {
			closeSession(session);
		}
	}

}

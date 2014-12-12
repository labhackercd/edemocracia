/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.portlets.graficos.service.impl;

import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import br.gov.camara.edemocracia.portlets.graficos.DadosConsolidados;
import br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso;
import br.gov.camara.edemocracia.portlets.graficos.service.base.ContadorAcessoLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.wiki.model.WikiPage;

/**
 * The implementation of the contador acesso local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalServiceUtil}
 * to access the contador acesso local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Robson Miranda
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.ContadorAcessoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalServiceUtil
 */
public class ContadorAcessoLocalServiceImpl extends
		ContadorAcessoLocalServiceBaseImpl {

	/**
	 * Exporta os dados de uma compania em CSV
	 * 
	 * @param companyId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public String getCSV(long companyId) throws SystemException, IOException {
		DateMidnight mes = getMenorMes(companyId);
		DateMidnight atual = getMesAtual();

		SimpleDateFormat mesAno = new SimpleDateFormat("yyyy-MM");
		mesAno.setTimeZone(TimeZoneUtil.getDefault());
		DateTimeFormatter iso = ISODateTimeFormat.dateTimeNoMillis().withZone(
				DateTimeZone.forTimeZone(TimeZoneUtil.getDefault()));

		CharArrayWriter writer = new CharArrayWriter();
		BufferedWriter bw = new BufferedWriter(writer);
		bw.append("comunidade;data_geracao;ano_mes;contador;valor\r\n");

		LinkedHashMap<String, Method> acessores = new LinkedHashMap<String, Method>();
		for (Method m : DadosConsolidados.class.getMethods()) {
			if (m.getName().startsWith("get") && m.getReturnType() == int.class
					&& m.getParameterTypes().length == 0) {
				StringBuilder sbNome = new StringBuilder(m.getName().substring(
						3));
				sbNome.setCharAt(0, Character.toLowerCase(sbNome.charAt(0)));
				if ("dataGeracao".equals(sbNome))
					continue;
				int i = 0;
				while (i < sbNome.length()) {
					char chr = sbNome.charAt(i);
					if (Character.isUpperCase(chr) && i > 0
							&& Character.isLowerCase(sbNome.charAt(i - 1))) {
						sbNome.setCharAt(i, Character.toLowerCase(chr));
						sbNome.insert(i, '_');
						i++;
					}
					i++;
				}
				acessores.put(sbNome.toString(), m);
			}
		}

		while (mes.isBefore(atual) || mes.isEqual(atual)) {
			Map<Long, DadosConsolidados> dadosMes = getDadosMes(companyId,
					new Date(mes.getMillis()));
			for (Long groupId : dadosMes.keySet()) {
				String nome;
				if (groupId == null) {
					nome = "Portal";
				} else {
					try {
						Group grupo = GroupLocalServiceUtil.getGroup(groupId);
						nome = grupo.getDescriptiveName().trim();
						StringBuilder sbNome = new StringBuilder(nome);
						for (int i = 0; i < sbNome.length(); i++) {
							if (sbNome.charAt(i) == '"') {
								sbNome.insert(i, '"');
								i++;
							}
						}
					} catch (PortalException e) {
						continue;
					}
				}

				DadosConsolidados dados = dadosMes.get(groupId);
				String cabecalho = "\"" + nome + "\";"
						+ iso.print(dados.getDataGeracao().getTime()) + ";";
				cabecalho += mesAno.format(new Date(mes.getMillis())) + ";";

				for (Map.Entry<String, Method> entrada : acessores.entrySet()) {
					try {
						String valor = ((Integer) entrada.getValue().invoke(
								dados)).toString();
						bw.append(cabecalho).append(entrada.getKey())
								.append(";").append(valor).append("\r\n");
					} catch (Exception ignore) {
					}
				}
			}
			mes = mes.plusMonths(1);
		}
		bw.close();
		return writer.toString();
	}

	/**
	 * Lista todas as comunidades públicas, privadas e restritas da companhia
	 * 
	 * @throws SystemException
	 */
	private List<Group> getComunidades(long companyId) throws SystemException {

		long groupClassNameId = ClassNameLocalServiceUtil
				.getClassNameId(Group.class);

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class,
				PortalClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		query.add(RestrictionsFactoryUtil.eq("classNameId", groupClassNameId));
		query.add(RestrictionsFactoryUtil.in("type", new Object[] {
				GroupConstants.TYPE_SITE_OPEN,
				GroupConstants.TYPE_SITE_PRIVATE,
				GroupConstants.TYPE_SITE_RESTRICTED }));
		query.add(RestrictionsFactoryUtil.eq("parentGroupId",
				GroupConstants.DEFAULT_PARENT_GROUP_ID));
		query.add(RestrictionsFactoryUtil.eq("active", true));
		query.add(RestrictionsFactoryUtil.ne("name",
				GroupConstants.CONTROL_PANEL));
		query.addOrder(OrderFactoryUtil.asc("name"));

		@SuppressWarnings("unchecked")
		List<Group> ret = GroupLocalServiceUtil.dynamicQuery(query);
		return ret;
	}

	/**
	 * Obtém os dados consolidados até o dia de hoje
	 * 
	 * @param companyId
	 * @return
	 * @throws SystemException
	 */
	@Transactional(readOnly = false)
	@Override
	public Map<Long, DadosConsolidados> getDadosConsolidados(long companyId)
			throws SystemException {
		DateMidnight mes = getMenorMes(companyId);
		DateMidnight atual = getMesAtual();

		LinkedHashMap<Long, DadosConsolidados> totais = new LinkedHashMap<Long, DadosConsolidados>();
		while (mes.isBefore(atual) || mes.isEqual(atual)) {
			Map<Long, DadosConsolidados> dadosMes = getDadosMes(companyId,
					new Date(mes.getMillis()));
			for (Long grupo : dadosMes.keySet()) {
				DadosConsolidados totaisGrupo;
				if (!totais.containsKey(grupo)) {
					totaisGrupo = new DadosConsolidados();
					totais.put(grupo, totaisGrupo);
				} else {
					totaisGrupo = totais.get(grupo);
				}

				// Copia / adiciona as estatisticas
				DadosConsolidados dadosGrupo = dadosMes.get(grupo);
				totaisGrupo.setNumeroMembros(dadosGrupo.getNumeroMembros());
				totaisGrupo.setForumTopicosCriados(totaisGrupo
						.getForumTopicosCriados()
						+ dadosGrupo.getForumTopicosCriados());
				totaisGrupo.setForumTotalPostagens(totaisGrupo
						.getForumTotalPostagens()
						+ dadosGrupo.getForumTotalPostagens());
				totaisGrupo.setForumVisualizacoes(dadosGrupo
						.getForumVisualizacoes());

				totaisGrupo.setBatepapoMensagens(totaisGrupo
						.getBatepapoMensagens()
						+ dadosGrupo.getBatepapoMensagens());
				totaisGrupo.setBibliotecaComentarios(totaisGrupo
						.getBibliotecaComentarios()
						+ dadosGrupo.getBibliotecaComentarios());
				totaisGrupo.setBlogsComentarios(totaisGrupo
						.getBlogsComentarios()
						+ dadosGrupo.getBlogsComentarios());
				totaisGrupo.setWikiComentarios(totaisGrupo.getWikiComentarios()
						+ dadosGrupo.getWikiComentarios());
				totaisGrupo.setWikilegisSugestoes(totaisGrupo
						.getWikilegisSugestoes()
						+ dadosGrupo.getWikilegisSugestoes());
				totaisGrupo.setWikilegisComentarios(totaisGrupo
						.getWikilegisComentarios()
						+ dadosGrupo.getWikilegisComentarios());
			}
			mes = mes.plusMonths(1);
		}
		return totais;
	}

	/**
	 * @return
	 */
	private DateMidnight getMesAtual() {
		DateMidnight atual = new DateMidnight(
				DateTimeZone.forTimeZone(TimeZoneUtil.getDefault()));
		atual = atual.withDayOfMonth(1);
		return atual;
	}

	/**
	 * @param companyId
	 * @return
	 * @throws SystemException
	 */
	private DateMidnight getMenorMes(long companyId) throws SystemException {
		Date menorDataMessage = buscaData(
				"select min(createDate) from MBMessage where companyId = ?",
				companyId);
		Date menorDataChat = buscaData(
				"select min(a.messageTS) from CDChat_ChatRoomMessage a "
						+ "JOIN CDChat_ChatRoom b ON a.chatRoomId = b.roomId "
						+ "JOIN Group_ c on b.groupId = c.groupId "
						+ "WHERE a.messageType = 0 and a.messageStatus = 1 and c.companyId = ?",
				companyId);

		if (menorDataMessage == null) // Se não tiver nenhuma mensagem
			menorDataMessage = new Date();
		if (menorDataChat == null)
			menorDataChat = new Date();
		Date menorData = menorDataMessage.before(menorDataChat) ? menorDataMessage
				: menorDataChat;
		DateMidnight mes = new DateMidnight(menorData.getTime(),
				DateTimeZone.forTimeZone(TimeZoneUtil.getDefault()));
		mes = mes.withDayOfMonth(1);
		return mes;
	}

	private Date buscaData(String sql, long companyId) throws SystemException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, companyId);
			rs = pstmt.executeQuery();
			if (!rs.next())
				return new Date();
			return rs.getTimestamp(1);
		} catch (SQLException e) {
			throw new SystemException(e);
		} finally {
			DataAccess.cleanUp(rs);
			DataAccess.cleanUp(pstmt);
			DataAccess.cleanUp(conn);
		}
	}

	/**
	 * Obtém os dados consolidados de todos os grupos
	 * 
	 * @param companyId
	 * @param mes
	 * @return
	 * @throws SystemException
	 */
	@Transactional(readOnly = false)
	private Map<Long, DadosConsolidados> getDadosMes(long companyId, Date mes)
			throws SystemException {

		DateTimeZone timeZone = DateTimeZone.forTimeZone(TimeZoneUtil
				.getDefault());
		MutableDateTime mdt = new MutableDateTime(mes, timeZone);
		mdt.setTime(0, 0, 0, 0);
		mdt.setDayOfMonth(1);
		mes = new Date(mdt.getMillis());

		Map<Long, DadosConsolidados> dc = null;
		List<ContadorAcesso> contadores = contadorAcessoPersistence.findByC_D(
				companyId, mes);

		// Verifica se precisa gerar novas estatísticas
		ContadorAcesso contador;
		if (contadores.isEmpty() || contadores.size() > 1) {
			for (ContadorAcesso contadorAcesso : contadores)
				deleteContadorAcesso(contadorAcesso);
			contador = createContadorAcesso(CounterLocalServiceUtil
					.increment(ContadorAcesso.class.getName()));
		} else {
			// Apenas um contador. Se for mês corrente e não tiver sido
			// atualizado hoje,
			// então atualiza
			contador = contadores.get(0);
			DateMidnight diaAtualizacao = new DateMidnight(
					contador.getDataAtualizacao(), timeZone);
			DateMidnight hoje = new DateMidnight(timeZone);

			DateMidnight mesAtualizacao = diaAtualizacao.withDayOfMonth(1);
			DateMidnight mesAtual = hoje.withDayOfMonth(1);
			DateMidnight mesDados = new DateMidnight(contador.getData(),
					timeZone).withDayOfMonth(1);

			// Mês atual. Precisa atualizar?
			if (mesDados.equals(mesAtual)) {
				if (!diaAtualizacao.equals(hoje))
					contador.setCache("");
			} else {
				// Nova atualização se os dados foram atualizados no mês a que
				// se
				// referem, ou se foram atualizados antes do mês chegar e
				// o mês atual for após o mês solicitado
				if (mesAtualizacao.equals(mesDados))
					contador.setCache("");
				else if (mesAtualizacao.isBefore(mesDados)
						&& mesAtual.isAfter(mesDados))
					contador.setCache("");
			}
		}

		if (!StringUtils.isBlank(contador.getCache())) {
			dc = (Map<Long, DadosConsolidados>) Base64.stringToObject(contador
					.getCache().trim(), DadosConsolidados.class
					.getClassLoader());
			if (dc == null)
				contador.setCache("");
		}

		if (StringUtils.isBlank(contador.getCache())) {
			dc = constroiDadosConsolidados(companyId, mes);
			contador.setData(mes);
			contador.setDataAtualizacao(new Date());
			contador.setCompanyId(companyId);
			contador.setCache(Base64.objectToString(dc));

			// Se não conseguiu serializar, exclui os dados
			if (contador.getCache() == null && !contador.isNew())
				deleteContadorAcesso(contador);
			else
				updateContadorAcesso(contador);
		}
		return dc;
	}

	private Map<Long, DadosConsolidados> constroiDadosConsolidados(
			long companyId, Date mes) throws SystemException {

		LinkedHashMap<Long, DadosConsolidados> retorno = new LinkedHashMap<Long, DadosConsolidados>();

		DadosConsolidados globais = new DadosConsolidados();
		globais.setDataGeracao(new Date());
		retorno.put(null, globais);

		for (Group group : getComunidades(companyId)) {
			// Pega os grupos filho
			List<Long> grupos = new ArrayList<Long>();
			grupos.add(group.getGroupId());

			grupos.addAll(getGruposFilhos(group));

			DadosConsolidados dc = new DadosConsolidados();
			dc.setDataGeracao(new Date());
			StringBuilder sbParamGrupos = new StringBuilder();
			for (int i = 0; i < grupos.size(); i++) {
				if (i > 0)
					sbParamGrupos.append(",");
				sbParamGrupos.append("?");
			}
			String paramGrupos = sbParamGrupos.toString();

			long wikiPageClassId = ClassNameLocalServiceUtil
					.getClassNameId(WikiPage.class);
			long blogsEntryClassId = ClassNameLocalServiceUtil
					.getClassNameId(BlogsEntry.class);
			long dlFileEntryClassId = ClassNameLocalServiceUtil
					.getClassNameId(DLFileEntry.class);
			long wikilegisClassId = ClassNameLocalServiceUtil
					.getClassNameId("br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo");

			Connection conn = null;
			try {
				conn = DataAccess.getConnection();
				String sql = "select COUNT(*) from ("
						+ " select distinct u.userId from Users_Groups ug  join User_ u on ug.userId = u.userId "
						+ "where ug.groupId in (#PARAMS#) and u.status = "
						+ WorkflowConstants.STATUS_APPROVED + ") as a";
				dc.setNumeroMembros(consulta(conn, sql, paramGrupos, grupos,
						null));

				// ////
				// Forum
				sql = "select count(*) from MBThread a join MBMessage b on a.rootMessageId = b.messageId "
						+ "where a.groupId IN (#PARAMS#) and a.categoryId <> -1 !AND b.createDate between ? and ?!";
				dc.setForumTopicosCriados(consulta(conn, sql, paramGrupos,
						grupos, mes));

				sql = "select count(*) from MBMessage where groupId in (#PARAMS#) "
						+ "and classNameId = 0 !and createDate between ? and ?!";
				dc.setForumTotalPostagens(consulta(conn, sql, paramGrupos,
						grupos, mes));

				sql = "select sum(viewCount) from MBThread where groupId in (#PARAMS#) and categoryId <> -1";
				dc.setForumVisualizacoes(consulta(conn, sql, paramGrupos,
						grupos, null));

				// ////
				// Wiki
				sql = "select count(*) from MBMessage where groupId in (#PARAMS#) and classNameId = "
						+ wikiPageClassId
						+ " "
						+ "and rootMessageId <> messageId !and createDate between ? and ?!";
				dc.setWikiComentarios(consulta(conn, sql, paramGrupos, grupos,
						mes));

				// ////
				// Blogs
				sql = "select count(*) from MBMessage where groupId in (#PARAMS#) and classNameId = "
						+ blogsEntryClassId
						+ " "
						+ "and rootMessageId <> messageId !and createDate between ? and ?!";
				dc.setBlogsComentarios(consulta(conn, sql, paramGrupos, grupos,
						mes));

				// ///
				// Biblioteca virtual
				sql = "select count(*) from MBMessage where groupId in (#PARAMS#) and classNameId = "
						+ dlFileEntryClassId
						+ " "
						+ "and rootMessageId <> messageId !and createDate between ? and ?!";
				dc.setBibliotecaComentarios(consulta(conn, sql, paramGrupos,
						grupos, mes));

				// ///
				// Bate-papos
				sql = "select count(*) from CDChat_ChatRoomMessage a JOIN CDChat_ChatRoom b ON a.chatRoomId = b.roomId "
						+ "WHERE b.groupId in (#PARAMS#) and a.messageType = 0 and a.messageStatus = 1 "
						+ "!and a.messageTS between ? and ?!";
				dc.setBatepapoMensagens(consulta(conn, sql, paramGrupos,
						grupos, mes));

				// ///
				// Wikilegis
				sql = "select count(*) from CDWL_Contribuicao where artigoId in ( "
						+ "select artigoId from CDWL_artigo where groupId in (#PARAMS#)) !and data_ between ? and ?! ";
				dc.setWikilegisSugestoes(consulta(conn, sql, paramGrupos,
						grupos, mes));

				sql = "select count(*) "
						+ "from CDWL_Artigo a left join MbMessage m on m.classPK = a.artigoId where m.classNameId = "
						+ wikilegisClassId
						+ " "
						+ "and m.groupId in (#PARAMS#) and m.parentMessageId <> 0 !and createDate between ? and ?!";
				dc.setWikilegisComentarios(consulta(conn, sql, paramGrupos,
						grupos, mes));

				retorno.put(group.getGroupId(), dc);

				// Adiciona às estatísticas globais
				if (group.getType() == GroupConstants.TYPE_SITE_OPEN) {
					globais.adiciona(dc);
				}

			} catch (SQLException e) {
				throw new SystemException(e);
			} finally {
				DataAccess.cleanUp(conn);
			}
		}
		globais.setNumeroMembros(UserLocalServiceUtil
				.getCompanyUsersCount(companyId));
		return retorno;
	}

	/**
	 * @param group
	 * 
	 * @return
	 * @throws SystemException
	 */
	private List<Long> getGruposFilhos(Group group) throws SystemException {
		List<Long> grupos = new ArrayList<Long>();

		long layoutClassNameId = ClassNameLocalServiceUtil
				.getClassNameId(Layout.class);
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class);
		query.add(RestrictionsFactoryUtil.eq("companyId", group.getCompanyId()));
		query.add(RestrictionsFactoryUtil.eq("classNameId", layoutClassNameId));
		query.add(RestrictionsFactoryUtil.eq("parentGroupId",
				group.getGroupId()));
		query.add(RestrictionsFactoryUtil.eq("active", true));
		@SuppressWarnings("unchecked")
		List<Group> filhos = GroupLocalServiceUtil.dynamicQuery(query);
		for (Group filho : filhos)
			grupos.add(filho.getGroupId());
		return grupos;
	}

	private int consulta(Connection conn, String sql, String paramGrupos,
			List<Long> grupos, Date mes) throws SQLException {
		sql = sql.replace("#PARAMS#", paramGrupos);
		boolean possuiData = false;
		int posData = sql.indexOf('!');
		if (posData >= 0) {
			int end = sql.indexOf('!', posData + 1);
			if (end >= 0) {
				if (mes == null) {
					sql = sql.substring(0, posData) + sql.substring(end + 1);
				} else {
					sql = sql.substring(0, posData)
							+ sql.substring(posData + 1, end)
							+ sql.substring(end + 1);
					possuiData = true;
				}
			}
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			int i;
			for (i = 0; i < grupos.size(); i++)
				pstmt.setLong(i + 1, grupos.get(i));
			if (possuiData) {
				// Obtém a data inicial e final
				TimeZone tz = TimeZoneUtil.getDefault();
				MutableDateTime dt = new MutableDateTime(mes,
						DateTimeZone.forTimeZone(tz));
				dt.setTime(0, 0, 0, 0);
				dt.setDayOfMonth(1);
				Timestamp inicio = new Timestamp(dt.getMillis());
				dt.addMonths(1);
				dt.addDays(-1);
				dt.setTime(23, 59, 59, 999);
				Timestamp fim = new Timestamp(dt.getMillis());

				pstmt.setTimestamp(i++ + 1, inicio);
				pstmt.setTimestamp(i++ + 1, fim);
			}
			ResultSet rs = pstmt.executeQuery();
			try {
				rs.next();
				return rs.getInt(1);
			} finally {
				DataAccess.cleanUp(rs);
			}
		} finally {
			DataAccess.cleanUp(pstmt);
		}
	}

}

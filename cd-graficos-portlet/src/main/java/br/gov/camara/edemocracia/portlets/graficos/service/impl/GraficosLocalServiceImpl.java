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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.sql.DataSource;

import br.gov.camara.edemocracia.portlets.graficos.service.base.GraficosLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

/**
 * The implementation of the graficos local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil}
 * to access the graficos local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Robson Miranda
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.GraficosLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil
 */
public class GraficosLocalServiceImpl extends GraficosLocalServiceBaseImpl {

	/**
	 * Retorna os usuários por UF
	 * 
	 * @param companyId
	 *            TODO
	 * @param pais
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Map<String, Integer> getUsuariosPorUf(long companyId, Country pais) {

		long contactClassId = ClassNameLocalServiceUtil.getClassNameId(Contact.class.getName());
		long classId = pais.getCountryId();

		DataSource dataSource = InfrastructureUtil.getDataSource();
		String sql = "select reg.regionCode, count(*) from User_ u join Contact_ c on u.contactId = c.contactId "
				+ "left outer join "
				+ "Address ad on (c.contactId = ad.classPK and ad.classNameId = ? and ad.countryId = ? and ad.primary_ <> 0) "
				+ "left outer join Region reg on (ad.regionId = reg.regionId) where u.companyId = ? "
				+ "group by reg.regionCode order by reg.regionCode";

		MappingSqlQuery<UsuarioPorEstado> query = MappingSqlQueryFactoryUtil.getMappingSqlQuery(dataSource, sql, new int[] {
				Types.BIGINT, Types.BIGINT, Types.BIGINT }, new RowMapper<UsuarioPorEstado>() {

			@Override
			public UsuarioPorEstado mapRow(ResultSet rs, int rowNumber) throws SQLException {
				String uf = rs.getString(1);
				if (uf == null)
					uf = "N/D";
				return new UsuarioPorEstado(uf, rs.getInt(2));
			}
		});

		Map<String, Integer> retorno = new LinkedHashMap<String, Integer>();
		for (UsuarioPorEstado entrada : query.execute(contactClassId, classId, companyId)) {
			retorno.put(entrada.getUf(), entrada.getNumero());
		}
		return retorno;
	}

	public Map<String, Integer> getUsuariosPorData(long companyId, TimeZone tz, Date inicio, Date fim) {
		String sql = "select createDate from User_ where createDate between ? and ? and companyId = ? order by createDate";

		return buscaQuantidadePorData(companyId, tz, inicio, fim, sql);
	}

	/**
	 * Busca a atividade na faixa de tempo especificada
	 * 
	 * @param companyId
	 * @param inicio
	 * @param fim
	 * @return
	 */
	public Map<String, Integer> getAtividadePorData(long companyId, TimeZone tz, Date inicio, Date fim) {
		String sql = "select createDate from MBMessage where createDate between ? and ? and companyId = ? order by createDate";

		return buscaQuantidadePorData(companyId, tz, inicio, fim, sql);
	}

	private Map<String, Integer> buscaQuantidadePorData(long companyId, TimeZone tz, Date inicio, Date fim, String sql) {
		DataSource dataSource = InfrastructureUtil.getDataSource();

		// Corrige as datas de início e fim
		Calendar cal = Calendar.getInstance(tz);
		cal.setTime(inicio);
		inicio = CalendarUtil.getGTDate(cal);
		cal.setTime(fim);
		fim = CalendarUtil.getLTDate(cal);

		Map<String, Integer> retorno = new LinkedHashMap<String, Integer>();

		MappingSqlQuery<Date> mensagens = MappingSqlQueryFactoryUtil.getMappingSqlQuery(dataSource, sql, new int[] {
				Types.TIMESTAMP, Types.TIMESTAMP, Types.BIGINT }, new RowMapper<Date>() {

			@Override
			public Date mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getTimestamp(1);
			}
		});

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(tz);
		for (Date data : mensagens.execute(inicio, fim, companyId)) {
			String dia = sdf.format(data);
			if (!retorno.containsKey(dia))
				retorno.put(dia, 1);
			else
				retorno.put(dia, retorno.get(dia) + 1);
		}

		return retorno;
	}

}

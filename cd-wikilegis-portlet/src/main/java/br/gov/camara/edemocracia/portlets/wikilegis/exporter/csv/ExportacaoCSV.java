package br.gov.camara.edemocracia.portlets.wikilegis.exporter.csv;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;
import br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper;
import br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ExportacaoCSV {
	
	private static final Log LOG = LogFactoryUtil.getLog(ExportacaoCSV.class);

	public static void getContribuicoesCSV(final Long groupId, final Writer writer) throws SystemException, SQLException, IOException, PortalException {
		final CSVWriter csvWriter = new CSVWriter(writer,';');
		final List<ContribuicaoWrapper> dados = WikiLegisServiceUtil.exportaContribuicoes(groupId);
		exportar(ContribuicaoWrapper.class, dados, csvWriter);
		csvWriter.close();
		writer.close();
	}
	
	public static void getComentariosCSV(final Long groupId, final Writer writer) throws SystemException, SQLException, IOException, PortalException {
		final CSVWriter csvWriter = new CSVWriter(writer,';');
		final List<ComentarioWrapper> dados = WikiLegisServiceUtil.exportaComentarios(groupId);
		exportar(ComentarioWrapper.class, dados, csvWriter);
		csvWriter.close();
		writer.close();
	}
	
	private static <T> void exportar(final Class<?> classe, final List<T> dados, final CSVWriter csvWriter) {
		
		final Field[] campos = classe.getDeclaredFields();
		final String[] colunas = new String[campos.length];
		final Method[] metodosDeAcesso = new Method[campos.length];
		
		// Coletando nome das colunas para impressão 
		// Coletando metodos de acesso get 
		for(int i = 0 ; i < campos.length ; i++) {
			final String nomeCampo = campos[i].getName(); 
			colunas[i] = nomeCampo;
			final String metodoDeAcesso = "get" + nomeCampo.substring(0, 1).toUpperCase() + nomeCampo.substring(1);
			try {
				metodosDeAcesso[i] = classe.getMethod(metodoDeAcesso,null);
			} catch (SecurityException e) {
				LOG.error("Erro ao exportar arquivo csv",e);
			} catch (NoSuchMethodException e) {
				LOG.error("Erro ao exportar arquivo csv. Método não encontrado.",e);
			}
		}
		csvWriter.writeNext(colunas);
		
		// Impressão dos dados
		final Iterator<T> iteratorDados = dados.iterator();
		final int columnCount = colunas.length;
		
		while (iteratorDados.hasNext()){
    		final T dadosForum = iteratorDados.next();
    		String[] nextLine = new String[columnCount];
    		for (int i = 0; i < columnCount; i++) {
        		try {
					nextLine[i] = metodosDeAcesso[i].invoke(dadosForum, null) + "";
				} catch (SecurityException e) {
					LOG.error("Erro ao exportar arquivo csv",e);
				} catch (IllegalArgumentException e) {
					LOG.error("Erro ao exportar arquivo csv",e);
				} catch (IllegalAccessException e) {
					LOG.error("Erro ao exportar arquivo csv",e);
				} catch (InvocationTargetException e) {
					LOG.error("Erro ao exportar arquivo csv",e);
				}
			}
        	csvWriter.writeNext(nextLine);
    	}
	}
}

package br.gov.camara.edemocracia.portlets.participacao.exporter;

import java.util.List;

import br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO;
import br.gov.camara.edemocracia.portlets.graficos.DadosUsuarioDTO;

public class CSVParticipacaoExporter {

	private static StringBuilder sb ;
	
	public CSVParticipacaoExporter() {
	}
	
	public static String export(List<DadosComunidadeDTO> listaDadosComunidade) {

		sb =  new StringBuilder();
		
		insertColumn("idComunidade");
		insertColumn("comunidade");
		insertColumn("idUsuario");
		insertColumn("usuario");
		insertColumn("email");
		insertColumn("postagensForum");
		insertColumn("comentariosWikilegis");
		insertColumn("contribuicoesWikilegis");
		insertColumn("comentariosWiki");
		insertColumn("alteracoesWiki");	
		insertColumn("comentariosBlog");
		insertColumn("comentariosConteudoWeb");		
		insertColumn("comentariosDocumentos");
		insertColumn("membro");
		
		lineEnd();

		for (DadosComunidadeDTO comunidade : listaDadosComunidade) {
			
			String groupId = Long.toString(comunidade.getGroupId());
			String nomeComunidade = comunidade.getNomeComunidade();
			
			for(DadosUsuarioDTO dadosUsuario : comunidade.getListaDadosUsuario().values()){
				insertColumn(groupId);
				insertColumn(nomeComunidade);
				insertColumn(dadosUsuario.getUserId());
				insertColumn(dadosUsuario.getUsername());
				insertColumn(dadosUsuario.getEmail());
				insertColumn(dadosUsuario.getPostagensForum());
				insertColumn(dadosUsuario.getComentariosWikilegis());
				insertColumn(dadosUsuario.getContribuicoesWikilegis());
				insertColumn(dadosUsuario.getComentariosWiki());
				insertColumn(dadosUsuario.getAlteracoesWiki());
				insertColumn(dadosUsuario.getComentariosBlog());
				insertColumn(dadosUsuario.getComentariosConteudoWeb());
				insertColumn(dadosUsuario.getComentariosDocumentos());
				insertColumn(dadosUsuario.isMembro() ? "Sim" : "Não");

				lineEnd();	
			}
			
		}

		return sb.toString();
	}

	private static void insertColumn(String coluna) {
		sb.append("\""+coluna+"\"").append(";");
	}
	
	private static void insertColumn(long coluna) {
		sb.append("\"" + Long.toString(coluna) + "\"").append(";");
	}
	
	private static void insertColumn(int coluna) {
		sb.append("\"" + Integer.toString(coluna) + "\"").append(";");
	}

	private static void insertColumn(boolean coluna) {
		sb.append("\"" + Boolean.toString(coluna) + "\"").append(";");
	}
	
	private static void lineEnd() {
		sb.append("\n");
	}
}

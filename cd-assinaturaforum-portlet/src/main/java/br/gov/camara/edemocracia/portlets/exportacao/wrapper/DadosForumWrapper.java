package br.gov.camara.edemocracia.portlets.exportacao.wrapper;

import java.util.Date;

public class DadosForumWrapper {

	private Long idFase;
	private Long idEixo;
	private Long idEixoPai;
	private String eixo;
	private String proposta;
	private Long idProposta;
	private Long idMensagemRaiz;
	private Long idMensagem;
	private Long idMensagemPai;
	private String textoMensagem;
	private Long idUsuario;
	private String usuario;
	private Date dataCriacao;
	private Long totalAvaliacoes;
	private Long pontuacaoAvaliacoes;
	
	public DadosForumWrapper() {
	}

	public Long getIdFase() {
		return idFase;
	}

	public void setIdFase(Long idFase) {
		this.idFase = idFase;
	}

	public Long getIdEixo() {
		return idEixo;
	}

	public void setIdEixo(Long idEixo) {
		this.idEixo = idEixo;
	}

	public Long getIdEixoPai() {
		return idEixoPai;
	}

	public void setIdEixoPai(Long idEixoPai) {
		this.idEixoPai = idEixoPai;
	}

	public String getEixo() {
		return eixo;
	}

	public void setEixo(String eixo) {
		this.eixo = eixo;
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}

	public Long getIdMensagemRaiz() {
		return idMensagemRaiz;
	}

	public void setIdMensagemRaiz(Long idMensagemRaiz) {
		this.idMensagemRaiz = idMensagemRaiz;
	}

	public Long getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Long getIdMensagemPai() {
		return idMensagemPai;
	}

	public void setIdMensagemPai(Long idMensagemPai) {
		this.idMensagemPai = idMensagemPai;
	}

	public String getTextoMensagem() {
		return textoMensagem;
	}

	public void setTextoMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getTotalAvaliacoes() {
		return totalAvaliacoes;
	}

	public void setTotalAvaliacoes(Long totalAvaliacoes) {
		this.totalAvaliacoes = totalAvaliacoes;
	}

	public Long getPontuacaoAvaliacoes() {
		return pontuacaoAvaliacoes;
	}

	public void setPontuacaoAvaliacoes(Long pontuacaoAvaliacoes) {
		this.pontuacaoAvaliacoes = pontuacaoAvaliacoes;
	}
	
}
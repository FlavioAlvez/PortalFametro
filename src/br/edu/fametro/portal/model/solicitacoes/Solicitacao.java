package br.edu.fametro.portal.model.solicitacoes;

import java.util.Date;

import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public abstract class Solicitacao {
	private long codigo;
	private GrupoAtendimento grupoAtendimento;
	private TipoAtendimento tipoAtendimento;
	private AcessaSistema cliente;
	private TipoUsuario tipo;
	private Date abertura;
	private Date fechamento;
	private String assunto;
	private String solicitacao;
	private String discussao;
	private String solucao;

	public Solicitacao() {

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public GrupoAtendimento getGrupoAtendimento() {
		return grupoAtendimento;
	}

	public void setGrupoAtendimento(GrupoAtendimento grupoAtendimento) {
		this.grupoAtendimento = grupoAtendimento;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public AcessaSistema getCliente() {
		return cliente;
	}

	public void setCliente(AcessaSistema cliente) {
		this.cliente = cliente;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public Date getFechamento() {
		return fechamento;
	}

	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getDiscussao() {
		return discussao;
	}

	public void setDiscussao(String discussao) {
		this.discussao = discussao;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	@Override
	public String toString() {
		return "Solicitacao [codigo=" + codigo + ", grupoAtendimento=" + grupoAtendimento + ", tipoAtendimento="
				+ tipoAtendimento + ", cliente=" + cliente + ", tipo=" + tipo + ", abertura=" + abertura
				+ ", fechamento=" + fechamento + ", assunto=" + assunto + ", solicitacao=" + solicitacao
				+ ", discussao=" + discussao + ", solucao=" + solucao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Solicitacao)) {
			return false;
		}
		Solicitacao other = (Solicitacao) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}
}
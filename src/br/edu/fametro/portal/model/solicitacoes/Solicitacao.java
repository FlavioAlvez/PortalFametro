package br.edu.fametro.portal.model.solicitacoes;

import java.util.Date;

import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public abstract class Solicitacao {
	private int codigo;
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
	
	public Solicitacao(int codigo, GrupoAtendimento grupoAtendimento, TipoAtendimento tipoAtendimento,
			AcessaSistema cliente, TipoUsuario tipo, String assunto, String solicitacao) {
		super();
		this.codigo = codigo;
		this.grupoAtendimento = grupoAtendimento;
		this.tipoAtendimento = tipoAtendimento;
		this.cliente = cliente;
		this.tipo = tipo;
		this.assunto = assunto;
		this.solicitacao = solicitacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
}

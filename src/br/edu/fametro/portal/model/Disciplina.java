package br.edu.fametro.portal.model;

public class Disciplina {
	private String nome;
	private String codigo;

	public Disciplina(String nome) {
		super();
		this.nome = nome;
	}

	public Disciplina(String nome, String codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
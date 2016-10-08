package br.edu.fametro.portal.model;

import java.util.Date;

public abstract class Pessoa {
	private String nome;
	private String rg;
	private String cpf;
	private Date nascimento;
	private Genero genero;

	public Pessoa(String nome, String rg, String cpf, Date nascimento, Genero genero) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
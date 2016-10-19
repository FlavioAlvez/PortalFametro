package br.edu.fametro.portal.model.atores;

import java.util.Date;

import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.enums.Genero;

public abstract class Pessoa {
	private String nome;
	private String rg;
	private String cpf;
	private Date nascimento;
	private Genero genero;
	private Filiacao filiacao;
	private String naturalidade;
	private String estadoNatal;

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

	public String getPrimeiroNome() {
		return nome.split(" ")[0];
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

	public Filiacao getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEstadoNatal() {
		return estadoNatal;
	}

	public void setEstadoNatal(String estadoNatal) {
		this.estadoNatal = estadoNatal;
	}

	@Override
	public boolean equals(Object obj) {
		if (cpf.equals(((Pessoa) obj).getCpf()))
			return true;
		else if (rg.equals(((Pessoa) obj).getRg()))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String buffer = new String();
		buffer += "Nome: " + nome + "\n";
		buffer += "RG: " + rg + "\n";
		buffer += "CPF: " + cpf + "\n";
		buffer += "Data de Nascimento: " + nascimento + "\n";
		buffer += "Gênero: " + genero.name() + "\n";
		return buffer;
	}
}
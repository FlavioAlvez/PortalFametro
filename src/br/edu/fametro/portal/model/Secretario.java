package br.edu.fametro.portal.model;

import java.util.Date;

public class Secretario extends Pessoa {
	private String matricula; // RegistroAcademico ex:2016123456
	private Usuario acesso;

	public Secretario(String nome, String rg, String cpf, Date nascimento, Genero genero) {
		super(nome, rg, cpf, nascimento, genero);
		// TODO Auto-generated constructor stub
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Usuario getAcesso() {
		return acesso;
	}

	public void setAcesso(Usuario acesso) {
		this.acesso = acesso;
	}
}

package br.edu.fametro.portal.model;

import java.util.Date;

public class Aluno extends Pessoa{
	private String filiacaoPai;
	private String filiacaoMae;
	private String matricula; //RegistroAcademico ex:2016123456
	private Usuario acesso;
	
	public Aluno(String nome, String rg, String cpf, Date nascimento, Genero genero) {
		super(nome, rg, cpf, nascimento, genero);
	}

	public String getFiliacaoPai() {
		return filiacaoPai;
	}

	public void setFiliacaoPai(String filiacaoPai) {
		this.filiacaoPai = filiacaoPai;
	}

	public String getFiliacaoMae() {
		return filiacaoMae;
	}

	public void setFiliacaoMae(String filiacaoMae) {
		this.filiacaoMae = filiacaoMae;
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
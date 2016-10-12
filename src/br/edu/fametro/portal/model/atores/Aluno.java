package br.edu.fametro.portal.model.atores;

import java.util.Date;

import br.edu.fametro.portal.model.enums.Genero;

public class Aluno extends Pessoa implements AcessaSistema{
	private String filiacaoPai;
	private String filiacaoMae;
	private String matricula; //RegistroAcademico ex:2016123456
	private String curso;
	private Usuario acesso;
	public Aluno(String nome, String rg, String cpf, Date nascimento, Genero genero, String curso) {
		super(nome, rg, cpf, nascimento, genero);
		this.curso = curso;
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Usuario getAcesso() {
		return acesso;
	}
	public void setAcesso(Usuario acesso) {
		this.acesso = acesso;
	}
}
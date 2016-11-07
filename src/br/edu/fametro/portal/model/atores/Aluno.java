package br.edu.fametro.portal.model.atores;

import java.util.Calendar;
import java.util.Date;

import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Genero;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Aluno extends Pessoa implements AcessaSistema {
	private String matricula;
	private Curso curso;
	private Endereco endereco;
	private String email;
	private Telefone residencial;
	private Telefone celular;
	private Telefone opcional;
	private Usuario usuario;
	
	public Aluno() {
		super();
	}
	
	public Aluno(long id, String nome, String rg, String cpf, Date nascimento, Genero genero, Curso curso) {
		super(nome, rg, cpf, nascimento, genero);
		this.curso = curso;
		matricula = Sistema.geraMatricula(TipoUsuario.ALUNO, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.ALUNO);
	}
	
	public Aluno(long id, String nome, String rg, String cpf, Date nascimento, Genero genero) {
		super(nome, rg, cpf, nascimento, genero);
		matricula = Sistema.geraMatricula(TipoUsuario.ALUNO, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.ALUNO);
	}

	public String getMatricula() {
		return matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getResidencial() {
		return residencial;
	}

	public void setResidencial(Telefone residencial) {
		this.residencial = residencial;
	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public Telefone getOpcional() {
		return opcional;
	}

	public void setOpcional(Telefone opcional) {
		this.opcional = opcional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void gerarMatriculaEUsuario(Long id) {
		this.matricula = Sistema.geraMatricula(TipoUsuario.ALUNO, Calendar.getInstance().getTime(), id);
		this.usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.ALUNO);
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Aluno))
			return false;
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", curso=" + curso + ", endereco=" + endereco + ", residencial="
				+ residencial + ", email=" + email + ", celular=" + celular + ", opcional=" + opcional + ", usuario="
				+ usuario + ", getUsuario()=" + getUsuario() + ", getMatricula()=" + getMatricula() + ", getEmail()="
				+ getEmail() + "]";
	}
}
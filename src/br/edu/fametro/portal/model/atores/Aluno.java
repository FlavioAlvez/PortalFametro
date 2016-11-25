package br.edu.fametro.portal.model.atores;

import java.util.Calendar;

import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Aluno extends Pessoa implements AcessaSistema {
	private long id;
	private String matricula;
	private Curso curso;
	private Endereco endereco;
	private String email;
	private Telefone residencial;
	private Telefone celular;
	private Telefone opcional;
	private Usuario usuario;

	public Aluno(long id) {
		this.id = id;
		matricula = Sistema.geraMatricula(TipoUsuario.ALUNO, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.ALUNO);
	}

	public long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", curso=" + curso + ", endereco=" + endereco + ", email=" + email
				+ ", residencial=" + residencial + ", celular=" + celular + ", opcional=" + opcional + ", usuario="
				+ usuario + "]";
	}
}
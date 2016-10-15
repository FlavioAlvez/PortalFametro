package br.edu.fametro.portal.model.atores;

import java.util.Calendar;
import java.util.Date;

import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.enums.Genero;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Aluno extends Pessoa implements AcessaSistema {
	private String matricula;
	private String curso;
	private Endereco endereco;
	private Telefone residencial;
	private Telefone celular;
	private Telefone opcional;
	private Usuario usuario;

	public Aluno(long id, String nome, String rg, String cpf, Date nascimento, Genero genero, String curso) {
		super(nome, rg, cpf, nascimento, genero);
		this.curso = curso;
		matricula = Sistema.geraMatricula(TipoUsuario.ALUNO, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.ALUNO);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getMatricula() {
		return matricula;
	}
}
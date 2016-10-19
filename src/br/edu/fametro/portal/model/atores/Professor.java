package br.edu.fametro.portal.model.atores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.Genero;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Professor extends Pessoa implements AcessaSistema {
	private String matricula;
	private Endereco endereco;
	private String email;
	private Telefone residencial;
	private Telefone celular;
	private Telefone opcional;
	private List<Disciplina> disciplinas;
	private boolean coordenador;
	private Usuario usuario;

	public Professor(long id, String nome, String rg, String cpf, Date nascimento, Genero genero, boolean coordenador) {
		super(nome, rg, cpf, nascimento, genero);
		this.disciplinas = new ArrayList<Disciplina>();
		this.coordenador = coordenador;
		matricula = Sistema.geraMatricula(TipoUsuario.PROFESSOR, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.PROFESSOR);
	}

	public Professor(long id, String nome, String rg, String cpf, Date nascimento, Genero genero,
			List<Disciplina> disciplinas, boolean coordenador) {
		super(nome, rg, cpf, nascimento, genero);
		this.disciplinas = disciplinas;
		this.coordenador = coordenador;
		matricula = Sistema.geraMatricula(TipoUsuario.PROFESSOR, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.PROFESSOR);
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void addDisciplina(Disciplina disciplina){
		disciplinas.add(disciplina);
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
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

package br.edu.fametro.portal.model.atores;

import java.util.Calendar;
import java.util.List;

import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Professor extends Pessoa implements AcessaSistema {
	private long id;
	private String matricula;
	private Endereco endereco;
	private String email;
	private Telefone residencial;
	private Telefone celular;
	private Telefone opcional;
	private List<Disciplina> disciplinas;
	private boolean coordenador;
	private Usuario usuario;

	public Professor(long id) {
		this.id = id;
		matricula = Sistema.geraMatricula(TipoUsuario.PROFESSOR, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.PROFESSOR);
	}

	public long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
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

	public boolean addDisciplina(Disciplina disciplina) {
		if (!disciplinas.contains(disciplina)) {
			return disciplinas.add(disciplina);
		}
		return false;
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

	@Override
	public String toString() {
		return super.toString() + "\nProfessor [id=" + id + ", matricula=" + matricula + ", endereco=" + endereco
				+ ", email=" + email + ", residencial=" + residencial + ", celular=" + celular + ", opcional="
				+ opcional + ", disciplinas=" + disciplinas + ", coordenador=" + coordenador + ", usuario=" + usuario
				+ "]";
	}
}
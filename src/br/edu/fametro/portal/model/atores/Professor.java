package br.edu.fametro.portal.model.atores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.fametro.portal.model.Disciplina;
import br.edu.fametro.portal.model.enums.Genero;

public class Professor extends Pessoa implements AcessaSistema {
	private List<Disciplina> disciplinas;
	private boolean coordenador;
	private String matricula; // RegistroAcademico ex:2016123456
	private Usuario acesso;

	public Professor(String nome, String rg, String cpf, Date nascimento, Genero genero, boolean coordenador) {
		super(nome, rg, cpf, nascimento, genero);
		this.disciplinas = new ArrayList<Disciplina>();
		this.coordenador = coordenador;
	}

	public Professor(String nome, String rg, String cpf, Date nascimento, Genero genero, List<Disciplina> disciplinas,
			boolean coordenador) {
		super(nome, rg, cpf, nascimento, genero);
		this.disciplinas = disciplinas;
		this.coordenador = coordenador;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
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

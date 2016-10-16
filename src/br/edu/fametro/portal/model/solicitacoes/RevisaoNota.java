package br.edu.fametro.portal.model.solicitacoes;

import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.enums.Avaliacao;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class RevisaoNota extends Solicitacao{
	private Professor professor;
	private Disciplina disciplina;
	private Avaliacao av;
	
	public RevisaoNota(int codigo, GrupoAtendimento grupoAtendimento, TipoAtendimento tipoAtendimento,
			AcessaSistema cliente, TipoUsuario tipo, String assunto, String solicitacao, Professor professor,
			Disciplina disciplina, Avaliacao av) {
		super(codigo, grupoAtendimento, tipoAtendimento, cliente, tipo, assunto, solicitacao);
		this.professor = professor;
		this.disciplina = disciplina;
		this.av = av;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Avaliacao getAv() {
		return av;
	}

	public void setAv(Avaliacao av) {
		this.av = av;
	}
}

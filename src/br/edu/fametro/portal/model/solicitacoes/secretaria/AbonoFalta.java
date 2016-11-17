package br.edu.fametro.portal.model.solicitacoes.secretaria;

import java.util.Date;

import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

public class AbonoFalta extends Solicitacao {
	private Professor professor;
	private Disciplina disciplina;
	private Date inicioAtestado;
	private Date fimAtestado;

	public AbonoFalta() {
		super();
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

	public Date getInicioAtestado() {
		return inicioAtestado;
	}

	public void setInicioAtestado(Date inicioAtestado) {
		this.inicioAtestado = inicioAtestado;
	}

	public Date getFimAtestado() {
		return fimAtestado;
	}

	public void setFimAtestado(Date fimAtestado) {
		this.fimAtestado = fimAtestado;
	}

	@Override
	public String toString() {
		return super.toString() + ", AbonoFalta [professor=" + professor + ", disciplina=" + disciplina
				+ ", inicioAtestado=" + inicioAtestado + ", fimAtestado=" + fimAtestado + "]";
	}
}
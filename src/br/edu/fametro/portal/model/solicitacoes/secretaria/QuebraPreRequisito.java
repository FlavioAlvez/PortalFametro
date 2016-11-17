package br.edu.fametro.portal.model.solicitacoes.secretaria;

import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

public class QuebraPreRequisito extends Solicitacao {
	private Disciplina disciplina;

	public QuebraPreRequisito() {
		super();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return super.toString() + ", QuebraPreRequisito [disciplina=" + disciplina + "]";
	}
}

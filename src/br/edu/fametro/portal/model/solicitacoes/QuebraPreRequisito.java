package br.edu.fametro.portal.model.solicitacoes;

import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class QuebraPreRequisito extends Solicitacao {
	private Disciplina disciplina;

	public QuebraPreRequisito(int codigo, GrupoAtendimento grupoAtendimento, TipoAtendimento tipoAtendimento,
			AcessaSistema cliente, TipoUsuario tipo, String assunto, String solicitacao, Disciplina disciplina) {
		super(codigo, grupoAtendimento, tipoAtendimento, cliente, tipo, assunto, solicitacao);
		this.disciplina = disciplina;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}

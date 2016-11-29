package br.edu.fametro.portal.model.solicitacoes.secretaria;

import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.enums.Avaliacao;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

public class RevisaoNota extends Solicitacao {
	private Professor professor;
	private Disciplina disciplina;
	private Avaliacao avaliacao;

	public RevisaoNota(long id) {
		super(id);
		setCodigo(Sistema.geraCodigoSolicitacao(GrupoAtendimento.SECRETARIA, TipoAtendimento.REVISAO_DE_NOTA, id));
		setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
		setTipoAtendimento(TipoAtendimento.REVISAO_DE_NOTA);
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

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return super.toString() + ", RevisaoNota [professor=" + professor + ", disciplina=" + disciplina
				+ ", avaliacao=" + avaliacao + "]";
	}
}

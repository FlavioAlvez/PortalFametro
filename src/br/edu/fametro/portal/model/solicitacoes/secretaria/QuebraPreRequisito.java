package br.edu.fametro.portal.model.solicitacoes.secretaria;

import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

public class QuebraPreRequisito extends Solicitacao {
	private Disciplina disciplina;

	public QuebraPreRequisito(long id) {
		super(id);
		setCodigo(Sistema.geraCodigoSolicitacao(GrupoAtendimento.SECRETARIA, TipoAtendimento.QUEBRA_DE_PRE_REQUISITO, id));
		setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
		setTipoAtendimento(TipoAtendimento.QUEBRA_DE_PRE_REQUISITO);
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

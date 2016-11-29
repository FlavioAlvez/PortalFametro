package br.edu.fametro.portal.model.solicitacoes.secretaria;

import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

public class Ouvidoria extends Solicitacao{
	public Ouvidoria(long id) {
		super(id);
		setCodigo(Sistema.geraCodigoSolicitacao(GrupoAtendimento.SECRETARIA, TipoAtendimento.OUVIDORIA, id));
		setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
		setTipoAtendimento(TipoAtendimento.OUVIDORIA);
	}

	public String toString() {
		return super.toString() + ", Ouvidoria []";
	}
}

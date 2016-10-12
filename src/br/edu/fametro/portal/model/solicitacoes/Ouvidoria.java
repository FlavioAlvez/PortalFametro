package br.edu.fametro.portal.model.solicitacoes;

import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Ouvidoria extends Solicitacao {

	public Ouvidoria(int codigo, GrupoAtendimento grupoAtendimento, TipoAtendimento tipoAtendimento,
			AcessaSistema cliente, TipoUsuario tipo, String assunto, String solicitacao) {
		super(codigo, grupoAtendimento, tipoAtendimento, cliente, tipo, assunto, solicitacao);
		// TODO Auto-generated constructor stub
	}
}

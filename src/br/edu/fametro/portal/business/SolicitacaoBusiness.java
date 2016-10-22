package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

public class SolicitacaoBusiness {
	private List<Solicitacao> banco;

	public SolicitacaoBusiness() {
		banco = new ArrayList<Solicitacao>();
	}

	public List<Solicitacao> getBanco() {
		return banco;
	}

	public int getSize() {
		return banco.size();
	}

	public boolean isEmpty() {
		if (this.banco == null || this.getSize() == 0)
			return true;
		else
			return false;
	}

	public boolean adicionar(Solicitacao nova) {
		if (!isEmpty()) {
			if (banco.contains(nova)) {
				return false;
			}
		}
		return banco.add(nova);
	}

	public Solicitacao pesquisaSolicitacao(Solicitacao s) {
		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.equals(s))
					return solicitacao;
			}
		}
		return null;
	}
	
	public List<Solicitacao> pesquisaCliente(AcessaSistema cliente){
		List<Solicitacao> result = new ArrayList<Solicitacao>();
		
		if (!isEmpty()) {
			for(Solicitacao solicitacao : banco){
				if(solicitacao.getCliente().equals(cliente))
					result.add(solicitacao);
			}
		}
		
		return result;
	}
}

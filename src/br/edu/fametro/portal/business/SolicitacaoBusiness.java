package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.fametro.portal.model.atores.AcessaSistema;
import br.edu.fametro.portal.model.enums.Avaliacao;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;
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

	public Solicitacao pesquisaCodigo(int codigo) {
		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getCodigo() == codigo)
					return solicitacao;
			}
		}
		return null;
	}

	public List<Solicitacao> pesquisaGrupoAtendimento(GrupoAtendimento grupoAtendimento) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getGrupoAtendimento().equals(grupoAtendimento))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaTipoAtendimento(TipoAtendimento tipoAtendimento) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getTipoAtendimento().equals(tipoAtendimento))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaTipoUsuario(TipoUsuario tipoUsuario) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getTipo().equals(tipoUsuario))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaDataAbertura(Date abertura) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getAbertura().equals(abertura))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaDataFechamento(Date fechamento) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getFechamento().equals(fechamento))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaAssunto(String assunto) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getAssunto().equals(assunto))
					result.add(solicitacao);
			}
		}

		return result;
	}


	public List<Solicitacao> pesquisaCliente(AcessaSistema cliente) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getCliente().equals(cliente))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaDisciplina(Disciplina disciplina) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getDisciplina().equals(disciplina))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public List<Solicitacao> pesquisaAvaliacao(Avaliacao avaliacao) {
		List<Solicitacao> result = new ArrayList<Solicitacao>();

		if (!isEmpty()) {
			for (Solicitacao solicitacao : banco) {
				if (solicitacao.getAv().equals(avaliacao))
					result.add(solicitacao);
			}
		}

		return result;
	}

	public boolean alterar(Solicitacao solicitacao) {
		if (!isEmpty()) {
			int index = banco.indexOf(solicitacao);

			if (index > -1) {
				banco.add(index, solicitacao);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Solicitacao s) {
		if (!isEmpty()) {
			if (banco.contains(s)) {
				return banco.remove(s);
			}
		}
		return false;
	}
}
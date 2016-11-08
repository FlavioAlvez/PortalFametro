package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.Avaliacao;

public class AvaliacaoBusiness {
	private List<Avaliacao> banco;

	public AvaliacaoBusiness() {
		banco = new ArrayList<Avaliacao>();
	}

	public List<Avaliacao> getBanco() {
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

	public boolean popularBanco() {
		if (isEmpty()) {
			Avaliacao lista[] = Avaliacao.values();
			for (Avaliacao g : lista) {
				banco.add(g);
			}
			return true;
		}
		return false;
	}

	public Avaliacao pesquisaName(String avaliacao) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(avaliacao))
					return banco.get(i);
			}
		}
		return null;
	}

	public Avaliacao pesquisaOrdinal(int avaliacao) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == avaliacao)
					return banco.get(i);
			}
		}
		return null;
	}
}
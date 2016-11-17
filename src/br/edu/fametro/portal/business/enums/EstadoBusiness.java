package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.Estado;

public class EstadoBusiness {
	private List<Estado> banco;

	public EstadoBusiness() {
		banco = new ArrayList<Estado>();
	}

	public List<Estado> getBanco() {
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
			Estado lista[] = Estado.values();
			for (Estado d : lista) {
				banco.add(d);
			}
			return true;
		}
		return false;
	}

	public Estado pesquisaName(String estado) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(estado))
					return banco.get(i);
			}
		}
		return null;
	}

	public Estado pesquisaOrdinal(int estado) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == estado)
					return banco.get(i);
			}
		}
		return null;
	}
	
	public List<Estado> pesquisaPais(String pais) {
		if (!isEmpty()) {
			List<Estado> result = new ArrayList<Estado>();
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getPais().equalsIgnoreCase(pais))
					result.add(banco.get(i));
			}
			return result;
		}
		return null;
	}

	public Estado pesquisaNome(String estado) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getNome().equalsIgnoreCase(estado))
					return banco.get(i);
			}
		}
		return null;
	}

	public Estado pesquisaAbreviacao(String estado) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getAbreviacao().equalsIgnoreCase(estado))
					return banco.get(i);
			}
		}
		return null;
	}
}
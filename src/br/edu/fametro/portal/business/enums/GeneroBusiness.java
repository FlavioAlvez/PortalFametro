package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.Genero;

public class GeneroBusiness {
	private List<Genero> banco;

	public GeneroBusiness() {
		banco = new ArrayList<Genero>();
	}

	public List<Genero> getBanco() {
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
			Genero lista[] = Genero.values();
			for (Genero g : lista) {
				banco.add(g);
			}
			return true;
		}
		return false;
	}

	public Genero pesquisaName(String genero) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(genero))
					return banco.get(i);
			}
		}
		return null;
	}

	public Genero pesquisaOrdinal(int genero) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == genero)
					return banco.get(i);
			}
		}
		return null;
	}
}
package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.Curso;

public class CursoBusiness {
	private List<Curso> banco;

	public CursoBusiness() {
		banco = new ArrayList<Curso>();
	}

	public List<Curso> getBanco() {
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
			Curso lista[] = Curso.values();
			for (Curso d : lista) {
				banco.add(d);
			}
			return true;
		}
		return false;
	}

	public Curso pesquisaName(String curso) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(curso))
					return banco.get(i);
			}
		}
		return null;
	}

	public Curso pesquisaOrdinal(int curso) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == curso)
					return banco.get(i);
			}
		}
		return null;
	}

	public Curso pesquisaNome(String curso) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getNome().equalsIgnoreCase(curso))
					return banco.get(i);
			}
		}
		return null;
	}

	public Curso pesquisaCodigo(String curso) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getCodigo().equalsIgnoreCase(curso))
					return banco.get(i);
			}
		}
		return null;
	}
}
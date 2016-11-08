package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.Disciplina;

public class DisciplinaBusiness {
	private List<Disciplina> banco;

	public DisciplinaBusiness() {
		banco = new ArrayList<Disciplina>();
	}

	public List<Disciplina> getBanco() {
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
			Disciplina lista[] = Disciplina.values();
			for (Disciplina d : lista) {
				banco.add(d);
			}
			return true;
		}
		return false;
	}

	public Disciplina pesquisaName(String disciplina) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(disciplina))
					return banco.get(i);
			}
		}
		return null;
	}

	public Disciplina pesquisaOrdinal(int disciplina) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == disciplina)
					return banco.get(i);
			}
		}
		return null;
	}

	public Disciplina pesquisaNome(String disciplina) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getNome().equalsIgnoreCase(disciplina))
					return banco.get(i);
			}
		}
		return null;
	}

	public Disciplina pesquisaCodigo(String disciplina) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getCodigo().equalsIgnoreCase(disciplina))
					return banco.get(i);
			}
		}
		return null;
	}
}
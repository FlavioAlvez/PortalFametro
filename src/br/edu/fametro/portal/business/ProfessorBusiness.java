package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.List;


import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.atores.Usuario;

public class ProfessorBusiness {
	private List<Professor> banco;
	
	public ProfessorBusiness() {
		banco = new ArrayList<Professor>();
	}

	public List<Professor> getBanco() {
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

	public boolean adicionar(Professor novo) {
		if (!isEmpty()) {
			if (banco.contains(novo)) {
				return false;
			}
		}
		return banco.add(novo);
	}

	public Professor pesquisaProfessor(Professor p) {
		if (!isEmpty()) {
			for (Professor professor : banco) {
				if (professor.equals(p)) {
					return professor;
				}
			}
		}
		return null;
	}

	public Professor pesquisaMatricula(String matricula) {
		if (!isEmpty()) {
			for (Professor professor : banco) {
				if (professor.getMatricula().equals(matricula)) {
					return professor;
				}
			}
		}
		return null;
	}

	public Professor pesquisaUsuario(Usuario u) {
		if (!isEmpty()) {
			for (Professor professor : banco) {
				if (professor.getUsuario().equals(u)) {
					if (professor.getUsuario().getSenha().equals(u.getSenha())) {
						return professor;
					}
					break;
				}
			}
		}
		return null;
	}

	public boolean alterar(Professor p) {
		if (!isEmpty()) {
			int index = banco.indexOf(p);

			if (index > -1) {
				banco.add(index, p);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Professor p) {
		if (!isEmpty()) {
			if (banco.contains(p)) {
				return banco.remove(p);
			}
		}
		return false;
	}
}

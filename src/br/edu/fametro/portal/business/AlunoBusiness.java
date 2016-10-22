package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.atores.Aluno;
import br.edu.fametro.portal.model.atores.Usuario;

public class AlunoBusiness {
	private List<Aluno> banco;

	public AlunoBusiness() {
		banco = new ArrayList<Aluno>();
	}

	public List<Aluno> getBanco() {
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

	public boolean adicionar(Aluno novo) {
		if (!isEmpty()) {
			if (banco.contains(novo)) {
				return false;
			}
		}
		return banco.add(novo);
	}

	public Aluno pesquisaAluno(Aluno a) {
		if (!isEmpty()) {
			for (Aluno aluno : banco) {
				if (aluno.equals(a)) {
					return aluno;
				}
			}
		}
		return null;
	}

	public Aluno pesquisaMatricula(String matricula) {
		if (!isEmpty()) {
			for (Aluno aluno : banco) {
				if (aluno.getMatricula().equals(matricula)) {
					return aluno;
				}
			}
		}
		return null;
	}

	public Aluno pesquisaUsuario(Usuario u) {
		if (!isEmpty()) {
			for (Aluno aluno : banco) {
				if (aluno.getUsuario().equals(u)) {
					if (aluno.getUsuario().getSenha().equals(u.getSenha())) {
						return aluno;
					}
					break;
				}
			}
		}
		return null;
	}

	public boolean alterar(Aluno a) {
		if (!isEmpty()) {
			int index = banco.indexOf(a);

			if (index > -1) {
				banco.add(index, a);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Aluno a) {
		if (!isEmpty()) {
			if (banco.contains(a)) {
				return banco.remove(a);
			}
		}
		return false;
	}
}
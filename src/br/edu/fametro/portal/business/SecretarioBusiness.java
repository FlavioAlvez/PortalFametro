package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.atores.Secretario;
import br.edu.fametro.portal.model.atores.Usuario;

public class SecretarioBusiness {
	private List<Secretario> banco;

	public SecretarioBusiness() {
		banco = new ArrayList<Secretario>();
	}

	public List<Secretario> getBanco() {
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

	public boolean adicionar(Secretario novo) {
		if (!isEmpty()) {
			if (banco.contains(novo)) {
				return false;
			}
		}
		return banco.add(novo);
	}

	public Secretario pesquisaSecretario(Secretario s) {
		if (!isEmpty()) {
			for (Secretario secretario : banco) {
				if (secretario.equals(s)) {
					return secretario;
				}
			}
		}
		return null;
	}

	public Secretario pesquisaMatricula(String matricula) {
		if (!isEmpty()) {
			for (Secretario secretario : banco) {
				if (secretario.getMatricula().equals(matricula)) {
					return secretario;
				}
			}
		}
		return null;
	}

	public Secretario pesquisaUsuario(Usuario u) {
		if (!isEmpty()) {
			for (Secretario secretario : banco) {
				if (secretario.getUsuario().equals(u)) {
					if (secretario.getUsuario().getSenha().equals(u.getSenha())) {
						return secretario;
					}
					break;
				}
			}
		}
		return null;
	}
	
	public boolean alterar(Secretario s) {
		if (!isEmpty()) {
			int index = banco.indexOf(s);

			if (index > -1) {
				banco.add(index, s);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Secretario s) {
		if (!isEmpty()) {
			if (banco.contains(s)) {
				return banco.remove(s);
			}
		}
		return false;
	}
}

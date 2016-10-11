package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.Secretario;
import br.edu.fametro.portal.model.Usuario;

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
	
	public boolean adicionar(Secretario novo) {
		return banco.add(novo);
	}

	public Secretario pesquisaUsuario(Usuario u) {
		if (this.banco != null && this.getSize() != 0) {
			for (int i = 0; i < getSize(); i++) {
				if (banco.get(i).getUsuario().equals(u)) {
					if (banco.get(i).getUsuario().getSenha().equals(u.getSenha())) {
						return banco.get(i);
					}
					break;
				}
			}
		}
		return null;
	}
}

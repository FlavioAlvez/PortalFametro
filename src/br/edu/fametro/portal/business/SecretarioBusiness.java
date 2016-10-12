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
		return banco.add(novo);
	}

	public Secretario pesquisaSecretario(Secretario s) {
		if (!isEmpty()) {
			for(Secretario temp: banco){
				if(temp.equals(s)){
					return temp;
				}
			}
		}
		return null;
	}
	
	

	public Secretario pesquisaUsuario(Usuario u) {
		if (!isEmpty()) {
			for (Secretario temp: banco) {
				if (temp.getUsuario().equals(u)) {
					if (temp.getUsuario().getSenha().equals(u.getSenha())) {
						return temp;
					}
					break;
				}
			}
		}
		return null;
	}
}

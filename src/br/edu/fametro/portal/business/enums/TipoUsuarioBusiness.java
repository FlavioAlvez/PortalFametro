package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.TipoUsuario;

public class TipoUsuarioBusiness {
	private List<TipoUsuario> banco;

	public TipoUsuarioBusiness() {
		banco = new ArrayList<TipoUsuario>();
	}

	public List<TipoUsuario> getBanco() {
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
			TipoUsuario lista[] = TipoUsuario.values();
			for (TipoUsuario d : lista) {
				banco.add(d);
			}
			return true;
		}
		return false;
	}

	public TipoUsuario pesquisaName(String tipoUsuario) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(tipoUsuario))
					return banco.get(i);
			}
		}
		return null;
	}

	public TipoUsuario pesquisaOrdinal(int tipoUsuario) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == tipoUsuario)
					return banco.get(i);
			}
		}
		return null;
	}

	public TipoUsuario pesquisaCodigo(int codigo) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getCodigo() == codigo)
					return banco.get(i);
			}
		}
		return null;
	}

	public TipoUsuario pesquisaNome(String nome) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getNome().equalsIgnoreCase(nome))
					return banco.get(i);
			}
		}
		return null;
	}
}
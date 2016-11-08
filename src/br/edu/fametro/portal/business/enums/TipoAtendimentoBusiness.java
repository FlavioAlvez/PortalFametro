package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;

public class TipoAtendimentoBusiness {
	private List<TipoAtendimento> banco;

	public TipoAtendimentoBusiness() {
		banco = new ArrayList<TipoAtendimento>();
	}

	public List<TipoAtendimento> getBanco() {
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
			TipoAtendimento lista[] = TipoAtendimento.values();
			for (TipoAtendimento d : lista) {
				banco.add(d);
			}
			return true;
		}
		return false;
	}

	public TipoAtendimento pesquisaName(String tipoAtendimento) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(tipoAtendimento))
					return banco.get(i);
			}
		}
		return null;
	}

	public TipoAtendimento pesquisaOrdinal(int tipoAtendimento) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == tipoAtendimento)
					return banco.get(i);
			}
		}
		return null;
	}

	public List<TipoAtendimento> pesquisaGrupo(GrupoAtendimento grupoAtendimento) {
		if (!isEmpty()) {
			List<TipoAtendimento> result = new ArrayList<TipoAtendimento>();
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getGrupo().getCodigo() == grupoAtendimento.getCodigo())
					result.add(banco.get(i));
			}
			return result;
		}
		return null;
	}

	public TipoAtendimento pesquisaCodigo(int codigo) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getCodigo() == codigo)
					return banco.get(i);
			}
		}
		return null;
	}

	public TipoAtendimento pesquisaTipo(String tipo) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getTipo().equalsIgnoreCase(tipo))
					return banco.get(i);
			}
		}
		return null;
	}
}
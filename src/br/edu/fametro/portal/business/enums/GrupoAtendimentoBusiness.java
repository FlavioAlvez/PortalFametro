package br.edu.fametro.portal.business.enums;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.GrupoAtendimento;

public class GrupoAtendimentoBusiness {
	private List<GrupoAtendimento> banco;

	public GrupoAtendimentoBusiness() {
		banco = new ArrayList<GrupoAtendimento>();
	}

	public List<GrupoAtendimento> getBanco() {
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
			GrupoAtendimento lista[] = GrupoAtendimento.values();
			for (GrupoAtendimento d : lista) {
				banco.add(d);
			}
			return true;
		}
		return false;
	}

	public GrupoAtendimento pesquisaName(String grupoAtendimento) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).name().equalsIgnoreCase(grupoAtendimento))
					return banco.get(i);
			}
		}
		return null;
	}

	public GrupoAtendimento pesquisaOrdinal(int grupoAtendimento) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).ordinal() == grupoAtendimento)
					return banco.get(i);
			}
		}
		return null;
	}

	public GrupoAtendimento pesquisaGrupo(String grupoAtendimento) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getGrupo().equalsIgnoreCase(grupoAtendimento))
					return banco.get(i);
			}
		}
		return null;
	}

	public GrupoAtendimento pesquisaCodigo(int grupoAtendimento) {
		if (!isEmpty()) {
			for (int i = 0; i < banco.size(); i++) {
				if (banco.get(i).getCodigo() == grupoAtendimento)
					return banco.get(i);
			}
		}
		return null;
	}
}

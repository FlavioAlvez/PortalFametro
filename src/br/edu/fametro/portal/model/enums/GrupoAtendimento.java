package br.edu.fametro.portal.model.enums;

public enum GrupoAtendimento {
	SECRETARIA(1, "Secretaria")/*, FINANCEIRO(2, "Financeiro"), RELACIONAMENTO(3, "Relacionamento")*/;
	
	public final int codigo;
	public final String grupo;

	private GrupoAtendimento(int codigo, String grupo) {
		this.codigo = codigo;
		this.grupo = grupo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getGrupo() {
		return grupo;
	}
}

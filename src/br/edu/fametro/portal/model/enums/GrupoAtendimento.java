package br.edu.fametro.portal.model.enums;

public enum GrupoAtendimento {
	SECRETARIA(2, "Secretaria");
	
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

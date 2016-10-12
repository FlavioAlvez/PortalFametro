package br.edu.fametro.portal.model.enums;

public enum TipoAtendimento {
	QUEBRA_DE_PRE_REQUISITO(51, "QUEBRA DE PRÉ-REQUISITO");

	public final int codigo;
	public final String tipo;

	TipoAtendimento(int codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}

package br.edu.fametro.portal.model.enums;

public enum TipoAtendimento {
	QUEBRA_DE_PRE_REQUISITO(1, "QUEBRA DE PRÉ-REQUISITO"), REVISAO_DE_NOTA(2, "REVISÃO DE AVALIAÇÃO"), ABONO_DE_FALTA(3, "ABONO DE FALTA"), OUVIDORIA(4, "OUVIDORIA");

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

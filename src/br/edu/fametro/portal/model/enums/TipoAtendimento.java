package br.edu.fametro.portal.model.enums;

public enum TipoAtendimento {
	QUEBRA_DE_PRE_REQUISITO(GrupoAtendimento.SECRETARIA, 1, "QUEBRA DE PRÉ-REQUISITO"), REVISAO_DE_NOTA(
			GrupoAtendimento.SECRETARIA, 2, "REVISÃO DE AVALIAÇÃO"), ABONO_DE_FALTA(GrupoAtendimento.SECRETARIA, 3,
					"ABONO DE FALTA"), OUVIDORIA(GrupoAtendimento.SECRETARIA, 4, "OUVIDORIA");

	private final GrupoAtendimento grupo;
	private final int codigo;
	private final String tipo;

	private TipoAtendimento(GrupoAtendimento grupo, int codigo, String tipo) {
		this.grupo = grupo;
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public GrupoAtendimento getGrupo() {
		return grupo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}

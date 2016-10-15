package br.edu.fametro.portal.model.enums;

public enum TipoUsuario {
	SECRETARIO(0), ALUNO(1), PROFESSOR(2);

	public final int codigo;

	private TipoUsuario(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
}

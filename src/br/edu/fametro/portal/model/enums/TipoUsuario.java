package br.edu.fametro.portal.model.enums;

public enum TipoUsuario {
	SECRETARIO(0, "Secretario"), ALUNO(1, "Aluno"), PROFESSOR(2, "Professor");

	private final int codigo;
	private final String nome;

	private TipoUsuario(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

}

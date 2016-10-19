package br.edu.fametro.portal.model.enums;

public enum Disciplina {
	DESENVOLVIMENTO_WEB("DESENVOLVIMENTO DE SISTEMAS PARA WEB", "1002.19"), MTC("METODOLOGIA DO TRABALHO CIENTÍFICO",
			"1002.01");

	private final String nome;
	private final String codigo;

	private Disciplina(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public static Disciplina search(String param) {
		for (Disciplina d : Disciplina.values()) {
			if (d.getCodigo().equalsIgnoreCase(param) || d.getNome().equalsIgnoreCase(param))
				return d;
		}
		return null;
	}
}

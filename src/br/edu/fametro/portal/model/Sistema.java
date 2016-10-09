package br.edu.fametro.portal.model;

public class Sistema {
	public static String geraMatricula() {
		// toDo
		return "2016123456";
	}

	public static Usuario geraPrimeiroAcesso(String matricula) {
		return new Usuario("1-" + matricula, "123456");
	}

	public static void geraPrimeiroAcesso(Aluno a) {

	}

	public static void geraPrimeiroAcesso(Professor p) {

	}

	public static void geraPrimeiroAcesso(Secretario s) {

	}
}

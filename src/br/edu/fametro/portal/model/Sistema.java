package br.edu.fametro.portal.model;

import br.edu.fametro.portal.model.atores.Usuario;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Sistema {
	public static String geraMatricula(TipoUsuario tipo) {
		int id;
		switch (tipo.name().toUpperCase()) {
		case "SECRETARIO":
			id = TipoUsuario.SECRETARIO.ordinal();
			break;
		case "ALUNO":
			id = TipoUsuario.ALUNO.ordinal();
			break;
		case "PROFESSOR":
			id = TipoUsuario.PROFESSOR.ordinal();
			break;
		default:
			id = -1;
			break;
		}
		return id + "-" + "2016123456";
	}

	public static Usuario geraPrimeiroAcesso(String matricula, TipoUsuario tipo) {
		return new Usuario(matricula, "123456");
	}
}

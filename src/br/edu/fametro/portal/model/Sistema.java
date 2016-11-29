package br.edu.fametro.portal.model;

import java.util.Date;

import br.edu.fametro.portal.model.atores.Usuario;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Sistema {
	public static String geraMatricula(TipoUsuario tipo, Date cadastro, long id) {
		int cdg;
		String id5 = String.valueOf(id);

		switch (tipo.name().toUpperCase()) {
		case "SECRETARIO":
			cdg = TipoUsuario.SECRETARIO.ordinal();
			break;
		case "ALUNO":
			cdg = TipoUsuario.ALUNO.ordinal();
			break;
		case "PROFESSOR":
			cdg = TipoUsuario.PROFESSOR.ordinal();
			break;
		default:
			cdg = -1;
			break;
		}

		while (id5.length() < 5) {
			id5 = "0".concat(id5);
		}

		return cdg + "-" + DateUtility.getAno(cadastro) + DateUtility.getSemestre(cadastro) + id5;
	}

	public static Usuario geraPrimeiroAcesso(String matricula, TipoUsuario tipo) {
		return new Usuario(matricula, "123456");
	}
	
	public static String geraCodigoSolicitacao(GrupoAtendimento ga, TipoAtendimento ta, long id){
		String cdg = new String();
		String id5 = String.valueOf(id);
	
		cdg = ga.getCodigo() + "-" + ta.getCodigo() + "-";
		
		while (id5.length() < 5) {
			id5 = "0".concat(id5);
		}
		
		cdg += id5;
		
		return cdg;
	}
}

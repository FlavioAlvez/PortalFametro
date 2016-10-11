package br.edu.fametro.portal.model;

import java.util.Date;

public class Secretario extends Pessoa implements AcessaSistema {
	private String matricula; // RegistroAcademico ex:2016123456
	private Usuario usuario;

	public Secretario(String nome, String rg, String cpf, Date nascimento, Genero genero) {
		super(nome, rg, cpf, nascimento, genero);
		matricula = Sistema.geraMatricula(TipoUsuario.SECRETARIO);
		System.out.print("PAS");
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.SECRETARIO);
		System.out.println("SOU");
	}

	public String getMatricula() {
		return matricula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario acesso) {
		this.usuario = acesso;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String buffer = new String();
		buffer += "Registro Acadêmico: " + matricula + "\n";
		buffer += super.toString();
		buffer += usuario + "\n";
		return buffer;
	}
}

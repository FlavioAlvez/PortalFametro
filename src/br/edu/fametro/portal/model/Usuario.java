package br.edu.fametro.portal.model;

public class Usuario{
	private String username; //"1-" + Matricula  Ex.: 1-2016123456 
	private String senha;

	public Usuario(String username, String senha) {
		super();
		this.username = username;
		this.senha = senha;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
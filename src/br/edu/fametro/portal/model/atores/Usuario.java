package br.edu.fametro.portal.model.atores;

import org.apache.commons.codec.digest.DigestUtils;

public class Usuario {
	private String username;
	private String senha;

	public Usuario(String username, String senha) {
		super();
		this.username = username;
		this.senha = encripta(senha);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = encripta(senha);
	}

	public String encripta(String param) {
		return DigestUtils.sha256Hex(param);
	}

	@Override
	public boolean equals(Object obj) {
		return username.equals(((Usuario) obj).getUsername());
	}

	@Override
	public String toString() {
		String buffer = new String();
		buffer += "Nome de usuário: " + username + "\n";
		buffer += "Senha: " + senha + "\n";
		return buffer;
	}
}
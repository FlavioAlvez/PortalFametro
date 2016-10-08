package br.edu.fametro.portal.model;

public class Telefone {
	private int ddd;
	private String numero; // 9dígitos

	public Telefone(int ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}

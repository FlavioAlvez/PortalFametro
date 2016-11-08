package br.edu.fametro.portal.model;

public class Telefone {
	private String ddd;
	private String numero; // 9dígitos

	public Telefone() {

	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public static Telefone maskToTelefone(String telefone) {
		// (99)99999-9999
		String ddd = telefone.substring(1, 3);
		String numero = telefone.substring(4, 9).concat(telefone.substring(10));

		Telefone tel = new Telefone();
		tel.setDdd(ddd);
		tel.setNumero(numero);

		return tel;
	}

	@Override
	public String toString() {
		return "(" + ddd + ")" + numero.substring(0, 5) + "-" + numero.substring(5);
	}
}
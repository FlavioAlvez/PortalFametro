package br.edu.fametro.portal.model;

public class Telefone {
	private String ddd;
	private String numero;

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

		String part1 = (telefone.substring(4)).split("-")[0];
		String part2 = (telefone.substring(4)).split("-")[1];
		String numero = part1.concat(part2);

		Telefone tel = new Telefone();
		tel.setDdd(ddd);
		tel.setNumero(numero);

		return tel;
	}

	@Override
	public String toString() {
		String part1 = numero.substring(0, numero.length() - 4);
		String part2 = numero.substring(numero.length() - 4);
		return "(" + ddd + ")" + part1 + "-" + part2;
	}
}
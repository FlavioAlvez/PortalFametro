package br.edu.fametro.portal.model;

public class Filiacao {
	private String pai;
	private String mae;

	public Filiacao() {

	}

	public Filiacao(String pai, String mae) {
		super();
		this.pai = pai;
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}
}

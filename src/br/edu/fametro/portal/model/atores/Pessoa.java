package br.edu.fametro.portal.model.atores;

import java.util.Date;

import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.enums.Genero;

public abstract class Pessoa {
	private String nome;
	private String rg;
	private String cpf;
	private Date nascimento;
	private Genero genero;
	private Filiacao filiacao;
	private String naturalidade;
	private String estadoNatal;

	public Pessoa() {

	}

	public String getNome() {
		return nome;
	}

	public String getPrimeiroNome() {
		return nome.split(" ")[0];
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Filiacao getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEstadoNatal() {
		return estadoNatal;
	}

	public void setEstadoNatal(String estadoNatal) {
		this.estadoNatal = estadoNatal;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", nascimento="
				+ DateUtility.DateToMask(nascimento) + ", genero=" + genero + ", filiacao=" + filiacao
				+ ", naturalidade=" + naturalidade + ", estadoNatal=" + estadoNatal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}

		Pessoa other = (Pessoa) obj;
		boolean cpfEquals = true;
		boolean rgEquals = true;

		if (cpf == null) {
			if (other.cpf != null) {
				cpfEquals = false;
			}
		} else if (!cpf.equals(other.cpf)) {
			cpfEquals = false;
		}

		if (rg == null) {
			if (other.rg != null) {
				rgEquals = false;
			}
		} else if (!rg.equals(other.rg)) {
			rgEquals = false;
		}

		return (cpfEquals || rgEquals);
	}
}
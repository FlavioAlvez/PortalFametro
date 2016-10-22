package br.edu.fametro.portal.model.atores;

import java.util.Calendar;
import java.util.Date;

import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Sistema;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.enums.Genero;
import br.edu.fametro.portal.model.enums.TipoUsuario;

public class Secretario extends Pessoa implements AcessaSistema {
	private String matricula;
	private Endereco endereco;
	private Telefone residencial;
	private Telefone celular;
	private Telefone opcional;
	private Usuario usuario;

	public Secretario(long id, String nome, String rg, String cpf, Date nascimento, Genero genero) {
		super(nome, rg, cpf, nascimento, genero);
		matricula = Sistema.geraMatricula(TipoUsuario.SECRETARIO, Calendar.getInstance().getTime(), id);
		usuario = Sistema.geraPrimeiroAcesso(matricula, TipoUsuario.SECRETARIO);
	}

	public String getMatricula() {
		return matricula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getResidencial() {
		return residencial;
	}

	public void setResidencial(Telefone residencial) {
		this.residencial = residencial;
	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public Telefone getOpcional() {
		return opcional;
	}

	public void setOpcional(Telefone opcional) {
		this.opcional = opcional;
	}

	public void setUsuario(Usuario acesso) {
		this.usuario = acesso;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Secretario))
			return false;
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

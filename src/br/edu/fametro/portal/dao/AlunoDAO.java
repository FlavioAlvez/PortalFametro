package br.edu.fametro.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.jdbc.PostgreConnector;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.atores.Aluno;

public class AlunoDAO {

	private Connection con = PostgreConnector.getConnection();

	public boolean cadastrar(Aluno aluno) {

		String sql = "INSERT  INTO aluno(matricula, senha, nome,genero,cpf,rg,nascimento,naturalidade,estadonatal,pai,mae,cep,logradouro,complemento,numero,bairro,cidade,estado,pais,email,residencial,celular,opcional,curso)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, aluno.getMatricula());
			stm.setString(2, aluno.getUsuario().getSenha());
			stm.setString(3, aluno.getNome());
			stm.setString(4, aluno.getGenero().name());
			stm.setString(5, aluno.getCpf());
			stm.setString(6, aluno.getRg());
			stm.setString(7, DateUtility.DateToMask(aluno.getNascimento()));
			stm.setString(8, aluno.getNaturalidade());
			stm.setString(9, aluno.getEstadoNatal());
			stm.setString(10, aluno.getFiliacao().getPai());
			stm.setString(11, aluno.getFiliacao().getMae());
			stm.setString(12, aluno.getEndereco().getCep());
			stm.setString(13, aluno.getEndereco().getLogradouro());
			stm.setString(14, aluno.getEndereco().getComplemento());
			stm.setString(15, String.valueOf(aluno.getEndereco().getNumero()));
			stm.setString(16, aluno.getEndereco().getBairro());
			stm.setString(17, aluno.getEndereco().getCidade());
			stm.setString(18, aluno.getEndereco().getEstado());
			stm.setString(19, aluno.getEndereco().getPais());
			stm.setString(20, aluno.getEmail());
			stm.setString(21, aluno.getResidencial().toString());
			stm.setString(22, aluno.getCelular().toString());
			stm.setString(23, aluno.getOpcional().toString());
			stm.setString(24, aluno.getCurso().getCodigo());

			stm.execute();
			stm.close();

			System.out.println("Cadastrado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	// Atualizar aluno
	public boolean alterarPerfil(Aluno aluno) {

		String sql = "UPDATE aluno SET cep = ?,logradouro = ?,complemento = ?,numero = ?,bairro = ?,cidade = ?,estado = ?,pais = ?,email = ?,"
				+ "residencial = ?,celular = ?,opcional = ? where matricula = ?";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, aluno.getEndereco().getCep());
			stm.setString(2, aluno.getEndereco().getLogradouro());
			stm.setString(3, aluno.getEndereco().getComplemento());
			stm.setString(4, String.valueOf(aluno.getEndereco().getNumero()));
			stm.setString(5, aluno.getEndereco().getBairro());
			stm.setString(6, aluno.getEndereco().getCidade());
			stm.setString(7, aluno.getEndereco().getEstado());
			stm.setString(8, aluno.getEndereco().getPais());
			stm.setString(9, aluno.getEmail());
			stm.setString(10, aluno.getResidencial().toString());
			stm.setString(11, aluno.getCelular().toString());
			stm.setString(12, aluno.getOpcional().toString());
			stm.setString(13, aluno.getMatricula());

			stm.execute();
			stm.close();

			System.out.println("Alterado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean alterarSenha(Aluno aluno) {
		String sql = "UPDATE aluno SET senha = ? where matricula = ?";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, aluno.getUsuario().getSenha());
			stm.setString(2, aluno.getMatricula());

			stm.execute();
			stm.close();

			System.out.println("Alterado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	// deletar aluno
	public boolean deletar(Aluno aluno) {

		String sql = "DELETE FROM  aluno where matricula = ?";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, aluno.getMatricula());

			stm.execute();
			stm.close();

			System.out.println("Deletado com sucesso!");
			return true;
		} catch (SQLException e) {
			System.out.println("Erro" + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	// select
	public List<Aluno> selecionar(String field, String value) {
		String sql = "SELECT * FROM ALUNO where " + field + " = ?";
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, value);

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String matricula = rs.getString("matricula");
				// COMPLETA com o resto dos campos

				Aluno a = new Aluno(id);
				a.setMatricula(matricula);
				// AQUI QLQR COISA EU COMPLETO

				lista.add(a);
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<Aluno> listar() {
		String sql = "SELECT * FROM ALUNO";
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String matricula = rs.getString("matricula");
				// COMPLETA com o resto dos campos

				Aluno a = new Aluno(id);
				a.setMatricula(matricula);
				// AQUI QLQR COISA EU COMPLETO

				lista.add(a);
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
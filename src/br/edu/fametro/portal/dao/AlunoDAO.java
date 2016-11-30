package br.edu.fametro.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.fametro.portal.business.enums.CursoBusiness;
import br.edu.fametro.portal.business.enums.GeneroBusiness;
import br.edu.fametro.portal.jdbc.PostgreConnector;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Aluno;
import br.edu.fametro.portal.model.atores.Usuario;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Genero;

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
	public boolean alterar(Aluno aluno) {

		String sql = "UPDATE aluno "
				+ "SET matricula = ?,senha = ?,nome = ?,genero = ?,cpf = ?,rg = ?,nascimento = ?,naturalidade = ?,estadonatal = ?,pai = ?,mae = ?,cep = ?,logradouro = ?,complemento = ?,numero = ?,bairro = ?,cidade = ?,estado = ?,pais = ?,email = ?,residencial = ?,celular = ?,opcional = ?,curso = ? "
				+ "WHERE cpf = ?";

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
			stm.setString(25, aluno.getCpf());

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
	public List<Aluno> listar() {
		String sql = "SELECT * FROM ALUNO";
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String matricula = rs.getString("matricula");
				String senha = rs.getString("senha");
				String nome = rs.getString("nome");
				String genero = rs.getString("genero");
				String cpf = rs.getString("cpf");
				String rg = rs.getString("rg");
				String nascimento = rs.getString("nascimento");
				String naturalidade = rs.getString("naturalidade");
				String estadoNatal = rs.getString("estadonatal");
				String pai = rs.getString("pai");
				String mae = rs.getString("mae");
				String cep = rs.getString("cep");
				String logradouro = rs.getString("logradouro");
				String complemento = rs.getString("complemento");
				String numero = rs.getString("numero");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String pais = rs.getString("pais");
				String email = rs.getString("email");
				String residencial = rs.getString("residencial");
				String celular = rs.getString("celular");
				String opcional = rs.getString("opcional");
				String curso = rs.getString("curso");

				Aluno aluno = new Aluno(id);
				aluno.setMatricula(matricula);
				{
					Usuario u = new Usuario(matricula, "");
					u.setSenhaEncryptada(senha);
					
					aluno.setUsuario(u);
				}
				aluno.setNome(nome);
				aluno.setRg(rg);
				aluno.setCpf(cpf);

				{
					GeneroBusiness bancoGenero = new GeneroBusiness();
					bancoGenero.popularBanco();
					Genero genero_aux = bancoGenero.pesquisaName(genero);

					aluno.setGenero(genero_aux);
				}
				{
					Date dtNascimento = DateUtility.maskToDate(nascimento);

					aluno.setNascimento(dtNascimento);
				}

				aluno.setNaturalidade(naturalidade);
				aluno.setEstadoNatal(estadoNatal);

				{
					Filiacao filiacao = new Filiacao();
					filiacao.setPai(pai);
					filiacao.setMae(mae);
					aluno.setFiliacao(filiacao);
				}

				{
					Endereco endereco = new Endereco();
					endereco.setCep(cep);
					endereco.setLogradouro(logradouro);
					endereco.setComplemento(complemento);
					endereco.setNumero(Integer.parseInt(numero));
					endereco.setBairro(bairro);
					endereco.setEstado(estado);
					endereco.setCidade(cidade);
					endereco.setPais(pais);
					aluno.setEndereco(endereco);
				}

				// Criar objeto - Contato
				aluno.setEmail(email);
				aluno.setResidencial(Telefone.maskToTelefone(residencial));
				aluno.setCelular(Telefone.maskToTelefone(celular));
				aluno.setOpcional(Telefone.maskToTelefone(opcional));

				// Criar objeto - Educacional
				{
					CursoBusiness bancoCurso = new CursoBusiness();
					bancoCurso.popularBanco();
					Curso c = bancoCurso.pesquisaCodigo(curso);
					aluno.setCurso(c);
				}

				lista.add(aluno);
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
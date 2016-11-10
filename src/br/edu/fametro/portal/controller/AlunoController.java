package br.edu.fametro.portal.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fametro.portal.business.AlunoBusiness;
import br.edu.fametro.portal.business.enums.CursoBusiness;
import br.edu.fametro.portal.business.enums.GeneroBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Aluno;
import br.edu.fametro.portal.model.atores.Usuario;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Genero;

/**
 * Servlet implementation class AlunoController
 */
@WebServlet("/AlunoController.do")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");

			switch (action.toLowerCase()) {
			case "cadastrar":
				cadastro(request, response);
				break;
			case "alterar perfil":
				alterarPerfil(request, response);
				break;
			case "alterar senha":
				alterarSenha(request, response);
				break;
			default:
				System.err.println("[AlunoController] action entrou no default!");
				System.err.println("[AlunoController] action = "
						+ (action == null ? "null" : action));
				response.sendRedirect("LoginController.do");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("LoginController.do");
		}
	}

	private void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Identifica��o
		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String genero = request.getParameter("genero");
		String nascimento = request.getParameter("nascimento");
		String naturalidade = request.getParameter("naturalidade");
		String estadoNatal = request.getParameter("estado-natal");

		// Filia��o
		String pai = request.getParameter("pai");
		String mae = request.getParameter("mae");

		// Endere�o
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("rua");
		String complemento = request.getParameter("complemento");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");

		// Contato
		String email = request.getParameter("email");
		String residencial = request.getParameter("fone-residencial"); // (12)12345-6789
		String celular = request.getParameter("fone-celular");
		String opcional = request.getParameter("fone-3");

		// Educacional
		String curso = request.getParameter("curso");

		// TESTE
		System.out.println("----- IDENTIFICA��O -----");
		System.out.println("Nome: " + nome);
		System.out.println("RG: " + rg);
		System.out.println("CPF: " + cpf);
		System.out.println("Genero: " + genero);
		System.out.println("Data de Nascimento: " + nascimento);
		System.out.println("Naturalidade: " + naturalidade);
		System.out.println("Estado Natal: " + estadoNatal);
		System.out.println();
		System.out.println("------- FILIA��O --------");
		System.out.println("Nome do Pai: " + pai);
		System.out.println("Nome da M�e: " + mae);
		System.out.println();
		System.out.println("------- ENDERE�O --------");
		System.out.println("CEP: " + cep);
		System.out.println("Logradouro: " + logradouro);
		System.out.println("Complemento: " + complemento);
		System.out.println("Numero: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Estado: " + estado);
		System.out.println("Cidade: " + cidade);
		System.out.println("Pa�s: " + pais);
		System.out.println();
		System.out.println("-------- CONTATO --------");
		System.out.println("Email: " + email);
		System.out.println("Telefone Residencial: " + residencial);
		System.out.println("Telefone Celular: " + celular);
		System.out.println("Telefone 3: " + opcional);
		System.out.println();
		System.out.println("------ EDUCACIONAL ------");
		System.out.println("Curso: " + curso);
		System.out.println();

		// Criando uma c�pia local do banco
		AlunoBusiness bancoAluno = (AlunoBusiness) request.getServletContext().getAttribute("bancoAluno");

		// Criar objeto
		Aluno aluno = new Aluno(bancoAluno.getSize());

		aluno.setNome(nome);
		aluno.setRg(rg);
		aluno.setCpf(cpf);

		{
			GeneroBusiness bancoGenero = (GeneroBusiness) request.getServletContext().getAttribute("bancoGenero");
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
			CursoBusiness bancoCurso = (CursoBusiness) request.getServletContext().getAttribute("bancoCurso");
			Curso c = bancoCurso.pesquisaCodigo(curso);
			aluno.setCurso(c);
		}
		
		// Adicionando ao banco local
		boolean adicionado = bancoAluno.adicionar(aluno);

		if (adicionado) {
			// Colocando o banco local de volta ao escopo da aplica��o
			request.getServletContext().setAttribute("bancoAluno", bancoAluno);
			request.setAttribute("usuario", aluno);
			request.setAttribute("sucesso", Boolean.TRUE);

			request.getRequestDispatcher("cadastrar-usuario.jsp?tipo=Aluno").forward(request, response);
		} else {
			request.setAttribute("usuario", aluno);
			request.setAttribute("erro", Boolean.TRUE);

			request.getRequestDispatcher("cadastrar-usuario.jsp?tipo=Aluno").forward(request, response);
		}

	}

	private void alterarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Identifica��o
		String matricula = request.getParameter("registro");
		String nome = request.getParameter("nome");
		String nascimento = request.getParameter("data-nascimento");
		String naturalidade = request.getParameter("naturalidade");
		String estadoNatal = request.getParameter("estado-natal");

		// Endereço
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String complemento = request.getParameter("complemento");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");

		// Contato
		String email = request.getParameter("email");
		String residencial = request.getParameter("fone-residencial"); // (12)12345-6789
		String celular = request.getParameter("fone-celular");
		String opcional = request.getParameter("fone-3");

		// TESTE
		System.out.println("----- IDENTIFICA��O -----");
		System.out.println("Registro Acad�mico: " + matricula);
		System.out.println("Nome: " + nome);
		System.out.println("Data de Nascimento: " + nascimento);
		System.out.println("Naturalidade: " + naturalidade);
		System.out.println("Estado Natal: " + estadoNatal);
		System.out.println();
		System.out.println("------- ENDERE�O --------");
		System.out.println("CEP: " + cep);
		System.out.println("Logradouro: " + logradouro);
		System.out.println("Complemento: " + complemento);
		System.out.println("Numero: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Estado: " + estado);
		System.out.println("Cidade: " + cidade);
		System.out.println("Pa�s: " + pais);
		System.out.println();
		System.out.println("-------- CONTATO --------");
		System.out.println("Email: " + email);
		System.out.println("Telefone Residencial: " + residencial);
		System.out.println("Telefone Celular: " + celular);
		System.out.println("Telefone 3: " + opcional);
		System.out.println();

		AlunoBusiness bancoAluno = (AlunoBusiness) request.getServletContext().getAttribute("bancoAluno");

		// Objeto � ser alterado
		Aluno aluno = (Aluno) request.getSession().getAttribute("usuarioLogado");

		// Alterar os dados no objeto local
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

		aluno.setEmail(email);
		aluno.setResidencial(Telefone.maskToTelefone(residencial));
		aluno.setCelular(Telefone.maskToTelefone(celular));
		aluno.setOpcional(Telefone.maskToTelefone(opcional));

		// Alterando o objeto no banco local
		boolean alterado = bancoAluno.alterar(aluno);

		if (alterado) {
			// Colocando o banco de volta ao escopo da aplica��o
			request.getServletContext().setAttribute("bancoAluno", bancoAluno);
			request.getSession().setAttribute("usuarioLogado", aluno);
			request.setAttribute("sucesso", Boolean.TRUE);
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", Boolean.TRUE);
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		}

	}

	public void alterarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Identifica��o
		String matricula = request.getParameter("registro");
//		String nome = request.getParameter("nome");
//		String nascimento = request.getParameter("data-nascimento");
//		String naturalidade = request.getParameter("naturalidade");
//		String estadoNatal = request.getParameter("estado-natal");

		// Seguran�a
		String senhaAtual = request.getParameter("senha-atual");
		String novaSenha = request.getParameter("nova-senha");
		String confirmarNovaSenha = request.getParameter("confirmar-senha");

		// Resgatando o banco
		AlunoBusiness bancoAluno = (AlunoBusiness) request.getServletContext().getAttribute("bancoAluno");

		// Objeto � ser alterado
		Aluno aluno = (Aluno) request.getSession().getAttribute("usuarioLogado");

		// Criar Usuario com dados passados na senhaAtual
		Usuario usuarioAtual = new Usuario(matricula, senhaAtual);

		// Conferindo senha atual
		boolean validado = false;

		if (aluno.getUsuario().getSenha().equals(usuarioAtual.getSenha())) {
			// Conferir se senhas novas s�o iguais
			if (novaSenha.equals(confirmarNovaSenha)) {
				validado = true;
			}
		}

		if (validado) {
			// Alterando o objeto
			Usuario buffer = aluno.getUsuario();
			buffer.setSenha(senhaAtual);
			aluno.setUsuario(buffer);

			// Alterando o objeto no banco local
			boolean alterado = bancoAluno.alterar(aluno);

			if (alterado) {
				// Colocando o banco de volta ao escopo da aplica��o
				request.getServletContext().setAttribute("bancoAluno", bancoAluno);
				request.getSession().setAttribute("usuarioLogado", aluno);
				request.setAttribute("sucesso", Boolean.TRUE);
				request.getRequestDispatcher("alterar-senha.jsp").forward(request, response);
			} else {
				request.setAttribute("erro", Boolean.TRUE);
				request.getRequestDispatcher("alterar-senha.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("erro", Boolean.TRUE);
			request.getRequestDispatcher("alterar-senha.jsp").forward(request, response);
		}
	}
}
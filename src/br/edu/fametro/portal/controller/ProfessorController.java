package br.edu.fametro.portal.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fametro.portal.business.ProfessorBusiness;
import br.edu.fametro.portal.business.enums.DisciplinaBusiness;
import br.edu.fametro.portal.business.enums.GeneroBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.atores.Usuario;
import br.edu.fametro.portal.model.enums.Genero;

/**
 * Servlet implementation class ProfessorController
 */
@WebServlet("/ProfessorController.do")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfessorController() {
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
				System.err.println("[ProfessorController] action entrou no default!");
				System.err.println("[ProfessorController] action = " + (action == null ? "null" : action));
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
		// Identificação
		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String genero = request.getParameter("genero");
		String nascimento = request.getParameter("nascimento");
		String naturalidade = request.getParameter("naturalidade");
		String estadoNatal = request.getParameter("estado-natal");

		// Filiação
		String pai = request.getParameter("pai");
		String mae = request.getParameter("mae");

		// Endereço
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
		String disciplinas[] = request.getParameterValues("disciplina");
		String coordenador = request.getParameter("coordenador"); // null ou on

		// TESTE
		System.out.println("----- IDENTIFICAÇÃO -----");
		System.out.println("Nome: " + nome);
		System.out.println("RG: " + rg);
		System.out.println("CPF: " + cpf);
		System.out.println("Genero: " + genero);
		System.out.println("Data de Nascimento: " + nascimento);
		System.out.println("Naturalidade: " + naturalidade);
		System.out.println("Estado Natal: " + estadoNatal);
		System.out.println();
		System.out.println("------- FILIAÇÃO --------");
		System.out.println("Nome do Pai: " + pai);
		System.out.println("Nome da Mãe: " + mae);
		System.out.println();
		System.out.println("------- ENDEREçO --------");
		System.out.println("CEP: " + cep);
		System.out.println("Logradouro: " + logradouro);
		System.out.println("Complemento: " + complemento);
		System.out.println("Numero: " + numero);
		System.out.println("Bairro: " + bairro);
		System.out.println("Estado: " + estado);
		System.out.println("Cidade: " + cidade);
		System.out.println("País: " + pais);
		System.out.println();
		System.out.println("-------- CONTATO --------");
		System.out.println("Email: " + email);
		System.out.println("Telefone Residencial: " + residencial);
		System.out.println("Telefone Celular: " + celular);
		System.out.println("Telefone 3: " + opcional);
		System.out.println();
		System.out.println("------ EDUCACIONAL ------");
		for (int i = 0; i < disciplinas.length; i++)
			System.out.println("Disciplinas: " + disciplinas[i]);
		System.out.println("É coordenador: " + (coordenador.equals("on") ? "Sim" : "Não"));
		System.out.println();

		// Resgatando o banco
		ProfessorBusiness bancoProfessor = (ProfessorBusiness) request.getServletContext()
				.getAttribute("bancoProfessor");

		// Criar objeto - Instanciando
		Professor professor = new Professor(bancoProfessor.getSize());
		// Criar objeto - Identificação
		professor.setNome(nome);
		professor.setRg(rg);
		professor.setCpf(cpf);
		{
			GeneroBusiness bancoGenero = (GeneroBusiness) request.getServletContext().getAttribute("bancoGenero");
			Genero genero_aux = bancoGenero.pesquisaName(genero);

			professor.setGenero(genero_aux);
		}
		{
			Date dtNascimento = DateUtility.maskToDate(nascimento);

			professor.setNascimento(dtNascimento);
		}
		professor.setNaturalidade(naturalidade);
		professor.setEstadoNatal(estadoNatal);
		// Criar objeto - Filiação
		{
			Filiacao filiacao = new Filiacao();
			filiacao.setPai(pai);
			filiacao.setMae(mae);
			professor.setFiliacao(filiacao);
		}
		// Criar objeto - Endereço
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

			professor.setEndereco(endereco);
		}
		// Criar objeto - Contato
		professor.setEmail(email);
		professor.setResidencial(Telefone.maskToTelefone(residencial));
		professor.setCelular(Telefone.maskToTelefone(celular));
		professor.setOpcional(Telefone.maskToTelefone(opcional));
		// Criar objeto - Educacional
		{
			DisciplinaBusiness bancoDisciplina = (DisciplinaBusiness) request.getServletContext()
					.getAttribute("bancoDisciplina");
			for (int i = 0; i < disciplinas.length; i++) {
				professor.addDisciplina(bancoDisciplina.pesquisaCodigo(disciplinas[i]));
			}
		}
		professor.setCoordenador(coordenador != null ? Boolean.TRUE : Boolean.FALSE);

		// Adicionando o objeto ao banco
		boolean adicionado = bancoProfessor.adicionar(professor);

		if (adicionado) {
			// Colocando o banco de volta ao escopo da aplicação
			request.getServletContext().setAttribute("bancoProfessor", bancoProfessor);
			request.setAttribute("usuario", professor);
			request.setAttribute("sucesso", Boolean.TRUE);

			request.getRequestDispatcher("cadastrar-usuario.jsp?tipo=Professor").forward(request, response);
		} else {
			request.setAttribute("usuario", professor);
			request.setAttribute("erro", Boolean.TRUE);

			request.getRequestDispatcher("cadastrar-usuario.jsp?tipo=Professor").forward(request, response);
		}
	}

	public void alterarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Identificação
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
		System.out.println("----- IDENTIFICAÇÃO -----");
		System.out.println("Registro Acadêmico: " + matricula);
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

		// Resgatando o banco
		ProfessorBusiness bancoProfessor = (ProfessorBusiness) request.getServletContext()
				.getAttribute("bancoProfessor");

		// Objeto � ser alterado
		Professor professor = (Professor) request.getSession().getAttribute("usuarioLogado");

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

			professor.setEndereco(endereco);
		}
		professor.setEmail(email);
		professor.setResidencial(Telefone.maskToTelefone(residencial));
		professor.setCelular(Telefone.maskToTelefone(celular));
		professor.setOpcional(Telefone.maskToTelefone(opcional));

		// Alterando o objeto no banco local
		boolean alterado = bancoProfessor.alterar(professor);

		if (alterado) {
			// Colocando o banco de volta ao escopo da aplicação
			request.getServletContext().setAttribute("bancoProfessor", bancoProfessor);
			request.getSession().setAttribute("usuarioLogado", professor);
			request.setAttribute("sucesso", Boolean.TRUE);
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		} else {
			request.setAttribute("erro", Boolean.TRUE);
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		}
	}

	public void alterarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Identificação
		String matricula = request.getParameter("registro");
		// String nome = request.getParameter("nome");
		// String nascimento = request.getParameter("data-nascimento");
		// String naturalidade = request.getParameter("naturalidade");
		// String estadoNatal = request.getParameter("estado-natal");

		// Seguran�a
		String senhaAtual = request.getParameter("senha-atual");
		String novaSenha = request.getParameter("nova-senha");
		String confirmarNovaSenha = request.getParameter("confirmar-senha");

		// Resgatando o banco
		ProfessorBusiness bancoProfessor = (ProfessorBusiness) request.getServletContext()
				.getAttribute("bancoProfessor");

		// Objeto � ser alterado
		Professor professor = (Professor) request.getSession().getAttribute("usuarioLogado");

		// Criar Usuario com dados passados na senhaAtual
		Usuario usuarioAtual = new Usuario(matricula, senhaAtual);

		// Conferindo senha atual
		boolean validado = false;

		if (professor.getUsuario().getSenha().equals(usuarioAtual.getSenha())) {
			// Conferir se senhas novas s�o iguais
			if (novaSenha.equals(confirmarNovaSenha)) {
				validado = true;
			}
		}

		if (validado) {
			// Alterando o objeto
			Usuario buffer = professor.getUsuario();
			buffer.setSenha(senhaAtual);
			professor.setUsuario(buffer);

			// Alterando o objeto no banco local
			boolean alterado = bancoProfessor.alterar(professor);

			if (alterado) {
				// Colocando o banco de volta ao escopo da aplicação
				request.getServletContext().setAttribute("bancoProfessor", bancoProfessor);
				request.getSession().setAttribute("usuarioLogado", professor);
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
package br.edu.fametro.portal.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> upstream/master

import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.business.enums.GeneroBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;

import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Secretario;
import br.edu.fametro.portal.model.enums.Genero;

/**
 * Servlet implementation class SecretarioController
 */
@WebServlet("/SecretarioController.do")
public class SecretarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecretarioController() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Qual método sera escolhido na tela de cadastro do secretário
		try {
			String action = request.getParameter("action");

			switch (action.toLowerCase()) {
			case "cadastrar":
				cadastrarSecretario(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("LoginController.do");
		}

	}

	private void cadastrarSecretario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Dados da Identificacao
		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String genero = request.getParameter("genero");
		String nascimento = request.getParameter("nascimento");
		String naturalidade = request.getParameter("naturalidade");
		String estadoNatal = request.getParameter("estado-natal");

		// Filiacao
		String pai = request.getParameter("pai");
		String mae = request.getParameter("mae");

		// Endereco
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("rua");
		String complemento = request.getParameter("complemento");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("uf");
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");

		// Contato
		String email = request.getParameter("email");
		String foneResidencia = request.getParameter("fone-residencial");
		String foneCelular = request.getParameter("fone-celular");
		String foneOpcional = request.getParameter("fone-3");

		// TESTE
		System.out.println("----- IDENTIFICAO -----");
		System.out.println("Nome: " + nome);
		System.out.println("RG: " + rg);
		System.out.println("CPF: " + cpf);
		System.out.println("Genero: " + genero);
		System.out.println("Data de Nascimento: " + nascimento);
		System.out.println("Naturalidade: " + naturalidade);
		System.out.println("Estado Natal: " + estadoNatal);
		System.out.println();
		System.out.println("------- FILIAÇAO --------");
		System.out.println("Nome do Pai: " + pai);
		System.out.println("Nome da Mae: " + mae);
		System.out.println();
		System.out.println("------- ENDEREÇO --------");
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
		System.out.println("Telefone Residencial: " + foneResidencia);
		System.out.println("Telefone Celular: " + foneCelular);
		System.out.println("Telefone 3: " + foneOpcional);
		System.out.println();

		// Criando uma cópia local do banco
		SecretarioBusiness bancoSecretario = (SecretarioBusiness) request.getServletContext()
				.getAttribute("bancoSecretario");

		// Criar objeto instanciando
		Secretario secretario = new Secretario(bancoSecretario.getSize());

		// Setar informações de Identificação
		secretario.setNome(nome);
		secretario.setRg(rg);
		secretario.setCpf(cpf);
		{
			GeneroBusiness bancoGenero = (GeneroBusiness) request.getServletContext().getAttribute("bancoGenero");
			Genero genero_aux = bancoGenero.pesquisaName(genero);

			secretario.setGenero(genero_aux);
		}
		{
			Date dtNascimento = DateUtility.maskToDate(nascimento);
			secretario.setNascimento(dtNascimento);
		}

		secretario.setNaturalidade(naturalidade);
		secretario.setEstadoNatal(estadoNatal);

		secretario.getFiliacao().setPai(pai);
		secretario.getFiliacao().setMae(mae);
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
			secretario.setEndereco(endereco);
		}
		secretario.setEmail(email);

		// Criar objeto - Contato
		secretario.setEmail(email);
		secretario.setResidencial(Telefone.maskToTelefone(foneResidencia));
		secretario.setCelular(Telefone.maskToTelefone(foneCelular));
		secretario.setOpcional(Telefone.maskToTelefone(foneOpcional));

		// Adicionando o objeto ao banco
		boolean adicionado = bancoSecretario.adicionar(secretario);

		if (adicionado) {
			// Colocando o banco de volta ao escopo da aplicação
			request.getServletContext().setAttribute("bancoSecretario", bancoSecretario);
			request.setAttribute("usuario", secretario);
			request.setAttribute("sucesso", Boolean.TRUE);

			request.getRequestDispatcher("cadastrar-usuario.jsp?tipo=Secretario").forward(request, response);
		} else {
			request.setAttribute("usuario", secretario);
			request.setAttribute("erro", Boolean.TRUE);

			request.getRequestDispatcher("cadastrar-usuario.jsp?tipo=Secretario").forward(request, response);
		}
	}

}
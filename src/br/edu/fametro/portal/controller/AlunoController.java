package br.edu.fametro.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.fametro.portal.business.AlunoBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Aluno;
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
			case "alterar":
				alterar(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("LoginController.do");
		}
	}

	private void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long id = 0L;
		
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
		Aluno aluno = new Aluno();
		
		aluno.setNome(nome);
		aluno.setRg(rg);
		aluno.setCpf(cpf);
		aluno.setNascimento(DateUtility.MaskToDate(nascimento));
		aluno.setGenero(genero.equalsIgnoreCase("masculino") ? Genero.MASCULINO : Genero.FEMININO);
		aluno.gerarMatriculaEUsuario(id);
		
		aluno.setNaturalidade(naturalidade);
		aluno.setEstadoNatal(estadoNatal);

		Filiacao filiacao = new Filiacao(pai, mae);
		aluno.setFiliacao(filiacao);

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

		aluno.setEmail(email);

		String dddAux = new String();
		String numeroAux = new String();
		Telefone aux;

		dddAux = residencial.substring(1, 3);
		numeroAux = residencial.substring(4, 9).concat(residencial.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		aluno.setResidencial(aux);

		dddAux = celular.substring(1, 3);
		numeroAux = celular.substring(4, 9).concat(celular.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		aluno.setCelular(aux);

		dddAux = opcional.substring(1, 3);
		numeroAux = opcional.substring(4, 9).concat(opcional.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		aluno.setCelular(aux);

		Curso listaCursos[] = Curso.values();
		Curso auxCurso = null;
		for (Curso c : listaCursos) {
			if (c.getCodigo().equalsIgnoreCase(curso))
				auxCurso = c;
		}
		aluno.setCurso(auxCurso);

		// TESTE
		System.out.println(aluno);

		// Adicionando ao banco local
		bancoAluno.adicionar(aluno);

		// Colocando o banco local de volta ao escopo da aplica��o
		request.getServletContext().setAttribute("bancoAluno", bancoAluno);

		// Redirecionando pra tela home
		response.sendRedirect("home.jsp?cadastro-de-aluno");
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		AlunoBusiness bancoAluno = new AlunoBusiness();

		HttpSession session = request.getSession();
		Aluno alunoLogado = (Aluno) session.getAttribute("usuarioLogado");

		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setLogradouro(logradouro);
		endereco.setComplemento(complemento);
		endereco.setNumero(Integer.parseInt(numero));
		endereco.setBairro(bairro);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setPais(pais);
		alunoLogado.setEndereco(endereco);

		alunoLogado.setEmail(email);

		String dddAux = new String();
		String numeroAux = new String();
		Telefone aux;

		dddAux = residencial.substring(1, 3);
		numeroAux = residencial.substring(4, 9).concat(residencial.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		alunoLogado.setResidencial(aux);

		dddAux = celular.substring(1, 3);
		numeroAux = celular.substring(4, 9).concat(celular.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		alunoLogado.setCelular(aux);

		dddAux = opcional.substring(1, 3);
		numeroAux = opcional.substring(4, 9).concat(opcional.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		alunoLogado.setCelular(aux);

		bancoAluno.alterar(alunoLogado);

	}
}

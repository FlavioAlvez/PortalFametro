package br.edu.fametro.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Qual método sera escolhido na tela de cadastro do secretário
		try {
			String action = request.getParameter("action");

			switch (action.toLowerCase()) {
			case "cadastrar":
				cadastrarSecretario(request, response);
				break;
			case "alterar":
				alterarSecretario(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("LoginController.do");
		}
		
	}
	private void cadastrarSecretario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String genero= request.getParameter("genero");
		String nascimento = request.getParameter("nascimento");
		String naturalidade = request.getParameter("naturalidade");
		String estadoNatal = request.getParameter("estado-natal");
		String pai = request.getParameter("pai");
		String mae = request.getParameter("mae");
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("rua");
		String complemento = request.getParameter("complemento");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("uf");
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");
		String email = request.getParameter("email");
		String foneResidencia = request.getParameter("fone-residencial");
		String foneCelular = request.getParameter("fone-celular");
		String foneOpcional = request.getParameter("fone-3");
		
		
		// Criando uma cópia local do banco
				SecretarioBusiness bancoSecretario = (SecretarioBusiness) request.getServletContext().getAttribute("bancoSecretario");

		// Criar objeto
		Secretario secretario = new Secretario();
		secretario.setNome(nome);
		secretario.setRg(rg);
		secretario.setCpf(cpf);
		secretario.setNascimento(DateUtility.MaskToDate(nascimento));
		secretario.setGenero(genero.equalsIgnoreCase("masculino") ? Genero.MASCULINO : Genero.FEMININO);
		secretario.setNaturalidade(naturalidade);
		secretario.setEstadoNatal(estadoNatal);

		Filiacao filiacao = new Filiacao(pai, mae);
		secretario.setFiliacao(filiacao);

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

		secretario.setEmail(email);

		String dddAux = new String();
		String numeroAux = new String();
		Telefone aux;

		dddAux = foneResidencia.substring(1, 3);
		numeroAux = foneResidencia.substring(4, 9).concat(foneResidencia.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		secretario.setResidencial(aux);

		dddAux = foneCelular.substring(1, 3);
		numeroAux = foneCelular.substring(4, 9).concat(foneCelular.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		secretario.setCelular(aux);

		dddAux = foneOpcional.substring(1, 3);
		numeroAux = foneOpcional.substring(4, 9).concat(foneOpcional.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		secretario.setCelular(aux);

				

		// TESTE
		System.out.println(secretario);

		// Adicionando ao banco local
		bancoSecretario.adicionar(secretario);

		// Colocando o banco local de volta ao escopo da aplica��o
		request.getServletContext().setAttribute("bancoSecretario", bancoSecretario);

		// Redirecionando pra tela home
		response.sendRedirect("home.jsp?cadastro-de-aluno");
	}
	private void alterarSecretario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		SecretarioBusiness bancoSecretario = new SecretarioBusiness();

		HttpSession session = request.getSession();
		Secretario secretarioLogado = (Secretario) session.getAttribute("usuarioLogado");
		
		
		
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("rua");
		String complemento = request.getParameter("complemento");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("uf");
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");
		String email = request.getParameter("email");
		String foneResidencia = request.getParameter("fone-residencial");
		String foneCelular = request.getParameter("fone-celular");
		String foneOpcional = request.getParameter("fone-3");
		
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setLogradouro(logradouro);
		endereco.setComplemento(complemento);
		endereco.setNumero(Integer.parseInt(numero));
		endereco.setBairro(bairro);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setPais(pais);
		secretarioLogado.setEndereco(endereco);
		
		secretarioLogado.setEmail(email);

		String dddAux = new String();
		String numeroAux = new String();
		Telefone aux;

		dddAux = foneResidencia.substring(1, 3);
		numeroAux = foneResidencia.substring(4, 9).concat(foneResidencia.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		secretarioLogado.setResidencial(aux);

		dddAux = foneCelular.substring(1, 3);
		numeroAux = foneCelular.substring(4, 9).concat(foneCelular.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		secretarioLogado.setCelular(aux);

		dddAux = foneOpcional.substring(1, 3);
		numeroAux = foneOpcional.substring(4, 9).concat(foneOpcional.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		secretarioLogado.setCelular(aux);
		
		bancoSecretario.alterar(secretarioLogado);
	}
}

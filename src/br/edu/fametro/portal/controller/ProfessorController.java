package br.edu.fametro.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.enums.Disciplina;
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cadastro(request, response);
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
		String disciplinas[] = request.getParameterValues("disciplina");
		String coordenador = request.getParameter("coordenador"); // null ou on

		//TESTE
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
		System.out.println("Telefone Residencial: " + residencial);
		System.out.println("Telefone Celular: " + celular);
		System.out.println("Telefone 3: " + opcional);
		System.out.println();
		System.out.println("------ EDUCACIONAL ------");
		for (int i = 0; i < disciplinas.length; i++)
			System.out.println("Disciplinas: " + disciplinas[i]);
		System.out.println("Coordenador: " + coordenador);
		System.out.println();

		// Criar objeto
		Professor professor = new Professor(0, nome, rg, cpf, DateUtility.HtmlToDate(nascimento),
				genero.equalsIgnoreCase("masculino") ? Genero.MASCULINO : Genero.FEMININO,
				coordenador.equalsIgnoreCase("on") ? Boolean.TRUE : Boolean.FALSE);
		professor.setNaturalidade(naturalidade);
		professor.setEstadoNatal(estadoNatal);

		Filiacao filiacao = new Filiacao(pai, mae);
		professor.setFiliacao(filiacao);

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

		professor.setEmail(email);

		String dddAux = new String(); // (0 1 2 )3
		String numeroAux = new String();// 4 5 6 7 8 -9 0 1 2 3
		Telefone aux;

		dddAux = residencial.substring(1, 3);
		numeroAux = residencial.substring(4, 9).concat(residencial.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		professor.setResidencial(aux);

		dddAux = celular.substring(1, 3);
		numeroAux = celular.substring(4, 9).concat(celular.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		professor.setCelular(aux);

		dddAux = opcional.substring(1, 3);
		numeroAux = opcional.substring(4, 9).concat(opcional.substring(10));
		aux = new Telefone(Integer.parseInt(dddAux), numeroAux);
		professor.setCelular(aux);

		for (int i = 0; i < disciplinas.length; i++) {
			professor.addDisciplina(Disciplina.search(disciplinas[i]));
		}
		
		
	}
}

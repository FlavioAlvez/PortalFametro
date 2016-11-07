package br.edu.fametro.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fametro.portal.business.AlunoBusiness;
import br.edu.fametro.portal.business.SolicitacaoBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.enums.Avaliacao;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;

/**
 * Servlet implementation class SolicitacaoController
 */
@WebServlet("/SolicitacaoController.do")
public class SolicitacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolicitacaoController() {
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
	}

	private void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipooAtendimentoCdg = request.getParameter("tipo-atendimento-cdg");
		String tipoAtendimento = request.getParameter("tipo-atendimento-descricao");

		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String grupo = request.getParameter("grupo");
		String abertura = request.getParameter("abertura");
		String fechamento = request.getParameter("fechamento");
		String assunto = request.getParameter("assunto");
		String descricao = request.getParameter("message");
		String avaliacao = request.getParameter("avaliacao");
		String disciplina = request.getParameter("disciplina");
		
		/* TESTE PARAMETROS */
		System.out.println("***** TESTE PARAMETROS *****");
		System.out.println("CODIGO ATENDIMENTO: " + tipooAtendimentoCdg);
		System.out.println("TIPO ATENDIMENTO: " + tipoAtendimento);
		System.out.println("MATRICULA: " + matricula);
		System.out.println("NOME: " + nome);
		System.out.println("GRUPO: " + grupo);
		System.out.println("ABERTURA: " + abertura);
		System.out.println("FECHAMENTO: " + fechamento);
		System.out.println("ASSUNTO: " + assunto);
		System.out.println("DESCRI��O: " + descricao);
		System.out.println("AVALIA��O: " + avaliacao);
		System.out.println("DISCIPLINA: " + disciplina);
		System.out.println("***** TESTE PARAMETROS *****");
		/* TESTE PARAMETROS */

		SolicitacaoBusiness bancoSolicitacao = (SolicitacaoBusiness) request.getServletContext()
				.getAttribute("bancoSolicitacao");
		AlunoBusiness bancoAluno = (AlunoBusiness) request.getServletContext().getAttribute("bancoAluno");

		Solicitacao solicitacao = new Solicitacao();
		Disciplina listaDisciplina[] = Disciplina.values();
		switch (Integer.parseInt(tipoAtendimento)) {
		case 1:
			// Quebra de Pr�-Requisito
			solicitacao = new Solicitacao();
			
			solicitacao.setCodigo(Integer.parseInt(tipooAtendimentoCdg));
			solicitacao.setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
			solicitacao.setTipoAtendimento(TipoAtendimento.QUEBRA_DE_PRE_REQUISITO);
			solicitacao.setCliente(bancoAluno.pesquisaMatricula(matricula));
			solicitacao.setTipo(TipoUsuario.ALUNO);
			solicitacao.setAbertura(DateUtility.HtmlToDate(abertura));
			solicitacao.setFechamento(DateUtility.HtmlToDate(fechamento));
			solicitacao.setAssunto(assunto);
			solicitacao.setSolicitacao(descricao);
			
			for (Disciplina aux : listaDisciplina) {
				if (disciplina.equalsIgnoreCase(aux.getCodigo()))
					solicitacao.setDisciplina(aux);
			}
			break;
		case 2:
			// Revis�o de Nota
			solicitacao = new Solicitacao();
			
			solicitacao.setCodigo(Integer.parseInt(tipooAtendimentoCdg));
			solicitacao.setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
			solicitacao.setTipoAtendimento(TipoAtendimento.REVISAO_DE_NOTA);
			solicitacao.setCliente(bancoAluno.pesquisaMatricula(matricula));
			solicitacao.setTipo(TipoUsuario.ALUNO);
			solicitacao.setAbertura(DateUtility.HtmlToDate(abertura));
			solicitacao.setFechamento(DateUtility.HtmlToDate(fechamento));
			solicitacao.setAssunto(assunto);
			solicitacao.setSolicitacao(descricao);
			
			for (Disciplina aux : listaDisciplina) {
				if (disciplina.equalsIgnoreCase(aux.getCodigo()))
					solicitacao.setDisciplina(aux);
			}
			solicitacao.setAv(avaliacao.equalsIgnoreCase("AV1") ? Avaliacao.AV1
					: (avaliacao.equalsIgnoreCase("AV2") ? Avaliacao.AV2 : Avaliacao.AVF));
			break;
		case 3:
			// Abono de Falta
			solicitacao = new Solicitacao();

			solicitacao.setCodigo(Integer.parseInt(tipooAtendimentoCdg));
			solicitacao.setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
			solicitacao.setTipoAtendimento(TipoAtendimento.ABONO_DE_FALTA);
			solicitacao.setCliente(bancoAluno.pesquisaMatricula(matricula));
			solicitacao.setTipo(TipoUsuario.ALUNO);
			solicitacao.setAbertura(DateUtility.HtmlToDate(abertura));
			solicitacao.setFechamento(DateUtility.HtmlToDate(fechamento));
			solicitacao.setAssunto(assunto);
			solicitacao.setSolicitacao(descricao);
			
			for (Disciplina aux : listaDisciplina) {
				if (disciplina.equalsIgnoreCase(aux.getCodigo()))
					solicitacao.setDisciplina(aux);
			}
			break;
		case 4:
			// Ouvidoria
			solicitacao = new Solicitacao();

			solicitacao.setCodigo(Integer.parseInt(tipooAtendimentoCdg));
			solicitacao.setGrupoAtendimento(GrupoAtendimento.SECRETARIA);
			solicitacao.setTipoAtendimento(TipoAtendimento.OUVIDORIA);
			solicitacao.setCliente(bancoAluno.pesquisaMatricula(matricula));
			solicitacao.setTipo(TipoUsuario.ALUNO);
			solicitacao.setAbertura(DateUtility.HtmlToDate(abertura));
			solicitacao.setFechamento(DateUtility.HtmlToDate(fechamento));
			solicitacao.setAssunto(assunto);
			solicitacao.setSolicitacao(descricao);
			
			break;
		default:
			// Buxo
			solicitacao = null;
			break;
		}
		
		bancoSolicitacao.adicionar(solicitacao);

		request.getServletContext().setAttribute("bancoSolicitacao", bancoSolicitacao);

		response.sendRedirect("home.jsp?solicitacao");
	}
	
}
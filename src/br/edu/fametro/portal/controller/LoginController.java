package br.edu.fametro.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.model.Secretario;
import br.edu.fametro.portal.model.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
			case "entrar":
				login(request, response);
				break;
			case "sair":
				logout(request, response);
				break;
			default:
				verificarSession(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			verificarSession(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String senha = request.getParameter("password");

		Usuario u = new Usuario(username, senha);

		HttpSession session = request.getSession();

		int tipo = Integer.parseInt(u.getUsername().split("-")[0]);
		switch (tipo) {
		case 0: // secretario 0-2016123456
			SecretarioBusiness bancoSecretario = (SecretarioBusiness) request.getServletContext()
					.getAttribute("bancoSecretario");

			Secretario secretarioLogado = bancoSecretario.pesquisaUsuario(u);

			if (secretarioLogado != null) {
				session.setAttribute("usuarioLogado", secretarioLogado);
			} else {
				session.setAttribute("loginInvalido", Boolean.TRUE);
			}
			break;
		case 1: // aluno 1-2016123456

			break;
		case 2: // professor 2-2016123456

			break;
		case 3: // coordenador 3-2016123456

			break;
		default:// buxo

			break;
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.setAttribute("usuarioLogado", null);
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void verificarSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("usuarioLogado") == null) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("home.jsp");
		}

	}
}

package br.edu.fametro.portal.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fametro.portal.model.AcessaSistema;
import br.edu.fametro.portal.model.Genero;
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
			switch (action) {
			case "entrar":
				login(request, response);
				break;
			case "sair":
				logout(request, response);
				break;
			default: // BUXO PRA TRATAR
				break;
			}
		} catch (Exception e) {

		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("");
		String senha = request.getParameter("");

		Usuario u = new Usuario(username, senha);

		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

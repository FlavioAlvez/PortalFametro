package br.edu.fametro.portal.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtro de login.
 */
@WebFilter(urlPatterns = "/*", dispatcherTypes = { DispatcherType.FORWARD, DispatcherType.REQUEST })
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hresp = (HttpServletResponse) response;
		HttpSession session = hreq.getSession();

		String paginaAtual = new String(hreq.getRequestURL());

		if (paginaAtual != null
			&& (paginaAtual.endsWith("")
				&& (!paginaAtual.endsWith("login.jsp")
							&& (!paginaAtual.endsWith("LoginController.do")
								&& ((paginaAtual.endsWith(".jsp") || paginaAtual.endsWith(".do"))))))) {
			if (session.getAttribute("usuarioLogado") == null) {
				session.invalidate();
				hresp.sendRedirect("login.jsp");
				return;
			}
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
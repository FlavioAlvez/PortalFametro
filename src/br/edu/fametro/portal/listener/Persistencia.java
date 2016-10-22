package br.edu.fametro.portal.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.fametro.portal.business.AlunoBusiness;
import br.edu.fametro.portal.business.EnumBusiness;
import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.model.atores.Aluno;
import br.edu.fametro.portal.model.atores.Secretario;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Genero;

/**
 * Application Lifecycle Listener implementation class Persistencia
 *
 */
@WebListener
public class Persistencia implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public Persistencia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent contexto) {
		// TODO Auto-generated method stub
		System.out.println("Finalizando aplicação!");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent contexto) {
		// TODO Auto-generated method stub
		System.out.println("Iniciando aplicação...");
		System.out.println("Gerando persistencia...");

		/****************************************************************************************************/
		System.out.println("[SECRETARIO] Instanciando banco...");
		SecretarioBusiness bancoSecretario = new SecretarioBusiness();

		System.out.println("[SECRETARIO] Adicionando o primeiro elemento...");
		bancoSecretario.adicionar(new Secretario(bancoSecretario.getSize(), "Secretario Tester Flavio", "123456789",
				"123.456.789-00", new Date(), Genero.MASCULINO));

		// Teste
		System.out.println("Secretários (" + bancoSecretario.getSize() + "):");
		for (Secretario s : bancoSecretario.getBanco()) {
			System.out.println("----------");
			System.out.println(s);
		}
		System.out.println("----------\n");

		System.out.println("[SECRETARIO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoSecretario", bancoSecretario);
		/****************************************************************************************************/
		System.out.println("[ALUNO] Instanciando banco...");
		AlunoBusiness bancoAluno = new AlunoBusiness();

		System.out.println("[ALUNO] Adicionando o primeiro elemento...");
		bancoAluno.adicionar(new Aluno(bancoAluno.getSize(), "Elias", "123456", "123.456.789-00", new Date(),
				Genero.MASCULINO, Curso.ADS));

		// Teste
		System.out.println("Alunos (" + bancoAluno.getSize() + "):");
		for (Aluno a : bancoAluno.getBanco()) {
			System.out.println("----------");
			System.out.println(a);
		}
		System.out.println("----------\n");

		System.out.println("[ALUNO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoAluno", bancoAluno);
		/****************************************************************************************************/
		System.out.println("[PROFESSOR]");
		/****************************************************************************************************/
		System.out.println("[SOLICITAÇÃO]");
		/****************************************************************************************************/
		System.out.println("[ENUM] Instanciando banco...");
		EnumBusiness bancoEnum = new EnumBusiness();
		
		System.out.println("[ENUM] Populando listas...");
		bancoEnum.popularTodos();
		
		System.out.println("[ENUM] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoEnum", bancoEnum);
		/****************************************************************************************************/
		System.out.println("Inicialização concluída...");
	}

}
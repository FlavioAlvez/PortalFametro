package br.edu.fametro.portal.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.fametro.portal.business.AlunoBusiness;
import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.business.enums.AvaliacaoBusiness;
import br.edu.fametro.portal.business.enums.CursoBusiness;
import br.edu.fametro.portal.business.enums.DisciplinaBusiness;
import br.edu.fametro.portal.business.enums.GeneroBusiness;
import br.edu.fametro.portal.business.enums.GrupoAtendimentoBusiness;
import br.edu.fametro.portal.business.enums.TipoAtendimentoBusiness;
import br.edu.fametro.portal.business.enums.TipoUsuarioBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
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

		System.out.println("[SECRETARIO] Criando o primeiro elemento...");
		Secretario secretarioExemplo = new Secretario(bancoSecretario.getSize());
		// Pessoa
		secretarioExemplo.setNome("Secretario Fulano Beltrano");
		secretarioExemplo.setRg("5368374810");
		secretarioExemplo.setCpf("123.456.789-00");
		secretarioExemplo.setNascimento(DateUtility.maskToDate("01/02/1993"));
		secretarioExemplo.setGenero(Genero.MASCULINO);
		{
			Filiacao filiacao = new Filiacao();
			filiacao.setPai("Pai do Secretario Beltrano");
			filiacao.setMae("Mãe do Secretario Beltrano");
			
			secretarioExemplo.setFiliacao(filiacao);
		}
		secretarioExemplo.setNaturalidade("Fortaleza");
		secretarioExemplo.setEstadoNatal("CE");
		// Secretario
		{
			Endereco endereco = new Endereco();
			endereco.setCep("60750-000");
			endereco.setLogradouro("Avenida Araquém Aguiar");
			endereco.setComplemento("Complemento");
			endereco.setNumero(234);
			endereco.setBairro("Prefeito José Walter");
			endereco.setEstado("CE");
			endereco.setCidade("Fortaleza");
			endereco.setPais("Brasil");

			secretarioExemplo.setEndereco(endereco);
		}
		secretarioExemplo.setResidencial(Telefone.maskToTelefone("(85)03473-7070"));
		secretarioExemplo.setCelular(Telefone.maskToTelefone("(85)97070-7070"));
		secretarioExemplo.setOpcional(Telefone.maskToTelefone("(85)99876-5432"));

		System.out.println("[SECRETARIO] Colocando o primeiro elemento no banco...");
		bancoSecretario.adicionar(secretarioExemplo);

		// Teste
		System.out.println("[SECRETARIO] Quantidade de elementos no banco: " + bancoSecretario.getSize());
		{
			int i = 0;
			for (Secretario s : bancoSecretario.getBanco()) {
				System.out.print("[SECRETARIO] Elemento " + i +": " + s +"\n");
				i++;
			}
		}
		// Fim Teste
	
		System.out.println("[SECRETARIO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoSecretario", bancoSecretario);
		
		/****************************************************************************************************/
		System.out.println("[ALUNO] Instanciando banco...");
		AlunoBusiness bancoAluno = new AlunoBusiness();

		System.out.println("[ALUNO] Criando o primeiro elemento...");
		Aluno alunoExemplo = new Aluno(bancoAluno.getSize());
		// Pessoa
		alunoExemplo.setNome("Aluno Fulano Beltrano");
		alunoExemplo.setRg("5368374810");
		alunoExemplo.setCpf("123.456.789-00");
		alunoExemplo.setNascimento(DateUtility.maskToDate("01/02/1993"));
		alunoExemplo.setGenero(Genero.MASCULINO);
		{
			Filiacao filiacao = new Filiacao();
			filiacao.setPai("Pai do Aluno Beltrano");
			filiacao.setMae("Mãe do Aluno Beltrano");
			
			alunoExemplo.setFiliacao(filiacao);
		}
		alunoExemplo.setNaturalidade("Fortaleza");
		alunoExemplo.setEstadoNatal("CE");
		// Aluno
		alunoExemplo.setCurso(Curso.ADS);
		{
			Endereco endereco = new Endereco();
			endereco.setCep("60750-000");
			endereco.setLogradouro("Avenida Araquém Aguiar");
			endereco.setComplemento("Complemento");
			endereco.setNumero(234);
			endereco.setBairro("Prefeito José Walter");
			endereco.setEstado("CE");
			endereco.setCidade("Fortaleza");
			endereco.setPais("Brasil");

			alunoExemplo.setEndereco(endereco);
		}
		alunoExemplo.setResidencial(Telefone.maskToTelefone("(85)03473-7070"));
		alunoExemplo.setCelular(Telefone.maskToTelefone("(85)97070-7070"));
		alunoExemplo.setOpcional(Telefone.maskToTelefone("(85)99876-5432"));

		System.out.println("[ALUNO] Colocando o primeiro elemento no banco...");
		bancoAluno.adicionar(alunoExemplo);

		// Teste
		System.out.println("[ALUNO] Quantidade de elementos no banco: " + bancoAluno.getSize());
		{
			int i = 0;
			for (Aluno s : bancoAluno.getBanco()) {
				System.out.print("[ALUNO] Elemento " + i +": " + s +"\n");
				i++;
			}
		}
		// Fim Teste
	
		System.out.println("[ALUNO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoAluno", bancoAluno);

		/****************************************************************************************************/
		System.out.println("[ENUM] Instanciando banco...");
		AvaliacaoBusiness bancoAvaliacao = new AvaliacaoBusiness();
		CursoBusiness bancoCurso = new CursoBusiness();
		DisciplinaBusiness bancoDisciplina = new DisciplinaBusiness();
		GeneroBusiness bancoGenero = new GeneroBusiness();
		GrupoAtendimentoBusiness bancoGrupoAtendimento = new GrupoAtendimentoBusiness();
		TipoAtendimentoBusiness bancoTipoAtendimento = new TipoAtendimentoBusiness();
		TipoUsuarioBusiness bancoTipoUsuario = new TipoUsuarioBusiness();

		System.out.println("[ENUM] Populando listas...");
		bancoAvaliacao.popularBanco();
		bancoCurso.popularBanco();
		bancoDisciplina.popularBanco();
		bancoGenero.popularBanco();
		bancoGrupoAtendimento.popularBanco();
		bancoTipoAtendimento.popularBanco();
		bancoTipoUsuario.popularBanco();

		System.out.println("[ENUM] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoAvaliacao", bancoAvaliacao);
		contexto.getServletContext().setAttribute("bancoCurso", bancoCurso);
		contexto.getServletContext().setAttribute("bancoDisciplina", bancoDisciplina);
		contexto.getServletContext().setAttribute("bancoGenero", bancoGenero);
		contexto.getServletContext().setAttribute("bancoGrupoAtendimento", bancoGrupoAtendimento);
		contexto.getServletContext().setAttribute("bancoTipoAtendimento", bancoTipoAtendimento);
		contexto.getServletContext().setAttribute("bancoTipoUsuario", bancoTipoUsuario);

		/****************************************************************************************************/
		System.out.println("[DateUtility] Auxiliar");
		DateUtility auxiliar = new DateUtility();
		contexto.getServletContext().setAttribute("DateUtility", auxiliar);
		
		/****************************************************************************************************/
		System.out.println("Inicialização concluída...");
	}
}
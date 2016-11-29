package br.edu.fametro.portal.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.fametro.portal.business.AlunoBusiness;
import br.edu.fametro.portal.business.ProfessorBusiness;
import br.edu.fametro.portal.business.SecretarioBusiness;
import br.edu.fametro.portal.business.SolicitacaoBusiness;
import br.edu.fametro.portal.business.enums.AvaliacaoBusiness;
import br.edu.fametro.portal.business.enums.CursoBusiness;
import br.edu.fametro.portal.business.enums.DisciplinaBusiness;
import br.edu.fametro.portal.business.enums.EstadoBusiness;
import br.edu.fametro.portal.business.enums.GeneroBusiness;
import br.edu.fametro.portal.business.enums.GrupoAtendimentoBusiness;
import br.edu.fametro.portal.business.enums.TipoAtendimentoBusiness;
import br.edu.fametro.portal.business.enums.TipoUsuarioBusiness;
import br.edu.fametro.portal.model.DateUtility;
import br.edu.fametro.portal.model.Endereco;
import br.edu.fametro.portal.model.Filiacao;
import br.edu.fametro.portal.model.Telefone;
import br.edu.fametro.portal.model.atores.Aluno;
import br.edu.fametro.portal.model.atores.Professor;
import br.edu.fametro.portal.model.atores.Secretario;
import br.edu.fametro.portal.model.enums.Avaliacao;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.Genero;
import br.edu.fametro.portal.model.enums.TipoUsuario;
import br.edu.fametro.portal.model.solicitacoes.Solicitacao;
import br.edu.fametro.portal.model.solicitacoes.secretaria.AbonoFalta;
import br.edu.fametro.portal.model.solicitacoes.secretaria.Ouvidoria;
import br.edu.fametro.portal.model.solicitacoes.secretaria.QuebraPreRequisito;
import br.edu.fametro.portal.model.solicitacoes.secretaria.RevisaoNota;

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
		secretarioExemplo.setResidencial(Telefone.maskToTelefone("(85)3473-7070"));
		secretarioExemplo.setCelular(Telefone.maskToTelefone("(85)97070-7070"));
		secretarioExemplo.setOpcional(Telefone.maskToTelefone("(85)99876-5432"));
		secretarioExemplo.setEmail("secretario@fametro.edu.br");

		System.out.println("[SECRETARIO] Colocando o primeiro elemento no banco...");
		bancoSecretario.adicionar(secretarioExemplo);

		// Teste
		System.out.println("[SECRETARIO] Quantidade de elementos no banco: " + bancoSecretario.getSize());
		{
			int i = 0;
			for (Secretario s : bancoSecretario.getBanco()) {
				System.out.print("[SECRETARIO] Elemento " + i + ": " + s + "\n");
				i++;
			}
		}
		// Fim Teste

		System.out.println("[SECRETARIO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoSecretario", bancoSecretario);

		/****************************************************************************************************/
		System.out.println("[PROFESSOR] Instanciando banco...");
		ProfessorBusiness bancoProfessor = new ProfessorBusiness();

		System.out.println("[PROFESSOR] Criando o primeiro elemento...");
		Professor professorExemplo = new Professor(bancoProfessor.getSize());
		// Pessoa
		professorExemplo.setNome("Professor Fulano Beltrano");
		professorExemplo.setRg("5368374810");
		professorExemplo.setCpf("123.456.789-00");
		professorExemplo.setNascimento(DateUtility.maskToDate("01/02/1993"));
		professorExemplo.setGenero(Genero.MASCULINO);
		{
			Filiacao filiacao = new Filiacao();
			filiacao.setPai("Pai do Professor Beltrano");
			filiacao.setMae("Mãe do Professor Beltrano");

			professorExemplo.setFiliacao(filiacao);
		}
		professorExemplo.setNaturalidade("Fortaleza");
		professorExemplo.setEstadoNatal("CE");
		// Professor
		professorExemplo.setCoordenador(Boolean.TRUE);
		{
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			disciplinas.add(Disciplina.DESENVOLVIMENTO_WEB);
			professorExemplo.setDisciplinas(disciplinas);
		}
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

			professorExemplo.setEndereco(endereco);
		}
		professorExemplo.setResidencial(Telefone.maskToTelefone("(85)3473-7070"));
		professorExemplo.setCelular(Telefone.maskToTelefone("(85)97070-7070"));
		professorExemplo.setOpcional(Telefone.maskToTelefone("(85)99876-5432"));
		professorExemplo.setEmail("professor@fametro.edu.br");

		System.out.println("[PROFESSOR] Colocando o primeiro elemento no banco...");
		bancoProfessor.adicionar(professorExemplo);

		// Teste
		System.out.println("[PROFESSOR] Quantidade de elementos no banco: " + bancoProfessor.getSize());
		{
			int i = 0;
			for (Professor p : bancoProfessor.getBanco()) {
				System.out.print("[PROFESSOR] Elemento " + i + ": " + p + "\n");
				i++;
			}
		}
		// Fim Teste

		System.out.println("[PROFESSOR] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoProfessor", bancoProfessor);

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
		alunoExemplo.setResidencial(Telefone.maskToTelefone("(85)3473-7070"));
		alunoExemplo.setCelular(Telefone.maskToTelefone("(85)97070-7070"));
		alunoExemplo.setOpcional(Telefone.maskToTelefone("(85)99876-5432"));
		alunoExemplo.setEmail("aluno@fametro.edu.br");

		System.out.println("[ALUNO] Colocando o primeiro elemento no banco...");
		bancoAluno.adicionar(alunoExemplo);

		// Teste
		System.out.println("[ALUNO] Quantidade de elementos no banco: " + bancoAluno.getSize());
		{
			int i = 0;
			for (Aluno a : bancoAluno.getBanco()) {
				System.out.print("[ALUNO] Elemento " + i + ": " + a + "\n");
				i++;
			}
		}
		// Fim Teste

		System.out.println("[ALUNO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoAluno", bancoAluno);

		/****************************************************************************************************/
		System.out.println("[SOLICITAÇÃO] Instanciando banco...");
		SolicitacaoBusiness bancoSolicitacao = new SolicitacaoBusiness();

		System.out.println("[SOLICITAÇÃO][QuebraPreRequisito] Criando o primeiro elemento...");
		QuebraPreRequisito s1 = new QuebraPreRequisito(bancoSolicitacao.getSize());
		s1.setCliente(bancoAluno.getBanco().get(0));
		s1.setTipo(TipoUsuario.ALUNO);
		s1.setAbertura(DateUtility.maskToDate("23/08/2016"));
		s1.setDisciplina(Disciplina.DESENVOLVIMENTO_WEB);
		s1.setFechamento(DateUtility.maskToDate("23/11/2016"));
		s1.setAssunto("Quebra de requisito");
		s1.setSolicitacao(
				"O aluno solicita a quebra de requisito para cursar a cadeira " + Disciplina.DESENVOLVIMENTO_WEB);
		s1.setDiscussao("O requisito é indispensável.");
		s1.setSolucao("A quebra de requisito foi negada.");

		System.out.println("[SOLICITAÇÃO][RevisaoNota] Criando o segundo elemento...");
		RevisaoNota s2 = new RevisaoNota(bancoSolicitacao.getSize());
		s2.setCliente(bancoAluno.getBanco().get(0));
		s2.setTipo(TipoUsuario.ALUNO);
		s2.setAbertura(DateUtility.maskToDate("24/11/2016"));
		s2.setDisciplina(Disciplina.DESENVOLVIMENTO_WEB);
		s2.setProfessor(bancoProfessor.getBanco().get(0));
		s2.setAvaliacao(Avaliacao.AV2);
		s2.setAssunto("Revisao de nota da " + Avaliacao.AV2.name());
		s2.setSolicitacao(
				"O aluno solicita a revisão da nota da " + Avaliacao.AV2.name() + Disciplina.DESENVOLVIMENTO_WEB);

		System.out.println("[SOLICITAÇÃO][AbonoFalta] Criando o terceiro elemento...");
		AbonoFalta s3 = new AbonoFalta(bancoSolicitacao.getSize());
		s3.setCliente(bancoAluno.getBanco().get(0));
		s3.setTipo(TipoUsuario.ALUNO);
		s3.setAbertura(DateUtility.maskToDate("24/11/2016"));
		s3.setDisciplina(Disciplina.DESENVOLVIMENTO_WEB);
		s3.setProfessor(bancoProfessor.getBanco().get(0));
		s3.setInicioAtestado(DateUtility.setDataHoraCompleta("2016-8-25", "12:13:14"));
		s3.setFimAtestado(DateUtility.setDataHoraCompleta("2016-9-3", "15:16:17"));
		s3.setAssunto("Abono de falta");
		s3.setSolicitacao("O aluno solicita o abono de falta");

		System.out.println("[SOLICITAÇÃO][Ouvidoria] Criando o quarto elemento...");
		Ouvidoria s4 = new Ouvidoria(bancoSolicitacao.getSize());
		s4.setCliente(bancoAluno.getBanco().get(0));
		s4.setTipo(TipoUsuario.ALUNO);
		s4.setAbertura(DateUtility.maskToDate("24/11/2016"));
		s4.setAssunto("Reclamação");
		s4.setSolicitacao(
				"A gente vai tudo morrer cedo com esses sonos desregulados pra fazer essa ruma de trabai. #DECEPS");

		System.out.println("[SOLICITAÇÃO] Colocando os elementos no banco...");
		bancoSolicitacao.adicionar(s1);
		bancoSolicitacao.adicionar(s2);
		bancoSolicitacao.adicionar(s3);
		bancoSolicitacao.adicionar(s4);

		// Teste
		System.out.println("[SOLICITAÇÃO] Quantidade de elementos no banco: " + bancoSolicitacao.getSize());
		{
			int i = 0;
			for (Solicitacao s : bancoSolicitacao.getBanco()) {
				System.out.print("[SOLICITAÇÃO] Elemento " + i + ": " + s + "\n");
				i++;
			}
		}
		// Fim Teste

		System.out.println("[SOLICITAÇÃO] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoSolicitacao", bancoSolicitacao);

		/****************************************************************************************************/
		System.out.println("[ENUM] Instanciando banco...");
		AvaliacaoBusiness bancoAvaliacao = new AvaliacaoBusiness();
		CursoBusiness bancoCurso = new CursoBusiness();
		DisciplinaBusiness bancoDisciplina = new DisciplinaBusiness();
		GeneroBusiness bancoGenero = new GeneroBusiness();
		GrupoAtendimentoBusiness bancoGrupoAtendimento = new GrupoAtendimentoBusiness();
		TipoAtendimentoBusiness bancoTipoAtendimento = new TipoAtendimentoBusiness();
		TipoUsuarioBusiness bancoTipoUsuario = new TipoUsuarioBusiness();
		EstadoBusiness bancoEstado = new EstadoBusiness();

		System.out.println("[ENUM] Populando listas...");
		bancoAvaliacao.popularBanco();
		bancoCurso.popularBanco();
		bancoDisciplina.popularBanco();
		bancoGenero.popularBanco();
		bancoGrupoAtendimento.popularBanco();
		bancoTipoAtendimento.popularBanco();
		bancoTipoUsuario.popularBanco();
		bancoEstado.popularBanco();

		System.out.println("[ENUM] Colocando banco no contexto da aplicação...\n");
		contexto.getServletContext().setAttribute("bancoAvaliacao", bancoAvaliacao);
		contexto.getServletContext().setAttribute("bancoCurso", bancoCurso);
		contexto.getServletContext().setAttribute("bancoDisciplina", bancoDisciplina);
		contexto.getServletContext().setAttribute("bancoGenero", bancoGenero);
		contexto.getServletContext().setAttribute("bancoGrupoAtendimento", bancoGrupoAtendimento);
		contexto.getServletContext().setAttribute("bancoTipoAtendimento", bancoTipoAtendimento);
		contexto.getServletContext().setAttribute("bancoTipoUsuario", bancoTipoUsuario);
		contexto.getServletContext().setAttribute("bancoEstado", bancoEstado);

		/****************************************************************************************************/
		System.out.println("[DateUtility] Auxiliar");
		DateUtility auxiliar = new DateUtility();
		contexto.getServletContext().setAttribute("DateUtility", auxiliar);

		/****************************************************************************************************/
		System.out.println("Inicialização concluída...");
	}
}
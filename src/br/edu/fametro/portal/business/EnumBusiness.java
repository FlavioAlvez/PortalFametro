package br.edu.fametro.portal.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.fametro.portal.model.enums.Avaliacao;
import br.edu.fametro.portal.model.enums.Curso;
import br.edu.fametro.portal.model.enums.Disciplina;
import br.edu.fametro.portal.model.enums.Genero;
import br.edu.fametro.portal.model.enums.GrupoAtendimento;
import br.edu.fametro.portal.model.enums.TipoAtendimento;
import br.edu.fametro.portal.model.enums.TipoUsuario;

//Utilitario
public class EnumBusiness {
	private List<Avaliacao> bancoAvaliacao;
	private List<Curso> bancoCurso;
	private List<Disciplina> bancoDisciplina;
	private List<Genero> bancoGenero;
	private List<GrupoAtendimento> bancoGrupoAtendimento;
	private List<TipoAtendimento> bancoTipoAtendimento;
	private List<TipoUsuario> bancoTipoUsuario;

	public EnumBusiness() {
		bancoAvaliacao = new ArrayList<Avaliacao>();
		bancoCurso = new ArrayList<Curso>();
		bancoDisciplina = new ArrayList<Disciplina>();
		bancoGenero = new ArrayList<Genero>();
		bancoGrupoAtendimento = new ArrayList<GrupoAtendimento>();
		bancoTipoAtendimento = new ArrayList<TipoAtendimento>();
		bancoTipoUsuario = new ArrayList<TipoUsuario>();
	}

	public void popularTodos() {
		popularBancoAvaliacao();
		popularBancoCurso();
		popularBancoDisciplina();
		popularBancoGenero();
		popularBancoGrupoAtendimento();
		popularBancoTipoAtendimento();
		popularBancoTipoUsuario();
	}

	public void popularBancoAvaliacao() {
		Avaliacao lista[] = Avaliacao.values();
		for (Avaliacao av : lista) {
			bancoAvaliacao.add(av);
		}
	}

	public void popularBancoCurso() {
		Curso lista[] = Curso.values();
		for (Curso c : lista) {
			bancoCurso.add(c);
		}
	}

	public void popularBancoDisciplina() {
		Disciplina lista[] = Disciplina.values();
		for(Disciplina d: lista){
			bancoDisciplina.add(d);
		}
	}

	public void popularBancoGenero() {
		Genero lista[] = Genero.values();
		for(Genero g: lista){
			bancoGenero.add(g);
		}
	}

	public void popularBancoGrupoAtendimento() {
		GrupoAtendimento lista[] = GrupoAtendimento.values();
		for(GrupoAtendimento ga: lista){
			bancoGrupoAtendimento.add(ga);
		}
	}

	public void popularBancoTipoAtendimento() {
		TipoAtendimento lista[] = TipoAtendimento.values();
		for(TipoAtendimento ta: lista){
			bancoTipoAtendimento.add(ta);
		}
	}

	public void popularBancoTipoUsuario() {
		TipoUsuario lista[] = TipoUsuario.values();
		for(TipoUsuario tu: lista){
			bancoTipoUsuario.add(tu);
		}
	}

	public List<Avaliacao> getBancoAvaliacao() {
		return bancoAvaliacao;
	}

	public List<Curso> getBancoCurso() {
		return bancoCurso;
	}

	public List<Disciplina> getBancoDisciplina() {
		return bancoDisciplina;
	}

	public List<Genero> getBancoGenero() {
		return bancoGenero;
	}

	public List<GrupoAtendimento> getBancoGrupoAtendimento() {
		return bancoGrupoAtendimento;
	}

	public List<TipoAtendimento> getBancoTipoAtendimento() {
		return bancoTipoAtendimento;
	}

	public List<TipoUsuario> getBancoTipoUsuario() {
		return bancoTipoUsuario;
	}
}

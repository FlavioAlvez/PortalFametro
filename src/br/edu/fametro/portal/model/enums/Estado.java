package br.edu.fametro.portal.model.enums;

public enum Estado {
	ACRE("Brasil", "AC", "Acre"), ALAGOAS("Brasil", "AL", "Alagoas"), AMAZONAS("Brasil", "AM", "Amazonas"),
	AMAPA("Brasil", "AP", "Amap�"), BAHIA("Brasil","BA", "Bahia"), CEARA("Brasil", "CE", "Cear�"),
	DISTRITO_FEDERAL("Brasil", "DF", "Distrito Federal"), ESPIRITO_SANTO("Brasil", "ES", "Esp�rito Santo"),
	GOIAS("Brasil","GO","Goi�s"), MARANHAO("Brasil","MA","Maranh�o"), MATO_GROSSO("Brasil","MT","Mato Grosso"),
	MATO_GROSSO_DO_SUL("Brasil","MS","Mato Grosso do Sul"),	MINAS_GERAIS("Brasil","MG","Minas Gerais"), 
	PARA("Brasil","PA","Par�"), PARAIBA("Brasil","PB","Para�ba"), PARANA("Brasil","PR","Paran�"),
	PERNAMBUCO("Brasil","PE","Pernambuco"), PIAUI("Brasil","PI","Piau�"), RIO_DE_JANEIRO("Brasil","RJ","Rio de Janeiro"), 
	RIO_GRANDE_DO_NORTE("Brasil","RN","Rio Grande do Norte"), RONDONIA("Brasil","RO","Rond�nia"), 
	RIO_GRANDE_DO_SUL("Brasil","RS","Rio Grande do Sul"), RORAIMA("Brasil","RR","Roraima"), 
	SANTA_CATARINA("Brasil","SC","Santa Catarina"), SERGIPE("Brasil","SE","Sergipe"), 
	SAO_PAULO("Brasil","SP","S�o Paulo"), TOCANTINS("Brasil","TO","Tocantins");
	
	private String pais;
	private String abreviacao;
	private String nome;

	private Estado(String pais, String abreviacao, String nome) {
		this.pais = pais;
		this.abreviacao = abreviacao;
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
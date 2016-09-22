package br.com.grupo4.sistemaacademico.endereco;

public enum Cidade {
	
	ABREU_E_LIMA("Abreu e Lima"),
	CAMARAGIBE("Camaragibe"),
	GOIANA("Goiana"),
	IGARASSU("Igarassu"),
	IPOJUCA("Ipojuca"),
	MORENO("Moreno"),
	OLINDA("Olinda"),
	PETROLINA("Petrolina"),
	RECIFE("Recife"),
	TIMBAUBA("Timbaúba");
	
	private String cidade;
	
	Cidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}
	
}

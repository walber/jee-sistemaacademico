package br.com.grupo4.projetoAcademico.model;

public enum Cidade {

	ABREU_E_LIMA("Abreu e Lima"), CAMARAGIBE("Camaragibe"), GOIANA("Goiana"), IGARASSU("Igarassu"), IPOJUCA(
			"Ipojuca"), MORENO("Moreno"), OLINDA(
					"Olinda"), RECIFE("Recife"), TIMBAUBA("Timba�ba"), VITORIA_SANTO_ANTAO("Vit�ria de Santo Ant�o");

	private String cidade;

	Cidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}
}
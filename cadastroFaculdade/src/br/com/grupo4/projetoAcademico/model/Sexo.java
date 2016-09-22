package br.com.grupo4.projetoAcademico.model;

public enum Sexo {

	MASCULINO('m'), FEMININO('f');

	private Character sexo;

	Sexo(Character sexo) {
		this.sexo = sexo;
	}

	public Character getSexo() {
		return sexo;
	}

}
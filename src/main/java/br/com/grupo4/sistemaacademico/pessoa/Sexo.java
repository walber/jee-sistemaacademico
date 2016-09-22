package br.com.grupo4.sistemaacademico.pessoa;

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

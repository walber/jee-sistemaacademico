package br.com.grupo4.sistemaacademico.pessoa;

public enum TipoPessoa {
	
	ALUNO("Aluno"),
	PROFESSOR("Professor");
	
	private String tipo;
	
	TipoPessoa(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
}

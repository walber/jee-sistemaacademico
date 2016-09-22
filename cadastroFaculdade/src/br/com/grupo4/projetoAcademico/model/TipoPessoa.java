package br.com.grupo4.projetoAcademico.model;

public enum TipoPessoa {
	
	ALUNO("aluno"),
	PROFESSOR("professor");
	
	private String tipo;
	
	TipoPessoa(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
}

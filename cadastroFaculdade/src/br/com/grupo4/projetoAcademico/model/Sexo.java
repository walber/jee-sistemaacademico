package br.com.grupo4.projetoAcademico.model;

public enum Sexo {

	MASCULINO(1), FEMININO(2);

	private final int sexo;

	Sexo(int sexo) {
		this.sexo = sexo;
	}

	public int getSexo() {
		return sexo;
	}
	
	public static Sexo fromCode(int code) throws Exception {
        if ( code ==1 ) {
            return MASCULINO;
        }
        if ( code == 2) {
            return FEMININO;
        }
        else {
        	throw new Exception("O Codigo de Sexo indicado não foi reconhecido.");
        }
    }

}
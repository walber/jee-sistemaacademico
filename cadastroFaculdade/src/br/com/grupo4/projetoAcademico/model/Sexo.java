package br.com.grupo4.projetoAcademico.model;

public enum Sexo {

	M("M"), F("F");

	private final String sexo;

	Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
	
	public static Sexo fromCode(String code) throws Exception {
        if ( code.equals("M") || code.equals("m")) {
            return M;
        }
        if ( code.equals("F") || code.equals("f")) {
            return F;
        }
        else {
        	throw new Exception("O Codigo de Sexo indicado não foi reconhecido.");
        }
    }

}
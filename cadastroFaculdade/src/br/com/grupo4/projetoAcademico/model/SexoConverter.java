package br.com.grupo4.projetoAcademico.model;

import javax.persistence.AttributeConverter;

public class SexoConverter implements AttributeConverter<String, Sexo> {

	@Override
	public Sexo convertToDatabaseColumn(String arg0) {
        try {
			return Sexo.fromCode( arg0 );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public String convertToEntityAttribute(Sexo arg0) {

		if ( arg0 == null ) {
            return null;
        }

        return arg0.getSexo();
	}

	

}

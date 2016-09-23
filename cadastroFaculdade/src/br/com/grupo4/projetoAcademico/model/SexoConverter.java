package br.com.grupo4.projetoAcademico.model;

import javax.persistence.AttributeConverter;

public class SexoConverter implements AttributeConverter<Integer, Sexo> {

	@Override
	public Sexo convertToDatabaseColumn(Integer arg0) {
        try {
			return Sexo.fromCode( arg0 );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public Integer convertToEntityAttribute(Sexo arg0) {

		if ( arg0 == null ) {
            return -1;
        }

        return arg0.getSexo();
	}

	

}

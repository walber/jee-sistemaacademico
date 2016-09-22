package br.com.grupo4.projetoAcademico.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "titulacao")
public class Titulacao implements Serializable {

	private static final long serialVersionUID = 5804101746424966857L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "nome_titulo", length = 50, nullable = false)
	private String nomeTitulo;

	@OneToMany(mappedBy = "titulacao", fetch = FetchType.LAZY)
	private Set<Professor> professores = new HashSet<>();
	
	/*
	 * Getters e setters
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTitulo() {
		return nomeTitulo;
	}

	public void setNomeTitulo(String nomeTitulo) {
		this.nomeTitulo = nomeTitulo;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}
	
	/*
	 * hashCode() e equals()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeTitulo == null) ? 0 : nomeTitulo.hashCode());
		result = prime * result + ((professores == null) ? 0 : professores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulacao other = (Titulacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeTitulo == null) {
			if (other.nomeTitulo != null)
				return false;
		} else if (!nomeTitulo.equals(other.nomeTitulo))
			return false;
		if (professores == null) {
			if (other.professores != null)
				return false;
		} else if (!professores.equals(other.professores))
			return false;
		return true;
	}

}
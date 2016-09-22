package br.com.grupo4.sistemaacademico.aluno;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.grupo4.sistemaacademico.pessoa.Pessoa;
import br.com.grupo4.sistemaacademico.professor.Professor;
import br.com.grupo4.sistemaacademico.publicacao.Publicacao;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 6238828153614651759L;

	/*
	 * Gerada pelo sistema, iniciando de 1000 e incrementando em 100
	 */
	@TableGenerator(name = "aluno_matricula", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL",
			pkColumnValue = "ADDR_GEN", initialValue = 1000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "aluno_matricula")
	@Column(nullable = false, unique = true)
	private Integer matricula;

	@ManyToOne
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;

	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	private Set<Publicacao> publicacoes = new HashSet<>();

	/*
	 * Getters e setters
	 */

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(Set<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}

	/*
	 * hashCode() e equals()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((publicacoes == null) ? 0 : publicacoes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (publicacoes == null) {
			if (other.publicacoes != null)
				return false;
		} else if (!publicacoes.equals(other.publicacoes))
			return false;
		return true;
	}

}

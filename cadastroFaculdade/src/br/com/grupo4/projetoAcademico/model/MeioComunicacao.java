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
@Table(name = "meio_comunicacao")
public class MeioComunicacao implements Serializable {

	private static final long serialVersionUID = -3954175723820452287L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 100, nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "meioComunicacao", fetch = FetchType.LAZY)
	private Set<Publicacao> publicacoes = new HashSet<>();
	
	/*
	 * Getters e setters
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publicacoes == null) ? 0 : publicacoes.hashCode());
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
		MeioComunicacao other = (MeioComunicacao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (publicacoes == null) {
			if (other.publicacoes != null)
				return false;
		} else if (!publicacoes.equals(other.publicacoes))
			return false;
		return true;
	}

}

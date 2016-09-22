package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface ProfessorDAO {
	public void inserir(Professor professor);
	public List<Professor> listar();
	public List<Endereco> getEnderecos(int id);
	public List<Telefone> getTelefones(int id);
	public Professor getProfessorById(int id);
	public void atualizar(Professor professor);
	public int getProfessorId(String cpf);
	
}

package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface AlunoDAO {
	public void inserir(Aluno aluno);
	public List<Aluno> listar();
	public List<Endereco> getEnderecos();
	public List<Telefone> getTelefones();
	public void remover(int id);
}

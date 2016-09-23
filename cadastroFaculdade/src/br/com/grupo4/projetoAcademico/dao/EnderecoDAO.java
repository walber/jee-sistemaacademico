package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface EnderecoDAO {

	public void inserir(Endereco endereco);
	public List<Endereco> listar();
	public void atualizar(Endereco endereco);
	public void remover(int id);
}

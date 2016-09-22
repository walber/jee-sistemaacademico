package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface PessoaDAO {

	public void inserir(Pessoa pessoa);
	public List<Pessoa> listar();
	public List<Endereco> getEnderecos();
	public List<Telefone> getTelefones();
	
}

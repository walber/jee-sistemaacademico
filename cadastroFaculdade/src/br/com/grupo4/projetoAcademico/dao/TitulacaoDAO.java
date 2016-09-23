package br.com.grupo4.projetoAcademico.dao;

import java.util.List;
import br.com.grupo4.projetoAcademico.model.Titulacao;

public interface TitulacaoDAO {

	public void inserir(Titulacao titulacao);
	public List<Titulacao> listar();
	public void atualizar(Titulacao titulacao);
	public void remover(int id);
	public Titulacao getTitulacaoById(int id);
}

package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class EnderecoDAOImpl implements EnderecoDAO {
	
	private SessionFactory sessionFactory;
	private static EnderecoDAOImpl instance;
	
	public static EnderecoDAOImpl getInstance(){
		if (instance == null){
			instance = new EnderecoDAOImpl();
		}
		
		return instance;
	}
	
	private EnderecoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void inserir(Endereco endereco) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			System.out.println("Ta chegnado em inserir de endereco");
			session.getTransaction().begin();
			session.save(endereco);
			session.getTransaction().commit();
			
		}
		else{
			System.out.println("Nao ta open");
		}
	}

	@Override
	public List<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

}

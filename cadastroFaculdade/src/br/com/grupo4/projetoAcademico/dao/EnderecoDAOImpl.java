package br.com.grupo4.projetoAcademico.dao;

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

}

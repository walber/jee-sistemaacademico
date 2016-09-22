package br.com.grupo4.projetoAcademico.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class TelefoneDAOImpl implements TelefoneDAO {

	private SessionFactory sessionFactory;
	private static TelefoneDAOImpl instance;
	
	public static TelefoneDAOImpl getInstance(){
		if (instance == null){
			instance = new TelefoneDAOImpl();
		}
		
		return instance;
	}
	
	private TelefoneDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void inserir(Telefone telefone) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			System.out.println("Ta chegnado em inserir de telefone");
			session.getTransaction().begin();
			session.save(telefone);
			session.getTransaction().commit();
			
		}
		else{
			System.out.println("Nao ta open");
		}
	}

	
}

package br.com.grupo4.projetoAcademico.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.model.Titulacao;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class TitulacaoDAOImpl implements TitulacaoDAO {

	private SessionFactory sessionFactory;
	private static TitulacaoDAOImpl instance;
	
	public static TitulacaoDAOImpl getInstance(){
		if (instance == null){
			instance = new TitulacaoDAOImpl();
		}
		
		return instance;
	}
	
	private TitulacaoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void inserir(Titulacao titulacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			System.out.println("Ta chegnado em inserir de titulacao");
			session.getTransaction().begin();
			session.save(titulacao);
			session.getTransaction().commit();
			
		}
		else{
			System.out.println("Nao ta open");
		}
	}
}

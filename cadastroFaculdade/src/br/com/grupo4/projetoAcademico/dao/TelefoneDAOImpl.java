package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
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
//			System.out.println("Ta chegnado em inserir de telefone");
			session.getTransaction().begin();
			session.save(telefone);
			session.getTransaction().commit();
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@Override
	@Transactional
	public List<Telefone> listar() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Telefone.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void atualizar(Telefone telefone) {
		sessionFactory.getCurrentSession().update(telefone);
		
	}

	@Override
	public void remover(int id) {
		sessionFactory.getCurrentSession().delete(this.getTelefoneById(id));
		
	}

	@Override
	public Telefone getTelefoneById(int id) {
		return (Telefone) sessionFactory.getCurrentSession().get(Telefone.class, id); 
	}

	
}

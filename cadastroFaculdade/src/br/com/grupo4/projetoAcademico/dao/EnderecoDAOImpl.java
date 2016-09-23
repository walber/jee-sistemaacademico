package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.projetoAcademico.model.Aluno;
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
	@Transactional
	public void inserir(Endereco endereco) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de endereco");
			session.getTransaction().begin();
			session.save(endereco);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Endereco> listar() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Endereco.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void atualizar(Endereco endereco) {
		sessionFactory.getCurrentSession().update(endereco);
	}

	@Override
	@Transactional
	public void remover(int id) {
		sessionFactory.getCurrentSession().delete(this.getEnderecoById(id));
	}
	
	@Override
	@Transactional
	public Endereco getEnderecoById(int id) {
		return (Endereco) sessionFactory.getCurrentSession().get(Endereco.class, id); 
	}
	
	// Precisamos de um metodo getEnderecoId(chave_primaria/candidata) ?

}

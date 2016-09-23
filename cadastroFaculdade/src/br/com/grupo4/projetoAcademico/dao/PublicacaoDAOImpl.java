package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Publicacao;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class PublicacaoDAOImpl implements PublicacaoDAO {

	private SessionFactory sessionFactory;
	private static PublicacaoDAOImpl instance;
	
	public static PublicacaoDAOImpl getInstance(){
		if (instance == null){
			instance = new PublicacaoDAOImpl();
		}
		
		return instance;
	}
	
	private PublicacaoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	@Transactional
	public void inserir(Publicacao publicacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			session.save(publicacao);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Publicacao> listar() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Publicacao.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void atualizar(Publicacao publicacao) {
		sessionFactory.getCurrentSession().update(publicacao);

	}

	@Override
	@Transactional
	public void remover(int id) {
		sessionFactory.getCurrentSession().delete(this.getEnderecoById(id));
	}

	@Override
	@Transactional
	public Publicacao getEnderecoById(int id) {
		return (Publicacao) sessionFactory.getCurrentSession().get(Publicacao.class, id); 
	}

}

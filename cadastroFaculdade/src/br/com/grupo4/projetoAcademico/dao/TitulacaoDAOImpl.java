package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
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
//			System.out.println("Ta chegnado em inserir de titulacao");
			session.getTransaction().begin();
			session.save(titulacao);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@Override
	@Transactional
	public List<Titulacao> listar() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Titulacao.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void atualizar(Titulacao titulacao) {
		sessionFactory.getCurrentSession().update(titulacao);		
	}

	@Override
	public void remover(int id) {
		sessionFactory.getCurrentSession().delete(this.getTitulacaoById(id));
		
	}

	@Override
	public Titulacao getTitulacaoById(int id) {
		return (Titulacao) sessionFactory.getCurrentSession().get(Titulacao.class, id); 

	}
}

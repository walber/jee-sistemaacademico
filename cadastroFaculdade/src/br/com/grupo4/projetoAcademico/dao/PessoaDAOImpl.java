package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class PessoaDAOImpl implements PessoaDAO {

	private SessionFactory sessionFactory;
	private static PessoaDAOImpl instance;
	
	public static PessoaDAOImpl getInstance(){
		if (instance == null){
			instance = new PessoaDAOImpl();
		}
		
		return instance;
	}
	
	private PessoaDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	@Override
	@Transactional
	public void inserir(Pessoa pessoa) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			session.save(pessoa);
			session.getTransaction().commit();
			
		}
		else{
			System.out.println("Nao ta open");
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Pessoa> listar() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class);
		return criteria.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Endereco> getEnderecos(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class, "pessoa");
		criteria.createCriteria("endereco", "e");
		criteria.add(Restrictions.eq("e.pessoa_id", id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Telefone> getTelefones(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class, "pessoa");
		criteria.createCriteria("telefone", "t");
		criteria.add(Restrictions.eq("t.pessoa_id", id));
		return criteria.list();
	}

	@Override
	@Transactional
	public void atualizar(Pessoa pessoa) {
		sessionFactory.getCurrentSession().update(pessoa);
		
	}

	@Override
	@Transactional
	public Pessoa getPessoaById(int id) {
		return (Pessoa) sessionFactory.getCurrentSession().get(Pessoa.class, id); 
	}

	@Override
	@Transactional
	public int getPessoaId(String cpf) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class, "aluno");
		criteria.add(Restrictions.eq("pessoa.cpf", cpf));
		criteria.setMaxResults(1);
		return (int) criteria.uniqueResult();
	}

}

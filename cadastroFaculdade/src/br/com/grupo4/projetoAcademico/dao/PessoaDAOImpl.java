package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	@Override
	public List<Pessoa> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> getEnderecos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Telefone> getTelefones() {
		// TODO Auto-generated method stub
		return null;
	}

}

package br.com.grupo4.sistemaacademico;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.grupo4.sistemaacademico.util.HibernateUtil;

public class Teste {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
	}

}

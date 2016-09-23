package br.com.grupo4.projetoAcademico.main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class TesteCriarTabelas {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		transaction.commit();
	}
	

}

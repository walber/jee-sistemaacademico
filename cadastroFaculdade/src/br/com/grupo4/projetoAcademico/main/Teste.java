package br.com.grupo4.projetoAcademico.main;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.grupo4.projetoAcademico.dao.ProfessorDAOImpl;
import br.com.grupo4.projetoAcademico.model.Cidade;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Sexo;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.model.TipoPessoa;
import br.com.grupo4.projetoAcademico.model.Titulacao;
import br.com.grupo4.projetoAcademico.service.ProfessorService;
import br.com.grupo4.projetoAcademico.service.ProfessorServiceImpl;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;




public class Teste {
	
	
	
	private ProfessorService prof;
	
	
	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = session.beginTransaction();
//		transaction.commit();
//		
		
		Teste t = new Teste();
		t.inserirProfessor();
		
	}
	
	public void inserirProfessor(){
		
		
		Professor p = new Professor();
		p.setCpf("1324");
		p.setNome("raimundo");
		p.setSexo(Sexo.MASCULINO);

		p.setInstituicao("ufpe");
		p.setDataAdmissao(new Date(System.currentTimeMillis()));
		
		
		HashSet<Endereco> end = new HashSet<Endereco>();
		Endereco nend = new Endereco();
		nend.setBairro("Bairro Novo");
		nend.setCidade(Cidade.OLINDA);
		nend.setLogradouro("rua 0");
		nend.setNumero(123);
		nend.setUf("PE");
		nend.setPessoa(p);
		end.add(nend);
//		p.setEndereco(end);
		
		
		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero(36211480);
		HashSet<Telefone> telefoneHS= new HashSet<Telefone>();
		telefone.setPessoa(p);
//		telefoneHS.add(telefone);
		
		
		Titulacao titulo = new Titulacao();
		titulo.setNomeTitulo("Professor");
		Set<Professor> conjuntoProfessores =  titulo.getProfessores();
		conjuntoProfessores.add(p);
		titulo.setProfessores(conjuntoProfessores);
		p.setTitulacao(titulo);
		
		
		ProfessorDAOImpl.getInstance().inserir(p);
		
		
//		prof.inserir(p);
	}
	
	
}

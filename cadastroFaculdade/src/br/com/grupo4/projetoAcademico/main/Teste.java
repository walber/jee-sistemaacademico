package br.com.grupo4.projetoAcademico.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.grupo4.projetoAcademico.dao.EnderecoDAOImpl;
import br.com.grupo4.projetoAcademico.dao.PessoaDAOImpl;
import br.com.grupo4.projetoAcademico.dao.ProfessorDAOImpl;
import br.com.grupo4.projetoAcademico.dao.TelefoneDAOImpl;
import br.com.grupo4.projetoAcademico.dao.TitulacaoDAOImpl;
import br.com.grupo4.projetoAcademico.model.Cidade;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Sexo;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.model.Titulacao;

public class Teste {

	public static void main(String[] args) {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = session.beginTransaction();
		// transaction.commit();
		//

		Teste t = new Teste();
		t.inserirPessoa();

	}

	public void inserirProfessor() {

		Professor p = new Professor();
		p.setCpf("10153823470");
		p.setNome("raimundo");
		p.setSexo(Sexo.M);
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
		// p.setEndereco(end);

		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero(36211480);
		// HashSet<Telefone> telefoneHS= new HashSet<Telefone>();
		telefone.setPessoa(p);
		// telefoneHS.add(telefone);

		Titulacao titulo = new Titulacao();
		titulo.setNomeTitulo("Professor");
		Set<Professor> conjuntoProfessores = titulo.getProfessores();
		conjuntoProfessores.add(p);
		titulo.setProfessores(conjuntoProfessores);
		// p.setTitulacao(titulo);

		ProfessorDAOImpl.getInstance().inserir(p);
		EnderecoDAOImpl.getInstance().inserir(nend);
		TelefoneDAOImpl.getInstance().inserir(telefone);
		TitulacaoDAOImpl.getInstance().inserir(titulo);

		// prof.inserir(p);
	}

	public void inserirPessoa() {

		Pessoa a = new Pessoa();
		a.setCpf("1015382470");
		a.setNome("paulo");
		a.setSexo(Sexo.M);

		Endereco nend = new Endereco();
		nend.setBairro("Bairro Novo");
		nend.setCidade(Cidade.OLINDA);
		nend.setLogradouro("rua 2");
		nend.setNumero(123);
		nend.setUf("PE");
		nend.setPessoa(a);

		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero(36211482);
		telefone.setPessoa(a);

		PessoaDAOImpl.getInstance().inserir(a);
		EnderecoDAOImpl.getInstance().inserir(nend);
		TelefoneDAOImpl.getInstance().inserir(telefone);

		// prof.inserir(p);
	}

}
package br.com.grupo4.projetoAcademico.service;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.dao.ProfessorDAO;
import br.com.grupo4.projetoAcademico.dao.ProfessorDAOImpl;

@Service
@ManagedBean
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	
	ProfessorDAO profDAO;
	
//	public void setProfessorDAO(ProfessorDAO profDAO) {
//		this.profDAO = profDAO;
//	}
	
	@Override
	public void inserir(Professor professor) {
		System.out.println("Birrlrllrlr");
		profDAO.inserir(professor);
	}
	

}

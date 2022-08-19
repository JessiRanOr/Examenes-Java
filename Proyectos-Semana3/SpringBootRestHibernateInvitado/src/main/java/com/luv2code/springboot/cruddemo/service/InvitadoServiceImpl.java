package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.InvitadoDAO;
import com.luv2code.springboot.cruddemo.entity.Invitado;

@Service
public class InvitadoServiceImpl implements InvitadoService {

	
	private InvitadoDAO invitadoDAO;
	//en el @Qualifier se indica cual va a implementar si el jdbc o el hibernate
	@Autowired
	public InvitadoServiceImpl(@Qualifier("invitadoDAOJdbcImpl") InvitadoDAO theInvitadoDAO) {
		invitadoDAO = theInvitadoDAO;
	}
	
	@Override
	@Transactional
	public List<Invitado> findAll() {
		return invitadoDAO.findAll();
	}

	@Override
	@Transactional
	public Invitado findById(int theId) {
		return invitadoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Invitado theInvitado) {
		invitadoDAO.save(theInvitado);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		invitadoDAO.deleteById(theId);
	}

}
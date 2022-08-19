package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Invitado;

public interface InvitadoService {

	public List<Invitado> findAll();
	
	public Invitado findById(int theId);
	
	public void save(Invitado theInvitado);
	
	public void deleteById(int theId);
	
}

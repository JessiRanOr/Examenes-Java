package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Invitado;

public interface InvitadoDAO {

	List<Invitado> findAll();
	
	Invitado findById(int theId);
	
	void save(Invitado theInvitado);
	
	void deleteById(int theId);
	
}

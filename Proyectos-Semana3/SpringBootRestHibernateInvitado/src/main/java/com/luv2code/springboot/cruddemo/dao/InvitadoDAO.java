package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Invitado;

public interface InvitadoDAO {
	//pasame findAll y regresa una lista de empleado
	//public List<Invitado> findAll(); se puede quitar el public porque en la interface se sabe 
	//por default que son publicos
	List<Invitado> findAll();
	//pasame un findbyid y te regreso el empleado 
	Invitado findById(int theId);
	//pasame un empleado y no regresa nada 
	void save(Invitado theInvitado);
	//pasame un id y no regresa nada 
	void deleteById(int theId);
	
}

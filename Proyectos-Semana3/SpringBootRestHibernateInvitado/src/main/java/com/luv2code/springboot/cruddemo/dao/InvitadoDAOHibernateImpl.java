package com.luv2code.springboot.cruddemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Invitado;
//capa de persistencia 
@Repository
public class InvitadoDAOHibernateImpl implements InvitadoDAO {

	// define field for entitymanager de springboot
	private EntityManager entityManager;
		
	// set up constructor injection 
	@Autowired
	public InvitadoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Invitado> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Invitado> theQuery =
				currentSession.createQuery("from Invitado", Invitado.class);
		
		// execute query and get result list
		List<Invitado> invitados = theQuery.getResultList();
		
		// return the results		
		return invitados;
	}


	@Override
	public Invitado findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Invitado theInvitado =
				currentSession.get(Invitado.class, theId);
		
		// return the employee
		return theInvitado;
	}


	@Override
	public void save(Invitado theInvitado) {
		//System.out.println(invitado);
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theInvitado);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Invitado where id=:invitadoId");
		theQuery.setParameter("invitadoId", theId);
		
		theQuery.executeUpdate();
	}

}








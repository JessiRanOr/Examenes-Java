package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Invitado;

@Repository
public class InvitadoDAOJdbcImpl implements InvitadoDAO {

	@Autowired
	DataSource dataSource;

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	@Override
	public List<Invitado> findAll() {
		System.out.println("Implementación DAO con JDBC: "+ dataSource);
		
		List<Invitado> listaInvitados = new ArrayList<>();
		
		try {
			myConn = dataSource.getConnection();
			// create sql statement
			String sql = "select * from employee";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
										
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
							
				// create new student object
				Invitado tempInvitado = new Invitado(id, nombre, apellido, email);
							
				// add it to the list of students
				listaInvitados.add(tempInvitado);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaInvitados;
	}

	@Override
	public Invitado findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Invitado theInvitado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}

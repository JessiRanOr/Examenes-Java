package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Invitado;
//capa de persistencia
@Repository
public class InvitadoDAOJdbcImpl implements InvitadoDAO {
//inyectado por Spring
	@Autowired
	DataSource dataSource;

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	@Override
	public List<Invitado> findAll() {
		System.out.println("Implementación DAO con JDBC: "+ dataSource);
		
		List<Invitado> listaInvitados = new ArrayList<>();
		
		try (	Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from invitado");
			){
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				
				// create new invitado object
				Invitado tempInvitado = new Invitado(id, nombre, apellido, email);
				
				// add it to the list of invitado
				listaInvitados.add(tempInvitado);				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaInvitados;	
	}

	@Override
	public Invitado findById(int theId) {
		
		////
		////
		System.out.println("Implementacion DAO con JDBC"+ dataSource);
		Invitado theInvitado = null;
		try (
				Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt =myConn.prepareStatement("select * from invitado where id=?");
				){
					myStmt.setInt(1, theId);
					try(ResultSet myRs = myStmt.executeQuery()){
						if(myRs.next()) {
							String nombre = myRs.getString("nombre");
							String apellido = myRs.getString("apellido");
							String email = myRs.getString("email");
							
							theInvitado = new Invitado(theId, nombre, apellido, email);
							
							}
						}
					}catch(SQLException e) {
						e.printStackTrace();
						
					}
					return theInvitado;
					
					
		}
		////
		////
		
		

	 // agregar o actualizar un invitado
	 // id=0 --- inserta 
	 //id != 0---Actualiza 

	@Override
	public void save(Invitado theInvitado) {
		
		if (theInvitado.getId() == 0) {
			System.out.println("Inserta");
			try(Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement("insert into invitado "
					   + "(nombre, apellido, email) "
					   + "values (?, ?, ?)")){
				
				myStmt.setString(1, theInvitado.getNombre());
				myStmt.setString(2, theInvitado.getApellido());
				myStmt.setString(3, theInvitado.getEmail());
				
				myStmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}	

		} else {
			
			System.out.println("Actualiza");
			try(Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement("update invitado "
							+ "set nombre=?, apellido=?, email=? "
							+ "where id=?")){
				
				myStmt.setString(1, theInvitado.getNombre());
				myStmt.setString(2, theInvitado.getApellido());
				myStmt.setString(3, theInvitado.getEmail());
				myStmt.setInt(4, theInvitado.getId());
				
				myStmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
		}			
	
	}
	
	//Eliminar invitado
	@Override
	public void deleteById(int theId) {
		System.out.println("Borra");
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement("delete from invitado where id=?")){
			int invitadoId = theId;
			myStmt.setInt(1, invitadoId);
			myStmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}	



	}
}
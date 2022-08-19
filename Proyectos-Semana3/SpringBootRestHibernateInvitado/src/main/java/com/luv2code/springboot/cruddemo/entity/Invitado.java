package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invitado")
public class Invitado {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	//MAPEA 
	@Column(name="nombre")//nivel base de datos
	private String nombre;//nivel de objetos
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
		
	// define constructors
	
	public Invitado() {
		
	}

	public Invitado(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	public Invitado(int id,String nombre, String apellido, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// define metodo tostring
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}
		
}












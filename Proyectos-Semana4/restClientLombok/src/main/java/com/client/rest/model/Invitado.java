package com.client.rest.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor 
@Data
public class Invitado {

	private int id;
	private String nombre;
	private String apellido;	
	private String email;
	
}
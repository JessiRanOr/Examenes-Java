package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVITADOS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invitado {

    @Id
    @Column(name = "INVITADO_ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "DOB")
    private String dob;
    
}

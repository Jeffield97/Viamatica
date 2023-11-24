package com.viamatica.springboot.Entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Persona")

public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    private String Nombres;
    private String Apellidos;
    private String Identificacion;
    private Date FechaNacimiento;

}

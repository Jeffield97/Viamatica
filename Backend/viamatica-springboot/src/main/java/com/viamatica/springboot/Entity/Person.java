package com.viamatica.springboot.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persona")

public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    private String Nombres;
    private String Apellidos;
    private String Identificacion;
    private Date FechaNacimiento;
    //Relation with User
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<User> usuarios;


}

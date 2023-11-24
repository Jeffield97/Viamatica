package com.viamatica.springboot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String Username;
    private String Password;
    private String Mail;
    private String SessionActive;
    //Relation with Person table
    @ManyToOne
    @JoinColumn(name = "Persona_idPersona2")
    private Person Persona;
    private String Status;
    @ManyToMany

    //Relation with Rol table
    @JoinTable(
            name = "rol_usuarios",
            joinColumns = @JoinColumn(name = "usuarios_idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "Rol_idRol")
    )
    private List<Rol> roles;
}

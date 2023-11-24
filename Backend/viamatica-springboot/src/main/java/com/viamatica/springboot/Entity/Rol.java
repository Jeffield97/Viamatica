package com.viamatica.springboot.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String RolName;
    //Relation with User
    @ManyToMany(mappedBy = "roles")
    private List<User> usuarios;

    //Relation with RolOptions
    @ManyToMany
    @JoinTable(
            name = "rol_rolOpciones",
            joinColumns = @JoinColumn(name = "Rol_idRol"),
            inverseJoinColumns = @JoinColumn(name = "RolOpciones_idOpcion")
    )
    private List<RolOptions> opciones;
}

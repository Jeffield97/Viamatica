package com.viamatica.springboot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "RolOpciones")
public class RolOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpcion;
    private String NombreOpcion;
    //Relation with Rol
    @ManyToMany(mappedBy = "opciones")
    private List<Rol> roles;
}

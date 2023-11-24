package com.viamatica.springboot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime FechaIngreso;
    private LocalDateTime FechaCierre;

    //Relation with User table
    @ManyToOne
    @JoinColumn(name = "usuarios_idUsuario")
    private User usuarios;
}

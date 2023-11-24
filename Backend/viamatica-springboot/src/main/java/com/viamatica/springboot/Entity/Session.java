package com.viamatica.springboot.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime FechaIngreso;
    private LocalDateTime fechaCierre;

    //Relation with User table
    @ManyToOne
    @JoinColumn(name = "usuarios_idUsuario")
    private User usuarios;
}

package com.viamatica.springboot.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String Password;
    private String Mail;
    @JsonIgnore

    private String sessionActive;
    @JsonIgnore

    private Integer failedLoginAttemps;
    //Relation with Person table
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Persona_idPersona2")
    private Person persona;
    private String status;

    //Relation with Rol table
    @ManyToMany
    @JoinTable(
            name = "rol_usuarios",
            joinColumns = @JoinColumn(name = "usuarios_idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "Rol_idRol")
    )
    private List<Rol> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

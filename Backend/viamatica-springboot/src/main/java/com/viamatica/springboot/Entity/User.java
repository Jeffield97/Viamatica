package com.viamatica.springboot.Entity;

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
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(unique = true)
    private String username;
    private String Password;
    private String Mail;
    private String sessionActive;
    private Integer failedLoginAttemps;
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

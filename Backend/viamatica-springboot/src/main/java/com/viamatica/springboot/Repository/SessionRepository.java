package com.viamatica.springboot.Repository;

import com.viamatica.springboot.Entity.Session;
import com.viamatica.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session,Integer> {
    Optional<Session> findByUsuariosAndFechaCierreIsNull(User user);

}

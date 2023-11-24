package com.viamatica.springboot.Repository;

import com.viamatica.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String Username);
    boolean existsByUsername(String username);


}

package com.viamatica.springboot.Service;

import com.viamatica.springboot.Entity.User;
import com.viamatica.springboot.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudService {
    final private UserRepository userRepository;
    @EntityGraph(attributePaths = "persona")
    public List<User> getUsersWithPerson() {
        return userRepository.findAll();
    }

}

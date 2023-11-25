package com.viamatica.springboot.Controller;

import com.viamatica.springboot.Entity.User;
import com.viamatica.springboot.Service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class CrudController {
    final private CrudService crudService;

    @GetMapping("/all")
    public List<User> getUsersWithPerson() {
        return crudService.getUsersWithPerson();
    }
}

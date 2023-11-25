package com.viamatica.springboot.Repository;

import com.viamatica.springboot.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}

package com.homework.repository;

import com.homework.model.Person;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByEmail(String email);
}

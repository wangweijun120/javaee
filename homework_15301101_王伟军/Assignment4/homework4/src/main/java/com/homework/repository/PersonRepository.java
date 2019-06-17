package com.homework.repository;

import com.homework.model.Person;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wangweijun
 */
@CacheConfig(cacheNames = "users")
public interface PersonRepository extends JpaRepository<Person, Long>{
    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    List<Person> findByEmail(String email);
}

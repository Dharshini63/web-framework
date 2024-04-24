package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springapp.model.dharshiniPerson;

public interface dharshiniPersonRepo extends JpaRepository<dharshiniPerson, Integer> {
    @Query("SELECT p FROM Person p WHERE age=?1")
    List<dharshiniPerson> findByAge(int age);
}

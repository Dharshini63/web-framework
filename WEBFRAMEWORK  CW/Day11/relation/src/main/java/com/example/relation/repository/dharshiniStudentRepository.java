package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relation.model.dharshiniStudent;

@Repository
public interface dharshiniStudentRepository extends JpaRepository<dharshiniStudent,Integer>{
    
}

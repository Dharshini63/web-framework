package com.example.day5cw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5cw2.model.dharshiniEmployee;


@Repository
public interface dharshiniEmployeeRepo extends JpaRepository<dharshiniEmployee,Integer>{
    
}

package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relation.model.dharshiniStudentInfo;

@Repository
public interface dharshiniStudentInfoRepository extends JpaRepository<dharshiniStudentInfo,Integer>{
    
}
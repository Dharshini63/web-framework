package com.example.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirection.model.dharshiniStudentInfo;

@Repository
public interface dharshiniStudentInfoRepository extends JpaRepository<dharshiniStudentInfo,Integer>{
    
}
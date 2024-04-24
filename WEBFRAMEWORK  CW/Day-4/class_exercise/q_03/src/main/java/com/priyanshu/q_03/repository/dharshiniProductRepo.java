package com.priyanshu.q_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanshu.q_03.model.Product;

@Repository
public interface dharshiniProductRepo extends JpaRepository<dharshiniProduct, Integer> {

}

package com.priyanshu.q_03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshu.q_03.model.Product;
import com.priyanshu.q_03.repository.ProductRepo;

@Service
public class dharshiniProductService {

    @Autowired
    private dharshiniProductRepo productRepo;

    public dharshiniProduct addProduct(dharshiniProduct product) {
        return productRepo.save(product);
    }

    public List<dharshiniProduct> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<dharshiniProduct> getProductById(int productId) {
        return productRepo.findById(productId);
    }

}

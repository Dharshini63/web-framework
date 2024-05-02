package com.example.cw3.service;

import com.example.cw3.model.dayanandProduct;
import com.example.cw3.repository.dayanandProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private dayanandProductRepo productRepo;

    public List<dayanandProduct> getAllProducts() {
        return productRepo.findAll();
    }

    public dayanandProduct getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public dayanandProduct addProduct(dayanandProduct product) {
        return productRepo.save(product);
    }
}
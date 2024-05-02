package com.example.cw3.service;

import com.example.cw3.model.DharshiniProduct;
import com.example.cw3.repository.DharshiniProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DharshiniProductService {

    @Autowired
    private DharshiniProductRepo productRepo;

    public List<DharshiniProduct> getAllProducts() {
        return productRepo.findAll();
    }

    public DharshiniProduct getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public DharshiniProduct addProduct(DharshiniProduct product) {
        return productRepo.save(product);
    }
}
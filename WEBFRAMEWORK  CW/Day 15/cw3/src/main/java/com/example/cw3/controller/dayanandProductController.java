package com.example.cw3.controller;


import com.example.cw3.model.dayanandProduct;
import com.example.cw3.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class dayanandProductController {

    private static final Logger logger = LoggerFactory.getLogger(dayanandProductController.class);

    @Autowired
    private ProductService ProductService;

    @GetMapping
    public ResponseEntity<List<dayanandProduct>> getAllProducts() {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/products; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                "N/A", HttpStatus.OK.value(), "List of Products", "N/A");
        List<dayanandProduct> Products = ProductService.getAllProducts();
        return ResponseEntity.ok(Products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<dayanandProduct> getProductById(@PathVariable("id") int id) {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/products/{}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                id, HttpStatus.OK.value(), "Product details", "N/A");
        dayanandProduct Product = ProductService.getProductById(id);
        return ResponseEntity.ok(Product);
    }

    @PostMapping
    public ResponseEntity<dayanandProduct> addProduct(@RequestBody dayanandProduct Product) {
        logger.info("FINISHED PROCESSING : METHOD=POST; REQUESTURI=/products; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                Product, HttpStatus.CREATED.value(), "Product added successfully", "N/A");
        dayanandProduct savedProduct = ProductService.addProduct(Product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
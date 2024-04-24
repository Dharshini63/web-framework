package com.example.day6cw3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw3.model.dharshiniProduct;
import com.example.day6cw3.service.ChaturyaProductService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class dharshiniProductController {
    public ChaturyaProductService productService;
    public dharshiniProductController(ChaturyaProductService productService)
    {
        this.productService = productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<dharshiniProduct> postMethodName(@RequestBody dharshiniProduct product) {
        if(productService.postProduct(product))
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/product/{offset}/{pagesize}")
    public ResponseEntity<List<dharshiniProduct>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<dharshiniProduct> list = productService.pagination(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<dharshiniProduct>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<dharshiniProduct> list = productService.sortPagination(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<dharshiniProduct> getMethodName(@PathVariable("productId") int id) {
        dharshiniProduct product = productService.getProductById(id);
        if(product==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    
    
}

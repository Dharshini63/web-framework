package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.dharshiniProduct;
import com.example.day6cw3.repository.dharshiniProductRepo;

@Service
public class ChaturyaProductService {
    public dharshiniProductRepo productRepo;
    public ChaturyaProductService(dharshiniProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(dharshiniProduct product)
    {
        try{

            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<dharshiniProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<dharshiniProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public dharshiniProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}

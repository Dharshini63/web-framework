package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.dharshiniProduct;
import com.example.day5cw1.repository.dharshiniProductRepo;

@Service
public class ChaturyaProductService {
    public dharshiniProductRepo productRepo;
    public ChaturyaProductService(dharshiniProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(dharshiniProduct product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,dharshiniProduct product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public dharshiniProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}

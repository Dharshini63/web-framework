package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.dharshiniEmployee;
import com.example.day5cw2.repository.dharshiniEmployeeRepo;

@Service
public class ChaturyaEmployeeService {
    public dharshiniEmployeeRepo employeeRepo;
    public ChaturyaEmployeeService(dharshiniEmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(dharshiniEmployee employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,dharshiniEmployee employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public dharshiniEmployee getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}

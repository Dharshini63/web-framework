package com.example.day14ce1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day14ce1.model.DilipEmployee;
import com.example.day14ce1.repository.DilipEmployeeRepo;

@Service

public class DharshiniEmployeeService {
    @Autowired
    DilipEmployeeRepo employeeRepo;

    public DilipEmployee addEmployee(DilipEmployee employee)
    {
        return employeeRepo.save(employee);
    }

    public List<DilipEmployee> getEmployees()
    {
        return employeeRepo.findAll();
    }

    public Optional<DilipEmployee> getEmployee(Long employeeId)
    {
        return employeeRepo.findById(employeeId);
    }

}

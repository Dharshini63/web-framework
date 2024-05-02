package com.example.day14ce1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day14ce1.model.DilipPayroll;
import com.example.day14ce1.repository.DilipPayrollRepo;

@Service
public class DharshiniPayrollService {
    @Autowired
    DilipPayrollRepo payrollRepo;

    public DilipPayroll addPayroll(Long id,DilipPayroll payroll)
    {
        DilipPayroll avail = payrollRepo.findById(id).orElse(null);

        if(avail!=null){
            avail.setAmount(payroll.getAmount());
            avail.setNoOfDaysWorked(payroll.getNoOfDaysWorked());
        return payrollRepo.save(avail);
        }
        else 
        return null;
    }

    public Optional<DilipPayroll> getPayroll(Long employeeId)
    {
        return payrollRepo.findById(employeeId);
    }
}

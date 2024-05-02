package com.example.cw1.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cw1.model.DharshiniPerson;
import com.example.cw1.repository.DharshiniPersonRepo;

@Service
public class DharshiniPersonService {
    @Autowired
    private DharshiniPersonRepo repo;

    public DharshiniPerson createPerson(DharshiniPerson person) {
        return repo.save(person);
    }

    public List<DharshiniPerson> getAllPersons() {
        return repo.findAll();
    }
}

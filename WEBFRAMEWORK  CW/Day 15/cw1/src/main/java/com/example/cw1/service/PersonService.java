package com.example.cw1.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cw1.model.dayanandPerson;
import com.example.cw1.repository.dayanandPersonRepo;

@Service
public class PersonService {
    @Autowired
    private dayanandPersonRepo repo;

    public dayanandPerson createPerson(dayanandPerson person) {
        return repo.save(person);
    }

    public List<dayanandPerson> getAllPersons() {
        return repo.findAll();
    }
}

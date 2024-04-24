package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.dharshiniPerson;
import com.example.springapp.repository.dharshiniPersonRepo;

@Service
public class dharshiniPersonService {
    public dharshiniPersonRepo personRepo;

    public dharshiniPersonService(dharshiniPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public boolean savePerson(dharshiniPerson person) {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<dharshiniPerson> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}

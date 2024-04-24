package com.example.relation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relation.model.dharshiniStudent;
import com.example.relation.repository.dharshiniStudentRepository;

@Service
public class dharshiniStudentService {
    public dharshiniStudentRepository studentRepository;
    public dharshiniStudentService(dharshiniStudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public dharshiniStudent saveStudent(dharshiniStudent student)
    {
        return studentRepository.save(student);
    }
    public List<dharshiniStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}

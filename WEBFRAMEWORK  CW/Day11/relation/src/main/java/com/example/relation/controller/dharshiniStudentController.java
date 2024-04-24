package com.example.relation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.relation.model.dharshiniStudent;
import com.example.relation.service.dharshiniStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class dharshiniStudentController {
    public dharshiniStudentService studentService;
    public dharshiniStudentController(dharshiniStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/student")
    public dharshiniStudent postMethodName(@RequestBody dharshiniStudent student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/api/student")
    public List<dharshiniStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}

package com.example.bidirection.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bidirection.model.dharshiniStudent;
import com.example.bidirection.model.dharshiniStudentInfo;
import com.example.bidirection.service.dharshiniStudentService;
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
    @PostMapping("/api/poststudent")
    public dharshiniStudent postMethodName(@RequestBody dharshiniStudent student) {
        return studentService.saveStudent(student);
    }
    @PostMapping("/api/poststudentinfo")
    public dharshiniStudentInfo postMethodName(@RequestBody dharshiniStudentInfo studentInfo) {
        return studentService.saveStudentInfo(studentInfo);
    }
    @GetMapping("/api/student")
    public List<dharshiniStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}
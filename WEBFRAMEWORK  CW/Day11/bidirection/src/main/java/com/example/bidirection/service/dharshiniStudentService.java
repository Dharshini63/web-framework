package com.example.bidirection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirection.model.dharshiniStudent;
import com.example.bidirection.model.dharshiniStudentInfo;
import com.example.bidirection.repository.dharshiniStudentInfoRepository;
import com.example.bidirection.repository.dharshiniStudentRepository;

@Service
public class dharshiniStudentService {
    public dharshiniStudentRepository studentRepository;
    public dharshiniStudentInfoRepository studentInfoRepository;
    public dharshiniStudentService(dharshiniStudentRepository studentRepository,dharshiniStudentInfoRepository studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public dharshiniStudent saveStudent(dharshiniStudent student)
    {
        return studentRepository.save(student);
    }
    public dharshiniStudentInfo saveStudentInfo(dharshiniStudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<dharshiniStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}

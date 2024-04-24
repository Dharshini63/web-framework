package com.example.day6cw2.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw2.model.dharshiniStudent;
import com.example.day6cw2.repository.dharshiniStudentRepo;

@Service
public class ChaturyaStudentService {
    public dharshiniStudentRepo studentRepo;
    public ChaturyaStudentService(dharshiniStudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }
    public boolean postStudent(dharshiniStudent student)
    {
        try{

            studentRepo.save(student);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<dharshiniStudent> paginationStudents(int pageno,int size)
    {
        return studentRepo.findAll(PageRequest.of(pageno, size)).getContent();
    }
    public List<dharshiniStudent>  sortPaginationStudents(int pageno,int size,String field)
    {
        return studentRepo.findAll(PageRequest.of(pageno, size,Sort.by(field))).getContent();
    }
}

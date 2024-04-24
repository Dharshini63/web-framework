package com.example.day6cw2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw2.model.dharshiniStudent;
import com.example.day6cw2.service.ChaturyaStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class dharshiniStudentController {
    public ChaturyaStudentService studentService;
    public dharshiniStudentController(ChaturyaStudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/api/student")
    public ResponseEntity<dharshiniStudent> postMethodName(@RequestBody dharshiniStudent student) {
        if(studentService.postStudent(student))
        {
            return new ResponseEntity<>(student,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/student")
    public ResponseEntity<List<dharshiniStudent>> getMethodName(@RequestParam("pageNo") int pageno , @RequestParam("pageSize") int size) {
        List<dharshiniStudent> list = studentService.paginationStudents(pageno,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    
    @GetMapping("/api/student/sort")
    public ResponseEntity<List<dharshiniStudent>> getsortPagination(@RequestParam("pageNo") int pageno , @RequestParam("pageSize") int size,@RequestParam("sortBy") String field) {
        List<dharshiniStudent> list = studentService.sortPaginationStudents(pageno, size, field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    
}

package com.example.day6cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw1.model.dharshiniChildren;
import com.example.day6cw1.service.ChaturyaChildrenService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class dharshiniChildrenController {
    public ChaturyaChildrenService childrenService;
    public dharshiniChildrenController(ChaturyaChildrenService childrenService)
    {
        this.childrenService = childrenService;
    }
    @PostMapping("/api/children")
    public ResponseEntity<dharshiniChildren> postMethodName(@RequestBody dharshiniChildren children) {
        if(childrenService.postChildren(children))
        {
            return new ResponseEntity<>(children,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<List<dharshiniChildren>> getMethodName(@PathVariable("field") String field) {
        List<dharshiniChildren> list = childrenService.getSortedChildrens(field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<List<dharshiniChildren>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<dharshiniChildren> list = childrenService.getPaginationChildrens(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<dharshiniChildren>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<dharshiniChildren> list = childrenService.getSortedPaginationChildrens(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}

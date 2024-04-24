package com.example.class_exercise_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercise_1.model.dharshiniBook;
import com.example.class_exercise_1.service.dharshiniBookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class dharshiniBookController {

     @Autowired
     public dharshiniBookService bookService;

     List<dharshiniBook> list;

     @PostMapping("/api/book")
     public ResponseEntity<dharshiniBook> postMethodName(@RequestBody dharshiniBook entity) {

          dharshiniBook inst = bookService.SaveEntity(entity);

          return new ResponseEntity<dharshiniBook>(inst, HttpStatus.CREATED);

     }

     @GetMapping("/api/book")
     public ResponseEntity<List<dharshiniBook>> getMethodName() {

          List<dharshiniBook> show = bookService.getDetails();
          if (!show.isEmpty()) {
               return new ResponseEntity<List<dharshiniBook>>(show, HttpStatus.OK);
          } else {
               return new ResponseEntity<List<dharshiniBook>>(show, HttpStatus.NOT_FOUND);
          }
     }

     @GetMapping("api/book/{bookId}")
     public dharshiniBook getMethodName(@PathVariable int bookId) {

          dharshiniBook getid = bookService.getBookById(bookId);

     }

}

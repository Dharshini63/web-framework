package com.example.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.DharshiniAuthor;
import com.example.q1.model.DharshiniBook;
import com.example.q1.service.DharshiniAuthorService;
import com.example.q1.service.DharshiniBookService;

@RestController
public class DharshiniAuthorController {
    @Autowired
    private DharshiniAuthorService authorService;
@Autowired
private DharshiniBookService bookService;
    @PostMapping("/author")
    public ResponseEntity<DharshiniAuthor> createAuthor(@RequestBody DharshiniAuthor author) {
        DharshiniAuthor savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @PostMapping("/book/author/{authorId}")
    public ResponseEntity<DharshiniBook> createBookForAuthor(@PathVariable Long authorId, @RequestBody DharshiniBook book) {
        DharshiniBook savedBook = bookService.saveBook(authorId, book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<DharshiniAuthor> getAuthorById(@PathVariable Long authorId) {
        DharshiniAuthor author = authorService.getAuthorById(authorId);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/author")
    public ResponseEntity<List<DharshiniAuthor>> getAllAuthors() {
        List<DharshiniAuthor> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<DharshiniAuthor> updateAuthor(@PathVariable Long authorId, @RequestBody DharshiniAuthor author) {
        DharshiniAuthor updatedAuthor = authorService.updateAuthor(authorId, author);
        if (updatedAuthor != null) {
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}

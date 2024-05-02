package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.DilipAuthor;
import com.example.q1.repository.DilipAuthorRepository;

@Service
public class DharshiniAuthorService {
    @Autowired
    private DilipAuthorRepository authorRepository;

    public DilipAuthor saveAuthor(DilipAuthor author) {
        return authorRepository.save(author);
    }

    public DilipAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<DilipAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public DilipAuthor updateAuthor(Long id, DilipAuthor author) {
        DilipAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

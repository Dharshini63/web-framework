package com.example.day14ce2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day14ce2.model.DilipBook;
import com.example.day14ce2.repository.DilipBookRepo;

@Service
public class DharshiniBookService {
   @Autowired
   DilipBookRepo bookRepo;

   public DilipBook addBook(DilipBook book)
   {
        return bookRepo.save(book);
   }

   public List<DilipBook> getBooks()
   {
        return bookRepo.findAll();
   }

   public Optional<DilipBook> getBook(int id)
   {
    return bookRepo.findById(id);
   }

   public DilipBook updateBook(int id,DilipBook book)
   {
        DilipBook avail = bookRepo.findById(id).orElse(null);
        if(avail!=null)
        {
            avail.setAuthor(book.getAuthor());
            avail.setAvailableCopies(book.getAvailableCopies());
            avail.setTitle(book.getTitle());
            avail.setTotalCopies(book.getTotalCopies());
            return bookRepo.save(avail);
        }
        else 
        return null;
   }
}

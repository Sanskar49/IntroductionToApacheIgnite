package com.example.IgniteDemoApplication.Service;

import com.example.IgniteDemoApplication.Model.Book;

import java.util.List;

public interface BookService {
    int count();
    List<Book> findAll();
   void save(Book book);
   void deleteById(Long id);
}

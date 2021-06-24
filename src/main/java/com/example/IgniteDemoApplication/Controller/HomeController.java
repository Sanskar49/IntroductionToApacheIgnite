package com.example.IgniteDemoApplication.Controller;

import com.example.IgniteDemoApplication.Model.Book;
import com.example.IgniteDemoApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Qualifier("bookServiceImpl")
    @Autowired
    private BookService bookService;

    @GetMapping("/count")
    public int count() {
       int ans = bookService.count();
       return ans;

    }

    @GetMapping("/allbooks")
    public List<Book> getAllBooksName() {
        List<Book> allBook = bookService.findAll();
        return allBook;

    }

    @PostMapping("/addBook")
    public String addBookName(@RequestBody Book book) {
           bookService.save(book);
           String response ="{\"success\":true,\"message\":\"Question successfully added\"}";
           return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        bookService.deleteById(id);
        String response ="{\"success\":true,\"message\":\"Question successfully deleted\"}";
        return response;


    }
}

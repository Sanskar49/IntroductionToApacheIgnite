package com.example.IgniteDemoApplication.Repository;


import com.example.IgniteDemoApplication.Model.Book;
import com.example.IgniteDemoApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM BOOK", Integer.class);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM BOOK",
                (rs, rowNum) ->
                new Book(
                        rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getBigDecimal("PRICE")

                )
        );
    }

    @Override
    public void save(Book book) {
          jdbcTemplate.update("INSERT INTO BOOK(ID,NAME,PRICE) VALUES(?,?,?)", book.getId() ,book.getName(),
                book.getPrice());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE BOOK WHERE ID = ?",id);

    }
}

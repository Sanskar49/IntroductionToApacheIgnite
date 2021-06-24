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
}

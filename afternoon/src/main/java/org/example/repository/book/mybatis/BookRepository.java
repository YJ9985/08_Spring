package org.example.repository.book.mybatis;

import org.example.domain.BookMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository

public class BookRepository {
    private final BookMapper bookMapper;

    @Autowired
    public BookRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<BookMyBatis> findAll() {
        return bookMapper.findAll();
    }

    public BookMyBatis findById(Long id) {
        return bookMapper.findById(id);
    }

    public int save(BookMyBatis newBookMyBatis) {
        return bookMapper.save(newBookMyBatis);
    }

    public int delete(Long id) {
        return bookMapper.delete(id);
    }

}


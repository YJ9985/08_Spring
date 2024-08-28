package org.example.repository.book.mybatis;

import org.example.domain.BookMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class BookRepository2 {
    private final BookMapper2 bookMapper2;

    @Autowired
    public BookRepository2(BookMapper2 bookMapper2) {
        this.bookMapper2 = bookMapper2;
    }

    public List<BookMyBatis> findAll() {
        return bookMapper2.findAll();
    }

    public BookMyBatis findById(Long id) {
        return bookMapper2.findById(id);
    }

    public int save(BookMyBatis newBookMyBatis) {
        return bookMapper2.save(newBookMyBatis);
    }

    public int delete(Long id) {
        return bookMapper2.delete(id);
    }

}


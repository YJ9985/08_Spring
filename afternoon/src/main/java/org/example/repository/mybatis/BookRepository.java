
package org.example.repository.mybatis;

import lombok.RequiredArgsConstructor;
import org.example.domain.BookMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public int save(BookMyBatis newBook) {
        return bookMapper.save(newBook);
    }

    public int delete(Long id) {
        return bookMapper.delete(id);
    }
}

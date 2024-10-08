package org.example.repository.book.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Repository
public class JpaBookRepository {
    private final EntityManager em;

    public List<Book> findAll() {
        String jpql = "SELECT b FROM Book b";
        List<Book> bookList = em.createQuery(jpql, Book.class).getResultList();
        return bookList;
    }

    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    public void delete(Book book) {
        Book book1 = em.find(Book.class, id);
        if (book1 != null) em.remove(book1);
    }
}

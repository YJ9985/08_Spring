package org.example.controller.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.BookMyBatis;
import org.example.repository.book.mybatis.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/book/mybatis")
public class MyBatisBookController {
    private final BookRepository bookRepository;

    @GetMapping("/show")
    public ResponseEntity<List<BookMyBatis>> findAll() {
        List<BookMyBatis> bookMyBatis = bookRepository.findAll();
        return ResponseEntity.ok(bookMyBatis);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<BookMyBatis> findById(@PathVariable Long id) {
        BookMyBatis findBook = bookRepository.findById(id);

        if(findBook == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(findBook);

    }

    @PostMapping("/save")
    public ResponseEntity<BookMyBatis> saveBook(
            @RequestParam("title") String title,
            @RequestParam("author") String author
    ) {
        BookMyBatis newBook = new BookMyBatis(null, title, author);
        int affectedRows = bookRepository.save(newBook);
        if (affectedRows == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        int result = bookRepository.delete(id);
        if (result > 0) {
            return ResponseEntity.ok("게시글 삭제 성공");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글 삭제 실패");
        }
    }
}

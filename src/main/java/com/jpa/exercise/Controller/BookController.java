package com.jpa.exercise.Controller;

import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.dto.BookResponse;
import com.jpa.exercise.service.BookService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookRepository;

    public BookController(BookService bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable) {
        return ResponseEntity.ok().body(bookRepository.findBooks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(new Book());
    }


}

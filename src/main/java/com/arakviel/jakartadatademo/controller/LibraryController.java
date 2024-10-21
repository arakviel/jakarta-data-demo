package com.arakviel.jakartadatademo.controller;

import com.arakviel.jakartadatademo.entity.Book;
import com.arakviel.jakartadatademo.repository.Library;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class LibraryController {

    private final Library library;

    @GetMapping
    public List<Book> index() {
        // Додаємо три книги
        library.add(new Book("9783161484100", "Book Title 1", LocalDate.of(2020, 1, 1), "This is the text of Book 1."));
        library.add(new Book("9781234567897", "Book Title 2", LocalDate.of(2021, 2, 1), "This is the text of Book 2."));
        library.add(new Book("9780123456789", "Book Title 3", LocalDate.of(2022, 3, 1), "This is the text of Book 3."));

        return library.books();
    }


}

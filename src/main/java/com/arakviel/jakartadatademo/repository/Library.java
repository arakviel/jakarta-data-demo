package com.arakviel.jakartadatademo.repository;

import com.arakviel.jakartadatademo.entity.Book;
import jakarta.data.repository.Find;
import jakarta.data.repository.Insert;
import jakarta.data.repository.Repository;
import java.util.List;

@Repository
public interface Library {
    @Find
    Book book(String isbn);

    @Find
    List<Book> books();

    @Insert
    void add(Book book);
}
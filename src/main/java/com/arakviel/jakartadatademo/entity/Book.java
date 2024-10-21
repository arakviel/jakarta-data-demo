package com.arakviel.jakartadatademo.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    String isbn;

    @Basic(optional = false)
    String title;

    LocalDate publicationDate;

    @Basic(optional = false)
    String text;
}
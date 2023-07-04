package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @Column(updatable = false)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String bookName;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    private Student student;

    /**
     * Dlaczego nie użyłeś @AllArgsConstructor ??
     * Czy nie lepiej użyć w tym wypadku LocalDate ??
     */
    public Book(LocalDateTime createdAt, String bookName) {
        this.createdAt = createdAt;
        this.bookName = bookName;
    }
}
/** 1. Jak przetłumaczyć persistence?? np. JPA ??
 *  2. Co to jest ten ORM?? Hibernate podobno nim jest,ale co to??
 *  3. Gdzie jest granica między Hibernate a JPA??*/
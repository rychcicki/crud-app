package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void postBooks(BookRequest request) {
        Book book1 = new Book(request.getCreatedAt(), request.getBookName());
        Book book2 = new Book(request.getCreatedAt(), request.getBookName());
        Book book3 = new Book(request.getCreatedAt(), request.getBookName());
        bookRepository.saveAll(List.of(book1, book2, book3));
    }
}
/** Skąd wiadomo, czy/które książki zostały przypisane do danego studenta ???*/

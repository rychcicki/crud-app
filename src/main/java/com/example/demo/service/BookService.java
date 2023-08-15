package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // do inicjalizacji pól final
/**
 * @RequiredArgsConstructor generates a constructor with 1 parameter for each field that requires special handling.
 * All non-initialized final fields get a parameter, as well as any fields that are marked as
 * @NonNull that aren't initialized where they are declared. For those fields marked with @NonNull,
 * an explicit null check is also generated. The constructor will throw a NullPointerException
 * if any of the parameters intended for the fields marked with @NonNull contain null.
 * The order of the parameters match the order in which the fields appear in your class.
 *
 */
public class BookService {
    //!!!!! final albo przez konstruktor albo przez przypisanie = w klasie
    private final BookRepository bookRepository;

    public void postBooks(BookRequest request) {
        Book book1 = new Book(request.getBookName(),request.getCreatedAt());
        Book book2 = new Book(request.getBookName(),request.getCreatedAt());
        Book book3 = new Book(request.getBookName(),request.getCreatedAt());
        bookRepository.saveAll(List.of(book1, book2, book3));
    }
}
/** Skąd wiadomo, czy/które książki zostały przypisane do danego studenta ???*/

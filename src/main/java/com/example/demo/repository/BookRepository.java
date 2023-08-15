package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    List<Book> findByBookName(String bookName);

    /** @Bean to obiekt, którym zarządza kontener IoC (odwrócenie sterowania - inversion of control):
     * Zadaniem IoC jest inicjalizacja, konfiguracja, zasilanie danymi, zarządzanie cyklem życia
     * piszesz logikę, a nie zarządzanie zależnościami
     * (czy klasa jest nullem czy nie (czy klasa/bean będzie zainicjalizowany))
     *
     * Repository określa klasę, która spełnia rolę repozytorium, czyli obiektu dostępu do danych DAO*/
}

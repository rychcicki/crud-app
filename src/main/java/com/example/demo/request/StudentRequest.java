package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentRequest {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final Long id;
}
/** Czy musi być id?
 *  czy w konstruktorze powinno być id?
 *  Co jeżeli w konstruktorze nie ma id, a będzie w request, czy należy je ustawiać?*/
//bo ta klasa jest zrobiona na potrzeby komunikacji z API
/** Dodałem pole id, aby móc pobrać id w metodzie Update.*/
//DTO to jest obiekt ktory tworzymy na potrzeby zwracania go przez api zeby nie zwracac calych encji.
// Wiec robiac metode np getAllStudents() powinienes zrobic StudentResponse i przekazac tylko to co musisz

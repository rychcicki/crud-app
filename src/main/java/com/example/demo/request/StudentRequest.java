package com.example.demo.request;

import com.example.demo.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StudentRequest {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
//    private final Long id;
}
// bo ta klasa jest zrobiona na potrzeby komunikacji z API
// DTO to jest obiekt, który tworzymy na potrzeby zwracania go przez api zeby nie zwracać calych encji.
// Wiec robiąc metodę np getAllStudents() powinieneś zrobić StudentResponse i przekazać tylko to co musisz

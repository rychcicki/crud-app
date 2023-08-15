package com.example.demo.request;

import com.example.demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
public class BookRequest {
    private final Long id;
    private final LocalDateTime createdAt;
    private final String bookName;
//    private final Student student;
}

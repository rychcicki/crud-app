package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentRegisterRequest {
    private final String firstName;
    private final String lastName;
    private final int age;
}

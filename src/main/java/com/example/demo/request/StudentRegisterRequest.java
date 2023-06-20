package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentRegisterRequest {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
}
/** W jakim celu została utworzona ta klasa z wybranymi polami klasy Student?
 * Dlaczego pola są final?? */
//bo ta klasa jest zrobiona na potrzeby komunikacji z API
/** Czy ta klasa pełni rolę obiektu DTO? (Data Transfer Object)  */

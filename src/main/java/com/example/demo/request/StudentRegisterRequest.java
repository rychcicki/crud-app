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
/** W jakim celu została utworzona ta klasa z wybranymi polami klasy Student?
 * Dlaczego pola są final?? */

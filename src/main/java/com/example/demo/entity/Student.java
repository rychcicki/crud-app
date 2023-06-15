package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Student")
@Getter
@Setter
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email", name = "email_constraint")
        })
@NoArgsConstructor

public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    private String lastName;
    private int age;
    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;

    @OneToOne(mappedBy = "student",
            orphanRemoval = true)
    private StudentIdCard studentIdCard;

    public Student(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", studentIdCard=" + studentIdCard +
                '}';
    }
}

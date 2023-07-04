package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
            /** Czym się różni name od sequenceName??
             * Nazwa generatora i nazwa sekwencji w bazie danych niewiele mi mówi...             */
            name = "student_sequence",
            sequenceName = "student_sequence",
            /** Czy to jest wartość, o którą zwiększa się kolejny numer id,
             * czy liczebność jednorazowych 'wygenerowań' numerów id??  */
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            /** Do nazwy czego odwołuje się nazwa w generatorze?? (name, sequenceName) */
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
    /**
     * Skoro tutaj nie ma adnotacji @Column, czy pole lastName nie jest kolumną tabeli??
     */
    private String lastName;
    private int age;
    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;

    /**
     * MappedBy dodaje się na obcym obiekcie
     */
    @OneToOne(mappedBy = "student",
            orphanRemoval = true)
    private StudentIdCard studentIdCard;

    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, // cascade nie ma domyślnego typu; trzeba zawsze ustawić
            /** To po co jest orphanRemoval = true, skoro ustawiamy CascadeType.REMOVE ??? Jaka jest różnica między nimi??*/
            fetch = FetchType.LAZY // rozumiem, że jest to domyślne i nie trzeba tego ustawiać dla @...toMany
    )
    private List<Book> books = new ArrayList<>();

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

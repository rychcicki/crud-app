package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Getter
@Setter
@ToString
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
            allocationSize = 1) //Jest to wartość, o którą zwiększa się kolejny numer id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            /** Do nazwy czego odwołuje się nazwa w generatorze?? (name, sequenceName)?
             * Chyba do name*/
            generator = "student_sequence")
    @Column(
            name = "id",
            nullable = false)
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String firstName;
    private String lastName;
    private int age;
    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;

    /** MappedBy dodaje się na obcym obiekcie */
    @OneToOne(mappedBy = "student",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    private StudentIdCard studentIdCard;
    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, // cascade nie ma domyślnego typu; trzeba zawsze ustawić
            fetch = FetchType.LAZY // domyślnie .LAZY dla @...toMany
    )
    @ToString.Exclude
    /** Musisz wyłączyć to pole z @ToString albo nadpisać metodę toString() bez tego pola.
     *  W przeciwnym razie rzucony zostanie LazyInitializaitonException */
    private List<Book> books = new ArrayList<>();

    public Student(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    /** Tylko bez List<Book> books. Inaczej rzucony zostanie LazyInitializaitonException */
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                ", studentIdCard=" + studentIdCard +
//                '}';
//    }
}

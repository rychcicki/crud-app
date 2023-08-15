package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_number_unique",
                        /** Skoro tylko jedna kolumna jest unikalna, to czy nie wystarczy @Column(unique=true) ?? */
                        columnNames = "card_number"
                )
        }
)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentIdCard {
    @Id
    @SequenceGenerator(
            name = "student_card_id_sequence",
            sequenceName = "student_card_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_card_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            /** Czy to jest kolumna klucza głównego, czy obcego?? Tj. id w encji Student czy StudentIdCard?? */
            referencedColumnName = "id",
            /** Skąd wiadomo, która kolumna jest oznaczone jako foreign key?? Co poniższy zapis w ogóle oznacza??*/
            foreignKey = @ForeignKey(name = "student_id_fk")
    )
    private Student student;

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

/**  Tutaj można zastosować @ToString -
     wszystkie pola mogą być generowane Lombokiem bez obawy o LazyInitializaitonException */
//    @Override
//    public String toString() {
//        return "StudentIdCard{" +
//                "id=" + id +
//                ", cardNumber='" + cardNumber + '\'' +
//                ", student=" + student +
//                '}';
//    }
}

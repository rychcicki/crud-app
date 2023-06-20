package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /** W sumie żadna z tych metod nie jest wywoływana. Gdzie jest implementacja tych metod?
     * Nie bardzo wiem, jak je zaimplementować w servisie, gdyż nie implementujemy interfejsu, a tylko wstawiamy obiekt final.
     * Sama nazwa mojej zakomentowanej metody jest wzięta z dokumentacji, więc jest OK.*/
    Student findStudentByFirstName(String firstName);
    //    @Query("where student.age >= ?21")
//    List<Student> findAllByAgeGreaterThanEquals(int age);
}

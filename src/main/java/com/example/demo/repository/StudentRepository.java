package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /** Gdzie przekazywany jest argument do metody 'findStudentByFirstName'
     * i dlaczego do mojej metody 'findAllByAgeGreaterThanEquals' nie jest przekazywany argument??
     * (nie działa jak ją odkomentuję)  */
    Student findStudentByFirstName(String firstName);
    //    @Query("where student.age >= ?21")
//    List<Student> findAllByAgeGreaterThanEquals(int age);
}

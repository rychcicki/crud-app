package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /** Repository - służy do łączenia z db*/
    Student findStudentByFirstName(String firstName);
    //    @Query("where student.age >= ?21")
    List<Student> findAllByAgeGreaterThanEqual(int age);



//    @Override
//    @Query( value = "select * from Student")
//    List<Student> findAll();
}

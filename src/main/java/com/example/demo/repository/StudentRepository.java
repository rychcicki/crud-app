package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /** Repository - służy do łączenia z db*/
    Student findStudentByFirstName(String firstName);
    //    @Query("where student.age >= ?21")
    List<Student> findAllByAgeGreaterThanEqual(int age);

    @Query(value = "SELECT * FROM Student WHERE first_name = :firstName AND age >= :age",
            nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age);

    @Query("SELECT s FROM Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Modifying
    @Query("DELETE from Student u where u.id = ?1")
    int deleteStudentById(Long id);

//    @Override
//    @Query( value = "select * from Student")
//    List<Student> findAll();
}

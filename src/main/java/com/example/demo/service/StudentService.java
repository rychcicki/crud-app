package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void registerStudent(StudentRegisterRequest request) {
        Student student = new Student();
        student.setAge(request.getAge());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow();
    }

    public Student updateStudent(Student studentToUpdate, Student student) {
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setAge(student.getAge());
        return studentRepository.save(studentToUpdate);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

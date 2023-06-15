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
        studentRepository.save(student);
    }

}

package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void registerStudent(StudentRequest request) {
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
//    public Student getStudentByName(String input) {
//        return studentRepository.findStudentByFirstName(input);
//    }
@Transactional
    public Student updateStudent(StudentRequest studentUpdate, Long id) {
        Student studentToEdit = studentRepository.findById(id)
                .orElseThrow();
        studentToEdit.setFirstName(studentUpdate.getFirstName());
        studentToEdit.setLastName(studentUpdate.getLastName());
        studentToEdit.setAge(studentUpdate.getAge());
        return studentToEdit;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

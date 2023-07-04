package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.BookRequest;
import com.example.demo.request.StudentRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public void registerStudent(StudentRequest request) {
        Student student = new Student();
        student.setAge(request.getAge());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        studentRepository.save(student);
        // tak działa LAZY
        Student student1 = studentRepository.findById(1L).get();
        List<Book> books = student1.getBooks();
    }

    public Student getStudent(Long id) {
        log.info("My log. Practise makes perfect ;-) ");
        return studentRepository.findById(id)
                .orElseThrow();
    }
    /** Myślałem wcześniej, że NullPointerException, ale sprawdziłem w dokumentacji, że NoSuchElementException.
     * Bardziej pasowałby chyba NullPointerException, bo ten drugi to wystąpi po przekroczeniu
     * rozmiaru kolekcji, a my przecież odwołujemy się do wartości nullowej. Chociaż w sumie nulla nie ma, bo to Optional...*/
//    public Student getStudentByName(String input) {
//        return studentRepository.findStudentByFirstName(input);
//    }
//@Transactional
    public Student updateStudent(StudentRequest studentRequest, Long id) {
        Student studentToEdit = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("There is no student with id: " + id + " in database."));
        /** Już kiedyś próbowałem i czy jest jakiś sposób, żeby powyższy zapis zrobić poprzez referencję np. .orElseThrow(IllegalStateException::new i co dalej?*/
        studentToEdit.setFirstName(studentRequest.getFirstName());
        studentToEdit.setLastName(studentRequest.getLastName());
        studentToEdit.setAge(studentRequest.getAge());
        return studentRepository.save(studentToEdit);
    }
    /** Hibernate ma wbudowany mechanizm "automatic dirty checking", który sprawdza, czy encja pobrana wcześniej
     * przez hibernate'a zmieniła stan. Jeżeli tak, to automatycznie ją zapisuje. Jeżeli nie zmieniła stanu,
     * to i tak nic się nie uaktualni.*/

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

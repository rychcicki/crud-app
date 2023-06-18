package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@RequiredArgsConstructor
/** Czy @ReguestMapping powinien być i gdzie dokładnie??? */
public class StudentService {
    private final StudentRepository studentRepository;

    /** Rozumiem, że to jest metoda typu create.
     * 1) Dlaczego nie jest przekazywany obiekt (bean??) Studenta, tylko obiekt request, którego istnienia nie rozumiem??
     * 2) Czy tu ma być np. @PostMapping("/student") i dlaczego nie/tak??  */
    public void registerStudent(StudentRegisterRequest request) {
        Student student = new Student();
        student.setAge(request.getAge());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        /** Dlaczego nie ustawiamy e-maila?? */
        studentRepository.save(student);
    }

    @GetMapping("/student/{id}")
    public void readStudent() {
        /** A to nie będzie zwykły getter na Studencie?? */

    }

    @PutMapping("/student/{id}")
    public void updateStudent(@PathVariable Student student, Student studentToUpdate) {
        student.setFirstName(studentToUpdate.getFirstName());
        //...and so on
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}

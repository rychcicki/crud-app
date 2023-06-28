package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.StudentRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
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
@Transactional
/** W sumie to nie jest takie oczywiste, ale doszedłem do tego, że działa w sposób i dzięki
 * wzorcowi strukturalnemu proxy (pełnomocnik) oraz AOP, przy czym AOP to już konkretna kobyła
 * i nie bardzo wiem, kiedy należy stosować adnotacje AOP, a kiedy wystarczy tylko @Transactional*/
    public Student updateStudent(StudentRequest studentRequest, Long id) {
        Student studentToEdit = studentRepository.findById(id)
                .orElseThrow();
        studentToEdit.setFirstName(studentRequest.getFirstName());
        studentToEdit.setLastName(studentRequest.getLastName());
        studentToEdit.setAge(studentRequest.getAge());
        return studentToEdit;
    }
    /** Powyższa metoda jest typem Update, czyli ma za zadanie aktualizować studenta.
     * Jak dla mnie wszystko jest klarowne w zakresie, jaki poznałem.
     * Metoda pobiera studenta z bazy (id), przekazuje (get) dane z requesta do pobranego studenta (set),
     * zapisuje w bazie zmienionego studenta dzięki adnotacji @Transactional poprzez return studentToEdit.
     * Hibernate ma wbudowany mechanizm "automatic dirty checking", który sprawdza, czy encja pobrana wcześniej przez hibernate'a
     * zmieniła stan. Jeżeli tak, to automatycznie ją zapisuje. Jeżeli nie zmieniła stanu, to i tak nic się
     * nie uaktualni.*/

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

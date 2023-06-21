package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.request.StudentRegisterRequest;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class StudentController {
    private final StudentService userService;
//w controller sa tylko requesty z wywolaniem metod z serwisu. Tu zadnej logiki biznesowej ma nie byc. Jedynie punkt dostepowy do api
    /** To straszne, że w necie (YT, blogi i artykuły) nadal używają adnotacji @RequestMapping.  */
    @PostMapping("/students")
    void registerUser(@RequestBody StudentRegisterRequest request) {
        userService.registerStudent(request);
    }

    @GetMapping("/students/{id}")
    Student readStudent(@PathVariable Long id) {
        return userService.getStudent(id);
    }

    @PutMapping("/students")
    Student updateStudent(Student studentToUpdate, Student student) {
        studentToUpdate.setFirstName(studentToUpdate.getFirstName());
        studentToUpdate.setAge(studentToUpdate.getAge());
        return userService.updateStudent(studentToUpdate, student);
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") Long id) {
        userService.deleteStudent(id);
    }

}

package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.request.StudentRequest;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class StudentController {
    private final StudentService userService;
    //w controller sa tylko requesty z wywolaniem metod z serwisu. Tu zadnej logiki biznesowej ma nie byc. Jedynie punkt dostepowy do api
    @PostMapping("/students")
    void registerUser(@RequestBody StudentRequest request) {
        userService.registerStudent(request);
    }
    @GetMapping("/students/{id}")
    Student readStudent(@PathVariable Long id) {
        return userService.getStudent(id);
    }
    @PutMapping("/students")
    Student updateStudent(@RequestBody StudentRequest studentToUpdate, Long id) {
        return userService.updateStudent(studentToUpdate, id);
    }
    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") Long id) {
        userService.deleteStudent(id);
    }
}

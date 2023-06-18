package com.example.demo.controller;

import com.example.demo.request.StudentRegisterRequest;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@RequiredArgsConstructor
class StudentController {
    private final StudentService userService;
/** Zwątpiłem już, gdzie mają być te metody CRUDowe... Tutaj czy w StudentService??  */
    @PostMapping("/register")
    void registerUser(@RequestBody StudentRegisterRequest request) {
        userService.registerStudent(request);
    }

}

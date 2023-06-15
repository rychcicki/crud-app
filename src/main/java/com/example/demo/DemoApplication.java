package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentIdCard;
import com.example.demo.repository.StudentIdCardRepository;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
//        return args -> {
//            Student maria = new Student("Maria", "Jones", 21, "maria.jones@gmail.com");
//            Student ahmed = new Student("Ahmed", "Ali", 23, "ahmed.ali@gmail.com");
//
//            System.out.println("Adding maria and ahmed ");
//            studentRepository.saveAll(List.of(maria, ahmed));
//            System.out.println("Number of students : ");
//            System.out.println(studentRepository.count());
//
//            studentRepository
//                    .findById(2L).
//                    ifPresentOrElse(
//                            System.out::println,
//                            () -> System.out.println("Student with ID 2 not found"));
//            studentRepository
//                    .findById(3L)
//                    .ifPresentOrElse(
//                            System.out::println,
//                            () -> System.out.println("Student with ID 3 not found"));
//            System.out.println("Select all students");
//            List<Student> students = studentRepository.findAll();
//            students.forEach(System.out::println);
//            System.out.println("Delete maria");
//            studentRepository.deleteById(1L);
//            System.out.println("number of students : ");
//            System.out.println(studentRepository.count());
//        };
//    }
@Bean
CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                    StudentIdCardRepository studentIdCardRepository) {
    return args -> {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = String.format("%s.%s@gmail.com", firstName,lastName);
        Student student = new Student(
                firstName,
                lastName,
                faker.number().numberBetween(18,55),
                email
        );
        StudentIdCard studentIdCard = new StudentIdCard("123456789", student);
        studentIdCardRepository.save(studentIdCard);
        studentRepository.save(student);
        studentRepository.findById(1L).ifPresent(System.out::println);
        studentIdCardRepository.findById(1L).ifPresent(System.out::println);
        studentRepository.deleteById(1L);
    };
}

}

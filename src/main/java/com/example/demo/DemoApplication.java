package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentIdCard;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentIdCardRepository;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    /** Nie może być więcej niż 1 bean w tej klasie. */
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        StudentIdCardRepository studentIdCardRepository, BookRepository bookRepository) {
        return args -> {
            Faker faker = new Faker();

                LocalDateTime createdAt = LocalDateTime.of(faker.number().numberBetween(1900,2010),
                        faker.number().numberBetween(1,12),
                        faker.number().numberBetween(1,28),
                        10,0,0,0);
                String bookName = faker.book().title();
            Book book = new Book(
                    bookName,
                    createdAt);

                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@gmail.com", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    faker.number().numberBetween(18, 55),
                    email);

            Book book1 = new Book("Lorem ipsum",LocalDateTime.now(),student);
            Book book2 = new Book("ABC",LocalDateTime.now(),student);
            Book book3 = new Book("123",LocalDateTime.now(),student);
            List<Book> listOfBooks = new ArrayList<>(List.of(book1, book2, book3));
            student.setBooks(listOfBooks);

            listOfBooks.add(book);
            book.setStudent(student);

            StudentIdCard studentIdCard = new StudentIdCard("123456789", student);

            studentIdCardRepository.save(studentIdCard);
            studentRepository.save(student);
            studentRepository.findById(1L).ifPresent(System.out::println);
            studentIdCardRepository.findById(1L).ifPresent(System.out::println);
//            studentRepository.deleteById(1L);

//          Student student1 = studentRepository.findById(1L).get()   // generuje LazyInitializaitonException
            Student student1 = studentRepository.findByIdWithBooks(1L).get();
            List<Book> books = student1.getBooks();
            books.forEach(System.out::println);
        };
    }
}

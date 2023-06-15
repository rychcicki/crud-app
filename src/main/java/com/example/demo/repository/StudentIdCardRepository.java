package com.example.demo.repository;

import com.example.demo.entity.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard,Long> {
}

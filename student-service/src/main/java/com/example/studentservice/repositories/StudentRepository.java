package com.example.studentservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.studentservice.models.student.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
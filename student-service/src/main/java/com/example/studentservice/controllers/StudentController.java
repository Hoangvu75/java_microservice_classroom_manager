package com.example.studentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.studentservice.models.student.Student;
import com.example.studentservice.models.student.StudentResponse.StudentElementResponse;
import com.example.studentservice.models.student.StudentResponse.StudentListResponse;
import com.example.studentservice.services.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String studentService() {
        return "student service";
    }

    @GetMapping("/students")
    public StudentListResponse getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/find-by-name")
    public StudentListResponse findStudentsByName(@RequestParam String name) {
        return studentService.findStudentsByName(name);
    }

    @GetMapping("/find-by-id")
    public StudentElementResponse findStudentsById(@RequestParam String id) {
        return studentService.findStudentsById(id);
    }

    @PostMapping("/add")
    public StudentElementResponse addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/remove")
    public StudentElementResponse removeStudentById(@RequestParam String id) {
        return studentService.removeStudentById(id);
    }

    @PutMapping("/update")
    public StudentElementResponse updateStudentById(@RequestParam String id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }
}

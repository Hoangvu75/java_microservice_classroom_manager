package com.example.studentservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentservice.exception.ControllerExceptionHandler.NotFoundException;
import com.example.studentservice.models.student.Student;
import com.example.studentservice.models.student.StudentResponse.StudentElementResponse;
import com.example.studentservice.models.student.StudentResponse.StudentListResponse;
import com.example.studentservice.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentListResponse getAllStudents() {
        List<Student> students = new ArrayList<>();
        List<Student> studentsApi = studentRepository.findAll();
        for (Student student : studentsApi) {
            Student studentElement = new Student(
                    student.getId(),
                    student.getName(),
                    student.getGender(),
                    student.getBirthday(), student.getPhone());
            students.add(studentElement);
        }

        String message = "Get list of student successfully";

        StudentListResponse response = new StudentListResponse(true, studentsApi, message);

        return response;
    }

    public StudentListResponse findStudentsByName(String name) {
        List<Student> students = new ArrayList<>();
        List<Student> studentsApi = studentRepository.findByNameContainingIgnoreCase(name);
        for (Student student : studentsApi) {
            Student studentElement = new Student(
                    student.getId(),
                    student.getName(),
                    student.getGender(),
                    student.getBirthday(), student.getPhone());
            students.add(studentElement);
        }

        String message = "Get list of student by name successfully";

        StudentListResponse response = new StudentListResponse(true, students, message);

        return response;
    }

    public StudentElementResponse findStudentsById(String id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (!studentOptional.isPresent()) {
            throw new NotFoundException("Student not found with id: " + id);
        }

        Student student = studentOptional.get();
        Student studentDTO = new Student(
                student.getId(),
                student.getName(),
                student.getGender(),
                student.getBirthday(),
                student.getPhone());
        String message = "Get student with id " + id + " successfully";

        StudentElementResponse response = new StudentElementResponse(true, studentDTO, message);

        return response;
    }

    public StudentElementResponse addStudent(Student student) {
        Student newStudent = studentRepository.save(student);

        String message = "Student added successfully";

        StudentElementResponse response = new StudentElementResponse(true, newStudent, message);

        return response;
    }

    public StudentElementResponse removeStudentById(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new NotFoundException("Student not found with id: " + id);
        }

        studentRepository.deleteById(id);
        String message = "Student with id " + id + " removed successfully";

        StudentElementResponse response = new StudentElementResponse(true, optionalStudent.get(), message);

        return response;
    }

    public StudentElementResponse updateStudentById(String id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new NotFoundException("Student not found with id: " + id);
        } 

        Student existingStudent = optionalStudent.get();
            
            if (student.getName() != null) 
                existingStudent.setName(student.getName());
            
            if (student.getGender() != null)
                existingStudent.setGender(student.getGender());
            
            if (student.getBirthday() != null)
                existingStudent.setBirthday(student.getBirthday());
            
            if (student.getPhone() != null)
                existingStudent.setPhone(student.getPhone());
    
            Student updatedStudent = studentRepository.save(existingStudent);
    
            String message = "Updated student successfully";
            StudentElementResponse response = new StudentElementResponse(true, updatedStudent, message);
            return response;
    }
    
}

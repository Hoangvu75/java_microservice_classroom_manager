package com.example.studentservice.models.student;

import java.util.List;

public class StudentResponse {

    public static class StudentListResponse {
        private Boolean success;
        private List<Student> students;
        private String message;

        public StudentListResponse(Boolean success, List<Student> students, String message) {
            this.success = success;
            this.students = students;
            this.message = message;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class StudentElementResponse {
        private Boolean success;
        private Student student;
        private String message;

        public StudentElementResponse(Boolean success, Student student, String message) {
            this.success = success;
            this.student = student;
            this.message = message;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

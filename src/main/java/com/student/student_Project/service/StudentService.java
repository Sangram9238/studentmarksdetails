package com.student.student_Project.service;

import com.student.student_Project.dto.StudentDTO;
import com.student.student_Project.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDTO studentDTO);
    Student updateStudentMarks(Long studentId, int marks1, int marks2, int marks3);
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
}


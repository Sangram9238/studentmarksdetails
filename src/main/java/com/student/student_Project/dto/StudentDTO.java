package com.student.student_Project.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String section;
    private String gender;
    private int marks1;
    private int marks2;
    private int marks3;
}


package com.student.student_Project.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, message = "First name should be at least 3 characters long")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, message = "Last name should be at least 3 characters long")
    private String lastName;

    @NotNull(message = "Date of Birth is mandatory")
    @Column(name = "dob")
    private LocalDate dob;

    @NotBlank(message = "Section is mandatory")
    @Pattern(regexp = "[A-C]", message = "Valid values for section are A, B, or C")
    private String section;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "[MF]", message = "Valid values for gender are M or F")
    private String gender;

    @Min(value = 0, message = "Marks should be between 0 and 100")
    @Max(value = 100, message = "Marks should be between 0 and 100")
    private Integer marks1;

    @Min(value = 0, message = "Marks should be between 0 and 100")
    @Max(value = 100, message = "Marks should be between 0 and 100")
    private Integer marks2;

    @Min(value = 0, message = "Marks should be between 0 and 100")
    @Max(value = 100, message = "Marks should be between 0 and 100")
    private Integer marks3;

    private Integer total;
    private Double average;
    private String result;
}




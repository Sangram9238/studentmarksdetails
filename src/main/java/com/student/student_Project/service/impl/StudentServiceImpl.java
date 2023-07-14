package com.student.student_Project.service.impl;

import com.student.student_Project.dto.StudentDTO;
import com.student.student_Project.entities.Student;
import com.student.student_Project.exception.InvalidStudentDataException;
import com.student.student_Project.exception.StudentNotFoundException;
import com.student.student_Project.repository.StudentRepository;
import com.student.student_Project.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        try {
            validateStudentDTO(studentDTO);
            Student student = new Student();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setDob(LocalDate.parse(String.valueOf(studentDTO.getDob())));
            student.setSection(studentDTO.getSection());
            student.setGender(studentDTO.getGender());
            student.setMarks1(studentDTO.getMarks1());
            student.setMarks2(studentDTO.getMarks2());
            student.setMarks3(studentDTO.getMarks3());
            calculateStudentResults(student);
            return studentRepository.save(student);
        } catch (InvalidStudentDataException ex) {
            throw new InvalidStudentDataException(ex.getMessage());
        }
    }

    @Override
    public Student updateStudentMarks(Long studentId, int marks1, int marks2, int marks3) {
        Student student = getStudentById(studentId);
        student.setMarks1(marks1);
        student.setMarks2(marks2);
        student.setMarks3(marks3);
        calculateStudentResults(student);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));
    }

    private void validateStudentDTO(StudentDTO studentDTO) {
        if (studentDTO.getFirstName().length() < 3) {
            throw new InvalidStudentDataException("First name should be at least 3 characters long.");
        }

        if (studentDTO.getLastName().length() < 3) {
            throw new InvalidStudentDataException("Last name should be at least 3 characters long.");
        }

        // Perform other validations here
    }

    private void calculateStudentResults(Student student) {
        int totalMarks = student.getMarks1() + student.getMarks2() + student.getMarks3();
        double averageMarks = totalMarks / 3.0;
        student.setTotal(totalMarks);
        student.setAverage(averageMarks);
        student.setResult(totalMarks >= 105 ? "Pass" : "Fail");
    }
}

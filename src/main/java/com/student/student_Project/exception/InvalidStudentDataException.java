package com.student.student_Project.exception;

import java.time.LocalDateTime;

public class InvalidStudentDataException extends RuntimeException {
    private LocalDateTime timestamp;
    private String details;

    public InvalidStudentDataException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.details = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}


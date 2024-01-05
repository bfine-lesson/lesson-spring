package com.lesson.spring.exception;

// RuntimeException vs Exception, (checked Exception vs unchecked Exception)
public class NotFoundStudentException extends RuntimeException {

    public NotFoundStudentException() {
        super("해당 학생을 찾을 수 없습니다.");
    }
}

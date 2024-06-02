package com.lesson.spring.exception;

public class NotFoundProfessorException extends RuntimeException {

    public NotFoundProfessorException() {
        super("해당 교수를 찾을 수 없습니다.");
    }
}

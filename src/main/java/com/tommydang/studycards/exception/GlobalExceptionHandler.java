package com.tommydang.studycards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GameSessionNotFoundException.class)
    public ResponseEntity<String> handleGameSessionNotFoundException(GameSessionNotFoundException gameSessionNotFoundException) {
        return new ResponseEntity<>("Error: " + gameSessionNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudyModuleNotFoundException.class)
    public ResponseEntity<String> handleStudyModuleNotFoundException(StudyModuleNotFoundException studyModuleNotFoundException) {
        return new ResponseEntity<>("Error: " + studyModuleNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FieldOfStudyNotFoundException.class)
    public ResponseEntity<String> handleFieldOfStudyNotFoundException(FieldOfStudyNotFoundException fieldOfStudyNotFoundException) {
        return new ResponseEntity<>("Error: " + fieldOfStudyNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}

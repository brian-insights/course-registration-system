package com.brian.course_registration_system;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.brian.course_registration_system.course.CourseNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationErrors(
        MethodArgumentNotValidException ex)
    {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " : " + error.getDefaultMessage())
                .toList();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgument(IllegalArgumentException ex)
    {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT.value(), ex.getMessage(), List.of(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(CourseNotFoundException.class)
public ResponseEntity<Map<String, String>> handleCourseNotFound(
        CourseNotFoundException ex)
{

    Map<String, String> error = Map.of(
            "error", ex.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
}
    
}

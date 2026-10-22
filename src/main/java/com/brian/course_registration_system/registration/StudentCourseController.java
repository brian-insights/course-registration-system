package com.brian.course_registration_system.registration;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class StudentCourseController
{
    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService)
    {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCourse registerStudent(@PathVariable Long studentId, @PathVariable Long courseId)
    {
        return studentCourseService.registerStudent(studentId, courseId);
    }

    
@GetMapping("/student/{studentId}")
public List<StudentCourseResponseDTO> getRegistrationsByStudent(
        @PathVariable Long studentId)
{
    return studentCourseService.getRegistrationsByStudent(studentId);
}

@DeleteMapping("/{registrationId}")
public ResponseEntity<String> cancelRegistration(
        @PathVariable Long registrationId) {

    studentCourseService.cancelRegistration(registrationId);

    return ResponseEntity.ok("Registration cancelled successfully");
}
}

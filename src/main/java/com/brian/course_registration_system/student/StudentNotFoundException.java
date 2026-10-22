package com.brian.course_registration_system.student;

public class StudentNotFoundException extends RuntimeException
{
    public StudentNotFoundException(String id)
    {
        super("Student not found with ID: " + id);
    }
}

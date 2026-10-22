package com.brian.course_registration_system.course;

public class CourseNotFoundException extends RuntimeException
{
    public CourseNotFoundException(String message)
    {
        super(message);
    }
}

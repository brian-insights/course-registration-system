package com.brian.course_registration_system.registration;

import java.time.LocalDateTime;

public class StudentCourseResponseDTO
{
    private Long id;
    private Long studentId;
    private Long courseId;
    private String courseTitle;
    private LocalDateTime localDateTime;
    private RegistrationStatus status;
    public StudentCourseResponseDTO(Long id, Long studentId, Long courseId, String courseTitle, LocalDateTime localDateTime,
            RegistrationStatus status)
    {
        this.courseTitle = courseTitle;
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.localDateTime = localDateTime;
        this.status = status;
    }

    
    public Long getId()
    {
        return id;
    }

    public Long getStudentId()
    {
        return studentId;
    }

    public Long getCourseId()
    {
        return courseId;
    }


    
    public String getCourseTitle()
    {
        return courseTitle;
    }


    public LocalDateTime getLocalDateTime()
    {
        return localDateTime;
    }

    public RegistrationStatus getRegistrationStatus()
    {
        return status;
    }


    public RegistrationStatus getStatus() {
        return status;
    }



}

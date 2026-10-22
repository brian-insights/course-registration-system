package com.brian.course_registration_system.registration;

import java.time.LocalDateTime;

import com.brian.course_registration_system.course.Course;
import com.brian.course_registration_system.student.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "student_courses")
public class StudentCourse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private com.brian.course_registration_system.student.Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private com.brian.course_registration_system.course.Course course;

    private LocalDateTime registrationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status = RegistrationStatus.ACTIVE;

    public StudentCourse()
    {
        
    }

    public Long getId()
    {
        return id;
    }


    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public LocalDateTime getRegistrationDate()
    {
        return registrationDate;
    }


    public RegistrationStatus getStatus()
    {
        return status;
    }

    public void setStatus(RegistrationStatus status)
    {
        this.status = status;
    }
}

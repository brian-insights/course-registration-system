package com.brian.course_registration_system.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "required")
    @Column(unique=true)
    private String regNo;
    @NotBlank(message="required")
    @Size(max=100, message="cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "required")
    @Size(max=254, message="email address is too long")
    @Email(message="invalid email address")
    @Column(unique=true)
    private String email;
    
    public Student()
    {

    }

    public Student(String regNo, String name, String email)
    {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getRegNo()
    {
        return regNo;
    }

    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}

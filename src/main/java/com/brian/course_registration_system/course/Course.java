package com.brian.course_registration_system.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="required")
    @Size(max=10, message="cannot exceed 10 characters.")
    private String code;

    @NotBlank(message="cannot be blank.")
    private String title;

    //@NotBlank(message = "credit hours cannot be blank")
    @Positive(message="must be positive")
    private int creditHours;

    @Positive(message="must be positive")
    private int capacity;

    
    public Course()
    {

    }


    public Course( String code, String title, int creditHours, int capacity)
    {
        this.code = code;
        this.title = title;
        this.creditHours = creditHours;
        this.capacity = capacity;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getCode()
    {
        return code;
    }


    public void setCode(String code)
    {
        this.code = code;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public int getCreditHours()
    {
        return creditHours;
    }


    public void setCreditHours(int creditHours)
    {
        this.creditHours = creditHours;
    }


    public int getCapacity()
    {
        return capacity;
    }


    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
}

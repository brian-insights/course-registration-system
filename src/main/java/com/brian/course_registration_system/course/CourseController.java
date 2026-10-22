package com.brian.course_registration_system.course;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/course")
public class CourseController
{
    private final CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses()
    {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id)
    {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course)
    {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable Long id, @Valid @RequestBody Course course)
    {
        return courseService.updatCourse(id, course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable Long id)
    {
        courseService.deleteCourse(id);
    }


}

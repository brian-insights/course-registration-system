package com.brian.course_registration_system.course;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService
{
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course)
    {
        if (courseRepository.existsByCodeIgnoreCase(course.getCode()))
        {
            throw new IllegalArgumentException("Course code already exists: " + course.getCode());
        }
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses()
    {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id)
    {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));
    }

    public Course updatCourse(Long id, Course updatedCourse)
    {
        Course existingCourse = getCourseById(id);

        if (courseRepository.existsByCodeIgnoreCaseAndIdNot(updatedCourse.getCode(), id))
        {
            throw new IllegalArgumentException("Course code already exists: " + updatedCourse.getCode());
        }

        existingCourse.setCode(updatedCourse.getCode());
        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setCreditHours(updatedCourse.getCreditHours());
        existingCourse.setCapacity(updatedCourse.getCapacity());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id)
    {
        Course existingCourse = getCourseById(id);
        courseRepository.delete(existingCourse);
    }
}

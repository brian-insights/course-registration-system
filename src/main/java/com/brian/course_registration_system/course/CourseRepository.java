package com.brian.course_registration_system.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>
{
    boolean existsByCodeIgnoreCase(String code);
    
    boolean existsByCodeIgnoreCaseAndIdNot(String code, Long id);
}

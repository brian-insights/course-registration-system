package com.brian.course_registration_system.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>
{

    Optional<StudentCourse> findById(Long id);

    boolean existsByStudentIdAndCourseIdAndStatus(Long studentId, Long courseId, RegistrationStatus status);

    long countByCourseIdAndStatus(
        Long courseId,
        RegistrationStatus status
);

List<StudentCourse> findByStudentId(Long studentId);
}

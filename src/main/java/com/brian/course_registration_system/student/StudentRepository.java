package com.brian.course_registration_system.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    Optional<Student> findByRegNo(String regNo);

    boolean existsByRegNo(String regNo);

boolean existsByEmailIgnoreCase(String email);

boolean existsByRegNoAndIdNot(String regNo, Long id);

    boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);
}

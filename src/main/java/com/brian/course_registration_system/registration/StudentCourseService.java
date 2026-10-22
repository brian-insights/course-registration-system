package com.brian.course_registration_system.registration;

import org.springframework.stereotype.Service;

import java.util.List;

import com.brian.course_registration_system.course.Course;
import com.brian.course_registration_system.course.CourseRepository;
import com.brian.course_registration_system.student.Student;
import com.brian.course_registration_system.student.StudentRepository;

//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentCourseService
{

    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentCourseService(StudentCourseRepository studentCourseRepository,
                                StudentRepository studentRepository,
                                CourseRepository courseRepository)
    {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional(readOnly = true)
    public List<StudentCourseResponseDTO> getRegistrationsByStudent(Long studentId)
    {
        if(!studentRepository.existsById(studentId))
        {
            throw new IllegalArgumentException(
                    "Student not found with ID: " + studentId);
        }
        return studentCourseRepository.findByStudentId(studentId)
                .stream()
                .map(studentCourse-> new StudentCourseResponseDTO(
                    studentCourse.getId(),
                    studentCourse.getStudent().getId(),
                    studentCourse.getCourse().getId(),
                    studentCourse.getCourse().getTitle(),
                    studentCourse.getRegistrationDate(),
                    studentCourse.getStatus()
                ))
                .toList();
    }


   @Transactional
   public StudentCourse registerStudent(Long studentId, Long courseId)
   {

       if (studentCourseRepository
               .existsByStudentIdAndCourseIdAndStatus(studentId, courseId, RegistrationStatus.ACTIVE)) {
           throw new IllegalArgumentException(
                   "Student is already registered for this course.");
       }

       Student student = studentRepository.findById(studentId)
               .orElseThrow(() -> new IllegalArgumentException(
                       "Student not found with ID: " + studentId));

       Course course = courseRepository.findById(courseId)
               .orElseThrow(() -> new IllegalArgumentException(
                       "Course not found with ID: " + courseId));

       long registeredCount = studentCourseRepository.countByCourseIdAndStatus(
               courseId, RegistrationStatus.ACTIVE);

       if (registeredCount >= course.getCapacity()) {
           throw new IllegalArgumentException(
                   "Course is full: " + course.getTitle());
       }

       StudentCourse registration = new StudentCourse();
       registration.setStudent(student);
       registration.setCourse(course);

       return studentCourseRepository.save(registration);

   }
   
   public void cancelRegistration(Long registrationId) {

    StudentCourse registration = studentCourseRepository
            .findById(registrationId)
            .orElseThrow(() ->
                    new RuntimeException("Registration not found"));

    if (registration.getStatus() == RegistrationStatus.CANCELLED) {
        throw new RuntimeException("Registration is already cancelled");
    }

    registration.setStatus(RegistrationStatus.CANCELLED);

    studentCourseRepository.save(registration);
}
}

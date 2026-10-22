package com.brian.course_registration_system.student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    
public Student addStudent(Student student)
{
    // Check for duplicate registration number
    if (studentRepository.existsByRegNo(student.getRegNo()))
    {
        throw new IllegalArgumentException(
                "Registration number already exists: "
                + student.getRegNo());
    }

    // Check for duplicate email
    if (studentRepository.existsByEmailIgnoreCase(student.getEmail()))
    {
        throw new IllegalArgumentException(
                "Email already exists: "
                + student.getEmail());
    }

    // Save the new student
    return studentRepository.save(student);
}


    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id)
    {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }

    
    
    public Student updateStudent(Long id, Student updatedStudent)
    {
        // 1. Find the existing student
        Student existingStudent = getStudentById(id);

        // 2. Check for a duplicate registration number
        if (studentRepository.existsByRegNoAndIdNot(
                updatedStudent.getRegNo(), id)) {
            throw new IllegalArgumentException(
                    "Registration number already exists: "
                            + updatedStudent.getRegNo());
        }

        // 3. Check for a duplicate email
        if (studentRepository.existsByEmailIgnoreCaseAndIdNot(
                updatedStudent.getEmail(), id)) {
            throw new IllegalArgumentException(
                    "Email already exists: "
                            + updatedStudent.getEmail());
        }

        // 4. Update the existing student's details
        existingStudent.setRegNo(updatedStudent.getRegNo());
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());

        // 5. Save and return the updated student
        return studentRepository.save(existingStudent);
    }
    
    public void deleteStudentById(Long id)
    {
        Student existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }
    
}

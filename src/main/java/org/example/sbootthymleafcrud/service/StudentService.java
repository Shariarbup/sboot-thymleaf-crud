package org.example.sbootthymleafcrud.service;

import org.example.sbootthymleafcrud.model.Student;
import org.example.sbootthymleafcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository; // Assume you have a StudentRepository for database operations

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAddress(updatedStudent.getAddress());
            existingStudent.setDescription(updatedStudent.getDescription());
            existingStudent.setCreatedDate(updatedStudent.getCreatedDate());
            studentRepository.save(existingStudent);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void saveStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }
}

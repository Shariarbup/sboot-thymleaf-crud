package org.example.sbootthymleafcrud.controller;

import org.example.sbootthymleafcrud.model.Student;
import org.example.sbootthymleafcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping( "/")
    public String showStudentList(Model model) {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studentList", studentList);
        return "html/student.html";
    }
}

package com.kejatori.springmvc.controller;

import com.kejatori.springmvc.entity.Student;
import com.kejatori.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping(path = "/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping
    public String createStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "redirect:/student";
    }
}

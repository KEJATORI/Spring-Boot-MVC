package com.kejatori.springmvc.controller;

import com.kejatori.springmvc.entity.Student;
import com.kejatori.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/edit/{studentId}")
    public String editStudentForm(@PathVariable("studentId") Long studentId, Model model){
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "edit_student";
    }

    @PostMapping(path = "/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId, @ModelAttribute("student") Student student, Model model){
        studentService.updateStudent(studentId, student);
        return "redirect:/student";
    }

    @GetMapping(path = "/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/student";
    }
}

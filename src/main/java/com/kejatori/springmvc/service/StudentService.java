package com.kejatori.springmvc.service;

import com.kejatori.springmvc.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
}

package com.kejatori.springmvc.repository;

import com.kejatori.springmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

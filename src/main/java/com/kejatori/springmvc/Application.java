package com.kejatori.springmvc;

import com.kejatori.springmvc.entity.Student;
import com.kejatori.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Kevin James", "Rivera", "riverakevinjames@gmail.com");
		Student student2 = new Student("Claridel", "Pagcu", "claridel.pagcu@gmail.com");
		studentRepository.saveAll(List.of(student1, student2));
	}
}

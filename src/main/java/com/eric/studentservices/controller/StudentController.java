package com.eric.studentservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eric.studentservices.model.Student;
import com.eric.studentservices.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable String studentId) {	
		return studentService.getStudent(studentId);
	}

}

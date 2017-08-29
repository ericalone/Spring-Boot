package com.eric.studentservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eric.studentservices.model.Student;

@Component
public class StudentService {
	private static List<Student> students = new ArrayList<>();

	static {
		Student s1 = new Student("Student1", "Join Smith");
		Student s2 = new Student("Student2", "Joe T");

		students.add(s1);
		students.add(s2);
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public Student getStudent(String studentId) {
		for (Student student : students) {
			if (student.getId().equalsIgnoreCase(studentId)) {
				return student;
			}
		}
		return null;
	}

}

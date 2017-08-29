package com.eric.studentservices.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eric.studentservices.model.Student;
import com.eric.studentservices.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	Student student1 = new Student("Student1", "Join Smith");
	Student student2 = new Student("Student2", "Eric Lee");

	@Test
	public void retrieveStudent() throws Exception {
		Mockito.when(studentService.getStudent(Mockito.anyString())).thenReturn(student1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/Student1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{id:Student1,name:Join Smith}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void retrieveAllStudents() throws Exception {
		List<Student> students = Arrays.asList(new Student[] { student1, student2 });

		Mockito.when(studentService.getAllStudents()).thenReturn(students);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{id:Student1,name:Join Smith},{id:Student2,name:Eric Lee}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}

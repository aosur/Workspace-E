package com.amigoscode.app.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "Guillermo"), 
			new Student(2, "Ian")
		);

	@PreAuthorize("hasRole('ROLE_STUDENT')")
	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		return STUDENTS.stream()
				.filter(student -> student.getStudentId().equals(studentId))
				.findAny()
				.orElseThrow(() -> new IllegalStateException("student " + studentId + " does not exists"));
	}

	@PreAuthorize("hasRole('STUDENT')")
	@GetMapping
	public List<Student> getStudents() {
		return STUDENTS;
	}
}

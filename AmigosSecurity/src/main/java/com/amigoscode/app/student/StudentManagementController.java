package com.amigoscode.app.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

	private final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "Guillermo"), 
			new Student(2, "Ian"),
			new Student(3, "Luquitas")
		);

	@GetMapping("{studentId}")
	@PreAuthorize("hasAuthority('student:read')")
	public Student getStudent(@PathVariable Integer studentId) {
		System.out.println("getStudent() id: " + studentId);
		return STUDENTS.stream()
				.filter(student -> student.getStudentId().equals(studentId))
				.findAny()
				.orElseThrow(() -> new IllegalStateException("student " + studentId + " does not exists"));
	}


	@GetMapping
	@PreAuthorize("hasAuthority('student:read')")
	public List<Student> getStudents() {
		System.out.println("getStudents()");
		return STUDENTS;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public Student createStudent(@RequestBody Student student) {
		System.out.println("createStudent(): " + student);
		return student;
	}
	
	@PutMapping(path="{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public Student updateStudent(@RequestBody Student student, @PathVariable Integer studentId) {
		System.out.println("updateStudent(): " + student + ": " + studentId);
		return student;
	}
	
	@DeleteMapping(path="{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {
		System.out.println("deleteStudent(): " + studentId);
		return ResponseEntity.ok().build();
	}
}

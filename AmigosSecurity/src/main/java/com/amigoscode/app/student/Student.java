package com.amigoscode.app.student;

public class Student {

	private Integer studentId;
	private String studentName;
	
	public Student(Integer studentId, String studentName) {
		setStudentId(studentId);
		setStudentName(studentName);
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
}

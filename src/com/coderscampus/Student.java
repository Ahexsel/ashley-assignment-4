package com.coderscampus;

public class Student implements Comparable <Student>{
	private int studentId;
	private String studentName;
	private String course;
	private int grade;

	
	public Student(int studentId, String studentName, String course, int grade) {
	this.studentId = studentId;
	this.studentName =studentName;
	this.course = course;
	this.grade = grade;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	@Override
	public int compareTo(Student that) {
		if(that == null) {
			return 1;	
		}if(this.grade > that.grade) {
			return -1;
		}else if (this.grade < that.grade) {
			return 1;
		}else if (this.grade == that.grade) {
			return this.studentName.compareTo(that.studentName);
		}
		return this.grade;
		
	}
	}
	
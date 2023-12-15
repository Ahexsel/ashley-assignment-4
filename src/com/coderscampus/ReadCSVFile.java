package com.coderscampus;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ReadCSVFile {
	private	Student[] students = new Student[100];
	
	public Student[] readStudentsData() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("MasterFile"))) {
		String line;
		int i = 0;
	
				while ((line = br.readLine()) != null) {
					String[] studentsInfo = line.split(",");
					if (studentsInfo.length == 4) {
					int studentId = Integer.parseInt(studentsInfo[0]);
					String studentName = studentsInfo[1];
					String course = studentsInfo[2];
					int grade = Integer.parseInt(studentsInfo[3]);
					
					Student student = new Student(studentId, studentName, course, grade);
					students[i] = student;
					i++;
					}
				
			}
				
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
		
		return students;
		
	}
	
	public void writeStudentsData(List<Student> students, String outputFileName) throws IOException {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
	    	String header = "Student ID,Student Name,Course,Grade";
	    	writer.write(header);
	    	writer.newLine();	    	
	    			
	        for (Student student : students) {
	            if (student != null) {
	                String line = student.getStudentId() + "," + student.getStudentName() + "," +
	                        student.getCourse() + "," + student.getGrade();
	                writer.write(line);
	                writer.newLine();
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        throw e;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		ReadCSVFile reader = new ReadCSVFile();
		Student[] students = reader.readStudentsData();
		
		Arrays.sort(students, (s1, s2) -> s1.getGrade().compareTo(s2.getGrade()));
		
		List<Student> course1Students = new ArrayList<>();
	    List<Student> course2Students = new ArrayList<>();
	    List<Student> course3Students = new ArrayList<>();

	    for (Student student : students) {
	    	if (student.getCourse().contains("APMTH")) {
	    		course1Students.add(student);
	    	} else if (student.getCourse().contains("STAT")) {
	    		course2Students.add(student);
	    	} else if (student.getCourse().contains("COMPSCI")) {
	    		course3Students.add(student);
	    	}
	    }
	
	reader.writeStudentsData(course1Students, "course1.csv");
	reader.writeStudentsData(course2Students, "course2.csv");
	reader.writeStudentsData(course3Students, "course3.csv");

	}
	}

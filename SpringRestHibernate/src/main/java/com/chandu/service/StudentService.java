package com.chandu.service;

import java.util.List;

import com.chandu.model.Student;

public interface StudentService {
	public void createStudent(Student student);
	public Student getStudentById(long id);
	public List<Student> getAllStudents();
	public void updateStudent(Student student);
	public void deleteStudent(long id);
}

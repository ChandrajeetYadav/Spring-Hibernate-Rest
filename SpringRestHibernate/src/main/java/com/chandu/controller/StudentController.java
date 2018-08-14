package com.chandu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chandu.model.Student;
import com.chandu.service.StudentService;
import com.chandu.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public void createStudent(@RequestBody Student student){
		studentService.createStudent(student);
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET, produces="application/json")
	public Student getStudentById(@PathVariable("id") long id){
		Student student = studentService.getStudentById(id);
		return student;
	}
	
	@RequestMapping(value="/students", method=RequestMethod.GET, produces="application/json")
	public List<Student> getAllStudents(){
		List<Student> studentList = studentService.getAllStudents();
		return studentList;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, produces="application/json")
	public void deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
	}
}

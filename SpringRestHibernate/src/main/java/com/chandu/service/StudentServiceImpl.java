package com.chandu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chandu.dao.StudentDAO;
import com.chandu.model.Student;

@Service
@Transactional(readOnly=true)
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDao;
	
	@Transactional
	public void createStudent(Student student) {
		studentDao.createStudent(student);
	}

	public Student getStudentById(long id) {
		return studentDao.getStudentById(id);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
	
	@Transactional
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
		
	}

	@Transactional
	public void deleteStudent(long id) {
		studentDao.deleteStudent(id);
	}
	
}

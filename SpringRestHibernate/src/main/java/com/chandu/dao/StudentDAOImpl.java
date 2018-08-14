package com.chandu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chandu.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

	public Student getStudentById(long id) {
		return sessionFactory.getCurrentSession().get(Student.class, id);
	}

	public List<Student> getAllStudents() {
		return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}

	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student obj = session.get(Student.class, student.getId());
		if(obj!=null){
			obj.setAge(student.getAge());
			obj.setName(student.getName());
			session.update(obj);
		}
	}

	public void deleteStudent(long id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		session.delete(student);
	}

}

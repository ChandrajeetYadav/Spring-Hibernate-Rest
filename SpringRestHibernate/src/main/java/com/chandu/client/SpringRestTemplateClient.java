package com.chandu.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.chandu.model.Student;

public class SpringRestTemplateClient {
	public static final String REST_BASE_URI="http://localhost:8080/SpringRestHibernate"; 
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void createStudent(){
		Student student = new Student();
		student.setAge(29);
		student.setName("Phanee");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity entity = new HttpEntity(student,headers);
		
		restTemplate.postForObject(REST_BASE_URI+"/create", entity, Student.class);
	}
	
	public static void getStudent(long id){
		Student student = restTemplate.getForObject(REST_BASE_URI+"/student/"+id, Student.class);
		System.out.println("*** Student with id: "+id+" ***");
		System.out.println(student);
	}
	
	
	public static void getAllStudents(){
		List<Map<String,Object>> studentList = restTemplate.getForObject(REST_BASE_URI+"/students", List.class);
		System.out.println("**** All Students ****");
		for(Map m: studentList){
			System.out.println(m.get("id")+" "+m.get("name")+" "+m.get("age"));;
		}
	}
	
	public static void updateStudent(){
		Student student = new Student();
		student.setId(45);
		student.setName("Choudary");
		student.setAge(38);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity entity = new HttpEntity(student,headers);
		
		restTemplate.put(REST_BASE_URI+"/update", entity, Student.class);
	}
	
	public static void deleteStudent(long id){
		restTemplate.delete(REST_BASE_URI+"/delete/"+id);
	}
	
	public static void main(String[] args){
		//createStudent();
		 getAllStudents();
		
		//updateStudent();
		//getStudent(45);
		
		//deleteStudent(51);
		//deleteStudent(50);
		
		
		
	}
}

package com.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entities.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	
	
	public Student insert(Student s)
	{
		System.out.println("Record inserted successfully");
		Student n=dao.save(s);
		return n;
				
		
	}
	public List<Student> getAllStudent()
	{
		List<Student> list=null;;
		
		try {
			
			list=(List<Student>) dao.findAll();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	public Optional<Student> byId(int id)
	{
		
		Optional<Student> s=null;
		
		s=this.dao.findById(id);
		
		return s;
		
	}
	
	public void deleteById(int id)
	{
		this.dao.deleteById(id);
		
	}
	public void deleteall()
	{
		this.dao.deleteAll();
		
	}
	public void update(int id, Student s)
	{
		
		s.setId(id);
		this.dao.save(s);
		
	}
	
	

}

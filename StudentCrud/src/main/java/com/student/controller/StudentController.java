package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.student.StudentService;
import com.student.entities.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/insert")
	public Student insert(@RequestBody Student s)
	{
		
		Student s1=(Student) this.service.insert(s);
		return s1;
		
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll()
	{
		List list=null;
		
		list=this.service.getAllStudent();
		return list;
		
		
		
	}
	@GetMapping("/getAll/{id}")
	public Optional<Student> getAll(@PathVariable int id)
	{
		Optional<Student> s=null;
		s=this.service.byId(id);
		return s;
		
		
		
		
		
	}
	@DeleteMapping("/deleteall")
	public String delete()
	{
		
		this.service.deleteall();
		
		return "deleted successfully";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		
		
		this.service.deleteById(id);
		return "deleted successfully";
		
	}
	
	@PutMapping("update/{id}")
	public String update(@RequestBody Student s,@PathVariable("id")int id)
	{
		
		this.service.update(id, s);
		return "update successfully";
	}
	
	
	
	
	
}

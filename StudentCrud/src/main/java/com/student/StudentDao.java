package com.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.student.entities.Student;

@Component
interface StudentDao extends CrudRepository<Student, Integer>  {
	

}

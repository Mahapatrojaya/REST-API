package com.CrudOpration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudOpration.entity.Student;
import com.CrudOpration.repository.StudentRepository;

@RestController
public class HomeController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to spring boot crud application";
	}
	@PostMapping("/saveStudent")
	public Student saveData(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	//fetching the student data
		@GetMapping("/getStudent/{rollNo}")
		public Student getStudentData(@PathVariable int rollNo) {
			Optional<Student> student=studentRepository.findById(rollNo);
			Student student1=student.get();
			return student1;
		}
	@GetMapping("/getAllstudents")
	public List<Student> getAll(){
		List<Student>studentList= studentRepository.findAll();
		return studentList;
	}
	@DeleteMapping("/deleteStudent/{rollNo}") //this {rollNo} we put the rollno like,what the store in database 101,102 this type
	public String deleteStudent(@PathVariable int rollNo) {
		Student student=studentRepository.findById(rollNo).get();
		if(student!=null)
			studentRepository.delete(student);
		return "Deleted Successfully";
	}
	@PutMapping("/UpdateStudent")
	public Student UpdateStudent(@RequestBody Student student) {
		 studentRepository.save(student);
		 return student;
	}
	
	}
	



package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class StudentController {
//	List<Student> students=new ArrayList<>();
//	
//	@GetMapping("/students")
//	public List<Student> students(){
//		Student s1=new Student();
//		s1.setId(1);
//		s1.setFirstName("Sneha");
//		s1.setLastName("Berkala");
//		
//		Student s2=new Student();
//		s2.setId(2);
//		s2.setFirstName("Abhi");
//		s2.setLastName("Shetty");
//		
//		students.add(s1);
//		students.add(s2);
//		return students;
//		
//	}
//	
//	@PreAuthorize("hasRole('ADMIN')")
//	@PostMapping("/students")	
//	public ResponseEntity<String> createStudent(@RequestBody Student student) {
//        try {
//            students.add(student);
//            return ResponseEntity.ok("Data saved!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                 .body("Not able to save the data");
//        }
//    }
	
	
	
//	public String createStudent(@RequestBody Student student) {
//	try {
//		students.add(student);
//		return "Data saved!!";
//	}
//	catch(Exception e){
//		return "Not able to save the data";
//	}
//
//}
	
	
	
	
	@GetMapping("/home")
	public String home() {
		return "<h1>Welcome Home</h1>";
	}

	@GetMapping("/user/home")
	public String user() {
		return "<h1>Welcome User</h1>";
	}

	@GetMapping("/admin/home")
	public String admin() {
		return "<h1>Welcome admin</h1>";
	}


}

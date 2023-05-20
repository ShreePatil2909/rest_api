package rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest_api.model.Student;
import rest_api.service.StdService;

@RestController
public class StudentController {

	@Autowired
	StdService service;

	@PostMapping("/students")
	public String createStudent(@RequestBody Student student) {

		service.createStudent(student);

		return "Succefully Store";
	}
	
	public Student getStudentById(@PathVariable("id") int id) {
		return service.getStudentById(id);
	}

	@GetMapping("/students")
	public List<Student> getAllStudent() {

		return service.getAllStudent();
	}

}

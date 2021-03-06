package org.shenba.school.controller;

import java.util.List;

import org.shenba.school.Exception.NoMatchFoundException;
import org.shenba.school.entity.Student;
import org.shenba.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shenba
 *
 */
@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * @return
	 */
	@GetMapping
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "show-students";
	}
	
	/**
	 * @return
	 */
	@GetMapping("/enroll")
	public String enrollStudents(Student student) {
		return "enroll-student";
	}
	
	/**
	 * @return
	 * @throws NoMatchFoundException 
	 */
	@PostMapping("/enroll")
	public String enrollStudents(Student student, Model model) throws NoMatchFoundException {
		studentService.saveStudent(student);
		model.addAttribute("students", studentService.getStudents());
		return "show-students";
	}
	
	/**
	 * @param studentName
	 * @return
	 */
	@GetMapping("/search/byname/{studentName}")
	public @ResponseBody List<Student> searchStudentsByName(@PathVariable("studentName") String studentName) {
		return studentService.serachByName(studentName);
	}
	
	/**
	 * @param studentId
	 * @return
	 * @throws NoMatchFoundException
	 */
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id") Long studentId) throws NoMatchFoundException {
		return studentService.findStudentById(studentId);
	}
	
	/**
	 * @param student
	 * @return
	 * @throws NoMatchFoundException
	 */
	@PostMapping
	public Student addOrUpdateStudent(@RequestBody Student student) throws NoMatchFoundException {
		return studentService.saveStudent(student);
	}
	
	/**
	 * @param studentId
	 * @return
	 * @throws NoMatchFoundException
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable("id") Long studentId) throws NoMatchFoundException {
		studentService.removeStudentById(studentId);
		return new ResponseEntity<String>("Removed student with id: " + studentId, HttpStatus.OK);
	}

}

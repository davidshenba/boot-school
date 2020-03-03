package org.shenba.school.controller;

import java.util.List;

import org.shenba.school.Exception.NoMatchFoundException;
import org.shenba.school.entity.Teacher;
import org.shenba.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * @return
	 */

	@GetMapping
	public List<Teacher> getAllTeachers() {
		return teacherService.getTeachers();
	}
	
	/**
	 * @param teacherName
	 * @return
	 */
	@GetMapping("/search/byname/{teacherName}")
	public List<Teacher> searchByName(@PathVariable("teacherName") String teacherName) {
		return teacherService.searchByName(teacherName);
	}
	
	/**
	 * @param teacherId
	 * @return
	 * @throws NoMatchFoundException
	 */
	@GetMapping("/{id}")
	public Teacher getTeacherById(@PathVariable("id") Long teacherId) throws NoMatchFoundException {
		return teacherService.findTeacherById(teacherId);
	}
	
	/**
	 * @param teacher
	 * @return
	 * @throws NoMatchFoundException
	 */
	@PostMapping
	public Teacher addOrUpdateTeacher(@RequestBody Teacher teacher) throws NoMatchFoundException {
		return teacherService.saveTeacher(teacher);
	}
	
	/**
	 * @param teacherId
	 * @return
	 * @throws NoMatchFoundException
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeTeacher(@PathVariable("id") Long teacherId) throws NoMatchFoundException {
		teacherService.removeTeacherById(teacherId);
		return new ResponseEntity<String>("Removed teacher with id: " + teacherId, HttpStatus.OK);
	}
	
	/**
	 * @param page
	 * @param rowsPerPage
	 * @return
	 */
	@GetMapping("/paginate")
	public List<Teacher> goToPage(@RequestParam int page, @RequestParam int rowsPerPage) {
		return teacherService.goToPage((page - 1), rowsPerPage);
	}

}

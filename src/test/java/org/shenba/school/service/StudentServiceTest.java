package org.shenba.school.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.shenba.school.Exception.NoMatchFoundException;
import org.shenba.school.entity.Student;
import org.shenba.school.repository.StudentRepository;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shenba
 *
 */
@SpringBootTest
public class StudentServiceTest {
	
	@Mock
	private StudentRepository studentRepo;
	
	@InjectMocks
	private StudentService studentService = new StudentService();
	
	/**
	 * 
	 */
	@Test
    public void testGetStudents() {
		
		List<Student> students = new ArrayList<Student>();
		students.add(getMockStudent());
		when(studentRepo.findAll()).thenReturn(students);
		
        List<Student> studentResults = studentService.getStudents();
        assertEquals(studentResults.isEmpty(), false);
    }
	
	/**
	 * 
	 */
	@Test
    public void testFindStudentById() throws NoMatchFoundException {
		
		Student student = getMockStudent();
		when(studentRepo.findById(1l)).thenReturn(Optional.of(student));
		
        Student studentResult = studentService.findStudentById(1l);
        assertNotNull(studentResult);
    }
	
	/**
	 * @return
	 */
	private Student getMockStudent() {
		Student student = new Student();
		student.setStudentClass("1");
		student.setStudentName("Mock");
		student.setStudentSection('A');
		student.setStudentId(12813L);
		student.setDateOfBirth(new Date());
		student.setDateOfJoining(new Date());
		student.setGender('M');
		student.setBloodGroup("O+");
		return student;
	}
	
}

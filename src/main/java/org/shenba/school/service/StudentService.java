package org.shenba.school.service;

import java.util.List;
import java.util.Optional;

import org.shenba.school.Exception.NoMatchFoundException;
import org.shenba.school.entity.Student;
import org.shenba.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	/**
	 * @return
	 */
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	/**
	 * @param studentId
	 * @return
	 * @throws NoMatchFoundException
	 */
	public Student findStudentById(Long studentId) throws NoMatchFoundException {
		Optional<Student> student = studentRepo.findById(studentId);
		if(!student.isPresent()) {
			throw new NoMatchFoundException("The student you are trying to find does not exist!");
		}
		return student.get();
	}
	
	/**
	 * @param student
	 * @return
	 * @throws NoMatchFoundException
	 */
	public Student saveStudent(Student student) throws NoMatchFoundException {
		if(student.getStudentId() != null) {
			Optional<Student> existingStudent = studentRepo.findById(student.getStudentId());
			if(existingStudent.isPresent()) {
				Student newStudent = existingStudent.get();
				newStudent.setBloodGroup(student.getBloodGroup());
				newStudent.setDateOfBirth(student.getDateOfBirth());
				newStudent.setDateOfJoining(student.getDateOfJoining());
				newStudent.setGender(student.getGender());
				newStudent.setStudentClass(student.getStudentClass());
				newStudent.setStudentName(student.getStudentName());
				newStudent.setStudentSection(student.getStudentSection());
				return studentRepo.save(newStudent);
			} else {
				throw new NoMatchFoundException("The student you are trying to update does not exist!");
			}
		}
		return studentRepo.save(student);
	}
	
	/**
	 * @param studentId
	 * @throws NoMatchFoundException
	 */
	public void removeStudentById(Long studentId) throws NoMatchFoundException {
		Optional<Student> student = studentRepo.findById(studentId);
		if(!student.isPresent()) {
			throw new NoMatchFoundException("The student you are trying to remove does not exist!");
		}
		studentRepo.deleteById(studentId);
	}
	
	/**
	 * @param studentName
	 * @return
	 */
	public List<Student> serachByName(String studentName) {
		return studentRepo.findByStudentNameContainsIgnoreCase(studentName);
	}

}

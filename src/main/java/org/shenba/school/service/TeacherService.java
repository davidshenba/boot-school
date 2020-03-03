package org.shenba.school.service;

import org.shenba.school.Exception.NoMatchFoundException;
import org.shenba.school.entity.Teacher;
import org.shenba.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	/**
	 * @return
	 */
	public List<Teacher> getTeachers() {
		return teacherRepo.findAll();
	}
	
	/**
	 * @param teacherId
	 * @return
	 * @throws NoMatchFoundException
	 */
	public Teacher findTeacherById(Long teacherId) throws NoMatchFoundException {
		Optional<Teacher> teacher = teacherRepo.findById(teacherId);
		if(!teacher.isPresent()) {
			throw new NoMatchFoundException("The teacher you are trying to find does not exist!");
		}
		return teacher.get();
	}
	
	/**
	 * @param teacher
	 * @return
	 * @throws NoMatchFoundException
	 */
	public Teacher saveTeacher(Teacher teacher) throws NoMatchFoundException {
		if(teacher.getTeacherId() != null) {
			Optional<Teacher> existingTeacher = teacherRepo.findById(teacher.getTeacherId());
			if(existingTeacher.isPresent()) {
				Teacher newTeacher = existingTeacher.get();
				newTeacher.setBloodGroup(teacher.getBloodGroup());
				newTeacher.setDateOfBirth(teacher.getDateOfBirth());
				newTeacher.setDateOfJoining(teacher.getDateOfJoining());
				newTeacher.setGender(teacher.getGender());
				newTeacher.setInChargeClass(teacher.getInChargeClass());
				newTeacher.setTeacherName(teacher.getTeacherName());
				newTeacher.setInChargeSection(teacher.getInChargeSection());
				return teacherRepo.save(newTeacher);
			} else {
				throw new NoMatchFoundException("The teacher you are trying to update does not exist!");
			}
		}
		return teacherRepo.save(teacher);
	}
	
	/**
	 * @param teacherId
	 * @throws NoMatchFoundException
	 */
	public void removeTeacherById(Long teacherId) throws NoMatchFoundException {
		Optional<Teacher> teacher = teacherRepo.findById(teacherId);
		if(!teacher.isPresent()) {
			throw new NoMatchFoundException("The teacher you are trying to remove does not exist!");
		}
		teacherRepo.deleteById(teacherId);
	}
	
	/**
	 * @param teacherName
	 * @return
	 */
	public List<Teacher> searchByName(String teacherName) {
		return teacherRepo.findByTeacherNameContainsIgnoreCase(teacherName);
	}
	
	/**
	 * @param pageNum
	 * @param rowsPerPage
	 * @return
	 */
	public List<Teacher> goToPage(int pageNum, int rowsPerPage) {
		Page<Teacher> teacherPage = teacherRepo.findAll(PageRequest.of(pageNum, rowsPerPage));
		return teacherPage.getContent();
	}

}

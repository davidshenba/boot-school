package org.shenba.school.repository;

import org.shenba.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	List<Teacher> findByTeacherNameContainsIgnoreCase(String teacherName);
	
}

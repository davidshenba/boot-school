package org.shenba.school.repository;

import org.shenba.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shenba
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

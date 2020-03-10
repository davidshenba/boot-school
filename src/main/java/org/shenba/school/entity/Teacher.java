package org.shenba.school.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "T_TEACHER")
public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TCHR_ID")
	private Long teacherId;
	
	@Column(name = "TCHR_NAME", nullable = false, length = 50)
	private String teacherName;
	
	@Column(name = "TCHR_INCHARGE_CLASS", nullable = false, length = 3)
	private String inChargeClass;
	
	@Column(name = "TCHR_DOB", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name = "TCHR_SEC", nullable = false)
	private char inChargeSection;
	
	@Column(name = "TCHR_DOJ", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	@Column(name = "TCHR_BLD_GRP", length = 3)
	private String bloodGroup;
	
	@Column(name = "TCHR_GENDER", length = 1, nullable = false)
	private char gender;

	@Column(name = "TCHR_SUBJECT", length = 1, nullable = false)
	private char subject;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classTeacher")
	private List<Student> students;

	/**
	 * @return the teacherId
	 */
	public Long getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the inChargeClass
	 */
	public String getInChargeClass() {
		return inChargeClass;
	}

	/**
	 * @param inChargeClass the inChargeClass to set
	 */
	public void setInChargeClass(String inChargeClass) {
		this.inChargeClass = inChargeClass;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the inChargeSection
	 */
	public char getInChargeSection() {
		return inChargeSection;
	}

	/**
	 * @param inChargeSection the inChargeSection to set
	 */
	public void setInChargeSection(char inChargeSection) {
		this.inChargeSection = inChargeSection;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @return the subject
	 */
	public char getSubject() {
		return subject;
	}

	/**
	 * @param subject the gender to set
	 */
	public void setSubject(char subject) {
		this.subject = subject;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}

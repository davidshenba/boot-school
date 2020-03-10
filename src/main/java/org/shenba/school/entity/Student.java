package org.shenba.school.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author shenba
 *
 */
@Entity
@Table(name = "T_STUDENT")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ST_ID")
	private Long studentId;
	
	@Column(name = "ST_NAME", nullable = false, length = 50)
	private String studentName;
	
	@Column(name = "ST_CLASS", nullable = false, length = 3)
	private String studentClass;
	
	@Column(name = "ST_DOB", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name = "ST_SEC", nullable = false)
	private char studentSection;
	
	@Column(name = "ST_DOJ", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	@Column(name = "ST_BLD_GRP", length = 3)
	private String bloodGroup;
	
	@Column(name = "ST_GENDER", length = 1, nullable = false)
	private char gender;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ST_CLASS", referencedColumnName = "TCHR_INCHARGE_CLASS", insertable=false, updatable=false)
	@JoinColumn(name = "ST_SEC", referencedColumnName = "TCHR_SEC", insertable=false, updatable=false)
	private Teacher classTeacher;

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentClass
	 */
	public String getStudentClass() {
		return studentClass;
	}

	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
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
	 * @return the studentSection
	 */
	public char getStudentSection() {
		return studentSection;
	}

	/**
	 * @param studentSection the studentSection to set
	 */
	public void setStudentSection(char studentSection) {
		this.studentSection = studentSection;
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

}

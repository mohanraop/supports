package com.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Student")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Stud_Id")
	private int studId;
	
	@Column(name="Stud_BirthYear")
	private int studBirthYear;
	
	@Column(name="Stud_GradYear")
	private int studGradYear;
	
	@Column(name="Stud_Name")
	private String studName;
	
	@Column(name="Stud_Course")
	private String studCourse;
	
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public int getStudBirthYear() {
		return studBirthYear;
	}
	public void setStudBirthYear(int studBirthYear) {
		this.studBirthYear = studBirthYear;
	}
	public int getStudGradYear() {
		return studGradYear;
	}
	public void setStudGradYear(int studGradYear) {
		this.studGradYear = studGradYear;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudCourse() {
		return studCourse;
	}
	public void setStudCourse(String studCourse) {
		this.studCourse = studCourse;
	}
	

}

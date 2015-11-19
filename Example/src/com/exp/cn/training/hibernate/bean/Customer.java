package com.exp.cn.training.hibernate.bean;

import java.util.Date;

public class Customer {
private Long id;
private String name;
private String gender;

private Date dateOfBirth;
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public void setId(Long id) {
	this.id = id;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

}

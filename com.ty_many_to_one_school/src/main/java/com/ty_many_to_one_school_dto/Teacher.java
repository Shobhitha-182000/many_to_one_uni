package com.ty_many_to_one_school_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id;
	private String teacher_name;
	private String salary;
	@ManyToOne
	private School school;
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", salary=" + salary
				+ ", school=" + school + "]";
	}
	
	
}

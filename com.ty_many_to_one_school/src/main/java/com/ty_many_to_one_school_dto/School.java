package com.ty_many_to_one_school_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

 

@Entity
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	private String name;
	private String location;
	 
	 
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
	@Override
	public String toString() {
		return "School [sid=" + sid + ", name=" + name + ", location=" + location + ", student="  + "]";
	}
	
}

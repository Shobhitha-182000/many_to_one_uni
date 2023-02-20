package com.ty_many_to_one_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Bank_name;
	private String head_office;
	private String ceo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBank_name() {
		return Bank_name;
	}
	public void setBank_name(String bank_name) {
		Bank_name = bank_name;
	}
	public String getHead_office() {
		return head_office;
	}
	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", Bank_name=" + Bank_name + ", head_office=" + head_office + ", ceo=" + ceo + "]";
	}
	
	
	
}

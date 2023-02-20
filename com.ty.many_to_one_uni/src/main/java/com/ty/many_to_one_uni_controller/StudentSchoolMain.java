package com.ty.many_to_one_uni_controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.many_to_one_uni_dto.School;
import com.ty.many_to_one_uni_dto.Student;

public class StudentSchoolMain {
	public static void main(String[] args) {
		 
	 
		
		Student s1=new Student();
		s1.setName("Chota Beam");
		s1.setMarks("78.2");
		s1.setPhone(2761663);
		s1.setAddress("blr");
		
		Student s=new Student(); 
		s.setName("DoreMan");
		s.setMarks("99");
		s.setPhone(73284682365l);
		s.setAddress("ckm");
		
		Student s3=new Student();
		s3.setName("Dora");
		s3.setPhone(37286586);
		s3.setMarks("77");
		s3.setAddress("skp");
		
		School school=new School();
		school.setName("VVIS");
		school.setLocation("BLR");
		
		s.setSchool(school);
		s1.setSchool(school);
		s3.setSchool(school);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		 entityTransaction.begin();
		 entityManager.persist(school);
		 entityManager.persist(s);
		 entityManager.persist(s1);
		 entityManager.persist(s3);
		 entityTransaction.commit();
				
		
		
		
		
		
		
	}
}

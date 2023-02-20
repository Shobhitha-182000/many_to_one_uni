package com.ty_many_to_one_school_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_many_to_one_school_dto.School;
import com.ty_many_to_one_school_dto.Student;

 

public class StudebtDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//save
	public void saveStudent(List<Student> list,int school_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school=entityManager.find(School.class, school_id);
		
		entityTransaction.begin();
		 
		 for(Student student:list) {
			 student.setSchool(school);
			 entityManager.persist(student);
		 }
		 
		 
		entityTransaction.commit();
	}
	// update
	 public void updateStudent(int school_id,Student student) {
		 EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Student recieve=entityManager.find(Student.class, school_id);
		 entityTransaction.begin();
		 if(recieve!=null) {	 
			 entityManager.merge(recieve);
			  
		 }
		 else
			 System.out.println("id not present");	
	 }
	
	//remove
		public void removeStudent(int sid) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			 Student student=entityManager.find(Student.class, sid);
			entityTransaction.begin();
			entityManager.remove(student);
			 
			entityTransaction.commit();
		}
		
		//getOne
		public Student getOneStudent(int sid) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			 Student student=entityManager.find(Student.class, sid);
			return student;
		}
		
		//getAll
		public List<Student> getAll(){
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			Query query=entityManager.createQuery("select e from Student e");
			List<Student> list=query.getResultList();
			return list;
		}
}

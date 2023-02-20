package com.ty_many_to_one_school_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_many_to_one_school_dto.School;
import com.ty_many_to_one_school_dto.Teacher;

public class TeacherDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//save
	public void saveTeacher(List<Teacher>list,int school_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School rcvSchool=entityManager.find(School.class, school_id);
		entityTransaction.begin();
		 
			for(Teacher teacher:list) {
				entityManager.persist(teacher);
			}
		entityTransaction.commit();	
	}
	
	//update
	public void updateTeacher(Teacher teacher,int teacher_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Teacher rcvteacher=entityManager.find(Teacher.class, teacher_id);
		entityTransaction.begin();
		if(rcvteacher!=null) {
			teacher.setTeacher_id(teacher_id);
		entityManager.merge(teacher);
		}
		entityTransaction.commit();	
		
	}
	
	//remove 
	public void removeTeacher(int teacher_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Teacher rcvteacher=entityManager.find(Teacher.class, teacher_id);
		
		entityTransaction.begin();
		entityManager.remove(rcvteacher);
		entityManager.remove(rcvteacher.getSchool());
		entityManager.remove(rcvteacher);
		
		entityTransaction.commit();
	}
	
	//get one
	public Teacher getOneTeacher(int teacher_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Teacher rcvteacher=entityManager.find(Teacher.class, teacher_id);
		return rcvteacher;
	}
	
	//get all
	public List<Teacher> getAllTeacher(){
		EntityManager entityManager=getEntityManager();
		 
		Query query=entityManager.createQuery("select c from Teacher c ");
		List<Teacher>teacher=query.getResultList();
		return teacher;
	}
	
	
	
	
	
	
	
}

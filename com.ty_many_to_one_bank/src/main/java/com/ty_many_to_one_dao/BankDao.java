package com.ty_many_to_one_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_many_to_one_dto.Bank;
import com.ty_many_to_one_dto.Branch;

public class BankDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	//save 
	public void saveBranch(Bank bank) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}
	//update
	public void updateBranch(Bank bank,int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank1=entityManager.find(Bank.class, id);
		entityTransaction.begin();
		if(bank1!=null) {
			bank1.setId(id);
		
			entityManager.merge(bank1);
		}
		entityTransaction.commit();
	}
	//remove
	public void removeCompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=entityManager.find(Bank.class, id);
		entityTransaction.begin();
		entityManager.remove(bank);
		 
		entityTransaction.commit();
	}
	
	//getOne
	public Bank getOneCompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=entityManager.find(Bank.class, id);
		return bank;
	}
	
	//getAll
	public List<Bank> getAll(){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select e from Student e");
		List<Bank> list=query.getResultList();
		return list;
	}
	

}

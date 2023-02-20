package com.ty_many_to_one_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_many_to_one_dto.Bank;
import com.ty_many_to_one_dto.Branch;
 

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	//save 
	public void saveBranch(List<Branch> branch) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		for(Branch branch1:branch) {
			entityManager.persist(branch);
			Bank bank=branch1.getBank();
			entityManager.merge(bank);		
	}
		 
		entityTransaction.commit();
	}
	//update
	public void updateBranch(Branch branch,int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch rcvBranch=entityManager.find(Branch.class, id);
		entityTransaction.begin();
		if(branch!=null) {
			branch.setId(id);
			branch.setBank(rcvBranch.getBank());
			entityManager.merge(branch);
			entityManager.merge(branch.getBank());
		}
		entityTransaction.commit();
	}
	//remove
	public void removeCompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class, id);
		entityTransaction.begin();
		entityManager.remove(branch);
		entityManager.remove(branch.getBank());
		 
		entityTransaction.commit();
	}
	
	//getOne
	public Branch getOneCompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class, id);
		//System.out.println(branch);
		System.out.println(branch.getBank());
		return branch;
	}
	
	//getAll
	public List<Branch> getAll(){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select e from Student e");
		List<Branch> list=query.getResultList();
		return list;
	}
	


}

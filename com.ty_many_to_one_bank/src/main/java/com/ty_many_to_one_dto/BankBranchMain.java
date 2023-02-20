package com.ty_many_to_one_dto;

import java.util.Scanner;

import com.ty_many_to_one_dao.BankDao;
import com.ty_many_to_one_dao.BranchDao;

 
public class BankBranchMain {
	public static void main(String[] args) {
		 
			Scanner scanner=new Scanner(System.in);
			BankDao bankDao=new BankDao();
			BranchDao branchDao=new BranchDao();
			boolean flag=true;
			
			do {
				System.out.println("do you want 1.save school \n 2.update school \n 3.remove school \n 4.getone \n 5.get all \n 6.exit");
				System.out.println("choose any of one");
				int choose=scanner.nextInt();
				switch (choose) {
				case 1:{
						System.out.println("enter the bank name");
						String name=scanner.next();
						
						System.out.println("enter the headoffice location");
						String location=scanner.next();
						
						System.out.println("enter the ceo");
					     String ceo=scanner.next();
						 
					    Bank bank=new Bank();
					    bank.setBank_name(name);
					    bank.setCeo(ceo);
					    bank.setHead_office(location);
					   
						 
						
						System.out.println("enter the student name");
						String sname=scanner.next();
						System.out.println("enter the student marks");
						double marks=scanner.nextDouble();
						System.out.println("enter the phone");
						long phone=scanner.nextLong();
						System.out.println("enter the address");
						String address=scanner.next();
						
						
				}break;
				case 2:{
					
				}break;
				case 3:{
					
				}break;
				
				case 4:{
					
				}break;
				case 5:{
					
				}break;
				case 6:{
						flag=true;
						System.out.println("THANK YOU");
				}break;
				default:
					break;
				}
				
				
			}while(flag);
			
		
	

	}
}

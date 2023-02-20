package com.ty_many_to_one_school_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty_many_to_one_school_dao.SchoolDao;
import com.ty_many_to_one_school_dto.School;
import com.ty_many_to_one_school_dto.Student;
import com.ty_many_to_one_school_dto.Teacher;
import com.ty_many_to_one_school_dao.StudebtDao;
import com.ty_many_to_one_school_dao.TeacherDao;
 
public class StudentTeacherDriver {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		 
		 StudebtDao studebtDao=new StudebtDao();
		SchoolDao schoolDao=new SchoolDao();
		TeacherDao teacherDao=new TeacherDao();
		boolean flag=true;
		
		do {
			System.out.println("do you want 1.save school \n 2.update school \n 3.remove school \n 4.getone \n 5.get all \n 6.exit");
			System.out.println("choose any of one");
			int choose=scanner.nextInt();
			switch (choose) {
			case 1:{
				System.out.println("enter the School name");
				String name=scanner.next();
				
				System.out.println("enter the location");
				String address=scanner.next();
				
				School school =new School();
				school.setName(name);
				school.setLocation(address);
				
				schoolDao.saveSchool(school);
				
				boolean repeat=true;
				do {
				System.out.println("do you want to add more  click on 1.to add student and teacher 2.exit");
				int select=scanner.nextInt();
				 
				 
					switch (select) {
					case 1:{
						System.out.println("enter the school id to be inserted");
						int school_id=scanner.nextInt();
						
						System.out.println("enter the Student name :");
						String s1name=scanner.next();
						
						System.out.println("enter the phone");
						long phone1=scanner.nextLong();
						
						System.out.println("enter the address");
						String Saddress1=scanner.next();
						
						System.out.println("enter the marks");
						String marks1=scanner.next();
						
						Student s4=new Student();
						
						System.out.println("enter the school id");
						int id=scanner.nextInt();
						
						s4.setName(s1name);
						s4.setMarks(marks1);
						s4.setPhone(phone1);
						s4.setAddress(Saddress1);
						s4.setSchool(school);
						
						List<Student>list1=new ArrayList<Student>();
						list1.add(s4);
						studebtDao.saveStudent(list1, school_id);
						System.out.println("inserted");
					}break;
					case 2:{
						//teacher information
						System.out.println("enter the school id to be inserted");
						int school_id=scanner.nextInt();				
		
						Teacher t1 =new Teacher();
						System.out.println("enter the teacher name");
						String teacher_name1=scanner.next();
						
						System.out.println("enter the salary");
						String salary1=scanner.next();
						
						t1.setTeacher_name(teacher_name1);
						t1.setSalary(salary1);
						t1.setSchool(school);
						 
						
						List<Teacher>teacher_list1=new ArrayList<Teacher>();
						teacher_list1.add(t1);
						
						teacherDao.saveTeacher(teacher_list1,school_id);
					}break;
						
					case 3:{
						repeat=false;
						System.out.println("Thank you");
					}break;

					default:
						break;
					}
					
				}while(repeat);
				
			}break;
			case 2:{
				boolean choose1=true;
				do {
					System.out.println("do you want to update 1.school 2.student 3.teacher 4.exit");
					int key=scanner.nextInt();
					switch (key) {
					case 1:{
						System.out.println("enter the id to be updated");
						int school_id=scanner.nextInt();
						
						System.out.println("enter the School name");
						String name=scanner.next();
						
						System.out.println("enter the location");
						String address=scanner.next();
						
						School school= new School();
						school.setSid(school_id);
						school.setName(name);
						school.setLocation(address);
						schoolDao.updateSchool(school_id, school);
						System.out.println("updated==========");
						
					}break;
					case 2:{
						System.out.println("enter the id to be updated");
						int student_id=scanner.nextInt();
						
						System.out.println("enter the Student name :");
						String s1name=scanner.next();
						
						System.out.println("enter the marks");
						String marks1=scanner.next();
						
						Student s4=new Student();
						
						s4.setName(s1name);
						s4.setMarks(marks1);
						
						studebtDao.updateStudent(student_id, s4);
						System.out.println("updated==========");
						 
						
					}break;
					case 3:{
						System.out.println("enter the id to be updated");
						int teacher_id=scanner.nextInt();
						
						Teacher t1 =new Teacher();
						System.out.println("enter the teacher name");
						String teacher_name1=scanner.next();
						
						System.out.println("enter the salary");
						String salary1=scanner.next();
						
						t1.setTeacher_name(teacher_name1);
						t1.setSalary(salary1);
						 
						 teacherDao.updateTeacher(t1, teacher_id);
						 System.out.println("updated==========");
						
						
						
					}break;
					case 4:{
						choose1=false;
						System.out.println("Thank you");
						
					}break;

					default:
						break;
					}
				}while(choose1);
				
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

package com.example.main;
import com.example.*;
import com.example.dao.*;
import com.example.entity.*;
public class App {
	public static void main(String[] args)
	{
		StudentDao dao=new StudentDao();
		System.out.println("INSERT");
		Student s1=new Student("prem","prem@gamil.com");
		int newId1=dao.insertStudent(s1);
		System.out.println("New Item Inserted"+newId1);
		Student s2=new Student("shyam","shyam@gamil.com");
		int newId2=dao.insertStudent(s2);
		System.out.println("New Item Inserted"+newId2);
		System.out.println("---SELECT BY ID---");
		Student fetchID1=dao.getStudentById(newId1);
		System.out.println("Fetched:"+fetchID1);
		Student fetchID2=dao.getStudentById(newId2);
		System.out.println("Fetched:"+fetchID2);
		System.out.println("---UPDATE ID---");
		boolean updated=dao.UpdateStudentEmail(newId2,"shyam123@gmail.com");
		System.out.println("Updated Record Is"+updated);
		System.out.println("After Updated Record Is"+dao.getStudentById(newId2));
		System.out.println("---DELETE ID---");
		boolean delete=dao.deleteStudent(newId2);
		System.out.println("Deleted Record Is"+delete);
		System.out.println("After Deleted Record Is"+dao.getStudentById(newId2));
		
	}

}

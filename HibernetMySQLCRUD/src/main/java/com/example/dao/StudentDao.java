package com.example.dao;
import com.example.entity.*;
import com.example.util.*;
import org.hibernate.*;
public class StudentDao {
	
	
	public int insertStudent(Student student)
	{
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			Integer id=(Integer)session.save(student);
			tx.commit();
			return id;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return -1;
		}
	}
	public boolean UpdateStudentEmail(int id,String newEmail)
	{
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			Student s=session.get(Student.class,id);
			if(s==null)return false;
			s.setEmail(newEmail);
			tx.commit();
			return true;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public boolean deleteStudent(int id)
	{
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			Student s=session.get(Student.class,id);
			if(s==null)return false;
			session.refresh(s);
			tx.commit();
			return true;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public Student getStudentById(int id) {
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			return session.get(Student.class,id);
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
	}

}

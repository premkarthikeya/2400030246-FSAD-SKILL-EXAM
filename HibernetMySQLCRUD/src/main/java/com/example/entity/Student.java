package com.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false,length=100)
	private String name;
	@Column(unique=true,length=100)
	private String email;
	public Student() {}
	public Student(String name, String email) {
		this.name=name;
		this.email=email;
	}
	public int getId() {return id;}
	public void setId() {this.id = id;}
	 
	public String getName(){return name;}
	public void setName(String name) {this.name=name;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email=email;}
	@Override
	public String toString()
	{
		return "Student{id="+id+",name='"+name+"',email='"+email+"'}";
	}
	
	
	
	

}

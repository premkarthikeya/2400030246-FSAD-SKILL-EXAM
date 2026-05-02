package com.demo.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 @Column(nullable = false, length = 60)
 private String name;
 @Column(nullable = false, length = 20)
 private String dept;
 private double cgpa;
 private int marks;
 private boolean passed;
 public Student() {}
 public Student(String name, String dept, double cgpa, int marks, boolean passed) {
 this.name = name;
 this.dept = dept;
 this.cgpa = cgpa;
 this.marks = marks;
 this.passed = passed;
 }
 public Integer getId() { return id; }
 public String getName() { return name; }
 public String getDept() { return dept; }
 public double getCgpa() { return cgpa; }
 public int getMarks() { return marks; }
 public boolean isPassed() { return passed; }
 public void setName(String name) { this.name = name; }
 public void setDept(String dept) { this.dept = dept; }
 public void setCgpa(double cgpa) { this.cgpa = cgpa; }
 public void setMarks(int marks) { this.marks = marks; }
 public void setPassed(boolean passed) { this.passed = passed; }
 @Override
 public String toString() {
 return "Student{id=" + id + ", name='" + name + "', dept='" + dept +
 "', cgpa=" + cgpa + ", marks=" + marks + ", passed=" + passed + "}";
 }
}
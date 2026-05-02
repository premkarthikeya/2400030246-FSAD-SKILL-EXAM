package com.student.model;

import java.util.List;

public class StudentCourses {

    private String rollNo;
    private String name;
    private List<String> courses;

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void print() {
        System.out.println(rollNo + " | " + name + " | courses = " + courses.size());
        for (String c : courses) {
            System.out.println("  - " + c);
        }
    }
}
package com.student.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.student.model.StudentCourses;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentCourses a = (StudentCourses) ctx.getBean("sc1");
        StudentCourses b = (StudentCourses) ctx.getBean("sc2");

        a.print();
        System.out.println("--------------------");
        b.print();
    }
}
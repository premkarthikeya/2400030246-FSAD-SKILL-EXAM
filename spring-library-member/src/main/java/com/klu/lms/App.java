package com.klu.lms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.klu.lms.Member;

public class App {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Member m1 = (Member) ctx.getBean("member1");
        Member m2 = (Member) ctx.getBean("member2");

        m1.print();
        m2.print();
    }
}
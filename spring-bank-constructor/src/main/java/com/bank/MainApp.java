package com.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Customer c1 = (Customer) ctx.getBean("cust1");
        Customer c2 = (Customer) ctx.getBean("cust2");

        c1.print();
        c2.print();
    }
}
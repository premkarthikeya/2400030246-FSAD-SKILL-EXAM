package com.student.model;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.student.model.Order;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Order o = (Order) ctx.getBean("order1");
        o.printInvoice();
    }
}
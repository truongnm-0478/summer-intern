package org.example;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean(UserService.class);

        try {
            userService.createUser("testuser1");
            userService.createUser("testuser2");
            System.out.println("Users created successfully");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        try {
            userService.transferMoney(1L, 2L, 100);
            System.out.println("Money transferred successfully");
        } catch (Exception e) {
            System.out.println("Transaction rolled back due to error: " + e.getMessage());
        }
    }
}

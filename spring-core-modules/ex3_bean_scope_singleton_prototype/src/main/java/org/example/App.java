package org.example;

import org.example.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args )
    {
        // Load Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get BeanService bean from context
        BeanService beanService = context.getBean(BeanService.class);

        // Print message
        System.out.println("First call to BeanService:");
        beanService.printBeans();

        System.out.println("Second call to BeanService:");
        beanService.printBeans();

    }

}

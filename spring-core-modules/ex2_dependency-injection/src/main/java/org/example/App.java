package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Load Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get MessagePrinter bean from context
        MessagePrinter printer = context.getBean(MessagePrinter.class);

        // Print message
        printer.printMessage();
    }
}

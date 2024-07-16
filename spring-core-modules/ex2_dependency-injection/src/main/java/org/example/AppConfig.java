package org.example;

import org.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    private final MessageService service;

    @Autowired
    public AppConfig(MessageService service) {
        this.service = service;
    }
}

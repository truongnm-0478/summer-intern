package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean instance created");
    }

    public String getMessage() {
        return "Hello from SingletonBean!";
    }
}

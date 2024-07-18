package nmt;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* nmt.MyService.doSomething())")
    public void beforeDoSomething() {
        System.out.println("Before advice: Before calling doSomething()");
    }

    @After("execution(* nmt.MyService.doSomething())")
    public void afterDoSomething() {
        System.out.println("After advice: After calling doSomething()");
    }
}
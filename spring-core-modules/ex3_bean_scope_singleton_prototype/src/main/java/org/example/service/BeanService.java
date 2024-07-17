package org.example.service;

import org.example.beans.PrototypeBean;
import org.example.beans.SingletonBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanService {

    @Autowired
    private SingletonBean singletonBean;


    @Autowired
//    private PrototypeBean prototypeBean;
    private ObjectProvider<PrototypeBean> prototypeBeanProvider;


    public void printBeans() {
        System.out.println("Printing beans from BeanService:");
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
        System.out.println(singletonBean.getMessage());
        System.out.println(prototypeBean.getMessage());
        System.out.println();
    }
}

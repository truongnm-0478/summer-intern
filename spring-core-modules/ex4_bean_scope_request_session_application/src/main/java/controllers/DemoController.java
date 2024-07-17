package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.beans.ApplicationBean;
import org.example.beans.RequestBean;
import org.example.beans.SessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DemoController {
    @Autowired
    private ApplicationBean applicationBean;

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private RequestBean requestBean;

    @GetMapping("/demo")
    public String demoPage(Model model, HttpServletRequest httpRequest) {
        // Set values for beans
        applicationBean.setValue("Application Scoped Bean Value");
        HttpSession session = httpRequest.getSession();
        sessionBean.setValue("Session Scoped Bean Value");
        requestBean.setValue("Request Scoped Bean Value");

        // Add beans to model for display
        model.addAttribute("applicationBean", applicationBean);
        model.addAttribute("sessionBean", sessionBean);
        model.addAttribute("requestBean", requestBean);

        return "demo";
    }
}

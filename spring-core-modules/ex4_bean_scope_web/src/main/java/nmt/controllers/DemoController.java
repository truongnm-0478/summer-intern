package nmt.controllers;

import nmt.beans.ApplicationBean;
import nmt.beans.RequestBean;
import nmt.beans.SessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
    @Autowired
    private ApplicationBean applicationBean;

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private RequestBean requestBean;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
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

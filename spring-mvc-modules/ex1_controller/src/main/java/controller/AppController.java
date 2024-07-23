package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome to the application!");
        return "welcome";
    }

    @PostMapping("/process")
    public String process(Model model) {
        model.addAttribute("message", "Processing your request...");
        return "process";
    }
}
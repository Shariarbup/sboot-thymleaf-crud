package org.example.sbootthymleafcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "html/login";
    }

    @GetMapping("/logout")
    public String logout() {
        // No need for controller logic. Spring Security handles logout.
        return "redirect:/login?logout";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "html/403";
    }
}

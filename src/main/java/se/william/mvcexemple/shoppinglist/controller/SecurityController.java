package se.william.mvcexemple.shoppinglist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @GetMapping("/loginPage")
    public String loginPage(){
        return "security/login-form";
    }

    @GetMapping("/loginError")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "security/login-form";
    }

    @PostMapping("/logOut")
    public String logOut(Model model){
        model.addAttribute("logOut", true);
        return "security/login-form";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "security/access-denied";
    }


}

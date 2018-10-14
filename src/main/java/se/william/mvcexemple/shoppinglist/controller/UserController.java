package se.william.mvcexemple.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.william.mvcexemple.shoppinglist.entity.User;
import se.william.mvcexemple.shoppinglist.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "security/registration";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "security/registration";
        }
        this.userService.saveUser(user);
        model.addAttribute("regSuccess", true);
        return "security/login-form";
    }

    @GetMapping("/profile")
    public String profile(){
        return "security/profile";
    }

    @GetMapping("/user")
    public String userPage(){
        return "user/user-page";
    }

    @GetMapping("/superuser")
    public String superuserPage(){
        return "superuser/superuser-page";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin/admin-page";
    }


}

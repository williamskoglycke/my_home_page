package se.william.mvcexemple.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.william.mvcexemple.shoppinglist.entity.Connection;
import se.william.mvcexemple.shoppinglist.service.MailService;
import se.william.mvcexemple.shoppinglist.service.SmsService;

import javax.validation.Valid;

@Controller
public class SiteController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/imagegallery")
    public String imageGallery(){
        return "imagegallery";
    }

    @GetMapping("/admin/sms")
    public String sms(Model model){
        model.addAttribute("connection", new Connection());
        return "admin/sms";
    }

    @PostMapping("/admin/sms")
    public String sendSms(@Valid @ModelAttribute Connection connection, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "admin/sms";
        }
        try {
            this.smsService.sendSms(connection.getToAddress(),connection.getMsg());
            model.addAttribute("success", true);
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("failure", true);
        }

        return "admin/sms";
    }

    @GetMapping("/admin/mail")
    public String mail(Model model){
        model.addAttribute("connection", new Connection());
        return "admin/mail";
    }

    @PostMapping("/admin/mail")
    public String sendMail(@Valid @ModelAttribute Connection connection, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "admin/mail";
        }
        try {
            this.mailService.sendMailTLS(connection.getToAddress(),connection.getMsg());
            model.addAttribute("success", true);
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("failure", true);
        }

        return "admin/mail";
    }

}

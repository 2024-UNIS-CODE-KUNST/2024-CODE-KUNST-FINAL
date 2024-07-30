package com.example.unisweb.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/subscribe")
    public String showSubscriptionForm() {
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public String afterSubscribe(@RequestParam String email) {
        emailService.saveEmail(email);
        return "redirect:/subscribe";
    }

    @PostMapping("/send")
    public String sendEmails(@RequestParam String subject, @RequestParam String message, Model model) {
        emailService.sendEmails(subject, message);
        model.addAttribute("message", "Emails sent successfully");
        return "result";
    }
}
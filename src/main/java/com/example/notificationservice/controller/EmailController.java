package com.example.notificationservice.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    private final JavaMailSender mailSender;


    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping("/send-email")

    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("tsksarahsp@gmail.com");
            message.setTo("sksarahsp@gmail.com");
            message.setSubject("Simple test email from Sunil!");
            message.setText("This is a sample email body for my first email!");

            mailSender.send(message);
            return "success!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

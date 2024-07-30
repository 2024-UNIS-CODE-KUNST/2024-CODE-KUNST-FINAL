package com.example.unisweb.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailEntity saveEmail(String email) {
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setEmail(email);
        return emailRepository.save(emailEntity);
    }

    public void sendEmails(String subject, String message) {
        List<EmailEntity> emails = emailRepository.findAll();
        for (EmailEntity emailEntity : emails) {
            sendEmail(emailEntity.getEmail(), subject, message);
        }
    }

    private void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}

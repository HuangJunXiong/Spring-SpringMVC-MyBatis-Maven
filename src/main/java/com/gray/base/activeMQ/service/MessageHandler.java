package com.gray.base.activeMQ.service;

import com.gray.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/3/12.
 */
@Component
public class MessageHandler {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${email.user.name}")
    String from;

    public void handler(User user){
        //作发邮件的操作
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(user.getEmail());
        message.setSubject("Register Remind");
        message.setText("Welcome to register! your user is "+user.getUsername());
        mailSender.send(message);
    }
}

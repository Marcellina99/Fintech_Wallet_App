package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendNotification(Users user) throws MailException{

        //send email

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(user.getEmailAddress());
        mail.setFrom("javag1liveproject@gmail.com");
        mail.setSubject("TestVerifyMail");
        mail.setText("Hi" + user.getName() + "!\nSending from Decagon SQ011A Java\n\nRegards, \n Group 1");
        javaMailSender.send(mail);
    }


}


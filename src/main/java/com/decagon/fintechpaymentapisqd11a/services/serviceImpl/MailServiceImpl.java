package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.dto.UserDto;
import com.decagon.fintechpaymentapisqd11a.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendNotification(UserDto userDto) throws MailException{

        //send email

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userDto.getEmailAddress());
        mail.setSubject(userDto.getSubject());
        mail.setText("Hi" + userDto.getName() + "!\n" + userDto.getMessage());
        javaMailSender.send(mail);
    }


}


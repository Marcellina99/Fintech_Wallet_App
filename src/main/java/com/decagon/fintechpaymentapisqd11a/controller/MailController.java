package com.decagon.fintechpaymentapisqd11a.controller;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.services.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @GetMapping("/send")
    public String sendMail () {

        //create a user

        Users user = new Users ();
        user.setName("Group1");
        user.setEmailAddress("josgolf3@gmail.com");

        //send a notification

        try
        {
            notificationService.sendNotification(user);

            return "mail has been sent";
        } catch (MailException e) {
            LOGGER.error("Could Not send mail to {}" , user.getName() , e);
        }
        return "Oops! Something bad happened."; }

    @Autowired
    NotificationService notificationService;

    private static Logger LOGGER = LoggerFactory.getLogger(MailController.class);
}

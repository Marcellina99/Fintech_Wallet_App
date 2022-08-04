package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.models.Users;
import org.springframework.mail.MailException;

public interface NotificationService {

    public void sendNotification(Users user) throws MailException;
}


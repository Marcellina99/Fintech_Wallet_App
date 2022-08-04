package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.dto.UserDto;
import org.springframework.mail.MailException;

public interface MailService {

    public void sendNotification(UserDto userDto) throws MailException;
}


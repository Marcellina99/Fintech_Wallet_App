package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import com.decagon.fintechpaymentapisqd11a.dto.UserDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MailServiceImpl.class})
@ExtendWith(SpringExtension.class)
class MailServiceImplTest {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @Test
    void testSendNotification() throws MailException {
        doNothing().when(javaMailSender).send((SimpleMailMessage) any());
        mailServiceImpl.sendNotification(
                new UserDto("Decagon", "Josgolf@yahoo.com", "You have been admitted", "Hello from Decagon"));
        verify(javaMailSender).send((SimpleMailMessage) any());
    }

    @Test
    void testSendNotification3() throws MailException {
        doThrow(new MailAuthenticationException("Oops! Something bad happened.")).when(javaMailSender).send((SimpleMailMessage) any());
        assertThrows(MailAuthenticationException.class, () -> mailServiceImpl.sendNotification(
                new UserDto("Decagon", "Josgolf@yahoo", "You have been admitted", "Hello from Decagon")));
        verify(javaMailSender).send((SimpleMailMessage) any());
    }
}


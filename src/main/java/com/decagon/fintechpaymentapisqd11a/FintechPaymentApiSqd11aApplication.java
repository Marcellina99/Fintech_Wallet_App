package com.decagon.fintechpaymentapisqd11a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class FintechPaymentApiSqd11aApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintechPaymentApiSqd11aApplication.class, args);
	}

	@Configuration
//	@PropertySource(value= "classpath:application.properties")
	public static class MailConfiguration {

		@Value("${SECRET_PASSWORD}")
		String Password;

		@Bean
		public JavaMailSender getJavaMailSender() {


			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setUsername("javag1liveproject@gmail.com");
			mailSender.setPassword(Password);

			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");

			return mailSender;
		}
	}


}

package com.alura.challenge.backend3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(
      String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("exportacaofilmow@gerador.dev.br");
        message.setTo(to); 
        message.setSubject("Senha cadastro importação CSV"); 
        message.setText("Sua senha é: "+text);
        emailSender.send(message);
    }

}
